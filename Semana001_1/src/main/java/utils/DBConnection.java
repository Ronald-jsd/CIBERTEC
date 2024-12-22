package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	//Extension de nuestra base de datOs
	//ruta a nuestra base de dataos(poner el nombre de nuestra base de datos)
	private static final String URL = "jdbc:mysql://localhost:3306/";
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
