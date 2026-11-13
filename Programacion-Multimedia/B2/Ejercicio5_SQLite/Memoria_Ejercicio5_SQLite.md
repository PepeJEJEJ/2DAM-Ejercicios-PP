# Memoria: ranking global con Docker, PHP y Android

## Apartado 1: Docker

### Explicación

Un contenedor es una instancia aislada que empaqueta una aplicación y lo necesario para ejecutarla. Comparte el kernel del sistema anfitrión, por lo que suele ser más ligero que una máquina virtual. En este ejercicio, Docker Compose configura dos servicios conectados por una red interna:

| Servicio | Contenedor / imagen | Función |
|---|---|---|
| `db` | MariaDB 11 | Guarda los usuarios y sus puntuaciones en la base de datos `bd_android`. |
| `web` | PHP 8.2 con Apache | Sirve la página web y ejecuta los scripts PHP que consultan o modifican la base de datos. |

El servicio web publica el puerto `80` del contenedor como el puerto `8080` del ordenador. La base de datos no publica un puerto al anfitrión: PHP se conecta a ella por la red de Compose usando el nombre de servicio `db`. El volumen `db_data` conserva los datos aunque se detengan o eliminen los contenedores.

El archivo `db/init.sql` crea la tabla `usuarios` e inserta inicialmente a Pilar (8 puntos) y José (6 puntos). El script de inicialización se ejecuta al crear por primera vez el volumen; para volver a inicializar la base de datos hay que borrar también ese volumen.

### Comandos para arrancar y parar

Ejecutar los comandos desde la carpeta `ServidorDocker`:

```powershell
# Construir la imagen PHP si hace falta y arrancar los dos servicios en segundo plano
docker compose up -d --build

# Comprobar el estado de los contenedores y los puertos
docker compose ps

# Ver los registros de los servicios
docker compose logs

# Detener los servicios sin borrar los contenedores ni los datos
docker compose stop

# Detener y eliminar los contenedores y la red; conserva el volumen de la base de datos
docker compose down

# Eliminar también el volumen; se perderán los datos y se volverá a ejecutar init.sql
docker compose down -v
```

Para acceder a la web desde el ordenador, abrir `http://localhost:8080`.

### Capturas que hay que adjuntar

1. **Docker Desktop y terminal:** mostrar los contenedores de `db` y `web` en estado activo en Docker Desktop y, en la terminal, la ejecución de `docker compose ps` con ambos servicios en marcha.

> **Insertar aquí la captura 1:** Docker Desktop con `db` y `web` activos, junto a la terminal con `docker compose ps`.

## Apartado 2: PHP

### Explicación

La carpeta `ServidorDocker/php/html` contiene la página y los endpoints PHP:

- **`index.html`** muestra el formulario para añadir un usuario y la tabla del ranking. Al cargar la página y al pulsar **Actualizar**, hace una petición a `listar.php`. Al enviar el formulario, manda nombre y puntuación a `insertar.php` mediante POST y vuelve a actualizar la lista.
- **`conexion.php`** configura las respuestas JSON, conecta con MariaDB y define el manejo de errores de servidor. Desde el contenedor web, el host de la base de datos es `db`, que es el nombre del servicio de Compose.
- **`listar.php`** consulta los usuarios y devuelve un array JSON ordenado por puntuación descendente y, en caso de empate, por nombre.
- **`insertar.php`** valida nombre y puntuación y añade el usuario con una consulta preparada. Devuelve JSON con el resultado y el ID creado.
- **`buscar.php`** recibe un nombre por GET y devuelve sus datos en JSON. Si no encuentra a la persona, responde con el código HTTP 404.

La tabla inicial contiene a Pilar con 8 puntos y a José con 6. Los datos añadidos después se guardan en el volumen de MariaDB.

### Capturas que hay que adjuntar

2. **Web inicial:** navegador en `http://localhost:8080`, mostrando el listado y las puntuaciones.
3. **Web tras insertar desde Android:** la misma página actualizada, con el usuario y la puntuación que se enviaron desde la aplicación.

> **Insertar aquí la captura 2:** página web en `localhost:8080` con el ranking visible.
>
> **Insertar aquí la captura 3:** página web con el registro añadido desde Android visible en el listado.

## Apartado 3: Android

### Explicación

La aplicación Android actúa como cliente del servidor PHP y utiliza la librería **Volley** para realizar peticiones HTTP. Volley gestiona una cola reutilizable de peticiones y ejecuta las operaciones de red de forma asíncrona, por lo que la interfaz no queda bloqueada mientras espera la respuesta.

En `MainActivity`, las peticiones funcionan así:

- `listar.php` se consulta mediante GET. La respuesta JSON se convierte en filas del ranking y se muestra en un `ListView`.
- `insertar.php` recibe el nombre y la puntuación mediante POST. Si se envía correctamente, la aplicación informa al usuario y vuelve a consultar el ranking.
- `buscar.php` se consulta mediante GET con el nombre codificado para URL. Si el servidor devuelve 404, la aplicación indica que el nombre no está en el ranking.
- Si falla una consulta por falta de conexión o por un error del servidor, se muestra un mensaje en pantalla; los detalles técnicos se registran con la etiqueta `VOLLEY` en Logcat.

### Permisos del Manifest

En el manifiesto se declara:

```xml
<uses-permission android:name="android.permission.INTERNET" />
```

Este permiso permite que la aplicación acceda a la red. No se solicita en tiempo de ejecución porque no es un permiso de tipo peligroso. Además, el manifiesto incluye:

```xml
<application
    android:usesCleartextTraffic="true"
    ... >
```

Esto permite las conexiones HTTP sin cifrar que utiliza el servidor local de la práctica. Para una aplicación publicada se debería usar HTTPS y retirar esta excepción.

### `localhost:8080` frente a `10.0.2.2`

En un navegador del ordenador, `localhost` apunta al propio ordenador. Por eso la página se abre en `http://localhost:8080`: Docker publica el puerto 80 del contenedor web en el puerto 8080 del anfitrión.

Dentro del emulador Android, `localhost` apuntaría al propio emulador, no al ordenador donde corre Docker. El emulador Android estándar reserva `10.0.2.2` como dirección para acceder al `localhost` del ordenador anfitrión. Por ese motivo, la aplicación usa `http://10.0.2.2:8080/`. En un dispositivo físico habría que sustituirla por la IP local del ordenador, manteniendo ambos dispositivos en la misma red.

### Capturas que hay que adjuntar

4. **Aplicación con ranking:** pantalla de la app con el ranking y la puntuación del usuario que se acaba de insertar.
5. **Confirmación en la web:** la captura 3 del apartado anterior debe mostrar ese mismo usuario y puntuación en `localhost:8080`.
6. **Servidor apagado:** detener los contenedores, pulsar **Actualizar** en la aplicación y mostrar el mensaje de error de conexión.

> **Insertar aquí la captura 4:** aplicación Android con el ranking y la puntuación enviados.
>
> **La captura 3 sirve también como evidencia de que ese registro llegó a la base de datos y se muestra en la web.**
>
> **Insertar aquí la captura 5:** aplicación Android con el servidor detenido y el mensaje de error tras consultar.

## Rutas del proyecto

- Servidor Docker: `app/src/main/java/com/RankingGlobal/RankingGlobal/ServidorDocker/`
- Cliente Android: `app/src/main/java/com/RankingGlobal/RankingGlobal/APPClienteAndroid/`

## Estado de las evidencias

El contenido de esta memoria se ha redactado a partir de los archivos del proyecto. Las capturas de ejecución quedan pendientes: en el entorno de preparación no están disponibles los comandos `docker`, `php` ni `adb`, por lo que no se ha podido arrancar el servidor ni el emulador y no se han generado imágenes de una ejecución real.
