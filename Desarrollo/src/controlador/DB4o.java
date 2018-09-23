package controlador;

import java.util.Calendar;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class DB4o {
	
	final static String BDEmpl = "DBEmpleados.yap";
	
	public static void main(String[] args) {
		
	//Abrir la BD
	ObjectContainer db= Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),BDEmpl);

	// Creamos Empleados
	Empleado e1 = new Empleado("María", "García", camarero, new Calendar(), );
	Empleado e2 = new Empleado("Ana", "Madrid");
	Empleado e3 = new Empleado("Luis", "Granada");
	Empleado e4 = new Empleado("Pedro", "Asturias");
	
	//Almacenar objetos Persona en la base de datos
	db.store(e1);
	db.store(e2);
	db.store(e3);
	db.store(e4);
	
	db.close(); //cerrar base de datos
	}
	}


