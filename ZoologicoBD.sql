create database zoologicos;
use zoologicos;

CREATE TABLE zoologicos (
    id_zoologico INT(11) AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    ciudad VARCHAR(100) NOT NULL,
    pais VARCHAR(100) NOT NULL,
    fecha_inauguracion DATE NOT NULL
);

CREATE TABLE especies (
    id_especie INT(11) AUTO_INCREMENT PRIMARY KEY,
    nombre_vulgar VARCHAR(100) NOT NULL,
    nombre_cientifico VARCHAR(100) NOT NULL,
    familia VARCHAR(200) NOT NULL,
    peligro_extincion BIT(1) NOT NULL
);

CREATE TABLE animales (
    id_animal INT(11) AUTO_INCREMENT PRIMARY KEY,
    identificacion VARCHAR(20) NOT NULL,
    sexo ENUM('Macho', 'Hembra') NOT NULL,
    año_nacimiento INT(10) NOT NULL,
    id_especie INT(11) NOT NULL,
    id_zoologico INT(11) NOT NULL,
    FOREIGN KEY (id_especie) REFERENCES especies(id_especie),
    FOREIGN KEY (id_zoologico) REFERENCES zoologicos(id_zoologico)
);

-- 5 Zoológicos
INSERT INTO zoologicos (nombre, ciudad, pais, fecha_inauguracion) VALUES
('Zoológico de Chapultepec', 'Ciudad de México', 'México', '1924-09-01'),
('San Diego Zoo', 'San Diego', 'Estados Unidos', '1916-12-02'),
('London Zoo', 'Londres', 'Reino Unido', '1828-04-27'),
('Singapore Zoo', 'Singapur', 'Singapur', '1973-06-27'),
('Beijing Zoo', 'Pekín', 'China', '1906-11-20');

-- 5 Especies
INSERT INTO especies (nombre_vulgar, nombre_cientifico, familia, peligro_extincion) VALUES
('Tigre de Bengala', 'Panthera tigris tigris', 'Felidae', b'1'),
('Elefante Africano', 'Loxodonta africana', 'Elephantidae', b'1'),
('Cebra de llanura', 'Equus quagga', 'Equidae', b'0'),
('Pingüino emperador', 'Aptenodytes forsteri', 'Spheniscidae', b'1'),
('Jirafa', 'Giraffa camelopardalis', 'Giraffidae', b'0');

-- 5 Animales
INSERT INTO animales (identificacion, sexo, año_nacimiento, id_especie, id_zoologico) VALUES
('TIG001', 'Macho', 2015, 1, 1),
('ELE002', 'Hembra', 2010, 2, 2),
('CEB003', 'Macho', 2018, 3, 3),
('PIN004', 'Hembra', 2012, 4, 4),
('JIR005', 'Macho', 2016, 5, 5);

