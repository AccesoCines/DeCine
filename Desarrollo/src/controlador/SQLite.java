package controlador;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

import modelo.*;
/*
 * "INSERT INTO Pelicula (titulo,ano_estreno,director,actor_principal,"
					+ "actor_secundario,sinopsis,duracion,trailer,fecha_Inicio,fecha_Fin,alta) VALUES(?,?,"
					+ "?,?,?,?,?,?,?,?,?, (select max (id) from Empleado)+1)";
 */

public class SQLite{
	public static void main(String[] args) {
			    
	    GestorBBDD gb = new GestorBBDD("sqlite");
	   Pelicula p = new Pelicula("LOS ILUSOS", 2013, "JONÁS TRUEBA", "Francesco Carril", "Aura Garrido","Ba ", 2, "http-ves/", new java.sql.Date(2018, 6, 15), new java.sql.Date(2018, 7, 10), true);
	  // Empleado e = new Empleado( "PEPA", "Moriz", Cargo.mantenimiento, new java.sql.Date(1972, 6, 15), new java.sql.Date(2013, 6, 10), "Española", new java.sql.Date(2018, 6, 14), true, 2);    
	    
	//    Sala sala = new Sala(34, 34, "alalal", 0, true, e, true);
	//  boolean correcto = gb.guardarSalaQL(sala);
	   //new java.sql.Date(2018, 6, 15), new java.sql.Date(2018, 7, 10)
	    
		  boolean correcto = gb.guardarPeliculaQL(p);
	    if(correcto) {
	    	JOptionPane.showMessageDialog(null, "Correcto", null, 0);
	    }else {
	    	JOptionPane.showMessageDialog(null, "Error", null, 0);
	    }
	    
	    
	    
	}

		}



