DROP TABLE "Proyeccion";
DROP TABLE "Empleado";
DROP TABLE "Pelicula";
DROP TABLE "Sala";

CREATE SEQUENCE empleado_id
  INCREMENT 0
  MINVALUE 0
  MAXVALUE 0
  START 0
  CACHE 0;

CREATE SEQUENCE sala_id
  INCREMENT 0
  MINVALUE 0
  MAXVALUE 0
  START 0
  CACHE 0;

CREATE SEQUENCE pelicula_id
  INCREMENT 0
  MINVALUE 0
  MAXVALUE 0
  START 0
  CACHE 0;

CREATE SEQUENCE proyeccion_id
  INCREMENT 0
  MINVALUE 0
  MAXVALUE 0
  START 0
  CACHE 0;

CREATE TABLE "Empleado" ( 
	Id NUMERIC NOT NULL PRIMARY KEY nextval('empleado_id'::regclass),
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
	Id NUMERIC NOT NULL PRIMARY KEY nextval('pelicula_id'::regclass),
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
	Id NUMERIC NOT NULL PRIMARY KEY nextval('sala_id'::regclass),
	Numero NUMERIC NOT NULL,
	Aforo NUMERIC NOT NULL,
	Dimensiones_pantalla VARCHAR (25) NOT NULL,
	Ano_inaiguracion NUMERIC NOT NULL,
	Discapacidad BOOLEAN NOT NULL,
	Alta BOOLEAN NOT NULL
);

CREATE TABLE "Proyeccion" (
	Id NUMERIC NOT NULL PRIMARY KEY DEFAULT nextval('proyeccion_id'::regclass),
	Id_sala NUMERIC NOT NULL,
	Id_pelicula NUMERIC NOT NULL,
	Hora TIME NOT NULL,
	Alta BOOLEAN NOT NULL,
	CONSTRAINT "Proyeccion_id_pelicula_fkey" FOREIGN KEY (id_pelicula)
      REFERENCES public."Pelicula" (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "Proyeccion_id_sala_fkey" FOREIGN KEY (id_sala)
      REFERENCES public."Sala" (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);
