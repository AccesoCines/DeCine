package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgreSQL {
	public static void main(String args[]) throws Exception {
	    Class.forName("org.postgresql.jdbc3");
	    String url = "jdbc:postgresql://localhost:5432/cines";
	    String user = "postgres";
	    String pass = "cines1510";
	    Connection con = null;
	    try{
	    	con = DriverManager.getConnection(url,user,pass);
	    	Statement stmt = con.createStatement();
		    ResultSet rs = stmt.executeQuery("SELECT VESION()");
		    while (rs.next()) {
		    	System.out.println(rs.getString(1));
			}
	    }catch (SQLException ex) {
	    	ex.printStackTrace();
	    }
	    		
	    con.close();
	  }
}
