package controlador;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map.Entry;

import javax.swing.JOptionPane;

import modelo.*;

public class GestorBBDD {
	
	//private String baseDatos;
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
		    passw = "cines1510";
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
	
	public boolean guardarSalaQL(Sala sala) {
		try {
			
			/*
			 * public Sala(int numero, int aforo, String dimPantalla, int anoInauguracion, boolean discapacidad,
			Empleado responsable, boolean alta)
			 */
			String query = "INSERT INTO Sala (numero,aforo,dimensiones_pantalla,"
					+ "ano_inauguracion,discapacidad,id_responsable, alta, id) VALUES(?,?,?,?,?,?,?, (select max (id) from Sala)+1)";
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
					+ "actor_secundario,duracion,trailer,alta,sinopsis,fecha_inicio,fecha_fin) VALUES(?,?,"
					+ "?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, pelicula.getTitulo());
			ps.setInt(2, pelicula.getAnoEstreno());		
			ps.setString(3, pelicula.getDirector());
			ps.setString(4, pelicula.getActorPrincipal());
			ps.setString(5, pelicula.getActorSecundario());
			ps.setInt(6, pelicula.getDuracion());
			ps.setString(7, pelicula.getTrailer());
			ps.setBoolean(8, pelicula.isAlta());
			ps.setString(9, pelicula.getSinopsis());
			ps.setDate(10, pelicula.getFechaInicio());
			ps.setDate(11, pelicula.getFechaFin());
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
					+ "actor_principal,actor_secundario,duracion,trailer,sinopsis) = (?,?,?,?,?,?,?,?)"
					+ "WHERE id=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, pelicula.getTitulo());
			ps.setInt(2, pelicula.getAnoEstreno());
			ps.setString(3, pelicula.getDirector());
			ps.setString(4, pelicula.getActorPrincipal());
			ps.setString(5, pelicula.getActorSecundario());
			ps.setInt(6, pelicula.getDuracion());
			ps.setString(7, pelicula.getTrailer());
			ps.setString(8, pelicula.getSinopsis());
			ps.setInt(9, pelicula.getId());
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


	public ArrayList<Pelicula> cargarPeliculas() {
		ArrayList<Pelicula> peliculas = new ArrayList<>();
		try {
			String query = "SELECT * FROM "+'"'+"Pelicula"+'"'+" WHERE ALTA=true AND fecha_inicio<current_date and fecha_fin>current_date ";
			ResultSet rs = con.createStatement().executeQuery(query);
			while(rs.next()) {
				peliculas.add(new Pelicula(
						rs.getString("titulo"),
						rs.getInt("ano_estreno"),
						rs.getString("director"),
						rs.getString("actor_principal"),
						rs.getString("actor_secundario"),
						rs.getString("sinopsis"),
						rs.getInt("duracion"),
						rs.getString("trailer"),
						rs.getDate("fecha_inicio"),
						rs.getDate("fecha_fin"),
						rs.getBoolean("alta"),
						rs.getInt("id")
						));
			}
			if(peliculas.isEmpty()) {
				JOptionPane.showMessageDialog(null, "No hay peliculas", null, 0);
				return null;
			}else {
				return peliculas;
			}
		} catch (SQLException e) {
			javax.swing.JOptionPane.showMessageDialog(null ,"Ha ocurrido un problema \n"+e.getMessage());
			e.printStackTrace();
			return null;
		}
	}


	public ArrayList<Sala> cargarSalas() {
		ArrayList<Sala> salas = new ArrayList<>();
		try {
			String query = "SELECT * FROM "+'"'+"Sala"+'"'+" WHERE ALTA=true";
			ResultSet rs = con.createStatement().executeQuery(query);
			while(rs.next()) {
				salas.add(new Sala(
						rs.getInt("numero"),
						rs.getInt("aforo"),
						rs.getString("dimensiones_pantalla"),
						rs.getInt("ano_inauguracion"),
						rs.getBoolean("discapacidad"),
						rs.getInt("id")
						));
			}
			if(salas.isEmpty()) {
				JOptionPane.showMessageDialog(null, "No hay salas", null, 0);
				return null;
			}else {
				return salas;
			}
		} catch (SQLException e) {
			javax.swing.JOptionPane.showMessageDialog(null ,"Ha ocurrido un problema \n"+e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
}
