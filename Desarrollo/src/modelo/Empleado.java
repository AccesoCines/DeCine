package modelo;

import java.util.Calendar;
import java.util.List;

public class Empleado {
	private String nombre;
	private String apellido;
	private Cargo cargo;
	private Calendar fechaContratacion;
	private Calendar fechaNacimiento;
	private String nacionalidad;
	private Calendar fechaFinContrato;

	private List<Sala> salas;

	public Empleado(String nombre, String apellido, Cargo cargo, Calendar fechaContratacion, Calendar fechaNacimiento,
			String nacionalidad, Calendar fechaFinContrato) {
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

	public Calendar getFechaContratacion() {
		return fechaContratacion;
	}

	public void setFechaContratacion(Calendar fechaContratacion) {
		this.fechaContratacion = fechaContratacion;
	}

	public Calendar getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Calendar fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public Calendar getFechaFinContrato() {
		return fechaFinContrato;
	}

	public void setFechaFinContrato(Calendar fechaFinContrato) {
		this.fechaFinContrato = fechaFinContrato;
	}

	public List<Sala> getSalas() {
		return salas;
	}

	public void anadirSala(Sala sala) {
		salas.add(sala);

	}

}
