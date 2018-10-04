package controlador;



import java.util.ArrayList;
import javax.swing.JOptionPane;

import modelo.*;

public class PostgreSQL {
	public static void main(String args[]) throws Exception {
	    GestorBBDD gb = new GestorBBDD("postgre");
	    Pelicula p = new Pelicula("dfsf", 2000, "director", "actorp", "actors", "sinop", 121, "trailer", new java.sql.Date(1985, 6, 10), new java.sql.Date(2019, 6, 10), true,1);
	    Empleado e = new Empleado("apagado", "dsfsdf", Cargo.camarero, new java.sql.Date(1985, 6, 10), new java.sql.Date(1985, 6, 10), "erer", new java.sql.Date(1985, 6, 10), true, 1);
	    Sala sala = new Sala(34, 0, "alalal", 0, true, e,true,1);
    
	    //gb.guardarPelicula(p);
	    //gb.guardarEmpleado(e);
	    //gb.guardarSala(sala);
	    
	    p.añadirProyeccion(new Proyeccion(sala,p,new java.sql.Time(20,30,00)));
	    p.añadirProyeccion(new Proyeccion(sala,p, new java.sql.Time(21,30,00)));
	    p.añadirProyeccion(new Proyeccion(sala,p, new java.sql.Time(22,30,00)));
	    p.añadirProyeccion(new Proyeccion(sala,p, new java.sql.Time(23,30,00)));
	    p.añadirProyeccion(new Proyeccion(sala,p, new java.sql.Time(00,30,00)));
	    //ArrayList<Pelicula> peliculas = p.cargarPeliculas();
	    
	    /*for(Pelicula pu:peliculas){
	    	System.out.println(pu.toString());
	    }*/
	    
	    gb.guardarProyecciones(p);
	    
	    boolean correcto = true;
	    
	    if(correcto) {
	    	JOptionPane.showMessageDialog(null, "Correcto", null, 0);
	    }else {
	    	JOptionPane.showMessageDialog(null, "Error", null, 0);
	    }
	}
	
}
