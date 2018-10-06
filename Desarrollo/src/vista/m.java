package vista;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import modelo.Cargo;
import modelo.Empleado;
import modelo.Sala;

public class m {
	
	public static void main(String args[]) throws Exception {
	
	final String BDEmple = "DBEmpleados2.yap";
	
	ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),BDEmple);
	
	
	
	 Empleado e = new Empleado("apagado", "dsfsdf", Cargo.camarero, new java.sql.Date(1985, 6, 10), new java.sql.Date(1985, 6, 10), "erer", new java.sql.Date(1985, 6, 10), true, 4);
	   Sala sala = new Sala(34, 0, "alalal", 0, true, e,true,6);
	    
	   Sala sala2 = new Sala( new Empleado(),34);
	   //db.store(sala);
	   
	   ObjectSet<Sala> result = db.queryByExample(sala2);
	    
	   if (result.size() != 0) {
		   while (result.hasNext()) {
			   Sala s = result.next();
			   System.out.println(s.getNumero());
			   Empleado em = s.getResponsable();
			   System.out.println(em.getNombre());
		   }
	   }
	  

	}

}
