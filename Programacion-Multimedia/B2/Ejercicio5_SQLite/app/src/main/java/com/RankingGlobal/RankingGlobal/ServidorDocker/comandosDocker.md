## Comandos Docker Compose

Docker compose permite tener un proyecto que cuente con varios contenedores y los comunica directamente por red interna sin tener que configurar nada manualmente.

**Levantar (iniciar) contenedores:**

- `docker-compose up`: Crea e inicia los contenedores en primer plano (verás los logs en tiempo real).

- `docker-compose up -d`: Lo mismo que el anterior, pero en modo "detached" (segundo plano), liberando la terminal (si no, al cerrar terminal se cierra el contenedor).

- `docker-compose up --build`: Fuerza la reconstrucción de las imágenes antes de levantar los contenedores (útil si se ha cambiado el Dockerfile o archivos que se copian en la imagen).

**Parar y eliminar contenedores:**

- `docker-compose stop`: Detiene los contenedores sin borrarlos.

- `docker-compose down`: Detiene y elimina los contenedores y redes creados, pero no los volúmenes.

- `docker-compose down -v`: Detiene, elimina contenedores Y también borra los volúmenes de datos (la base de datos se reseteará a su estado inicial al volver a levantarlo).