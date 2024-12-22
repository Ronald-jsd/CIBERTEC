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

	private Connection connection;

	// Constructor para inyectar la conexión
	public UserDao(Connection connection) {
		this.connection = connection;
	}

	@Override
	public boolean registerUser(User user) {
		String sql = "INSERT INTO usuarios (nombre, email) VALUES (?, ?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getMail());
			return stmt.executeUpdate() > 0; // Tabla ha sido afectada
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<User> listarUser() {
		List<User> listaUsuarios = new ArrayList<>();

		String sql = "SELECT * FROM usuarios";
		try (PreparedStatement stm = connection.prepareStatement(sql); ResultSet rs = stm.executeQuery()) {
			while (rs.next()) {
				String nombre = rs.getString("nombre");
				String email = rs.getString("email");
				User usuario = new User(nombre, email);
				listaUsuarios.add(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaUsuarios;
	}

	@Override
	public List<User> listarUserSP() {
		List<User> personas = new ArrayList<>();

		// Llamamos al Stored Procedure
		String sql = "{call listar_personas()}"; // Nombre del SP

		try (CallableStatement stmt = connection.prepareCall(sql); ResultSet rs = stmt.executeQuery()) {

			System.out.println("Print used SP");

			// Procesamos el resultado
			while (rs.next()) {
				String nombre = rs.getString("nombre");
				String email = rs.getString("email");
				User usuario = new User(nombre, email);
				personas.add(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return personas;
	}

	@Override
	public boolean borrarUser(String name) {
		String sql = "DELETE FROM usuarios WHERE nombre = ?"; // Consulta SQL para borrar

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, name); // Establecer el parámetro en la consulta
			int filasAfectadas = stmt.executeUpdate(); // Ejecutar la consulta
			return filasAfectadas > 0; // Si se eliminó al menos una fila, devolver true
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean actualizarUser(User user) {
		// TODO Auto-generated method stub
		String sql = "UPDATE usuarios SET nombre = ?, email = ? WHERE nombre = ?"; 

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, user.getName()); 
			stmt.setString(2, user.getMail()); 
			stmt.setString(3, user.getName()); 
			int filasAfectadas = stmt.executeUpdate(); 
			return filasAfectadas > 0; // Si se eliminó al menos una fila, devolver true
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
