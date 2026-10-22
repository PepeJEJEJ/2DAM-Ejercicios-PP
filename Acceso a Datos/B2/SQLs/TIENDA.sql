-- CREAR LA B.D
DROP DATABASE IF EXISTS tienda;
CREATE DATABASE IF NOT EXISTS tienda;
USE tienda;

-- CREAR LAS TABLAS DE LA B.D
CREATE TABLE cliente (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nombre     VARCHAR(30)  NOT NULL,
    direccion  VARCHAR(100) NOT NULL,
    ciudad     VARCHAR(30)  NOT NULL,
    email      VARCHAR(100)
);

CREATE TABLE producto (
    id_producto INT AUTO_INCREMENT PRIMARY KEY,
    nombre      VARCHAR(60) NOT NULL,
    categoria   VARCHAR(30),
    marca       VARCHAR(30) NOT NULL,
    precio      DECIMAL(8,2) NOT NULL,
    stock       INT DEFAULT 0
);

CREATE TABLE proveedor (
    id_proveedor INT AUTO_INCREMENT PRIMARY KEY,
    nombre       VARCHAR(60) NOT NULL,
    ciudad       VARCHAR(60) NOT NULL,
    telefono     VARCHAR(15)
);

CREATE TABLE compra (
    id_compra    INT AUTO_INCREMENT PRIMARY KEY,
    id_proveedor INT NOT NULL,
    id_producto  INT NOT NULL,
    fecha        DATE NOT NULL,
    cantidad     INT NOT NULL,
    coste        DECIMAL(8,2) NOT NULL,
    FOREIGN KEY (id_proveedor) REFERENCES proveedor (id_proveedor),
    FOREIGN KEY (id_producto)  REFERENCES producto (id_producto)
);

CREATE TABLE venta (
    id_venta    INT AUTO_INCREMENT PRIMARY KEY,
    id_cliente  INT NOT NULL,
    id_producto INT NOT NULL,
    fecha       DATE NOT NULL,
    cantidad    INT NOT NULL,
    FOREIGN KEY (id_cliente)  REFERENCES cliente (id_cliente),
    FOREIGN KEY (id_producto) REFERENCES producto (id_producto)
);

SHOW TABLES;
DESCRIBE cliente;
-- MODIFICAR LA LECTURA
ALTER TABLE cliente ADD COLUMN telefono VARCHAR(9);
ALTER TABLE cliente RENAME COLUMN telefono TO movil;
ALTER TABLE cliente MODIFY COLUMN movil VARCHAR(15);
DESCRIBE cliente;
ALTER TABLE cliente DROP COLUMN movil;
DESCRIBE cliente;

-- INDICE (Facilita las busquedas):
CREATE INDEX idx_ciudad ON cliente (ciudad);
SHOW INDEX FROM cliente;
DROP INDEX idx_ciudad ON cliente;
SHOW INDEX FROM cliente;

-- INSERTAR DATOS
INSERT INTO cliente (nombre, direccion, ciudad, email)
VALUES ('Juan Lopez', 'C/Andalucia nº 2', 'Badajoz', 'juan.lopez@davante.org');

INSERT INTO proveedor (nombre, ciudad, telefono) VALUES
 ('HP',            'Madrid',    '915000001'),
 ('Lenovo',        'Barcelona', '934000002'),
 ('Logitech',      'Valencia',  '963000003'),
 ('TechMayorista', 'Malaga',    '952000004');

INSERT INTO producto (nombre, categoria, marca, precio, stock) VALUES
 ('Portatil HP 15',          'Portatiles', 'HP',     549.00, 15),
 ('Portatil Lenovo IdeaPad', 'Portatiles', 'Lenovo', 479.00, 20);

INSERT INTO venta (id_cliente, id_producto, fecha, cantidad) VALUES
 (1, 1, '2026-09-01', 1),
 (1, 2, '2026-09-01', 1);


-- INSERTAR LOS DEMAS DATOS
INSERT INTO cliente (nombre, direccion, ciudad, email) VALUES
 ('Pepe Tejada',      'Avda. de Sevilla 12',  'Sevilla',   'pepe.tejada@davante.org'),
 ('Victor Fernandez', 'C/Mayor 5',            'Jaen',      NULL),
 ('Jose Assensio',    'C/Huesca 8',           'Huesca',    'jose.assensio@davante.org'),
 ('Leo Perez',        'Plaza Mayor 1',        'Orense',    NULL),
 ('Patricia Aranda',  'Paseo de Gracia 20',   'Barcelona', 'patricia.aranda@davante.org'),
 ('David Lopez',      'Gran Via 45',          'Madrid',    'david.lopez@davante.org'),
 ('Enrique Ferreras', 'C/Larios 3',           'Malaga',    'enrique.ferreras@davante.org'),
 ('Luis Guzman',    'C/Colon 18',           'Valencia',  NULL);

INSERT INTO producto (nombre, categoria, marca, precio, stock) VALUES
 ('Monitor Samsung 24',    'Monitores',      'Samsung',  139.90,  30),
 ('Raton Logitech M185',   'Perifericos',    'Logitech',  14.90, 100),
 ('Teclado Logitech K120', 'Perifericos',    'Logitech',  12.50,  80),
 ('Impresora HP DeskJet',  'Impresoras',     'HP',        69.00,  25),
 ('Disco SSD 1TB',         'Almacenamiento', 'Kingston',  74.90,  45),
 ('Pendrive 64GB',         'Almacenamiento', 'Kingston',   8.90, 150);

INSERT INTO venta (id_cliente, id_producto, fecha, cantidad) VALUES
 (2, 3, '2026-09-01', 2),
 (2, 5, '2026-09-01', 1),
 (1, 7, '2026-09-15', 1),
 (1, 6, '2026-09-15', 1),
 (5, 2, '2026-09-20', 1),
 (5, 4, '2026-09-20', 1),
 (5, 5, '2026-09-20', 1),
 (7, 6, '2026-10-01', 2),
 (7, 8, '2026-10-01', 3),
 (2, 4, '2026-10-05', 2),
 (2, 7, '2026-10-05', 1);

INSERT INTO compra (id_proveedor, id_producto, fecha, cantidad, coste) VALUES
 (1, 1, '2026-08-25',  20, 430.00),
 (1, 6, '2026-08-25',  30,  48.00),
 (2, 2, '2026-08-26',  25, 380.00),
 (3, 4, '2026-08-27', 120,   9.50),
 (3, 5, '2026-08-27', 100,   7.80),
 (4, 3, '2026-08-28',  40, 105.00),
 (4, 4, '2026-08-28',  50,  10.20),
 (4, 7, '2026-08-29',  60,  58.00),
 (4, 8, '2026-08-29', 200,   5.20);

SELECT * FROM cliente;
SELECT * FROM producto;
SELECT COUNT(*) AS ventas FROM venta;
SELECT COUNT(*) AS compras FROM compra;

 -- PRUEBA DE ERRORES MAS HABITUALES

-- 1) Menos valores que columnas:
INSERT INTO cliente VALUES ('x', 'y', 'z');

-- 2) Un texto donde va un número:
INSERT INTO producto (nombre, marca, precio) VALUES ('Raton', 'Logitech', 'barato');

-- 3) Clave foránea inexistente (el cliente 99 no existe):
INSERT INTO venta (id_cliente, id_producto, fecha, cantidad) VALUES (99, 1, '2026-10-10', 1);

-- 4) Falta una columna obligatoria (NOT NULL):
INSERT INTO cliente (nombre, email) VALUES ('Marta', 'marta@davante.org');