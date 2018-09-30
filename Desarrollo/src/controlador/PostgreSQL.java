package controlador;



import javax.swing.JOptionPane;

import modelo.*;
public class PostgreSQL {
	public static void main(String args[]) throws Exception {
	    GestorBBDD gb = new GestorBBDD("postgre");
	    Pelicula p = new Pelicula("dfsf", 0, "dfhakshf", "sdfasdf", "bob", "dsdfs", 0, "dfsfd", new java.sql.Date(1985, 6, 10), new java.sql.Date(1985, 6, 10),false,1);
	    Empleado e = new Empleado("apagado", "dsfsdf", Cargo.camarero, new java.sql.Date(1985, 6, 10), new java.sql.Date(1985, 6, 10), "erer", new java.sql.Date(1985, 6, 10), true, 1);
	    Sala sala = new Sala(34, 0, "alalal", 0, true, e,true,1);
    
	    
	    p.añadirProyeccion(new Proyeccion(sala,p,new java.sql.Time(20,30,00)));
	    p.añadirProyeccion(new Proyeccion(sala,p, new java.sql.Time(21,30,00)));
	    p.añadirProyeccion(new Proyeccion(sala,p, new java.sql.Time(22,30,00)));
	    p.añadirProyeccion(new Proyeccion(sala,p, new java.sql.Time(23,30,00)));
	    p.añadirProyeccion(new Proyeccion(sala,p, new java.sql.Time(00,30,00)));
	    boolean correcto = gb.modificarEmpleado(e);
	    if(correcto) {
	    	JOptionPane.showMessageDialog(null, "Correcto", null, 0);
	    }else {
	    	JOptionPane.showMessageDialog(null, "Error", null, 0);
	    }
	}
	
}
