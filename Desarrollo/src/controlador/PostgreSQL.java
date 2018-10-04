package controlador;



import java.util.ArrayList;
import javax.swing.JOptionPane;

import modelo.*;

public class PostgreSQL {
	public static void main(String args[]) throws Exception {
	    GestorBBDD gb = new GestorBBDD("postgre");
	    Pelicula p = new Pelicula("dfsf", 2000, "director", "actorp", "actors", "sinop", 121, "trailer", new java.sql.Date(1985, 6, 10), new java.sql.Date(2019, 6, 10), true);
	    Empleado e = new Empleado("apagado", "dsfsdf", Cargo.camarero, new java.sql.Date(1985, 6, 10), new java.sql.Date(1985, 6, 10), "erer", new java.sql.Date(1985, 6, 10), true, 1);
	    Sala sala = new Sala(34, 0, "alalal", 0, true, e,true,1);
    
	    //gb.guardarPelicula(p);
	    
	    //p.añadirProyeccion(new Proyeccion(sala,p,new java.sql.Time(20,30,00)));
	    //p.añadirProyeccion(new Proyeccion(sala,p, new java.sql.Time(21,30,00)));
	    //p.añadirProyeccion(new Proyeccion(sala,p, new java.sql.Time(22,30,00)));
	    //p.añadirProyeccion(new Proyeccion(sala,p, new java.sql.Time(23,30,00)));
	    //p.añadirProyeccion(new Proyeccion(sala,p, new java.sql.Time(00,30,00)));
	    ArrayList<Pelicula> peliculas = p.cargarPeliculas();
	    
	    for(Pelicula pu:peliculas){
	    	System.out.println(pu.toString());
	    }
	    
	    /*if(correcto) {
	    	JOptionPane.showMessageDialog(null, "Correcto", null, 0);
	    }else {
	    	JOptionPane.showMessageDialog(null, "Error", null, 0);
	    }*/
	}
	

		GestorBBDD gb = new GestorBBDD("postgre");
		Sala sala = new Sala(0, 0, "alalal", 0, false, null);
		Pelicula p = new Pelicula("dfsf", 0, "dfhakshf", "sdfasdf", "dsffse", null, 0, "dfsfd", null, null);
		Empleado e = new Empleado("fjkdjf", "dfdf", Cargo.camarero, new java.sql.Date(1985, 6, 10), "dfsdf",
				new java.sql.Date(1985, 6, 10), new java.sql.Date(1985, 6, 10));
		
		
		boolean correcto = gb.guardarEmpleado(e);
		
		if (correcto) {
			JOptionPane.showMessageDialog(null, "Correcto", null, 0);
		} else {
			JOptionPane.showMessageDialog(null, "Error", null, 0);
		}
}
}
