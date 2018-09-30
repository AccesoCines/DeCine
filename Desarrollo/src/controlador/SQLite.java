package controlador;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

import modelo.*;




public class SQLite{
	public static void main(String[] args) {
			    
	    GestorBBDD gb = new GestorBBDD("sqlite");
	    Sala sala = new Sala(0, 0, "alalal", 0, false);
	    Pelicula p = new Pelicula("dfsf", 0, "dfhakshf", "sdfasdf", "dsffse", 0, "dfsfd");
	    Empleado e = new Empleado("fjkdjf", "dfdf", Cargo.camarero, new java.sql.Date(1985, 6, 10), "dfsdf", new java.sql.Date(1985, 6, 10), new java.sql.Date(1985, 6, 10));
	    boolean correcto = gb.guardarEmpleado(e);
	    if(correcto) {
	    	JOptionPane.showMessageDialog(null, "Correcto", null, 0);
	    }else {
	    	JOptionPane.showMessageDialog(null, "Error", null, 0);
	    }
	}
		
		
		
		
		
		}

}

