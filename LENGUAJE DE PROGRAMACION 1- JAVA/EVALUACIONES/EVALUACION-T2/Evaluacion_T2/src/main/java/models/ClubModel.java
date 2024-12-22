package models;

public class ClubModel {
	 private int idClub; 
	private int idLiga; 
	private String nombreClub; 
	private int campeonatosNacionales;
	private int copasNacionales;
	private String campeonatosEuropeos;	
	
	public int getIdClub() {
		return idClub;
	}
	public void setIdClub(int idClub) {
		this.idClub = idClub;
	}
	public int getIdLiga() {
		return idLiga;
	}
	public void setIdLiga(int idLiga) {
		this.idLiga = idLiga;
	}
	public String getNombreClub() {
		return nombreClub;
	}
	public void setNombreClub(String nombreClub) {
		this.nombreClub = nombreClub;
	}
	public int getCampeonatosNacionales() {
		return campeonatosNacionales;
	}
	public void setCampeonatosNacionales(int campeonatosNacionales) {
		this.campeonatosNacionales = campeonatosNacionales;
	}
	public int getCopasNacionales() {
		return copasNacionales;
	}
	public void setCopasNacionales(int copasNacionales) {
		this.copasNacionales = copasNacionales;
	}
	public String getCampeonatosEuropeos() {
		return campeonatosEuropeos;
	}
	public void setCampeonatosEuropeos(String campeonatosEuropeos) {
		this.campeonatosEuropeos = campeonatosEuropeos;
	}	
}
