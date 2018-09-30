package controlador;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

import modelo.*;
/*
INSERT INTO Pelicula VALUES (1, "COLOR SEQUENCE", 1943, "DWINELL GRANT", "-", "-", 2, "https://www.caninomag.es/cine-experimental-10-peliculas-que-te-haran-amarlo-de-una-vez-por-todas/", 1);
 * 
 */


//TODO INSERT PELICULA PREGUNTAR POR QUE EN EL CONSTRUCTOR NO ESTÁN LAS FECHAS Y LA SINOPSIS
public class SQLite{
	public static void main(String[] args) {
			    
	    GestorBBDD gb = new GestorBBDD("sqlite");
	    Pelicula p = new Pelicula( "COLOR SEQUENCE", 1943, "DWINELL GRANT", "-", "-", 2, "https://www.caninomag.es/cine-experimental-10-peliculas-que-te-haran-amarlo-de-una-vez-por-todas/", 1);
	    Empleado e = new Empleado( "María", "Moriz", Cargo.mantenimiento, new java.sql.Date(1972, 6, 15), new java.sql.Date(2013, 6, 10), "Española", new java.sql.Date(2018, 6, 14), true, 2);    
	    
	//    Sala sala = new Sala(34, 34, "alalal", 0, true, e, true);
	//  boolean correcto = gb.guardarSalaQL(sala);
	    
		  boolean correcto = gb.guardarPeliculaQL(p);
	    if(correcto) {
	    	JOptionPane.showMessageDialog(null, "Correcto", null, 0);
	    }else {
	    	JOptionPane.showMessageDialog(null, "Error", null, 0);
	    }
	    
	    
	    
	}

		}



