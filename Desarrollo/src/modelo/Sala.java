package modelo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sala {
	private int numero;
	private int aforo;
	private String dimPantalla;
	private int anoInauguracion;
	private boolean discapacidad;
	private Map<Pelicula,java.sql.Date> proyecciones;
	
	private List<Empleado> empleados;
	
	
	public Sala(int numero, int aforo, String dimPantalla, int anoInauguracion, boolean discapacidad) {
		this.numero = numero;
		this.aforo = aforo;
		this.dimPantalla = dimPantalla;
		this.anoInauguracion = anoInauguracion;
		this.discapacidad = discapacidad;
		proyecciones = new HashMap<>();
	}

	public void anadirProyeccion(Pelicula pelicula,java.sql.Date hora) {
		proyecciones.put(pelicula, hora);
	}
	
	public void anadirEmpleado(Empleado empleado) {
		empleados.add(empleado);
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getAforo() {
		return aforo;
	}

	public void setAforo(int aforo) {
		this.aforo = aforo;
	}

	public String getDimPantalla() {
		return dimPantalla;
	}

	public void setDimPantalla(String dimPantalla) {
		this.dimPantalla = dimPantalla;
	}

	public int getAnoInauguracion() {
		return anoInauguracion;
	}

	public void setAnoInauguracion(int anoInauguracion) {
		this.anoInauguracion = anoInauguracion;
	}

	public boolean isDiscapacidad() {
		return discapacidad;
	}

	public void setDiscapacidad(boolean discapacidad) {
		this.discapacidad = discapacidad;
	}
	
	public Map<Pelicula, java.sql.Date> getProyecciones() {
		return proyecciones;
	}

	public List<Empleado> getEmpleados() {
		return empleados;
	}

	
}
