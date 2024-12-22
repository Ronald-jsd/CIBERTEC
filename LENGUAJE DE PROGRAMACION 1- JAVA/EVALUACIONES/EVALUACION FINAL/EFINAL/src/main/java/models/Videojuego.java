package models;

public class Videojuego {
	private int codigo;
	private String nombre;
	private String version;
	private double costo;
	private Desarrolladora desarrolladora;

	public Videojuego(int codigo, String nombre, String version, double costo, Desarrolladora desarrolladora) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.version = version;
		this.costo = costo;
		this.desarrolladora = desarrolladora;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public Desarrolladora getDesarrolladora() {
		return desarrolladora;
	}

	public void setDesarrolladora(Desarrolladora desarrolladora) {
		this.desarrolladora = desarrolladora;
	}
}
