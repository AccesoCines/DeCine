package modelo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pelicula {
	private String titulo;
	private int anoEstreno;
	private String director;
	private String actorPrincipal;
	private String actorSecundario;
	private int duracion;
	private String trailer;
	private Map<Sala, java.sql.Date> proyeccion;
	
	public Pelicula(String titulo, int anoEstreno, String director, String actorPrincipal, String actorSecundario,
			int duracion, String trailer) {
		this.titulo = titulo;
		this.anoEstreno = anoEstreno;
		this.director = director;
		this.actorPrincipal = actorPrincipal;
		this.actorSecundario = actorSecundario;
		this.duracion = duracion;
		this.trailer = trailer;
		proyeccion = new HashMap<>();
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
	
	public Map<Sala, java.sql.Date> getProyeccion() {
		return proyeccion;
	}

	public void añadirProyeccion(Sala sala, java.sql.Date hora) {
		proyeccion.put(sala, hora);
		sala.anadirProyeccion(this, hora);
	}
	
}
