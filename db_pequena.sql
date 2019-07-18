create database db_pequena;
use db_pequena;

create table usuario
(
	id int auto_increment primary key,
    nombres varchar(50) not null,
    apellidos varchar(50) not null,
    correo varchar(40) unique not null,
    dni varchar(8) unique not null,
    estado int -- 1: activo | 2: eliminado
);

create table tipo_mascota
(
	id int auto_increment primary key,
    tipo varchar(30)
);

insert into tipo_mascota values(null, 'perro');
insert into tipo_mascota values(null, 'gato');
insert into tipo_mascota values(null, 'conejo');

create table mascota
(
	id int auto_increment primary key,
    nombre varchar(30) not null,
    tipo_mascota int not null,
    dueno int not null,
    estado int, -- 1: activo | 2: eliminado
    foreign key(tipo_mascota) references tipo_mascota(id),
    foreign key(dueno) references usuario(id)
);