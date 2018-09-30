package modelo;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pelicula {
	private String titulo;
	private int anoEstreno;
	private String director;
	private String actorPrincipal;
	private String actorSecundario;
	private String sinopsis;
	private int duracion;
	private String trailer;
	private java.sql.Date fechaInicio;
	private java.sql.Date fechaFin;
	private boolean alta;
	
	private Map<Sala, java.sql.Time> proyeccion;

	public Pelicula(String titulo, int anoEstreno, String director, String actorPrincipal, String actorSecundario,
			String sinopsis, int duracion, String trailer, Date fechaInicio, Date fechaFin, boolean b) {
		super();
		this.titulo = titulo;
		this.anoEstreno = anoEstreno;
		this.director = director;
		this.actorPrincipal = actorPrincipal;
		this.actorSecundario = actorSecundario;
		this.setSinopsis(sinopsis);
		this.duracion = duracion;
		this.trailer = trailer;
		this.setFechaInicio(fechaInicio);
		this.setFechaFin(fechaFin);
	}

	public Pelicula(String titulo, int anoEstreno, String director, String actorPrincipal, String actorSecundario,
			String sinopsis, int duracion, String trailer, Date fechaInicio, Date fechaFin) {
		super();
		this.titulo = titulo;
		this.anoEstreno = anoEstreno;
		this.director = director;
		this.actorPrincipal = actorPrincipal;
		this.actorSecundario = actorSecundario;
		this.setSinopsis(sinopsis);
		this.duracion = duracion;
		this.trailer = trailer;
		this.setFechaInicio(fechaInicio);
		this.setFechaFin(fechaFin);
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAnoEstreno() {
		return anoEstreno;
	}

	public void setAnoEstreno(int anoEstreno) {
		this.anoEstreno = anoEstreno;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getActorPrincipal() {
		return actorPrincipal;
	}

	public void setActorPrincipal(String actorPrincipal) {
		this.actorPrincipal = actorPrincipal;
	}

	public String getActorSecundario() {
		return actorSecundario;
	}

	public void setActorSecundario(String actorSecundario) {
		this.actorSecundario = actorSecundario;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getTrailer() {
		return trailer;
	}

	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}

	public Map<Sala, java.sql.Time> getProyeccion() {
		return proyeccion;
	}

	public void añadirProyeccion(Sala sala, java.sql.Time hora) {
		proyeccion.put(sala, hora);
		sala.anadirProyeccion(this, hora);
	}

	public boolean isAlta() {
		return alta;
	}

	public void setAlta(boolean alta) {
		this.alta = alta;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public java.sql.Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(java.sql.Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public java.sql.Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(java.sql.Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Sala getSala() {
		
		
		
		return null;
	}
}
