package clases;

public class Register {
	private String nombre;
	private String correo;
	private String contrasena;
	public Register(String nombre, String correo) {
		this.nombre = nombre;
		this.correo = correo;
	}
	
	public Register(String contrasena) {
		this.contrasena = contrasena;
	}
	

	
	public String getNombre() {
		return nombre;
	}
	public String getCorreo() {
		return correo;
	}
	public String getContrasena() {
		return contrasena;
	}
	
	
	
	



}
