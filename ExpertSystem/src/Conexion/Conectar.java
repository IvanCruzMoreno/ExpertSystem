package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conectar {

	private static Connection conexion;
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private static final String user = "root";
	private static final String password ="";
	private static final String url = "jdbc:mysql://localhost:3306/expertsystem";
	
	public Conectar() {
		
		conexion = null;
		
		try {
			Class.forName(driver);
			conexion = DriverManager.getConnection(url, user, password);
			
			if(conexion != null) {
				System.out.println("-- Conexion Establecida --");
			}
		} catch (Exception e) {
			//System.err.println(e.getMessage());
		}
	}
	
	public Connection getConnection() {
		return conexion;
	}
	public void desconectar() {
		conexion = null;
	}
}
