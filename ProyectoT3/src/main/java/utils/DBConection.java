package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConection {

	private static final String URL = "jdbc:mysql://localhost:3306/";
	private static final String USER = "";
	private static final String PASSWORD = "";

	public static Connection getConnection() {

		Connection conexion = null;
		try {
			conexion = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Conexion correcta a la base de daatos");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error en la conexion a la base de datos");
		}
		return conexion;
	}

}
