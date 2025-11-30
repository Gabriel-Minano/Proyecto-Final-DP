/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  USER
 * Created: 22 oct 2025
 */

CREATE DATABASE colegio;
use colegio;
create table aulas(
id_aula int not null auto_increment primary key,
grado varchar(15) not null,
seccion varchar(20) not null
);

CREATE TABLE alumnos (
    id_alumno INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    dni CHAR(8) UNIQUE,
    primer_nombre VARCHAR(50) NOT NULL,
    segundo_nombre VARCHAR(50),
    primer_apellido VARCHAR(50) NOT NULL,
    segundo_apellido VARCHAR(50),
    id_aula INT,
    FOREIGN KEY (id_aula)
        REFERENCES aulas(id_aula)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE TABLE profesores (
    id_profesor INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    dni CHAR(8) UNIQUE,
    primer_nombre VARCHAR(50) NOT NULL,
    segundo_nombre VARCHAR(50),
    primer_apellido VARCHAR(50) NOT NULL,
    segundo_apellido VARCHAR(50),
    especialidad VARCHAR(50) NOT NULL,
    segunda_especialidad VARCHAR(50)
);

CREATE TABLE aula_profesor (
    id_asignacion INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id_aula INT,
    id_profesor INT,
    FOREIGN KEY (id_aula)
        REFERENCES aulas(id_aula)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (id_profesor)
        REFERENCES profesores(id_profesor)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

create table administradores(
id_admin int not null auto_increment primary key,
usuario varchar(50) not null,
contrasenha varchar(50) not null
);

INSERT INTO administradores (usuario, contrasenha) VALUES ('ADMIN','ADMIN');