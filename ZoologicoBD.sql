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
