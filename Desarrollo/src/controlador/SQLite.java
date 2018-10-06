package controlador;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

import modelo.*;
/*

"INSERT INTO Proyeccion(id,id_sala,id_pelicula,hora,alta) VALUES((select max (id) from Pelicula)+1), ?,?,"
						+ "?,?)";
 */

public class SQLite{
	public static void main(String[] args) {
			    
	    GestorBBDD gb = new GestorBBDD("sqlite");
	   Pelicula p = new Pelicula("LOS ILUSOS", 2013, "JONÁS TRUEBA", "Francesco Carril", "Aura Garrido", "Ba ", 2, "http-ves/", new java.sql.Date(2018, 6, 15), new java.sql.Date(2018, 7, 10), true, 1);
	   Empleado e = new Empleado( "PEPA", "Moriz", Cargo.mantenimiento, new java.sql.Date(1972, 6, 15), new java.sql.Date(2013, 6, 10), "Española", new java.sql.Date(2018, 6, 14), true, 2);    
	   Sala sala = new Sala(34, 34, "alalal", 0, true, e, true, 1);
	//  boolean correcto = gb.guardarSalaQL(sala);
	   //new java.sql.Date(2018, 6, 15), new java.sql.Date(2018, 7, 10)
	    Proyeccion pro = new Proyeccion ( sala, p, new java.sql.Time (20, 30, 00));

	    p.añadirProyeccion(pro);
	    
		  boolean correcto = gb.guardarProyeccionesQL(p);
	    if(correcto) {
	    	JOptionPane.showMessageDialog(null, "Correcto", null, 0);
	    }else {
	    	JOptionPane.showMessageDialog(null, "Error", null, 0);
	    }
	    
	    
	    
	}

		}



