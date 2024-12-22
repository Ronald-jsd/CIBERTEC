package db_utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
 // Constantes que almacenan los detalles de la conexión
 private static final String URL = "jdbc:mysql://"; 
 private static final String USUARIO = ""; 
 private static final String CONTRASENA = "";
 
//Método estático para obtener una conexión a la base de datos
 public static Connection getConnection() {
     Connection conexion = null; // Inicializa la conexión como null
     try {
         // Intenta establecer la conexión
         conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
         System.out.println("Conexión exitosa con la base de datos");
     } catch (Exception e) {
         System.err.println("Error en la conexión con la base de datos: " + e.getMessage());
     }
     return conexion; // Retorna la conexión
 }
}
