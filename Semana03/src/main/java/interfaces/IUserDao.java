package interfaces;

import java.sql.SQLException;
import java.util.List;

import model.User;

public interface IUserDao {

	// METODO PARA REGISTRAR
	public boolean registerUser(User user);

	// Read
	public List<User> listarUser();

	public List<User> listarUserSP();

}