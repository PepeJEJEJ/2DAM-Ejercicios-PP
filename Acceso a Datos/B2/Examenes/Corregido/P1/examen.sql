-- ============================================================
-- EXAMEN SQL: GIMNASIO  ·  Script INICIAL
-- Ejecutar ENTERO en Workbench antes de empezar (rayo).
-- Crea la base de datos 'gimnasio' y las tablas monitor y socio.
-- Las tablas actividad e inscripcion las tienes que crear tu.
-- ============================================================

DROP DATABASE IF EXISTS gimnasio;
CREATE DATABASE gimnasio;
USE gimnasio;

CREATE TABLE monitor (
    id_monitor INT AUTO_INCREMENT PRIMARY KEY,
    nombre     VARCHAR(50) NOT NULL,
    telefono   VARCHAR(9)
);

CREATE TABLE socio (
    id_socio   INT AUTO_INCREMENT PRIMARY KEY,
    nombre     VARCHAR(50) NOT NULL,
    ciudad     VARCHAR(40),
    email      VARCHAR(80),
    fecha_alta DATE NOT NULL
);

CREATE TABLE actividad (
    id_actividad INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    precio DECIMAL(6, 2)NOT NULL,
    plazas INT,
    dia VARCHAR(10),
    id_monitor INT,
    FOREIGN KEY (id_monitor) REFERENCES monitor(id_monitor)
);

CREATE TABLE inscripcion (
    id_inscripcion   INT AUTO_INCREMENT PRIMARY KEY,
    id_socio INT,
    id_actividad INT,
    FOREIGN KEY (id_socio) REFERENCES socio(id_socio),
    FOREIGN KEY (id_actividad) REFERENCES actividad(id_actividad),
    fecha DATE NOT NULL
);
select * from inscripcion;
select * from monitor;
select * from socio;
select * from actividad;

ALTER TABLE socio ADD COLUMN telefono VARCHAR(15);

-- ALTER TABLE inscripcion set id_socio = 7 where id_actividad = 2;

-- select nombre, fecha_alta from socio WHERE fecha_alta is BETWEEN '1-01-2026' and '30-06-2026';

select DISTINCT dia from actividad;

select nombre, dia, precio from actividad WHERE precio<20;

select nombre from socio where nombre like '%er%';

UPDATE actividad set precio=precio*'0.10' WHERE id_actividad = 2;

UPDATE socio set ciudad='Malaga' WHERE id_socio = 6;

select s.nombre,a.nombre,i.fecha from inscripcion i JOIN socio s on i.id_actividad = s.id_socio JOIN actividad a on s.id_socio = a.id_actividad;

select a.nombre,a.dia,m.nombre from monitor m RIGHT JOIN actividad a on a.id_actividad = m.id_monitor;

select a.nombre,COUNT(i.id_socio) as inscritos,SUM(a.precio) as precio_total from actividad a RIGHT JOIN inscripcion i on a.id_actividad = i.id_actividad GROUP BY(a.nombre);

-- EL ULTIMO ES POR LAS CLAVES FORANEAS (DEPENDEN LA UNA LA OTRA)
DELETE FROM socio where id_socio=1;
DELETE FROM inscripcion where id_inscripcion=8;
