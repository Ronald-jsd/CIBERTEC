package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import interfaces.IUserDao;
import model.User;

public class UserDao implements IUserDao {

	private Connection connection;

	// Constructor para inyectar la conexión
	public UserDao(Connection connection) {
		this.connection = connection;
	}

	@Override
	public boolean registerUser(User user) {
		// segun las columnas de la base de datos
		String sql = "INSERT INTO usuarios (nombre, correo) VALUES (?, ?)";
		// declaro una variable de tipo Prepare y devuelve la inserccion
		// enviare a la base de datos para que ingrese los datos
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			// los signos de interrogacion lo vamos a convertir en el dato de entrada

			stmt.setString(1, user.getName());
			stmt.setString(2, user.getMail());

			// si es  > 0  return true
			return stmt.executeUpdate() > 0; 
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}