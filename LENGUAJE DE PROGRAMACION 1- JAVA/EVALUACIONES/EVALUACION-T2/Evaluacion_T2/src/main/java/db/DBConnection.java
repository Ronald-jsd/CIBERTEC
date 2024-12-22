package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	public static final String URL="jdbc:mysql://localhost:3306/";
	public static final String USUARIO="";
	public static final String PASSWORD = "";
	
	public static  Connection getConnection() {
		Connection conexion = null;
		try {
			conexion = DriverManager.getConnection(URL,USUARIO,PASSWORD);
			System.out.println("Conexion exitosa a la BD");
		}catch (Exception e) {
			// TODO: handle exception
			System.err.println("Fallo la conexion");
			e.printStackTrace();
		}
		return conexion;	
	}//final method

}//final class
