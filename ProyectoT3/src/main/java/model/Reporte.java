package model;

import java.util.Date;

public class Reporte {


	private int idReporte;
	private Date fecha;
	private String codigoLinea;
	private String maquina; /**/
	private double produccion;
	private double reproceso;
	private String turno;
	private String operador;
	

	
	
	public int getIdReporte() {
		return idReporte;
	}
	public void setIdReporte(int idReporte) {
		this.idReporte = idReporte;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getCodigoLinea() {
		return codigoLinea;
	}
	public void setCodigoLinea(String codigoLinea) {
		this.codigoLinea = codigoLinea;
	}
	public String getMaquina() {
		return maquina;
	}
	public void setMaquina(String maquina) {
		this.maquina = maquina;
	}
	public double getProduccion() {
		return produccion;
	}
	public void setProduccion(double produccion) {
		this.produccion = produccion;
	}
	public double getReproceso() {
		return reproceso;
	}
	public void setReproceso(double reproceso) {
		this.reproceso = reproceso;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	public String getOperador() {
		return operador;
	}
	public void setOperador(String operador) {
		this.operador = operador;
	}
	
}
