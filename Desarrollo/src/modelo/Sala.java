package modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import controlador.DB4o;
import controlador.GestorBBDD;

public class Sala {
	private int numero;
	private int aforo;
	private String dimPantalla;
	private int anoInauguracion;
	private boolean discapacidad;
	private Empleado responsable;
	private boolean alta;
	private int id;
	private String bbdd = "db4o"; //TODO cambiar por variable desde la ventana anterior
	//Cuando se carga la ventana hay que traer aqu� la variable de que BBDD es para pasarla al new GestorBBDD
	
	private ArrayList<Proyeccion> proyecciones;
	private ArrayList<Empleado> empleados;
	
	public Sala() {	}
	
	public Sala(Empleado responsable,int numero) {
		this.responsable = responsable;
		this.numero = numero;
	}

	public Sala(int numero, int aforo, String dimPantalla, int anoInauguracion, boolean discapacidad,
			Empleado responsable, boolean alta) {
		this.numero = numero;
		this.aforo = aforo;
		this.dimPantalla = dimPantalla;
		this.anoInauguracion = anoInauguracion;
		this.discapacidad = discapacidad;
		this.setResponsable(responsable);
		this.alta = alta;
		proyecciones = new ArrayList<>();
	}
	
	public Sala(int numero, int aforo, String dimPantalla, int anoInauguracion, boolean discapacidad,
			Empleado responsable, boolean alta, int id) {
		this.numero = numero;
		this.aforo = aforo;
		this.dimPantalla = dimPantalla;
		this.anoInauguracion = anoInauguracion;
		this.discapacidad = discapacidad;
		this.responsable = responsable;
		this.alta = alta;
		this.id = id;
		proyecciones = new ArrayList<>();
	}

	public Sala(int numero, int aforo, String dimPantalla, int anoInauguracion, boolean discapacidad, int id) {
		this.numero = numero;
		this.aforo = aforo;
		this.dimPantalla = dimPantalla;
		this.anoInauguracion = anoInauguracion;
		this.discapacidad = discapacidad;
		this.id = id;
		proyecciones = new ArrayList<>();
	}


	public Sala(int numero, int aforo, String dimPantalla, int anoInauguracion, boolean discapacidad,
			Empleado responsable) {
		this.numero = numero;
		this.aforo = aforo;
		this.dimPantalla = dimPantalla;
		this.anoInauguracion = anoInauguracion;
		this.discapacidad = discapacidad;
		this.setResponsable(responsable);
		proyecciones = new ArrayList<>();
	}
	
	public static ArrayList<Sala> cargarSalas(String bbdd) {
		GestorBBDD gb = new GestorBBDD(bbdd);
		ArrayList<Sala> salas = new ArrayList<>();
		switch(bbdd) {
		case "postgre":
			salas = gb.cargarSalas();
			break;
		case "sqlite":
			salas = gb.cargarSalasQL();
			break;
		case "db4o":
			salas = DB4o.mostrarListSala();
		}
		return salas;
	}
	
	public boolean guardarSala(String bbdd) {
		GestorBBDD gb = new GestorBBDD(bbdd);	
		boolean correcto = false;
		switch(bbdd) {
		case "postgre":
			correcto = gb.guardarSala(this);
			break;
		case "sqlite":
			correcto = gb.guardarSalaQL(this);
			break;
		case "db4o":
			correcto = DB4o.guardarSala(this);
			break;
		}
		return correcto;
	}

	public void anadirProyeccion(Proyeccion proyeccion) {
		proyecciones.add(proyeccion);
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
	
	public ArrayList<Proyeccion> getProyecciones() {
		return proyecciones;
	}

	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public boolean isAlta() {
		return alta;
	}

	public void setAlta(boolean alta) {
		this.alta = alta;
	}

	public Empleado getResponsable() {
		return responsable;
	}

	public void setResponsable(Empleado responsable) {
		this.responsable = responsable;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
}
