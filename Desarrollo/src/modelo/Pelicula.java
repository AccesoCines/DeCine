package modelo;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
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
	private static String bbdd; 
	private ArrayList<Proyeccion> proyecciones;
	
	public static String getBbdd() {
		return bbdd;
	}

	public static void setBbdd(String bbdd) {
		Pelicula.bbdd = bbdd;
	}

	public static ArrayList<Pelicula> cargarPeliculas(String bbdd) throws ParseException{
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
	
	public static ArrayList<Pelicula> cargarPeliculasBaja(String elegirBBDD) {
		GestorBBDD gb = new GestorBBDD(elegirBBDD);
		ArrayList<Pelicula> pelis = new ArrayList<>();
		switch(elegirBBDD) {
			case "postgre":
				pelis = gb.cargarPeliculasBaja();
				break;
			case "sqlite":
				pelis = gb.cargarPeliculasBajaQL();
				break;
			case "db4o":
				pelis = DB4o.mostrarListPeliBaja();
				break;
		}
		return pelis;
	}
	
	public boolean guardarProyecciones(String bbdd2) {
		GestorBBDD gb = new GestorBBDD(bbdd2);
		boolean correcto = false;
		switch(bbdd2) {
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
	
	public boolean guardarPelicula(String bbdd) {
		GestorBBDD gb = new GestorBBDD(bbdd);	
		boolean correcto = false;
		switch(bbdd) {
		case "postgre":
			correcto = gb.guardarPelicula(this);
			break;
		case "sqlite":
			correcto = gb.guardarPeliculaQL(this);
			break;
		case "db4o":
			correcto = DB4o.guardarPeli(this);
			break;
		}
		return correcto;
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

	public void anadirProyeccion(Proyeccion proyeccion) {
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

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean bajaPelicula(String bbdd2) {
		GestorBBDD gb = new GestorBBDD(bbdd2);
		boolean correcto = false;
		switch(bbdd2) {
		case "postgre":
			correcto = gb.bajaPelicula(this);
			break;
		case "sqlite":
			correcto = gb.bajaPeliculaQL(this);
			break;
		case "db4o":
			correcto = DB4o.eliminarPeli(this);
			break;
		}
		return correcto;
	}

	
}
