-- PASO 1: CREAR LA BASE DE DATOS
DROP DATABASE IF EXISTS tienda;
CREATE DATABASE IF NOT EXISTS tienda;
USE tienda;

-- PASO 2: CREAR TABLAS
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
-- PASO 3: COMPROBAR TABLAS CREADAS
SHOW TABLES;
DESCRIBE cliente;

-- PASO 4: MODIFICAR LA ESTRUCTURA DE UNA TABLA (ALTER TABLE)
ALTER TABLE cliente ADD COLUMN telefono VARCHAR(9);
ALTER TABLE cliente RENAME COLUMN telefono TO movil;
ALTER TABLE cliente MODIFY COLUMN movil VARCHAR(15);
DESCRIBE cliente;
ALTER TABLE cliente DROP COLUMN movil;
DESCRIBE cliente;

-- PASO 5: CREAR Y ELIMINAR ÍNDICES
CREATE INDEX idx_ciudad ON cliente (ciudad);
SHOW INDEX FROM cliente;
DROP INDEX idx_ciudad ON cliente;
SHOW INDEX FROM cliente;

-- PASO 6: INSERTAR LOS PRIMEROS DATOS
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

-- PASO 7: INSERTAR EL RESTO DE DATOS
-- SIGZEBEN
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

-- PASO 8: CONSULTAR DATOS
SELECT * FROM cliente;
SELECT * FROM producto;

-- PASO 9: CONSULTAS DE AGREGACIÓN (COUNT)
SELECT COUNT(*) AS ventas FROM venta;
SELECT COUNT(*) AS compras FROM compra;

-- PASO 10: INSERTAR NUEVOS REGISTROS
INSERT INTO cliente (nombre, direccion, ciudad, email)
VALUES ('Ana Ruiz', 'C/Sol 7', 'Malaga', 'ana.ruiz@davante.org');

INSERT INTO cliente (nombre, direccion, ciudad, email)
VALUES ('Luis Soto', 'C/Luna 9', 'Granada', 'luis.soto@davante.org');

-- PASO 11: COMPROBAR LOS REGISTROS INSERTADOS
SELECT id_cliente, nombre, ciudad FROM cliente WHERE id_cliente > 8;

-- PASO 12: MODIFICAR DATOS (UPDATE)
UPDATE cliente SET ciudad = 'Cordoba' WHERE id_cliente = 3;

-- PASO 13: VERIFICAR EL UPDATE
SELECT id_cliente, nombre, ciudad FROM cliente WHERE id_cliente = 3;

-- PASO 14: ACTUALIZAR VARIAS COLUMNAS
UPDATE producto SET stock = stock + 5, precio = 529.00 WHERE id_producto = 1;

-- PASO 15: ACTUALIZAR MEDIANTE OPERACIÓN ARITMÉTICA
UPDATE producto SET precio = precio * 1.10 WHERE id_producto = 4;

-- PASO 16: COMPROBAR LOS CAMBIOS REALIZADOS
SELECT id_producto, nombre, precio, stock FROM producto WHERE id_producto IN (1, 4);

-- PASO 17: REEMPLAZAR REGISTROS (REPLACE)
REPLACE INTO producto (id_producto, nombre, categoria, marca, precio, stock)
VALUES (9, 'Alfombrilla raton', 'Perifericos', 'Logitech', 4.90, 60);

-- PASO 18: COMPROBAR EL REPLACE
SELECT * FROM producto WHERE id_producto = 9;

-- PASO 19: PRUEBAS DE ERRORES HABITUALES

-- ERROR 1: MENOS VALORES QUE COLUMNAS
INSERT INTO cliente VALUES ('x', 'y', 'z');

-- ERROR 2: TIPO DE DATO INCORRECTO
INSERT INTO producto (nombre, marca, precio) VALUES ('Raton', 'Logitech', 'barato');

-- ERROR 3: CLAVE FORÁNEA INEXISTENTE
INSERT INTO venta (id_cliente, id_producto, fecha, cantidad) VALUES (99, 1, '2026-10-10', 1);

-- ERROR 4: COLUMNA OBLIGATORIA NO INFORMADA
INSERT INTO cliente (nombre, email) VALUES ('Marta', 'marta@davante.org');

-- ERROR 5: MODO SEGURO DE MYSQL
UPDATE cliente SET ciudad = 'Cordoba' WHERE ciudad = 'Jaen';

-- EJERCICIO PROPUESTO: Mostrar nombre y stock de los productos con stock inferior a 30.

-- EJERCICIO PROPUESTO: Mostrar los clientes cuya ciudad empiece por M.

-- EJERCICIO PROPUESTO: Mostrar clientes sin email ordenados por nombre.

-- EJERCICIO PROPUESTO: Mostrar productos Logitech con precio inferior a 14 €.

-- EJERCICIO PROPUESTO: Incrementar un 10% el precio de determinados productos.

-- EJERCICIO PROPUESTO: Insertar un proveedor Kingston y registrar una compra.

-- EJERCICIO PROPUESTO: Obtener el total gastado por proveedor mediante JOIN y GROUP BY.