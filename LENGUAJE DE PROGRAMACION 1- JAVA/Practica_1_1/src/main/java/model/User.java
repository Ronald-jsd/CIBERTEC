package model;

public class User {

	private String name;
	private String liga;
	private int puntos;
	private int victorias;
	private int derrotas;
	public User(String name, String liga, int puntos, int victorias, int derrotas) {
		super();
		this.name = name;
		this.liga = liga;
		this.puntos = puntos;
		this.victorias = victorias;
		this.derrotas = derrotas;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLiga() {
		return liga;
	}
	public void setLiga(String liga) {
		this.liga = liga;
	}
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	public int getVictorias() {
		return victorias;
	}
	public void setVictorias(int victorias) {
		this.victorias = victorias;
	}
	public int getDerrotas() {
		return derrotas;
	}
	public void setDerrotas(int derrotas) {
		this.derrotas = derrotas;
	}

	
	
	
}
