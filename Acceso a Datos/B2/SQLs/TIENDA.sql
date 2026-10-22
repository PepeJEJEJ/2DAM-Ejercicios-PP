DROP DATABASE IF EXISTS tienda;
CREATE DATABASE IF NOT EXISTS tienda;
USE tienda;

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