package modelo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import controlador.*;

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
	private int id;
	private String bbdd = "postgre"; 
	
	private ArrayList<Proyeccion> proyecciones;
	
	public ArrayList<Pelicula> cargarPeliculas(){
		GestorBBDD gb = new GestorBBDD(bbdd);
		ArrayList<Pelicula> pelis = new ArrayList<>();
		switch(bbdd) {
			case "postgre":
				pelis = gb.cargarPeliculas();
				break;
			case "sqlite":
				pelis = gb.cargarPeliculasQL();
				break;
			case "db4o":
				pelis = DB4o.mostrarListPeli();
				break;
		}
		return pelis;
		
	}
	
	public boolean guardarProyecciones() {
		GestorBBDD gb = new GestorBBDD(bbdd);
		boolean correcto = false;
		switch(bbdd) {
		case "postgre":
			correcto = gb.guardarProyecciones(this);
			break;
		case "sqlite":
			correcto = gb.guardarProyeccionesQL(this);
			break;
		case "db4o":
			correcto = DB4o.guardarProyecciones(this);
			break;
		}
		return correcto;
	}
	
	public boolean guardarPelicula() {
		GestorBBDD gb = new GestorBBDD(bbdd);	
		return gb.guardarPelicula(this);
	}
	
	public Pelicula(String titulo, int anoEstreno, String director, String actorPrincipal, String actorSecundario,
			String sinopsis, int duracion, String trailer, Date fechaInicio, Date fechaFin, boolean alta) {
		this.titulo = titulo;
		this.anoEstreno = anoEstreno;
		this.director = director;
		this.actorPrincipal = actorPrincipal;
		this.actorSecundario = actorSecundario;
		this.sinopsis = sinopsis;
		this.duracion = duracion;
		this.trailer = trailer;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.alta = alta;
		proyecciones = new ArrayList<>();
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
		proyecciones = new ArrayList<>();
	}

	
	
	public Pelicula(String titulo, int anoEstreno, String director, String actorPrincipal, String actorSecundario,
			String sinopsis, int duracion, String trailer, Date fechaInicio, Date fechaFin, boolean alta, int id) {
		this.titulo = titulo;
		this.anoEstreno = anoEstreno;
		this.director = director;
		this.actorPrincipal = actorPrincipal;
		this.actorSecundario = actorSecundario;
		this.sinopsis = sinopsis;
		this.duracion = duracion;
		this.trailer = trailer;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.alta = alta;
		this.id = id;
		proyecciones = new ArrayList<>();
	}

	public Pelicula() {	}

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

	public ArrayList<Proyeccion> getProyecciones() {
		return proyecciones;
	}

	public void añadirProyeccion(Proyeccion proyeccion) {
		proyecciones.add(proyeccion);
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
