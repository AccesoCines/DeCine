package modelo;

import java.util.Calendar;
import java.util.List;

public class Empleado {
	private String nombre;
	private String apellido;
	private Cargo cargo;
	private java.sql.Date fechaContratacion;
	private java.sql.Date fechaNacimiento;
	private String nacionalidad;
	private java.sql.Date fechaFinContrato;
	private boolean alta;

	// De 0 a 1 año : Portero , camarero
	// De 1 a 3 años : Acomodador o responsable del bar
	// De 3 a 5 años : Responsable de sala
	// Más de 5 años : Responsable salón de cine
	private List<Sala> salas;

	public Empleado(String nombre, String apellido, Cargo cargo, java.sql.Date fechaNacimiento,
			String nacionalidad,java.sql.Date fechaContratacion, java.sql.Date fechaFinContrato ) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.cargo = cargo;
		this.fechaContratacion = fechaContratacion;
		this.fechaNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;
		this.fechaFinContrato = fechaFinContrato;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public java.sql.Date getFechaContratacion() {
		return fechaContratacion;
	}

	public void setFechaContratacion(java.sql.Date fechaContratacion) {
		this.fechaContratacion = fechaContratacion;
	}

	public java.sql.Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(java.sql.Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public java.sql.Date getFechaFinContrato() {
		return fechaFinContrato;
	}

	public void setFechaFinContrato(java.sql.Date fechaFinContrato) {
		this.fechaFinContrato = fechaFinContrato;
	}

	public List<Sala> getSalas() {
		return salas;
	}

	public void anadirSala(Sala sala) {
		salas.add(sala);

	}

}
