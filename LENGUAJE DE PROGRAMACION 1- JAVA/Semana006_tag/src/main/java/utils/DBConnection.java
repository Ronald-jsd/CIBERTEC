package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static final String URL = "jdbc:mysql://localhost:3306/UERS";
	private static final String USUARIO = "";
	private static final String CONTRASENA = "";

	public static Connection getConnection() {
		Connection conexion = null;

		try {
			// Establecer la conexión
			conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
			System.out.println("Conexión exitosa a la base de datos");
		} catch (SQLException e) {
			System.err.println("Error al conectar a la base de datos: " + e.getMessage());
		}

		return conexion;
	}
}
