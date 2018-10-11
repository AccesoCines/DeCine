package modelo;

import java.util.ArrayList;

public class MetaDato {
	private String nombreBD;
	private String driver;
	private String url;
	private String usuario;
	private ArrayList<Tabla> tablas;
	
	public MetaDato(String nombreBD, String driver, String url, String usuario) {
		this.nombreBD = nombreBD;
		this.driver = driver;
		this.url = url;
		this.usuario = usuario;
		tablas = new ArrayList<>();
	}

	public MetaDato() {
	}

	public String getNombreBD() {
		return nombreBD;
	}

	public void setNombreBD(String nombreBD) {
		this.nombreBD = nombreBD;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public ArrayList<Tabla> getTablas() {
		return tablas;
	}
	
	public void anadirTabla(Tabla tabla) {
		tablas.add(tabla);
	}
}
