package controlador;

import java.sql.*;


import java.lang.*;

import javax.swing.JOptionPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




public class SQLite{
	public static void main(String[] args) {
		Connection con = null;
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:SQLiteExperimental.db");
			System.out.println("Open Database");
		}catch(Exception e) {
			System.out.print(e);
		}
		}

}

