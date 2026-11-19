# MEMORIA DE LA PRÁCTICA: RANKING GLOBAL CON DOCKER, PHP Y ANDROID

---

## APARTADO 1: DOCKER

### 1.1. Explicación Teórica y Arquitectura

#### ¿Qué es un contenedor?
Un **contenedor** es una unidad de software ligera, autónoma y ejecutable que empaqueta el código de una aplicación junto con todas sus dependencias, bibliotecas y archivos de configuración necesarios para que se ejecute de forma rápida y fiable en cualquier entorno de computación. 

A diferencia de una **máquina virtual (VM)**, que virtualiza el hardware completo e incluye un sistema operativo huésped (*Guest OS*) entero, los contenedores comparten el mismo núcleo (*kernel*) del sistema operativo anfitrión (*Host OS*). Esto permite que los contenedores se inicien en cuestión de segundos, consuman significativamente menos memoria RAM y espacio en disco, y ofrezcan una eficiencia mucho mayor.

#### Contenedores del proyecto (`docker-compose.yml`)
En este proyecto se utiliza **Docker Compose** para orquestar y comunicar dos contenedores en una red interna privada:

1. **Contenedor de Base de Datos (`db`):**
   - **Imagen:** `mariadb:11`
   - **Función:** Almacena de forma persistente los datos de los usuarios y sus puntuaciones en la base de datos `bd_android`.
   - **Configuración:** Cuenta con un volumen nombrado (`db_data`) montado en `/var/lib/mysql` para garantizar la persistencia de los datos tras detener o reiniciar el contenedor. Además, monta el script `init.sql` para inicializar automáticamente la tabla `usuarios` y los datos por defecto (Pilar con 8 puntos, José con 6 puntos) la primera vez que se genera la base de datos.

2. **Contenedor Web y Servidor Backend (`web`):**
   - **Imagen:** Basada en `php:8.2-apache` (compilada localmente mediante el `Dockerfile` de `./php`).
   - **Función:** Servidor HTTP Apache que procesa la aplicación web frontend (`index.html`) y ejecuta los scripts en PHP (`conexion.php`, `listar.php`, `insertar.php`, `buscar.php`).
   - **Red y Puertos:** Expone el puerto `80` del contenedor hacia el puerto `8080` de la máquina anfitriona (`8080:80`). Esto permite acceder al servicio desde el navegador web del equipo anfitrión a través de `http://localhost:8080`. Se comunica con el contenedor `db` a través de la red interna de Docker resolviendo el nombre de host `db`.

---

### 1.2. Comandos para arrancar y parar el entorno

Todos los comandos se ejecutan desde la terminal situándose en la carpeta donde se encuentra el archivo `docker-compose.yml` (`ServidorDocker`):

* **Arrancar los contenedores en segundo plano (detached mode):**
  ```bash
  docker compose up -d
  ```
  *(Añada `--build` si ha modificado el Dockerfile o la configuración de las imágenes: `docker compose up -d --build`)*

* **Comprobar el estado de los contenedores en marcha:**
  ```bash
  docker compose ps
  ```

* **Visualizar los registros/logs de los servicios:**
  ```bash
  docker compose logs -f
  ```

* **Detener temporalmente los contenedores (sin borrarlos ni perder el estado):**
  ```bash
  docker compose stop
  ```

* **Arrancar de nuevo los contenedores detenidos:**
  ```bash
  docker compose start
  ```

* **Detener y eliminar los contenedores y las redes creadas:**
  ```bash
  docker compose down
  ```

* **Detener y borrar contenedores, redes Y volúmenes (reinicia la BD a su estado inicial `init.sql`):**
  ```bash
  docker compose down -v
  ```

---

### 1.3. Capturas del Apartado 1

> **CAPTURA 1.1: Docker Desktop y Terminal con los contenedores activos**
> 
> *Instrucción para el alumno:* Adjuntar aquí una captura de pantalla donde se observe:
> 1. La interfaz de **Docker Desktop** mostrando la pila de contenedores (`ServidorDocker`) con los servicios `db` y `web` en estado **Running** (color verde).
> 2. La **terminal de comandos** ejecutando `docker compose ps` y mostrando ambos contenedores activos y el mapeo del puerto `0.0.0.0:8080->80/tcp`.

```
+-----------------------------------------------------------------------------------+
|                                                                                   |
|                   [ INSERTAR AQUÍ CAPTURA 1.1: DOCKER DESKTOP ]                   |
|           Contenedores `db` y `web` en marcha + Terminal con `docker compose ps`  |
|                                                                                   |
+-----------------------------------------------------------------------------------+
```

---

## APARTADO 2: PHP

### 2.1. Explicación de los Scripts Backend

El backend PHP está alojado en el contenedor web (`/var/www/html`) y se encarga de la lógica de negocio y comunicación con MariaDB.

#### 1. `conexion.php`
- **Función:** Define la configuración global del servidor y establece la conexión con la base de datos MariaDB.
- **Detalles clave:**
  - Establece la cabecera `Content-Type: application/json; charset=utf-8` para asegurar que todas las respuestas se envíen en formato JSON codificado en UTF-8.
  - Utiliza `set_exception_handler` para capturar cualquier fallo de conexión o error de ejecución de MySQL y devolver automáticamente un código de respuesta **HTTP 500 (Internal Server Error)** con una estructura JSON de error (`{"resultado":"ERROR", "mensaje":"..."}`). Esto evita que PHP responda errores en HTML.
  - Conecta a MariaDB mediante `mysqli_connect("db", "alumno", "alumno", "bd_android")`, haciendo uso del nombre de host `"db"` que resuelve la DNS interna de Docker Compose.

#### 2. `index.html`
- **Función:** Interfaz web para el usuario en el navegador (`http://localhost:8080`).
- **Detalles clave:**
  - Muestra un formulario para registrar nuevos usuarios con su nombre y puntuación.
  - Renderiza una tabla HTML interactiva con el listado del ranking de jugadores.
  - Mediante JavaScript (`fetch`), realiza peticiones asíncronas a `listar.php` al cargar la página y a `insertar.php` al enviar el formulario.

#### 3. `listar.php`
- **Función:** Devuelve el ranking global completo de jugadores.
- **Detalles clave:**
  - Ejecuta la consulta SQL: `SELECT id, nombre, puntuacion FROM usuarios ORDER BY puntuacion DESC, nombre`.
  - Ordena a los jugadores descendentemente por su puntuación (los marcadores más altos primero) y alfabéticamente en caso de empate.
  - Formatea los campos numéricos como enteros numéricos de JSON (no strings) y devuelve una lista/array de objetos JSON (`[{"id":1, "nombre":"Pilar", "puntuacion":8}, ...]`).

#### 4. `insertar.php`
- **Función:** Recibe datos de un nuevo registro y los almacena en la base de datos.
- **Detalles clave:**
  - Recibe los parámetros `nombre` y `puntuacion` a través de una petición HTTP **POST**.
  - Valida que el nombre no esté vacío y que la puntuación sea un valor numérico. En caso de invalidez, responde con un código **HTTP 400 (Bad Request)**.
  - Emplea **consultas preparadas** (`mysqli_prepare` y `mysqli_stmt_bind_param`) para prevenir ataques de **Inyección SQL**.
  - Devuelve una confirmación JSON: `{"resultado":"OK", "id": X}` con código **HTTP 200**.

#### 5. `buscar.php`
- **Función:** Busca la puntuación de un usuario específico por su nombre.
- **Detalles clave:**
  - Recibe el parámetro `nombre` mediante una petición HTTP **GET** (`buscar.php?nombre=Pilar`).
  - Realiza una consulta preparada filtrando por nombre (`WHERE nombre = ? LIMIT 1`).
  - Si el usuario existe, devuelve un objeto JSON con sus datos. Si el usuario no se encuentra en la base de datos, devuelve un código **HTTP 404 (Not Found)** con `{"resultado":"NO_ENCONTRADO"}`.

---

### 2.2. Capturas del Apartado 2

> **CAPTURA 2.1: Aplicación web en navegador (`localhost:8080`)**
> 
> *Instrucción para el alumno:* Adjuntar una captura de pantalla del navegador accediendo a `http://localhost:8080` donde se observe la tabla del ranking con las puntuaciones iniciales cargadas.

```
+-----------------------------------------------------------------------------------+
|                                                                                   |
|                   [ INSERTAR AQUÍ CAPTURA 2.1: WEB EN LOCALHOST ]                 |
|             Navegador en `http://localhost:8080` con el ranking inicial           |
|                                                                                   |
+-----------------------------------------------------------------------------------+
```

---

## APARTADO 3: ANDROID

### 3.1. Explicación Técnica de la App Android

#### ¿Qué hace la librería Volley?
**Volley** es una biblioteca de red desarrollada por Google para aplicaciones Android que simplifica y optimiza el proceso de realización de peticiones HTTP/HTTPS a servidores web.

Sus características y funciones principales en la app son:
1. **Gestión Asíncrona en Segundo Plano:** Volley ejecuta las peticiones de red en hilos secundarios (*background threads*) y entrega las respuestas de vuelta en el hilo principal de la interfaz de usuario (*UI Thread*). Esto evita que la aplicación se bloquee o muestre el mensaje de error *ANR (Application Not Responding)*.
2. **Cola de Peticiones (`RequestQueue`):** Administra una cola interna (`Volley.newRequestQueue(this)`) que gestiona el envío, concurrencia y cancelación de solicitudes HTTP.
3. **Tipos de Peticiones Especializadas:** 
   - `JsonArrayRequest`: Se usa en `listar()` para recibir un array de objetos JSON directamente.
   - `JsonObjectRequest`: Se usa en `buscarPorNombre()` para recibir un único objeto JSON.
   - `StringRequest`: Se usa en `insertar()` sobreescribiendo el método `getParams()` para enviar los datos mediante un formulario HTTP POST (`application/x-www-form-urlencoded`).

---

#### Permisos obligatorios en el `AndroidManifest.xml`

Para permitir la comunicación de red, el archivo `AndroidManifest.xml` incluye las siguientes configuraciones:

1. **Permiso de Internet:**
   ```xml
   <uses-permission android:name="android.permission.INTERNET" />
   ```
   *Explicación:* Permite que la aplicación abra sockets de red para comunicarse con servidores externos o locales. Es un permiso de categoría normal, por lo que se concede automáticamente al instalar la app sin requerir confirmación en tiempo de ejecución.

2. **Permiso de Tráfico en Texto Plano (`usesCleartextTraffic`):**
   ```xml
   <application
       android:usesCleartextTraffic="true"
       ... >
   ```
   *Explicación:* A partir de Android 9.0 (API nivel 28), el sistema bloquea por defecto todas las conexiones HTTP no cifradas en favor de HTTPS por motivos de seguridad. Dado que el servidor de desarrollo local Docker opera sobre HTTP estándar (`http://`), es imprescindible activar `android:usesCleartextTraffic="true"` para evitar excepciones de red de tipo `UnknownServiceException: CLEARTEXT communication to 10.0.2.2 not permitted`.

---

#### Acceso a `localhost:8080` frente a `10.0.2.2`

- **En el equipo anfitrión (PC):**
  - La dirección `localhost` (o `127.0.0.1`) hace referencia al propio equipo donde se ejecuta el navegador web. Docker publica el puerto `80` del contenedor web en el puerto `8080` del equipo anfitrión. Por tanto, el navegador accede mediante `http://localhost:8080/`.

- **En el Emulador de Android:**
  - El emulador funciona dentro de una máquina virtual con su propia pila de red virtualizada. Dentro del emulador, `localhost` o `127.0.0.1` apunta **al propio dispositivo móvil virtualizado**, no al PC donde corre Docker.
  - Para permitir que el emulador acceda a los servicios alojados en el `localhost` de la máquina anfitriona (el PC), el entorno de desarrollo de Android asigna la dirección IP especial **`10.0.2.2`**.
  - Por esta razón, en el código Java de la app Android la URL base se define como:
    ```java
    private static final String BASE = "http://10.0.2.2:8080/";
    ```
  - *(Nota: Si la prueba se realiza desde un dispositivo móvil físico conectado por Wi-Fi, debe usarse la dirección IP privada del ordenador en la red local, como por ejemplo `http://192.168.1.X:8080/`)*.

---

### 3.2. Capturas del Apartado 3

> **CAPTURA 3.1: Aplicación Android con el ranking cargado y la nueva puntuación**
> 
> *Instrucción para el alumno:* Adjuntar una captura del emulador Android ejecutando la aplicación, tras enviar una nueva puntuación desde el formulario (por ejemplo: un usuario nuevo con sus puntos) y comprobando que aparece listado en el `ListView`.

```
+-----------------------------------------------------------------------------------+
|                                                                                   |
|               [ INSERTAR AQUÍ CAPTURA 3.1: APP ANDROID CON RANKING ]              |
|        Pantalla de la app con la lista del ranking y el registro insertado        |
|                                                                                   |
+-----------------------------------------------------------------------------------+
```

> **CAPTURA 3.2: Confirmación en la web del dato insertado desde Android**
> 
> *Instrucción para el alumno:* Adjuntar una captura del navegador web en `http://localhost:8080` refrescado, donde se certifique que el dato insertado desde el móvil Android se ha guardado correctamente en MariaDB y se muestra en la web.

```
+-----------------------------------------------------------------------------------+
|                                                                                   |
|             [ INSERTAR AQUÍ CAPTURA 3.2: WEB CON DATO DESDE ANDROID ]             |
|          Navegador en `http://localhost:8080` mostrando el nuevo usuario          |
|                                                                                   |
+-----------------------------------------------------------------------------------+
```

> **CAPTURA 3.3: Comprobación del error en Android con el servidor detenido**
> 
> *Instrucción para el alumno:* Detener los contenedores Docker mediante `docker compose stop`. A continuación, pulsar el botón "Actualizar" o intentar buscar en la app Android y adjuntar la captura donde se visualice el mensaje Toast de error de conexión (`"No se puede conectar con el servidor"`).

```
+-----------------------------------------------------------------------------------+
|                                                                                   |
|             [ INSERTAR AQUÍ CAPTURA 3.3: ERROR CON SERVIDOR APAGADO ]             |
|     Pantalla de la app Android mostrando el Toast de error al detener Docker      |
|                                                                                   |
+-----------------------------------------------------------------------------------+
```
