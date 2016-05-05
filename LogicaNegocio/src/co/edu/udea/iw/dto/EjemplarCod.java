package co.edu.udea.iw.dto;

import java.io.Serializable;

public class EjemplarCod implements Serializable{
	
	private Dispositivo codigoDispositivo;  
	private Integer consecutivo;
		
	public Dispositivo getCodigoDispositivo() {
		return codigoDispositivo;
	}
	public void setCodigoDispositivo(Dispositivo codigoDispositivo) {
		this.codigoDispositivo = codigoDispositivo;
	}
	public Integer getConsecutivo() {
		return consecutivo;
	}
	public void setConsecutivo(Integer consecutivo) {
		this.consecutivo = consecutivo;
	}
		
}
