package modelo;

import java.sql.Time;

public class Proyeccion {
	private Sala sala;
	private Pelicula pelicula;
	private java.sql.Time hora;
	private int id;
	private boolean alta;
	
	public Proyeccion(Sala sala, Pelicula pelicula, Time hora) {
		this.sala = sala;
		this.pelicula = pelicula;
		this.hora = hora;
	}
	public Proyeccion(Sala sala, Pelicula pelicula, Time hora, int id) {
		this.sala = sala;
		this.pelicula = pelicula;
		this.hora = hora;
		this.id = id;
	}
	
	public Proyeccion(Sala sala, Pelicula pelicula, Time hora, boolean alta) {
		this.sala = sala;
		this.pelicula = pelicula;
		this.hora = hora;
		this.alta = alta;
	}
	
	public Proyeccion(Sala sala, Pelicula pelicula, Time hora, int id, boolean alta) {
		this.sala = sala;
		this.pelicula = pelicula;
		this.hora = hora;
		this.id = id;
		this.alta = alta;
	}
	public Sala getSala() {
		return sala;
	}
	public void setSala(Sala sala) {
		this.sala = sala;
	}
	public Pelicula getPelicula() {
		return pelicula;
	}
	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}
	public java.sql.Time getHora() {
		return hora;
	}
	public void setHora(java.sql.Time hora) {
		this.hora = hora;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public boolean isAlta() {
		return alta;
	}

	public void setAlta(boolean alta) {
		this.alta = alta;
	}
}
