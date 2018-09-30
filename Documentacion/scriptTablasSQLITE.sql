DROP TABLE "Proyeccion";
DROP TABLE "Empleado";
DROP TABLE "Pelicula";
DROP TABLE "Sala";



CREATE TABLE "Empleado" ( 
	Id NUMERIC NOT NULL PRIMARY KEY,
	Nombre VARCHAR ( 25 ) NOT NULL,
	Apellido VARCHAR ( 25 ) NOT NULL, 
	Cargo VARCHAR ( 25 ) NOT NULL, 
	FechaNacimiento DATE, 
	Nacionalidad VARCHAR ( 25 ), 
	FechaContratacion DATE, 
	FechaFinContrato DATE,
	Alta BOOLEAN NOT NULL
);

CREATE TABLE "Pelicula" (
	Id NUMERIC NOT NULL PRIMARY KEY,
	Titulo VARCHAR (25) NOT NULL,
	Ano_estreno NUMERIC NOT NULL,
	Director VARCHAR (25) NOT NULL,
	Actor_principal VARCHAR (25) NOT NULL,
	Actor_secundario VARCHAR (25) NOT NULL,
	Duracion NUMERIC NOT NULL,
	Trailer VARCHAR (500) NOT NULL,
	Alta BOOLEAN NOT NULL
);

CREATE TABLE "Sala" (
	Id NUMERIC NOT NULL PRIMARY KEY,
	Numero NUMERIC NOT NULL,
	Aforo NUMERIC NOT NULL,
	Dimensiones_pantalla VARCHAR (25) NOT NULL,
	Ano_inauguracion NUMERIC NOT NULL,
	Discapacidad BOOLEAN NOT NULL,
	Alta BOOLEAN NOT NULL,
	CONSTRAINT id_responsable FOREIGN KEY (id_responsable)
        REFERENCES "Empleado" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);