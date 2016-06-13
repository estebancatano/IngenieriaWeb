package co.edu.udea.iw.dto;

import java.util.Date;

/**
 * Clase DTO para los datos de la tabla Prestamo
 * @author Esteban Cataño
 * @author Vanesa Guzman
 * @author Jeison Triana
 * @version 1
 */
public class Prestamo {
	/**
	 * Codigo del prestamo
	 * El id de la tabla, es auto_increment
	 */
	private Long codigo;
	/**
	 * Codigo de la reserva.
	 * Clave foranea a la tabla reserva
	 */
	private Reserva codigoReserva;
	/**
	 * Fecha en el que el administrador le entrega el
	 * dispositivo al investigador
	 */
	private Date fechaEntrega;
	/**
	 * Nombre de usuario del administrador que le entrega
	 * el dispositivo al investigador
	 */
	private Usuario administradorEntrega;
	/**
	 * Fecha máxima en la cual el investigador debe
	 * devolver el dispositivo
	 */
	private Date fechaMaximaDevolucion;
	/**
	 * Fecha en el que el investigador devuelve el dispositivo
	 */
	private Date fechaDevolucion;
	/**
	 * Nombre de usuario del administrador que recibe el
	 * dispositivo cuando es devuelto por el investigador
	 */
	private Usuario administradorDevolucion;
	/**
	 * @return the codigo
	 */
	public Long getCodigo() {
		return codigo;
	}
	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	/**
	 * @return the codigoReserva
	 */
	public Reserva getCodigoReserva() {
		return codigoReserva;
	}
	/**
	 * @param codigoReserva the codigoReserva to set
	 */
	public void setCodigoReserva(Reserva codigoReserva) {
		this.codigoReserva = codigoReserva;
	}
	/**
	 * @return the fechaEntrega
	 */
	public Date getFechaEntrega() {
		return fechaEntrega;
	}
	/**
	 * @param fechaEntrega the fechaEntrega to set
	 */
	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	/**
	 * @return the administradorEntrega
	 */
	public Usuario getAdministradorEntrega() {
		return administradorEntrega;
	}
	/**
	 * @param administradorEntrega the administradorEntrega to set
	 */
	public void setAdministradorEntrega(Usuario administradorEntrega) {
		this.administradorEntrega = administradorEntrega;
	}
	/**
	 * @return the fechaMaximaDevolucion
	 */
	public Date getFechaMaximaDevolucion() {
		return fechaMaximaDevolucion;
	}
	/**
	 * @param fechaMaximaDevolucion the fechaMaximaDevolucion to set
	 */
	public void setFechaMaximaDevolucion(Date fechaMaximaDevolucion) {
		this.fechaMaximaDevolucion = fechaMaximaDevolucion;
	}
	/**
	 * @return the fechaDevolucion
	 */
	public Date getFechaDevolucion() {
		return fechaDevolucion;
	}
	/**
	 * @param fechaDevolucion the fechaDevolucion to set
	 */
	public void setFechaDevolucion(Date fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}
	/**
	 * @return the administradorDevolucion
	 */
	public Usuario getAdministradorDevolucion() {
		return administradorDevolucion;
	}
	/**
	 * @param administradorDevolucion the administradorDevolucion to set
	 */
	public void setAdministradorDevolucion(Usuario administradorDevolucion) {
		this.administradorDevolucion = administradorDevolucion;
	}	
}
