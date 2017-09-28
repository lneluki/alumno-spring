drop database springdemo;

create database springdemo;

use springdemo;

create table alumno (
  id INT NOT NULL AUTO_INCREMENT,
  dni VARCHAR(10) NOT NULL,
  nombre VARCHAR(40) NOT NULL,
  apellido VARCHAR(40) NOT NULL,
  ano INT,
  curso INT,
  PRIMARY KEY ( id )
);


delete from alumno;

insert into alumno(dni, nombre, apellido, ano, curso) values('21322345','Francisco', 'Sesin', 2, 3);
insert into alumno(dni, nombre, apellido, ano, curso) values('40322345','Pepe', 'Kali', 2, 5);
insert into alumno(dni, nombre, apellido, ano, curso) values('10322345','Ana', 'Franco', 1, 3);