package controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import modelo.Cargo;
import modelo.Empleado;
import modelo.Pelicula;
import modelo.Sala;

public class DB4o {
	
	
	final static String BDEmpl = "DBEmpleados.yap";
	
	
	public static void main(String[] args) {
		
	//Abrir la BD
	//ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),BDEmpl);

	java.sql.Date date = new java.sql.Date(1985, 6, 10);
	//Recoger del jcalendar en la ventana
	//java.util.Date fecha2 = (java.util.Date) jcalendar.getvalue();
	//En el modelo
	//java.sql.Date sql = new java.sql.Date(fecha2.getTime());

	/*
	// Creamos Empleados
	Empleado e1 = new Empleado("Irene", "Aparicio", Cargo.camarero, date, "espa�ola", date,date);
	Empleado e2 = new Empleado("Belen", "Campos", Cargo.acomodadorResponsableBar, date, "espa�ola", date, date);
	
	// Creamos Peliculas
	Pelicula p1 = new Pelicula("Jurassic World: El reino caido", 2018, "Juan Antonio Bayona","Chris Pratt", "Bryce Dallas Howard", 128, "trailer" );
	Pelicula p2 = new Pelicula("La Monja", 2018, "Corin Hardy", "Bonnie Aarons", "Taissa Farmiga", 96, "trailer");
	
	// Creamos Salas
	Sala s1 = new Sala(1, 100, "15*8,5", 2015, true);
	Sala s2 = new Sala(2, 120, "15*8,5", 2015, true);
	
	//Almacenar objetos Persona en la base de datos
	db.store(e1);
	
	 
	
	db.store(p1);
	db.store(p2);
	db.store(s1);
	db.store(s2);
	db.close(); //cerrar base de datos
	*/
	
	
	
		Empleado e2 = new Empleado("Miriam", "Campos", Cargo.acomodadorResponsableBar, date, "espa�ola", date, date);
	//guardarEmple(e2);
	
	
	
	}
	public static void guardarEmple(Empleado e){
		
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),BDEmpl);
		db.store(e);
		javax.swing.JOptionPane.showMessageDialog(null, "Guardado");
		db.close();
		
	}
	
	public static void eliminarEmple(Empleado e) {
		
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),BDEmpl);
		e.setAlta(false);
		//No se elimina el empleado, el atributo alta pasa a false.
		javax.swing.JOptionPane.showMessageDialog(null, "Eliminado");
		db.close();
	}
		
	public static void modificarEmple(Empleado e) {
		
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),BDEmpl);
		
		//e.setNombre(getText(jlabel1));
		//e.setApellido(getText(jlabel2));
		
		db.store(e);
		javax.swing.JOptionPane.showMessageDialog(null, "Modificado");
		db.close();
	}
	
	public static ArrayList <Empleado> mostrarListEmple() {
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),BDEmpl);
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
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),BDEmpl);
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
	}
	
	
	


