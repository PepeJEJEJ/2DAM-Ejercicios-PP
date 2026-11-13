-- Se ejecuta solo la primera vez que se crea el volumen de la base de datos.
-- Si se cambia este fichero, hay que hacer "docker compose down -v" para que vuelva a ejecutarse
CREATE TABLE IF NOT EXISTS usuarios (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(50),
  puntuacion INT
);

INSERT INTO usuarios(nombre, puntuacion) VALUES
('Pilar', 8),
('José', 6);
