package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map.Entry;

import modelo.*;

public class GestorBBDD {
	
	private String baseDatos;
	private String url;
	private String user;
	private String passw;
	private Connection con;
	
	//Constructor SQLite
	public GestorBBDD(String baseDatos) {
		switch(baseDatos) {
		case "postgre":
			url = "jdbc:postgresql://localhost:5433/cines";
		    user = "postgres";
		    passw = "";
		    try {
		    	Class.forName("org.postgresql.Driver"); 
				con = DriverManager.getConnection(url,user,passw);
			} catch (SQLException e) {
				javax.swing.JOptionPane.showMessageDialog(null ,"Ha ocurrido un problema \n"+e.getMessage());
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				javax.swing.JOptionPane.showMessageDialog(null ,"Ha ocurrido un problema \n"+e.getMessage());
				e.printStackTrace();
			}
			break;
		case "mysql":
			
			break;
		case "sqlite":
			
			break;			
		}
	}

	
	public boolean guardarSala(Sala sala) {
		try {
			String query = "INSERT INTO "+'"'+"Sala"+'"'+"(numero,aforo,dimensiones_pantalla,"
					+ "ano_inauguracion,discapacidad,alta,id_responsable) VALUES(?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, sala.getNumero());
			ps.setInt(2, sala.getAforo());
			ps.setString(3, sala.getDimPantalla());
			ps.setInt(4, sala.getAnoInauguracion());
			ps.setBoolean(5, sala.isDiscapacidad());
			ps.setBoolean(6, sala.isAlta());
			ps.setInt(7, sala.getResponsable().getId());
			ps.execute();
			ps.close();
			return true;
		} catch (SQLException e) {
			javax.swing.JOptionPane.showMessageDialog(null ,"Ha ocurrido un problema \n"+e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean guardarEmpleado(Empleado empleado) {
		try {
			String query = "INSERT INTO "+'"'+"Empleado"+'"'+" (nombre,apellido,cargo,fechanacimiento,"
					+ "nacionalidad,fechacontratacion,fechafincontrato,alta) VALUES(?,?,"
					+ "?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, empleado.getNombre());
			ps.setString(2, empleado.getApellido());		
			ps.setString(3, empleado.getCargo().toString());
			ps.setDate(4, empleado.getFechaNacimiento());
			ps.setString(5, empleado.getNacionalidad());
			ps.setDate(6, empleado.getFechaContratacion());
			ps.setDate(7, empleado.getFechaFinContrato());
			ps.setBoolean(8, empleado.isAlta());
			ps.execute();
			ps.close();
			return true;
		} catch (SQLException e) {
			javax.swing.JOptionPane.showMessageDialog(null ,"Ha ocurrido un problema \n"+e.getMessage());
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean guardarPelicula(Pelicula pelicula) {
		try {
			String query = "INSERT INTO "+'"'+"Pelicula"+'"'+" (titulo,ano_estreno,director,actor_principal,"
					+ "actor_secundario,duracion,trailer,alta) VALUES(?,?,"
					+ "?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, pelicula.getTitulo());
			ps.setInt(2, pelicula.getAnoEstreno());		
			ps.setString(3, pelicula.getDirector());
			ps.setString(4, pelicula.getActorPrincipal());
			ps.setString(5, pelicula.getActorSecundario());
			ps.setInt(6, pelicula.getDuracion());
			ps.setString(7, pelicula.getTrailer());
			ps.setBoolean(8, pelicula.isAlta());
			ps.execute();
			ps.close();
			return true;
		} catch (SQLException e) {
			javax.swing.JOptionPane.showMessageDialog(null ,"Ha ocurrido un problema \n"+e.getMessage());
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean guardarProyecciones(Pelicula pelicula) {
		try {
				for(Proyeccion proyeccion: pelicula.getProyecciones()) {
					String query = "INSERT INTO "+'"'+"Proyeccion"+'"'+" (id_sala,id_pelicula,hora,alta) "
							+ "VALUES(?,?,?,?)";
					PreparedStatement ps = con.prepareStatement(query);
					ps.setInt(1, proyeccion.getSala().getId());
					ps.setInt(2, proyeccion.getPelicula().getId());
					ps.setTime(3, proyeccion.getHora());
					ps.setBoolean(4, proyeccion.isAlta());
					ps.execute();
					ps.close();
				}
			return true;
		} catch (SQLException e) {
			javax.swing.JOptionPane.showMessageDialog(null ,"Ha ocurrido un problema \n"+e.getMessage());
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean modificarSala(Sala sala) {
		try {
			String query = "UPDATE "+'"'+"Sala"+'"'+" SET (numero,aforo,dimensiones_pantalla,"
					+ "ano_inauguracion,discapacidad,alta,id_responsable) = (?,?,?,?,?,?,?)"
					+ "WHERE id=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, sala.getNumero());
			ps.setInt(2, sala.getAforo());
			ps.setString(3, sala.getDimPantalla());
			ps.setInt(4, sala.getAnoInauguracion());
			ps.setBoolean(5, sala.isDiscapacidad());
			ps.setBoolean(6, sala.isAlta());
			ps.setInt(7, sala.getResponsable().getId());
			ps.setInt(8, sala.getId());
			ps.execute();
			ps.close();
			return true;
		} catch (SQLException e) {
			javax.swing.JOptionPane.showMessageDialog(null ,"Ha ocurrido un problema \n"+e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean modificarPelicula(Pelicula pelicula) {
		try {
			String query = "UPDATE "+'"'+"Pelicula"+'"'+" SET (titulo,ano_estreno,director,"
					+ "actor_principal,actor_secundario,duracion,trailer) = (?,?,?,?,?,?,?)"
					+ "WHERE id=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, pelicula.getTitulo());
			ps.setInt(2, pelicula.getAnoEstreno());
			ps.setString(3, pelicula.getDirector());
			ps.setString(4, pelicula.getActorPrincipal());
			ps.setString(5, pelicula.getActorSecundario());
			ps.setInt(6, pelicula.getDuracion());
			ps.setString(7, pelicula.getTrailer());
			ps.setInt(8, pelicula.getId());
			ps.execute();
			ps.close();
			return true;
		} catch (SQLException e) {
			javax.swing.JOptionPane.showMessageDialog(null ,"Ha ocurrido un problema \n"+e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean modificarEmpleado(Empleado empleado) {
		try {
			String query = "UPDATE "+'"'+"Empleado"+'"'+" SET (nombre,apellido,cargo,"
					+ "fechanacimiento,nacionalidad,fechacontratacion,fechafincontrato) = (?,?,?,?,?,?,?)"
					+ "WHERE id=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, empleado.getNombre());
			ps.setString(2, empleado.getApellido());
			ps.setString(3, empleado.getCargo().toString());
			ps.setDate(4, empleado.getFechaNacimiento());
			ps.setString(5, empleado.getNacionalidad());
			ps.setDate(6, empleado.getFechaContratacion());
			ps.setDate(7, empleado.getFechaFinContrato());
			ps.setInt(8, empleado.getId());
			ps.execute();
			ps.close();
			return true;
		} catch (SQLException e) {
			javax.swing.JOptionPane.showMessageDialog(null ,"Ha ocurrido un problema \n"+e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
}
