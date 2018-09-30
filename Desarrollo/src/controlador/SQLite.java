package controlador;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

import modelo.*;




public class SQLite{
	public static void main(String[] args) {
			    
	    GestorBBDD gb = new GestorBBDD("sqlite");
	    Pelicula p = new Pelicula("", 0, "dfhakshf", "sdfasdf", "dsffse", null, 0, "dfsfd", null, null);
	    Empleado e = new Empleado( "María", "Moriz", Cargo.mantenimiento, new java.sql.Date(1972, 6, 15), new java.sql.Date(2013, 6, 10), "Española", new java.sql.Date(2018, 6, 14), true);
	    Sala sala = new Sala(0, 0, "alalal", 0, false, e);
	    boolean correcto = gb.guardarEmpleadoQL(e);
	    if(correcto) {
	    	JOptionPane.showMessageDialog(null, "Correcto", null, 0);
	    }else {
	    	JOptionPane.showMessageDialog(null, "Error", null, 0);
	    }
	}
		
		
		
		
		
		}



