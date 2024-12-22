package models;

public class Desarrolladora {
	private int idDesarrolladora;
	private String nombre;
	private String pais;

	public Desarrolladora(int idDesarrolladora, String nombre, String pais) {
		this.idDesarrolladora = idDesarrolladora;
		this.nombre = nombre;
		this.pais = pais;
	}

	public Desarrolladora(String nombre) {
		this.nombre = nombre;
	}

	public Desarrolladora(int idDesarrolladora) {
		this.idDesarrolladora = idDesarrolladora;
	}

	public Desarrolladora(int idDesarrolladora, String nombre) {
		// TODO Auto-generated constructor stub
		this.idDesarrolladora = idDesarrolladora;
		this.nombre = nombre;
	}

	public int getIdDesarrolladora() {
		return idDesarrolladora;
	}

	public void setIdDesarrolladora(int idDesarrolladora) {
		this.idDesarrolladora = idDesarrolladora;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	@Override
	public String toString() {
		return nombre;
	}

	/*
	 * @Override public String toString() { return "idDesarrolladora=" +
	 * idDesarrolladora + ", nombre=" + nombre + ", pais=" + pais ; }
	 */
}
