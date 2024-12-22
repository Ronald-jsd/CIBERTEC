package model;

public class Admin {
	private int id;
	private String correo;
	private String password;

	// Constructor vacío
	public Admin() {
	}

	// Constructor con parámetros
	public Admin(int id, String correo, String password) {
		this.id = id;
		this.correo = correo;
		this.password = password;
	}

	// Getters y setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
