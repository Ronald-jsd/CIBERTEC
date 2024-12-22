package interfaz;

import java.util.List;

import model.User;

public interface IUserDao {
	//metodo registrar
	public boolean registerUser(User user);
	//metodo listar
	public List<User> listarClub();
	//Borrar
	public boolean deleteUser(String name);

}
