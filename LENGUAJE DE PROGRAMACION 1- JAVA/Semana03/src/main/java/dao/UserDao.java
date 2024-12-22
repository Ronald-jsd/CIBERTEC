package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import interfaces.IUserDao;
import model.User;

public class UserDao implements IUserDao {
	private Connection connection; // Conexión a la base de datos

	// Constructor para inicializar la conexión
	public UserDao(Connection connection) {
		this.connection = connection;
	}

	// Implementación del método para registrar un usuario
	@Override
	public boolean registerUser(User user) {
		String sql = "INSERT INTO usuarios (nombre, email) VALUES (?, ?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			// Asigna los valores a los parámetros de la consulta
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getMail());
			return stmt.executeUpdate() > 0; // Verifica si se afectaron filas
		} catch (SQLException e) {
			e.printStackTrace(); // Maneja excepciones de SQL
			return false;
		}
	}

	// Implementación del método para listar usuarios
	@Override
	public List<User> listarUser() {
		List<User> listaUsuarios = new ArrayList<>();
		String sql = "SELECT * FROM usuarios";
		try (PreparedStatement stm = connection.prepareStatement(sql); ResultSet rs = stm.executeQuery()) {
			while (rs.next()) {
				// Recupera los datos de cada fila y crea un objeto User
				String nombre = rs.getString("nombre");
				String email = rs.getString("email");
				User usuario = new User(nombre, email);
				listaUsuarios.add(usuario); // Agrega el usuario a la lista
			}
		} catch (SQLException e) {
			e.printStackTrace(); // Manejo de excepciones
		}
		return listaUsuarios;
	}

	// Implementación del método para listar usuarios mediante un Stored Procedure
	@Override
	public List<User> listarUserSP() {
		List<User> personas = new ArrayList<>();
		String sql = "{call listar_personas()}"; // Llama al Stored Procedure
		try (CallableStatement stmt = connection.prepareCall(sql); ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				// Procesa el resultado del SP
				String nombre = rs.getString("nombre");
				String email = rs.getString("email");
				User usuario = new User(nombre, email);
				personas.add(usuario); // Agrega el usuario a la lista
			}
		} catch (SQLException e) {
			e.printStackTrace(); // Manejo de excepciones
		}
		return personas;
	}
}
