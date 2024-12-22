package interfaces;

import java.sql.SQLException;
import java.util.List;

import model.User;

public interface IUserDao {

	// create
	public boolean registerUser(User user);

	// Read
	public List<User> listarUser();

	public List<User> listarUserSP();

	// Delete
	public boolean borrarUser(String name);

	// Update
	public boolean actualizarUser(User user);
}
