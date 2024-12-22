
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Admin;

public class AdminDao {

	private Connection connection;

	public AdminDao(Connection connection) {
		this.connection = connection;
	}

	public Admin login(String correo, String password) {
		Admin admin = null;
		String query = "SELECT * FROM admin WHERE correo = ? AND password = ?";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setString(1, correo);
			stmt.setString(2, password);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					admin = new Admin();
					admin.setId(rs.getInt("id"));
					admin.setCorreo(rs.getString("correo"));
					admin.setPassword(rs.getString("password"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return admin;
	}
}
