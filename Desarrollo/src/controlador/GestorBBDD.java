package controlador;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;

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
			url = "jdbc:sqlite:NuevaQL.db";
		    try {
				Class.forName("org.sqlite.JDBC");
				con = DriverManager.getConnection(url);
			} catch (SQLException e) {
				javax.swing.JOptionPane.showMessageDialog(null ,"Ha ocurrido un problema \n"+e.getMessage());
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				javax.swing.JOptionPane.showMessageDialog(null ,"Ha ocurrido un problema \n"+e.getMessage());
				e.printStackTrace();
			}
			
			break;		
		case "db4o":
			
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
	
	public boolean guardarEmpleadoQL(Empleado empleado) {
		try {
			String query = "INSERT INTO Empleado (nombre,apellido,cargo,fechanacimiento,"
					+ "nacionalidad,fechacontratacion,fechafincontrato,alta, id) VALUES(?,?,"
					+ "?,?,?,?,?,?, (select max (id) from Empleado)+1)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, empleado.getNombre());
			ps.setString(2, empleado.getApellido());		
			ps.setString(3, empleado.getCargo().toString());
			ps.setDate(4, empleado.getFechaNacimiento());
			ps.setString(5, empleado.getNacionalidad());
			ps.setDate(6, empleado.getFechaContratacion());
			ps.setDate(7, empleado.getFechaFinContrato());
			ps.setBoolean(8, empleado.isAlta());
		//	ps.setString(9,  (select max (id) from Empleado)+1);
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

	public boolean guardarPeliculaQL(Pelicula pelicula) {
		try {
			String query = "INSERT INTO Pelicula (titulo,ano_estreno,director,actor_principal,actor_secundario,sinopsis,duracion,trailer,fecha_Inicio,fecha_Fin,alta,id) VALUES(?,?,?,?,?,?,?,?,?,?,?, (select max (id) from Pelicula)+1)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, pelicula.getTitulo());
			ps.setInt(2, pelicula.getAnoEstreno());		
			ps.setString(3, pelicula.getDirector());
			ps.setString(4, pelicula.getActorPrincipal());
			ps.setString(5, pelicula.getActorSecundario());
			ps.setString(6, pelicula.getSinopsis()); 
			ps.setInt(7, pelicula.getDuracion());
			ps.setString(8, pelicula.getTrailer());
			ps.setDate(9, pelicula.getFechaInicio());
			ps.setDate(10, pelicula.getFechaFin());
			ps.setBoolean(11, pelicula.isAlta());
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
			PreparedStatement ps = null;
			for(Proyeccion proyeccion:pelicula.getProyecciones()) {
				String query = "INSERT INTO "+'"'+"Proyeccion"+'"'+" (id_sala,id_pelicula,hora,alta) VALUES(?,?,"
						+ "?,?)";
				ps = con.prepareStatement(query);
				ps.setInt(1, proyeccion.getSala().getId());		
				ps.setInt(2, pelicula.getId());
				ps.setTime(3, proyeccion.getHora());
				ps.setBoolean(4, proyeccion.isAlta());
				ps.execute();
			}
			ps.close();
			return true;
		} catch (SQLException e) {
			javax.swing.JOptionPane.showMessageDialog(null ,"Ha ocurrido un problema \n"+e.getMessage());
			e.printStackTrace();
			return false;
		}	
	}
	
	public ArrayList<Proyeccion> cargarProyecciones(Pelicula pelicula) {
		ArrayList<Proyeccion> proyecciones = new ArrayList<>();
		try {
			String query = "SELECT * FROM "+'"'+"Proyeccion"+'"'+" WHERE ALTA=true AND id_pelicula=? ";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, pelicula.getId());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int numSala = rs.getInt("id_sala");
				PreparedStatement pss = con.prepareStatement("SELECT * FROM "+'"'+"Sala"+'"'+" WHERE id=? ");		
				pss.setInt(1, numSala);
				ResultSet rss = pss.executeQuery();
				Sala s = new Sala();
				while(rss.next()) {
					s = new Sala(
							rss.getInt("id"),
							rss.getInt("numero")
							); 
				}
				proyecciones.add(new Proyeccion(
						s,
						pelicula,
						rs.getTime("hora")
						));
			}
			if(proyecciones.isEmpty()) {
				JOptionPane.showMessageDialog(null, "No hay proyecciones", null, 0);
				return proyecciones;
			}else {
				return proyecciones;
			}
		} catch (SQLException e) {
			javax.swing.JOptionPane.showMessageDialog(null ,"Ha ocurrido un problema \n"+e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean guardarProyeccionesQL(Pelicula pelicula) {
		try {
			PreparedStatement ps = null;
			for(Proyeccion proyeccion:pelicula.getProyecciones()) {
				String query = "INSERT INTO Proyeccion(id_sala,id_pelicula,hora,alta, id) VALUES( ?,?,"
						+ "?,?, (select max (id) from Proyeccion)+1)";
				ps = con.prepareStatement(query);
				ps.setInt(1, proyeccion.getSala().getId());		
				ps.setInt(2, pelicula.getId());
				ps.setTime(3, proyeccion.getHora());
				ps.setBoolean(4, proyeccion.isAlta());
				ps.execute();
			}
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

	public ArrayList<Pelicula> cargarPeliculasBaja() {
		ArrayList<Pelicula> peliculas = new ArrayList<>();
		try {
			String query = "SELECT * FROM "+'"'+"Pelicula"+'"'+" WHERE ALTA=false AND fecha_inicio<current_date and fecha_fin>current_date ";
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

	
	public ArrayList<Pelicula> cargarPeliculasQL() throws ParseException {
		ArrayList<Pelicula> peliculas = new ArrayList<>();
		
		try {
			String query = "SELECT * FROM Pelicula WHERE ALTA=1 ";
			ResultSet rs = con.createStatement().executeQuery(query);
			while(rs.next()) {
				boolean alta;
				int n =	rs.getInt("alta");
				if (n==1) {
					alta=true;
				}else {
					alta=false;
				}
				/*
				SimpleDateFormat format  = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date parsed = format.parse(rs.getString("fecha_Inicio"));
				java.sql.Date fechaIni = new java.sql.Date(parsed.getTime());
				java.util.Date parsed2 = format.parse(rs.getString("fecha_Fin"));
				java.sql.Date fechaFin = new java.sql.Date(parsed2.getTime());
				*/
				
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
						alta,
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
			String query = "SELECT * FROM "+'"'+"Sala"+'"'+" WHERE ALTA=true ";
			ResultSet rs = con.createStatement().executeQuery(query);
			while(rs.next()) {
				String queryRes = "SELECT * FROM "+'"'+"Empleado"+'"'+" WHERE ID=?";
				PreparedStatement ps = con.prepareStatement(queryRes);
				ps.setInt(1, rs.getInt("id_responsable"));
				ResultSet rsr = ps.executeQuery();
				Empleado resp = new Empleado();
				while(rsr.next()) {
					resp = new Empleado(
							rsr.getString("nombre"),
							rsr.getString("apellido"),
							Cargo.valueOf(rsr.getString("cargo")),
							rsr.getDate("fechacontratacion"),
							rsr.getDate("fechanacimiento"),
							rsr.getString("nacionalidad"),
							rsr.getDate("fechafincontrato"),
							rsr.getBoolean("alta"),
							rsr.getInt("id")
							);
				}
				salas.add(new Sala(
						rs.getInt("numero"),
						rs.getInt("aforo"),
						rs.getString("dimensiones_pantalla"),
						rs.getInt("ano_inauguracion"),
						rs.getBoolean("discapacidad"),
						resp,
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
	
	public ArrayList<Sala> cargarSalasBaja() {
		ArrayList<Sala> salas = new ArrayList<>();
		try {
			String query = "SELECT * FROM "+'"'+"Sala"+'"'+" WHERE ALTA=false ";
			ResultSet rs = con.createStatement().executeQuery(query);
			while(rs.next()) {
				String queryRes = "SELECT * FROM "+'"'+"Empleado"+'"'+" WHERE ID=?";
				PreparedStatement ps = con.prepareStatement(queryRes);
				ps.setInt(1, rs.getInt("id_responsable"));
				ResultSet rsr = ps.executeQuery();
				Empleado resp = new Empleado();
				while(rsr.next()) {
					resp = new Empleado(
							rsr.getString("nombre"),
							rsr.getString("apellido"),
							Cargo.valueOf(rsr.getString("cargo")),
							rsr.getDate("fechacontratacion"),
							rsr.getDate("fechanacimiento"),
							rsr.getString("nacionalidad"),
							rsr.getDate("fechafincontrato"),
							rsr.getBoolean("alta"),
							rsr.getInt("id")
							);
				}
				salas.add(new Sala(
						rs.getInt("numero"),
						rs.getInt("aforo"),
						rs.getString("dimensiones_pantalla"),
						rs.getInt("ano_inauguracion"),
						rs.getBoolean("discapacidad"),
						resp,
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

	public MetaDato cargarMetaDatos() {
		MetaDato metaDatos = null;
		try {
			DatabaseMetaData dbmeta = con.getMetaData();
			metaDatos = new MetaDato();
			metaDatos.setNombreBD(dbmeta.getDatabaseProductName());
			metaDatos.setDriver(dbmeta.getDriverName());
			metaDatos.setUrl(dbmeta.getURL());
			metaDatos.setUsuario(dbmeta.getUserName());
			ResultSet rs = dbmeta.getTables(null, "public", "%", null);
			while(rs.next()) {
				String nombreTabla = rs.getString("TABLE_NAME");
				String esquema = rs.getString("TABLE_SCHEM");
				String clavePrimaria="";
				ResultSet rsp = dbmeta.getPrimaryKeys(null, null, nombreTabla);
				while(rsp.next()) {
					clavePrimaria = rsp.getString("COLUMN_NAME");
				}
				Tabla tabla = new Tabla(nombreTabla,esquema,clavePrimaria);
				metaDatos.anadirTabla(tabla);
				ResultSet rsc = dbmeta.getColumns(null, null, nombreTabla, null);
				while(rsc.next()) {
					tabla.anadirColumna(new Columna(
								rsc.getString("TYPE_NAME"),
								rsc.getInt("NULLABLE")==1?true:false,
								rsc.getString("COLUMN_NAME")
							));
				}
			}
			return metaDatos;
		} catch (SQLException e) {
			javax.swing.JOptionPane.showMessageDialog(null ,"Ha ocurrido un problema \n"+e.getMessage());
			e.printStackTrace();
			return null;
		}	
	}

	public ArrayList<Empleado> cargarEmpleados() {
		ArrayList<Empleado> empleados = new ArrayList<>();
		try {
			String query = "SELECT * FROM "+'"'+"Empleado"+'"'+" WHERE ALTA=true ";
			ResultSet rs = con.createStatement().executeQuery(query);
			while(rs.next()) {
				Cargo cargo = Cargo.valueOf(rs.getString("cargo"));
				empleados.add(new Empleado(
						rs.getString("nombre"),
						rs.getString("apellido"),
						Cargo.valueOf(rs.getString("cargo")),
						rs.getDate("fechacontratacion"),
						rs.getDate("fechanacimiento"),
						rs.getString("nacionalidad"),
						rs.getDate("fechafincontrato"),
						rs.getBoolean("alta"),
						rs.getInt("id")
						));
			}
			if(empleados.isEmpty()) {
				JOptionPane.showMessageDialog(null, "No hay empleados", null, 0);
				return null;
			}else {
				return empleados;
			}
		} catch (SQLException e) {
			javax.swing.JOptionPane.showMessageDialog(null ,"Ha ocurrido un problema \n"+e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<Empleado> cargarEmpleadosResp() {
		ArrayList<Empleado> empleados = new ArrayList<>();
		try {
			String query = "SELECT * FROM "+'"'+"Empleado"+'"'+" WHERE ALTA=true AND cargo='responsableSala'";
			ResultSet rs = con.createStatement().executeQuery(query);
			while(rs.next()) {
				empleados.add(new Empleado(
						rs.getString("nombre"),
						rs.getString("apellido"),
						Cargo.valueOf(rs.getString("cargo")),
						rs.getDate("fechacontratacion"),
						rs.getDate("fechanacimiento"),
						rs.getString("nacionalidad"),
						rs.getDate("fechafincontrato"),
						rs.getBoolean("alta"),
						rs.getInt("id") //Importante!!!!
						));
			}
			if(empleados.isEmpty()) {
				JOptionPane.showMessageDialog(null, "No hay empleados", null, 0);
				return null;
			}else {
				return empleados;
			}
		} catch (SQLException e) {
			javax.swing.JOptionPane.showMessageDialog(null ,"Ha ocurrido un problema \n"+e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean bajaEmpleado(Empleado empleado) {
		try {
			String query = "UPDATE "+'"'+"Empleado"+'"'+ " SET alta = false where id=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, empleado.getId());
			ps.executeUpdate();
			ps.close();
			return true;
		} catch (SQLException e) {
			javax.swing.JOptionPane.showMessageDialog(null ,"Ha ocurrido un problema \n"+e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean bajaPelicula(Pelicula pelicula) {
		try {
			String query = "UPDATE "+'"'+"Pelicula"+'"'+ " SET alta = false where id=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, pelicula.getId());
			ps.executeUpdate();
			ps.close();
			return true;
		} catch (SQLException e) {
			javax.swing.JOptionPane.showMessageDialog(null ,"Ha ocurrido un problema \n"+e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean bajaSala(Sala sala) {
		try {
			String query = "UPDATE "+'"'+"Sala"+'"'+ " SET alta = false where id=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, sala.getId());
			ps.executeUpdate();
			ps.close();
			return true;
		} catch (SQLException e) {
			javax.swing.JOptionPane.showMessageDialog(null ,"Ha ocurrido un problema \n"+e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
		
	public ArrayList<Sala> cargarSalasQL() {
		ArrayList<Sala> salas = new ArrayList<>();
		try {
			String query = "SELECT * FROM  Sala WHERE ALTA=1 ";
			ResultSet rs = con.createStatement().executeQuery(query);
			while(rs.next()) {
				String queryRes = "SELECT* FROM Empleado WHERE id=?";
				PreparedStatement ps = con.prepareStatement(queryRes);
				ps.setInt(1, rs.getInt("Id_responsable"));
				ResultSet rsr = ps.executeQuery();
				Empleado resp = new Empleado();
				while(rsr.next()) {
					boolean alta;
					int n =	rsr.getInt("alta");
					if (n==1) {
						alta=true;
					}else {
						alta=false;
					}
					resp = new Empleado(
							rsr.getString("nombre"),
							rsr.getString("apellido"),
							Cargo.valueOf(rsr.getString("cargo")),
							rsr.getDate("fechacontratacion"),
							rsr.getDate("fechanacimiento"),
							rsr.getString("nacionalidad"),
							rsr.getDate("fechafincontrato"),
							alta,
							rsr.getInt("id")
							);
				}
				salas.add(new Sala(
						rs.getInt("numero"),
						rs.getInt("aforo"),
						rs.getString("dimensiones_pantalla"),
						rs.getInt("ano_inauguracion"),
						rs.getBoolean("discapacidad"),
						resp,
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

			
	public boolean modificarEmpleado(Empleado empleado) {
		try {
			String query = "UPDATE "+'"'+"Empleado"+'"'+ " SET nombre = ?, apellido = ?, "
					+ "cargo = ?, fechanacimiento = ?, nacionalidad = ?, fechacontratacion = ?,"
					+ " fechafincontrato = ? where id=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, empleado.getNombre());
			ps.setString(2, empleado.getApellido());		
			ps.setString(3, empleado.getCargo().toString());
			ps.setDate(4, empleado.getFechaNacimiento());
			ps.setString(5, empleado.getNacionalidad());
			ps.setDate(6, empleado.getFechaContratacion());
			ps.setDate(7, empleado.getFechaFinContrato());
			ps.setInt(8, empleado.getId());
			int lineas = ps.executeUpdate();
			ps.close();
			if(lineas==1) {
				return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			javax.swing.JOptionPane.showMessageDialog(null ,"Ha ocurrido un problema \n"+e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	public boolean modificarSala(Sala sala) {
		try {
			String query = "UPDATE "+'"'+"Sala"+'"'+ " SET numero = ?, aforo = ?, "
					+ "dimensiones_pantalla = ?, ano_inauguracion = ?, discapacidad = ?,"
					+ " id_responsable = ? where id=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, sala.getNumero());
			ps.setInt(2, sala.getAforo());
			ps.setString(3, sala.getDimPantalla());
			ps.setInt(4, sala.getAnoInauguracion());
			ps.setBoolean(5, sala.isDiscapacidad());
			ps.setInt(6, sala.getResponsable().getId());
			ps.setInt(7, sala.getId());
			int lineas = ps.executeUpdate();
			ps.close();
			if(lineas==1) {
				return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			javax.swing.JOptionPane.showMessageDialog(null ,"Ha ocurrido un problema \n"+e.getMessage());
			e.printStackTrace();
			return false;
		}		
	}

	public boolean modificarSalaQL(Sala sala) {
		try {
			String query = "UPDATE Sala SET numero = ?, aforo = ?, dimensiones_pantalla = ?, ano_inauguracion = ?, discapacidad = ?,  id_responsable = ? where id=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, sala.getNumero());
			ps.setInt(2, sala.getAforo());
			ps.setString(3, sala.getDimPantalla());
			ps.setInt(4, sala.getAnoInauguracion());
			ps.setBoolean(5, sala.isDiscapacidad());
			ps.setInt(6, sala.getResponsable().getId());
			ps.setInt(7, sala.getId());
			int lineas = ps.executeUpdate();
			ps.close();
			if(lineas==1) {
				return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			javax.swing.JOptionPane.showMessageDialog(null ,"Ha ocurrido un problema \n"+e.getMessage());
			e.printStackTrace();
			return false;
		}		
	}


	public boolean bajaEmpleadoQL(Empleado empleado) {
		try {
			String query = "UPDATE Empleado SET alta = 0 where id=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, empleado.getId());
			ps.executeUpdate();
			ps.close();
			return true;
		} catch (SQLException e) {
			javax.swing.JOptionPane.showMessageDialog(null ,"Ha ocurrido un problema \n"+e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	public ArrayList<Empleado> cargarEmpleadosRespQL() {
		ArrayList<Empleado> empleados = new ArrayList<>();
		try {
			String query = "SELECT * FROM  Empleado  WHERE ALTA=1 AND cargo='responsableSala' ";
			ResultSet rs = con.createStatement().executeQuery(query);
			while(rs.next()) {
				boolean alta;
				int n =	rs.getInt("alta");
				if (n==1) {
					alta=true;
				}else {
					alta=false;
				}
				empleados.add(new Empleado(
						rs.getString("nombre"),
						rs.getString("apellido"),
						Cargo.valueOf(rs.getString("cargo")),
						rs.getDate("fechacontratacion"),
						rs.getDate("fechanacimiento"),
						rs.getString("nacionalidad"),
						rs.getDate("fechafincontrato"),						
						alta,
						rs.getInt("id") //Importante!!!!
						));
			}
			if(empleados.isEmpty()) {
				JOptionPane.showMessageDialog(null, "No hay empleados", null, 0);
				return null;
			}else {
				return empleados;
			}
		} catch (SQLException e) {
			javax.swing.JOptionPane.showMessageDialog(null ,"Ha ocurrido un problema \n"+e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	

	public ArrayList<Empleado> cargarEmpleadosQL() {
		ArrayList<Empleado> empleados = new ArrayList<>();
		try {
			String query = "SELECT * FROM Empleado WHERE ALTA=1 ";
			ResultSet rs = con.createStatement().executeQuery(query);
			while(rs.next()) {
				boolean alta;
				int n =	rs.getInt("alta");
				if (n==1) {
					alta=true;
				}else {
					alta=false;
				}
				empleados.add(new Empleado(
						rs.getString("nombre"),
						rs.getString("apellido"),
						Cargo.valueOf(rs.getString("cargo")),
						rs.getDate("fechacontratacion"),
						rs.getDate("fechanacimiento"),
						rs.getString("nacionalidad"),
						rs.getDate("fechafincontrato"),						
						alta,
						rs.getInt("id")
						));
			}
			if(empleados.isEmpty()) {
				JOptionPane.showMessageDialog(null, "No hay empleados", null, 0);
				return null;
			}else {
				return empleados;
			}
		} catch (SQLException e) {
			javax.swing.JOptionPane.showMessageDialog(null ,"Ha ocurrido un problema \n"+e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	public boolean modificarEmpleadoQL(Empleado empleado) {
		try {
			String query = "UPDATE Empleado SET nombre = ?, apellido = ?, "
					+ "cargo = ?, fechanacimiento = ?, nacionalidad = ?, fechacontratacion = ?,"
					+ " fechafincontrato = ? where id=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, empleado.getNombre());
			ps.setString(2, empleado.getApellido());		
			ps.setString(3, empleado.getCargo().toString());
			ps.setDate(4, empleado.getFechaNacimiento());
			ps.setString(5, empleado.getNacionalidad());
			ps.setDate(6, empleado.getFechaContratacion());
			ps.setDate(7, empleado.getFechaFinContrato());
			ps.setInt(8, empleado.getId());
			ps.executeUpdate();
			ps.close();
			return true;
		} catch (SQLException e) {
			javax.swing.JOptionPane.showMessageDialog(null ,"Ha ocurrido un problema \n"+e.getMessage());
			e.printStackTrace();
			return false;
		}
	}


	public boolean bajaPeliculaQL(Pelicula pelicula) {
		try {
			String query = "UPDATE Pelicula SET alta = 0 where id=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, pelicula.getId());
			ps.executeUpdate();
			ps.close();
			return true;
		} catch (SQLException e) {
			javax.swing.JOptionPane.showMessageDialog(null ,"Ha ocurrido un problema \n"+e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	public boolean bajaSalaQR(Sala sala) {
		try {
			String query = "UPDATE Sala SET alta = 0 where id=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, sala.getId());
			ps.executeUpdate();
			ps.close();
			return true;
		} catch (SQLException e) {
			javax.swing.JOptionPane.showMessageDialog(null ,"Ha ocurrido un problema \n"+e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
		


	public ArrayList<Empleado> cargarEmpleadosBaja() {
		ArrayList<Empleado> empleados = new ArrayList<>();
		try {
			String query = "SELECT * FROM "+'"'+"Empleado"+'"'+" WHERE ALTA=false ";
			ResultSet rs = con.createStatement().executeQuery(query);
			while(rs.next()) {
				empleados.add(new Empleado(
						rs.getString("nombre"),
						rs.getString("apellido"),
						Cargo.valueOf(rs.getString("cargo")),
						rs.getDate("fechacontratacion"),
						rs.getDate("fechanacimiento"),
						rs.getString("nacionalidad"),
						rs.getDate("fechafincontrato"),
						rs.getBoolean("alta"),
						rs.getInt("id")
						));
			}
			if(empleados.isEmpty()) {
				JOptionPane.showMessageDialog(null, "No hay empleados", null, 0);
				return null;
			}else {
				return empleados;
			}
		} catch (SQLException e) {
			javax.swing.JOptionPane.showMessageDialog(null ,"Ha ocurrido un problema \n"+e.getMessage());
			e.printStackTrace();
			return null;
		}
	}


	public ArrayList<Empleado> cargarEmpleadosBajaQL() {
		ArrayList<Empleado> empleados = new ArrayList<>();
		try {
			String query = "SELECT * FROM Empleado WHERE ALTA=0 ";
			ResultSet rs = con.createStatement().executeQuery(query);
			while(rs.next()) {
				boolean alta;
				int n =	rs.getInt("alta");
				if (n==1) {
					alta=true;
				}else {
					alta=false;
				}
				empleados.add(new Empleado(
						rs.getString("nombre"),
						rs.getString("apellido"),
						Cargo.valueOf(rs.getString("cargo")),
						rs.getDate("fechacontratacion"),
						rs.getDate("fechanacimiento"),
						rs.getString("nacionalidad"),
						rs.getDate("fechafincontrato"),
						alta,
						rs.getInt("id")
						));
			}
			if(empleados.isEmpty()) {
				JOptionPane.showMessageDialog(null, "No hay empleados", null, 0);
				return null;
			}else {
				return empleados;
			}
		} catch (SQLException e) {
			javax.swing.JOptionPane.showMessageDialog(null ,"Ha ocurrido un problema \n"+e.getMessage());
			e.printStackTrace();
			return null;
		}
	}






	public ArrayList<Sala> cargarSalasBajaQL() {
		ArrayList<Sala> salas = new ArrayList<>();
		try {
			String query = "SELECT * FROM Sala WHERE ALTA=0 ";
			ResultSet rs = con.createStatement().executeQuery(query);
			while(rs.next()) {
				boolean alta;
				int n =	rs.getInt("alta");
				if (n==1) {
					alta=true;
				}else {
					alta=false;
				}
				String queryRes = "SELECT * FROM Empleado WHERE ID=?";
				PreparedStatement ps = con.prepareStatement(queryRes);
				ps.setInt(1, rs.getInt("id_responsable"));
				ResultSet rsr = ps.executeQuery();
				Empleado resp = new Empleado();
				while(rsr.next()) {
					resp = new Empleado(
							rsr.getString("nombre"),
							rsr.getString("apellido"),
							Cargo.valueOf(rsr.getString("cargo")),
							rsr.getDate("fechacontratacion"),
							rsr.getDate("fechanacimiento"),
							rsr.getString("nacionalidad"),
							rsr.getDate("fechafincontrato"),
							alta,
							rsr.getInt("id")
							);
				}
				salas.add(new Sala(
						rs.getInt("numero"),
						rs.getInt("aforo"),
						rs.getString("dimensiones_pantalla"),
						rs.getInt("ano_inauguracion"),
						rs.getBoolean("discapacidad"),
						resp,
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




	public ArrayList<Pelicula> cargarPeliculasBajaQL() {
		ArrayList<Pelicula> peliculas = new ArrayList<>();
		try {
			//String query = "SELECT * FROM Pelicula WHERE ALTA=0 AND fecha_inicio<current_date and fecha_fin>current_date ";

			String query = "SELECT * FROM Pelicula WHERE ALTA=0 ";
			ResultSet rs = con.createStatement().executeQuery(query);
			while(rs.next()) {
				boolean alta;
				int n =	rs.getInt("alta");
				if (n==1) {
					alta=true;
				}else {
					alta=false;
				}
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
						alta,
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

	


	public boolean modificarPelicula(Pelicula pelicula) {
		try {
			String query = "UPDATE "+'"'+"Pelicula"+'"'+ " SET titulo = ?, ano_estreno = ?, "
					+ "director = ?, actor_principal = ?, actor_secundario = ?, "
					+ "duracion = ?, trailer = ?, sinopsis=?, fecha_inicio=?,"
					+ "fecha_fin=? where id=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, pelicula.getTitulo());
			ps.setInt(2, pelicula.getAnoEstreno());		
			ps.setString(3, pelicula.getDirector());
			ps.setString(4, pelicula.getActorPrincipal());
			ps.setString(5, pelicula.getActorSecundario());
			ps.setInt(6, pelicula.getDuracion());
			ps.setString(7, pelicula.getTrailer());
			ps.setString(8, pelicula.getSinopsis());
			ps.setDate(9, pelicula.getFechaInicio());
			ps.setDate(10, pelicula.getFechaFin());
			ps.setInt(11, pelicula.getId());
			int lineas = ps.executeUpdate();
			ps.close();
			if(lineas==1) {
				return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			javax.swing.JOptionPane.showMessageDialog(null ,"Ha ocurrido un problema \n"+e.getMessage());
			e.printStackTrace();
			return false;
		}
	}


	public boolean modificarPeliculaQL(Pelicula pelicula) {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean bajaSalaQL(Sala sala) {
		// TODO Auto-generated method stub
		return false;
	}


	public ArrayList<Proyeccion> cargarProyeccionesQL(Pelicula p) {
		// TODO Auto-generated method stub
		return null;
	}



}
