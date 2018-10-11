package modelo;

import java.util.ArrayList;

public class Tabla {
	private String nombre;
	private String esquema;
	private String clavePrimaria;
	private ArrayList<Columna> columnas;
	
	public Tabla(String nombre, String esquema, String clavePrimaria) {
		this.nombre = nombre;
		this.esquema = esquema;
		this.clavePrimaria = clavePrimaria;
		columnas = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEsquema() {
		return esquema;
	}

	public void setEsquema(String esquema) {
		this.esquema = esquema;
	}

	public String getClavePrimaria() {
		return clavePrimaria;
	}

	public void setClavePrimaria(String clavePrimaria) {
		this.clavePrimaria = clavePrimaria;
	}

	public ArrayList<Columna> getColumnas() {
		return columnas;
	}
	
	public void anadirColumna(Columna columna) {
		columnas.add(columna);
	}
}
