package controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import modelo.Cargo;
import modelo.Empleado;
import modelo.Pelicula;
import modelo.Proyeccion;
import modelo.Sala;

public class DB4o {
	
	
	final static String BDCine = "DBCines.yap";
	
	private ObjectContainer rootContainer;
	
		
	//Abrir la BD
	ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),BDCine);
		
	//java.sql.Date date = new java.sql.Date(1985, 6, 10);
	//Recoger del jcalendar en la ventana
	//java.util.Date fecha2 = (java.util.Date) jcalendar.getvalue();
	//En el modelo
	//java.sql.Date sql = new java.sql.Date(fecha2.getTime());

	/*
	// Creamos Empleados
	Empleado e1 = new Empleado("Irene", "Aparicio", Cargo.camarero, date, date "espa�ola",date);
	Empleado e2 = new Empleado("Belen", "Campos", Cargo.acomodadorResponsableBar, date, date, "espa�ola", date);
	Empleado e3 = new Empleado("Maria", "Elorza", Cargo.portero, date, date, "espa�ola", date);
	Empleado e4 = new Empleado("Jon", "Garcia", Cargo.responsableSala, date, date, "espa�ola", date);
	Empleado e5 = new Empleado("Mario", "Izquierdo", Cargo.responsableCine, date, date, "venezolano", date);
	Empleado e6 = new Empleado("John", "Smith", Cargo.camarero, date, date, "canadiense", date);
	Empleado e7 = new Empleado("Oscar", "Gonzalez", Cargo.portero, date, date, "argentino", date);
	Empleado e8 = new Empleado("Marta", "Lopez", Cargo.mantenimiento, date, date, "espa�ola", date);
	Empleado e9 = new Empleado("Iker", Urquiza, Cargo.responsableSala, date, date, "espa�ola", date);
	Empleado e10 = new Empleado("Uxune", "Etxeberria", Cargo.responsableCine,date, date, "espa�ola", date);
	db.store(e1);
	db.store(e2);
	db.store(e3);
	db.store(e4);
	db.store(e5);
	db.store(e6);
	db.store(e7);
	db.store(e8);
	db.store(e9);
	db.store(e10);
	
	
	// ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDPeli);
	// Creamos Peliculas
	String titulo;
	int anoEstreno;
	String director;
	String actorPrincipal;
	String actorSecundario;
	String sinopsis;
	int duracion;
	String trailer;
	java.sql.Date fechaInicio;
	java.sql.Date fechaFin;
	Pelicula p1 = new Pelicula("Jurassic World: El reino caido", 2018, "Juan Antonio Bayona","Chris Pratt", "Bryce Dallas Howard", 128, "trailer" );
	Pelicula p2 = new Pelicula("La Monja", 2018, "Corin Hardy", "Bonnie Aarons", "Taissa Farmiga", 96, "trailer");
	
	
	// ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDSala);
	// Creamos Salas
	Sala s1 = new Sala(1, 100, "15*8,5", 2015, true);
	Sala s2 = new Sala(2, 125, "15*8,5", 2015, true);
	Sala s3 = new Sala(3, 125, "5*3,5", 2013, false);
	Sala s4 = new Sala(4, 150, "15*8,5, 2014, true);
	Sala s5 = new Sala(5, 100, "10*5", 2012, true);
	Sala s6 = new Sala(6, 125, "7*3,5", 2012, false);
	Sala s7 = new Sala(7, 150, "10*5, 2014, true);
	Sala s8 = new Sala(8, 125, "15*8,5", 2012, true);
	Sala s9 = new Sala(9, 150, "10*5", 2013, true);
	Sala s10 = new Sala(10, 125, "7*3,5", 2012, true);
	
	
	
	//Almacenar objetos Persona en la base de datos
	db.store(e1);
	
	 
	
	db.store(p1);
	db.store(p2);
	db.store(s1);
	db.store(s2);
	db.close(); //cerrar base de datos
	*/
	
	
	
		Empleado e2 = new Empleado(
				"Miriam", 
				"Campos", 
				Cargo.acomodadorResponsableBar, 
				new Date(2018,12,20), 
				new Date(2018,12,20), 
				"espa�ola", 
				new Date(2018,12,20),
				true
				);
	//guardarEmple(e2);
	
	
	
	
	public static void guardarEmple(Empleado e){
		
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),BDCine);
		db.store(e);
		javax.swing.JOptionPane.showMessageDialog(null, "Guardado");
		db.close();
		
	}
	
	public static void eliminarEmple(Empleado e) {
		
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),BDCine);
		e.setAlta(false);
		//No se elimina el empleado, el atributo alta pasa a false.
		javax.swing.JOptionPane.showMessageDialog(null, "Eliminado");
		db.close();
	}
		
	public static void modificarEmple(Empleado e) {
		
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),BDCine);
		
		//e.setNombre(getText(jlabel1));
		//e.setApellido(getText(jlabel2));
		
		db.store(e);
		javax.swing.JOptionPane.showMessageDialog(null, "Modificado");
		db.close();
	}
	
	public static ArrayList <Empleado> mostrarListEmple() {
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),BDCine);
		Empleado em = new Empleado( null, null, null, null, null, null, null );
		
		ArrayList<Empleado> listaEmpleados = new ArrayList<Empleado>();
		ObjectSet<Empleado> result = db.queryByExample(em);
		if (result.size() == 0){
			javax.swing.JOptionPane.showMessageDialog(null, "No hay empleados.");
		}
		while (result.hasNext()) {
		Empleado e = result.next();
		listaEmpleados.add(e);
	
		}
		
		db.close();
		return listaEmpleados;
		
	}

	
	public static ArrayList<Empleado> historicoEmple() {
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),BDCine);
		Empleado em = new Empleado( null, null, null, null, null, null, null, false);
		
		ArrayList<Empleado> listaEmpleados = new ArrayList<>();
		ObjectSet<Empleado> result = db.queryByExample(em);
		if (result.size() == 0){
			javax.swing.JOptionPane.showMessageDialog(null, "No hay empleados en hist�rico.");
		}
		while (result.hasNext()) {
		Empleado e = result.next();
		
		listaEmpleados.add(e);
		}
		db.close();
		return listaEmpleados;
	
	}



		public static void guardarPeli(Pelicula p){
		
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),BDCine);
		db.store(p);
		javax.swing.JOptionPane.showMessageDialog(null, "Guardado");
		db.close();
		
	}
	
	public static void eliminarPeli(Pelicula p) {
		
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),BDCine);
		p.setAlta(false);
		//No se elimina la pelicula, el atributo alta pasa a false.
		javax.swing.JOptionPane.showMessageDialog(null, "Eliminado");
		db.close();
	}
		
	public static void modificarPeli(Pelicula p) {
		
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),BDCine);
		
		//p.setNombre(getText(jlabel1));
		//p.setApellido(getText(jlabel2));
		
		db.store(p);
		javax.swing.JOptionPane.showMessageDialog(null, "Modificado");
		db.close();
	}
	
	public static ArrayList <Sala> mostrarListSala() {
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),BDCine);
		
		Sala sa = new Sala();
		
		ArrayList<Sala> listaSalas = new ArrayList<Sala>();
		ObjectSet<Sala> result = db.queryByExample(sa);
		if (result.size() == 0){
			javax.swing.JOptionPane.showMessageDialog(null, "No hay salas.");
		}else {
			while (result.hasNext()) {
			Sala s = result.next();
			listaSalas.add(s);
			}
		}
		
		db.close();
		return listaSalas;
		
	}
	
	public static ArrayList <Pelicula> mostrarListPeli() {
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),BDCine);
		Pelicula pe = new Pelicula();
		
		ArrayList<Pelicula> listaPeliculas = new ArrayList<Pelicula>();
		ObjectSet<Pelicula> result = db.queryByExample(pe);
		if (result.size() == 0){
			javax.swing.JOptionPane.showMessageDialog(null, "No hay peliculas.");
		}else {
			while (result.hasNext()) {
				Pelicula p = (Pelicula) result.next();
				listaPeliculas.add(p);
		
			}
		}
		db.close();
		return listaPeliculas;
	}

	
	public static ArrayList<Pelicula> historicoPeli() {
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),BDCine);
		Pelicula pe = new Pelicula( null, 0, null, null, null, null, 0, null, null, null, false);
		
		ArrayList<Pelicula> listaPeliculas = new ArrayList<>();
		ObjectSet<Pelicula> result = db.queryByExample(pe);
		if (result.size() == 0){
			javax.swing.JOptionPane.showMessageDialog(null, "No hay peliculas en historico.");
		}
		while (result.hasNext()) {
		Pelicula p = result.next();
		
		listaPeliculas.add(p);
		}
		db.close();
		return listaPeliculas;
	}
	
	public static void guardarSala(Sala s){
		
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),BDCine);
		db.store(s);
		javax.swing.JOptionPane.showMessageDialog(null, "Guardado");
		db.close();
		
	}
	
	public static void eliminarSala(Sala s) {
		
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),BDCine);
		s.setAlta(false);
		//No se elimina la sala, el atributo alta pasa a false.
		javax.swing.JOptionPane.showMessageDialog(null, "Eliminado");
		db.close();
	}
		
	public static void modificarSala(Sala s) {
		
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),BDCine);
		
		//s.setNombre(getText(jlabel1));
		//s.setApellido(getText(jlabel2));
		
		db.store(s);
		javax.swing.JOptionPane.showMessageDialog(null, "Modificado");
		db.close();
	}
	
	public static ArrayList<Sala> historicoSalas() {
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),BDCine);
		Sala sa = new Sala( 0, 0, null, 0, false, null, false);
		
		ArrayList<Sala> listaSalas = new ArrayList<>();
		ObjectSet<Sala> result = db.queryByExample(sa);
		if (result.size() == 0){
			javax.swing.JOptionPane.showMessageDialog(null, "No hay salas en historico.");
		}
		while (result.hasNext()) {
			Sala s = result.next();
			
			listaSalas.add(s);
		}
		db.close();
		return listaSalas;
	}
	
	public static boolean guardarProyecciones(Pelicula p) {
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),BDCine);
		for(Proyeccion pro :p.getProyecciones() ) {
			db.store(pro);
		}
		db.close();
		return true;
	}
	
	/*public ArrayList<Proyeccion> mostrarListaProyecciones(){
		ArrayList<Proyeccion> proyecciones = new ArrayList<>();
		
		
	}*/
}
	
	
	
	


