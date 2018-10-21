package modelo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import controlador.DB4o;
import controlador.GestorBBDD;

public class Empleado {
	private String nombre;
	private String apellido;
	private Cargo cargo;
	private java.sql.Date fechaContratacion;
	private java.sql.Date fechaNacimiento;
	private String nacionalidad;
	private java.sql.Date fechaFinContrato;
	private boolean alta;
	private int id;
	private String bbdd;


	// De 0 a 1 año : Portero , camarero
	// De 1 a 3 años : Acomodador o responsable del bar
	// De 3 a 5 años : Responsable de sala
	// Más de 5 años : Responsable salón de cine
	private List<Sala> salas;
	//LA BBDD LA CARGA EN VENTANA LISTADO
	public boolean guardarEmpleado(String bbdd) {
		GestorBBDD gb = new GestorBBDD(bbdd);
		boolean correcto = false;
		switch(bbdd) {
		case "postgre":
			correcto = gb.guardarEmpleado(this);
			break;
		case "sqlite":
			correcto = gb.guardarEmpleadoQL(this);
			break;
		case "db4o":
			correcto = DB4o.guardarEmple(this);
			break;
		}
		return correcto;
	}
	
	public boolean modificarEmpleado(String bbdd2) {
		GestorBBDD gb = new GestorBBDD(bbdd2);
		boolean correcto = false;
		switch(bbdd2) {
		case "postgre":
			correcto = gb.modificarEmpleado(this);
			break;
		case "sqlite":
			correcto = gb.modificarEmpleadoQL(this);
			break;
		case "db4o":
			correcto = DB4o.modificarEmple(this);
			break;
		}
		return correcto;
	}

	public boolean bajaEmpleado(String bbdd2) {
		GestorBBDD gb = new GestorBBDD(bbdd2);
		boolean correcto = false;
		switch(bbdd2) {
		case "postgre":
			correcto = gb.bajaEmpleado(this);
			break;
		case "sqlite":
			correcto = gb.bajaEmpleadoQL(this);
			break;
		case "db4o":
			correcto = DB4o.eliminarEmple(this);
			break;
		}
		return correcto;
	}
	
	public static ArrayList<Empleado> cargarEmpleados(String bbdd){
		GestorBBDD gb = new GestorBBDD(bbdd);
		ArrayList<Empleado> empleados = new ArrayList<>();
		switch(bbdd) {
			case "postgre":
				empleados = gb.cargarEmpleados();
				break;
			case "sqlite":
				empleados = gb.cargarEmpleadosQL();
				break;
			case "db4o":
				empleados = DB4o.mostrarListEmple();
				break;
		}
		return empleados;
	}
	
	public static ArrayList<Empleado> cargarEmpleadosResp(String bbdd){
		GestorBBDD gb = new GestorBBDD(bbdd);
		ArrayList<Empleado> empleados = new ArrayList<>();
		switch(bbdd) {
			case "postgre":
				empleados = gb.cargarEmpleadosResp();
				break;
			case "sqlite":
				empleados = gb.cargarEmpleadosRespQL();
				break;
			case "db4o":
				empleados = DB4o.mostrarListEmpleResp();
				break;
		}
		return empleados;
	}
	
	public Empleado(String nombre, String apellido, Cargo cargo, Date fechaContratacion, Date fechaNacimiento,
			String nacionalidad, Date fechaFinContrato, boolean alta) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.cargo = cargo;
		this.fechaContratacion = fechaContratacion;
		this.fechaNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;
		this.fechaFinContrato = fechaFinContrato;
		this.alta = alta;
	}

	public Empleado() {
		
	}
	
	public Empleado(String nombre, String apellido, Cargo cargo, Date fechaNacimiento,
			String nacionalidad,Date fechaContratacion, Date fechaFinContrato ) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.cargo = cargo;
		this.fechaContratacion = fechaContratacion;
		this.fechaNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;
		this.fechaFinContrato = fechaFinContrato;
		this.alta = true;
	}
	
	

	public Empleado(String nombre, String apellido, Cargo cargo, Date fechaContratacion, Date fechaNacimiento,
			String nacionalidad, Date fechaFinContrato, boolean alta, int id) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.cargo = cargo;
		this.fechaContratacion = fechaContratacion;
		this.fechaNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;
		this.fechaFinContrato = fechaFinContrato;
		this.alta = alta;
		this.setId(id);
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

	public boolean isAlta() {
		return alta;
	}

	public void setAlta(boolean alta) {
		this.alta = alta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	
}
