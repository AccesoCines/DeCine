package modelo;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Empleado {
	private String nombre;
	private String apellido;
	private Cargo cargo; 
	private Calendar fechaContratacion;
	private Calendar fechaNacimiento;
	private String nacionalidad;
	private Date fechaFinContrato;
	
	private List<Sala> salas;
	
	public Empleado(String nombre, String apellido, Cargo cargo, Calendar fechaContratacion, Calendar fechaNacimiento,
			String nacionalidad, Date fechaFinContrato) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.cargo = cargo;
		this.fechaContratacion = fechaContratacion;
		this.fechaNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;
		this.fechaFinContrato = fechaFinContrato;
	}
	
	public void anadirSala(Sala sala) {
		salas.add(sala);
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

	public Date getFechaContratacion() {
		return fechaContratacion;
	}

	public void setFechaContratacion(Date fechaContratacion) {
		this.fechaContratacion = fechaContratacion;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	
	public Date getFechaFinContrato() {
		return fechaFinContrato;
	}

	public void setFechaFinContrato(Date fechaFinContrato) {
		this.fechaFinContrato = fechaFinContrato;
	}

	public List<Sala> getSalas(){
		return salas;
	}
	
}
