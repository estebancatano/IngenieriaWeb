package co.edu.udea.iw.dto;

public class Ejemplar {
	
	private EjemplarCod codigo;
	private String estado;
	private String observaciones;
	
	public EjemplarCod getCodigo() {
		return codigo;
	}
	public void setCodigo(EjemplarCod codigo) {
		this.codigo = codigo;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	

}
