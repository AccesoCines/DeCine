package controlador;

import java.sql.*;

import java.lang.*;

public class SQLite{
	public static void main(String[] args) {
		Connection con = null;
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:\\C:\\Users\\Susana\\Desktop\\DeCine\\SQLiteBaseDatos\\SQLiteCINES.db");
			System.out.println("Open Database");
		}catch(Exception e) {
			System.out.print(e);
		}
		}

}

