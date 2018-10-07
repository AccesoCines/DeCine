package vista;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import controlador.DB4o;
import controlador.GestorBBDD;
import modelo.Cargo;
import modelo.Empleado;
import modelo.Pelicula;
import modelo.Proyeccion;
import modelo.Sala;

public class m {
	
	public static void main(String args[]) throws Exception {
	
	final String BDCines = "DBCines.yap";
	
	//ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),BDCines);
	
	
	
	 Empleado e = new Empleado("apagado", "dsfsdf", Cargo.camarero, new java.sql.Date(1985, 6, 10), new java.sql.Date(1985, 6, 10), "erer", new java.sql.Date(1985, 6, 10), true, 4);
	   Sala sala = new Sala(34, 0, "alalal", 0, true, e,true,6);
	    
	   Sala sala2 = new Sala( new Empleado(),34);
	   Pelicula peli = new Pelicula("titulo",8,"dire","actor","secun","algo",33,"dfdf",new Date(2017,1,1),new Date(2019,1,1));
	   
	   Proyeccion p = new Proyeccion(sala,peli,new Time(19,30,00),true);
	  peli.añadirProyeccion(p);
	  
	  //DB4o.guardarSala(sala);
	   //DB4o.guardarProyecciones(peli);
	   //DB4o.guardarEmple(e);
	  DB4o.guardarPeli(peli);
	  /*ArrayList<Pelicula> pelis = DB4o.mostrarListPeli();
	  for(Pelicula pep : pelis) {
		  System.out.println(pep.getActorPrincipal());
	  }*/
	  
	  ArrayList<Pelicula> pelis = DB4o.mostrarListPeli();
	  for(Pelicula pep : pelis) {
		  System.out.println(pep.getProyecciones().get(0).getHora());
	  }
	  
	  /*ArrayList<Sala> salas = DB4o.mostrarListSala();
	   for(Sala s :salas) {
		   System.out.println(s.getNumero());
	   }*/
	   
	   
	   
	   /*ObjectSet<Sala> result = db.queryByExample(sala2);
	    
	   if (result.size() != 0) {
		   while (result.hasNext()) {
			   Sala s = result.next();
			   System.out.println(s.getNumero());
			   Empleado em = s.getResponsable();
			   System.out.println(em.getNombre());
		   }
	   }
	  
	   db.close();*/
	}

}
