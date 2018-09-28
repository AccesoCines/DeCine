package controlador;

import java.util.Calendar;
import java.util.Date;

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
	ObjectContainer db= Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),BDEmpl);

	java.sql.Date date = new java.sql.Date(1985, 6, 10);
	//Recoger del jcalendar en la ventana
	//java.util.Date fecha2 = (java.util.Date) jcalendar.getvalue();
	//En el modelo
	//java.sql.Date sql = new java.sql.Date(fecha2.getTime());

	
	// Creamos Empleados
	Empleado e1 = new Empleado("Irene", "Aparicio", Cargo.camarero, date, "española", date,date);
	Empleado e2 = new Empleado("Belen", "Campos", Cargo.acomodadorResposableBar, date, "española", date, date);
	
	// Creamos Peliculas
	Pelicula p1 = new Pelicula("Jurassic World: El reino caido", 2018, "Juan Antonio Bayona","Chris Pratt", "Bryce Dallas Howard", 128, "trailer" );

	// Creamos Salas
	Sala s1 = new Sala(1, 100, "15*8,5", 2015, true);
	
	//Almacenar objetos Persona en la base de datos
	db.store(e1);
	db.store(e2);
	db.store(p1);
	db.store(s1);
	
	
	
	db.close(); //cerrar base de datos
	}
	}


