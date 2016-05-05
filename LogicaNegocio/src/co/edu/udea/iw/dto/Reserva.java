package co.edu.udea.iw.dto;

import java.util.Date;

/**
 * Clase DTO para los datos de la tabla Reserva
 * @author Esteban Cataño
 * @author Vanesa Guzman
 * @author Jeison Triana
 * @version 1
 */
public class Reserva {
	/**
	 * Codigo de la reserva
	 * El id de la tabla, es auto_increment
	 */
	private Long codigo;
	/**
	 * Ejemplar que se quiere reservar
	 */
	private Ejemplar ejemplar;
	/**
	 * Nombre de usuario del investigador que hace la reserva
	 */
	private Usuario investigador;
	/**
	 * Fecha en la que el investigador realiza la reserva
	 */
	private Date fechaSolicitud;
	/**
	 * Fecha para la cual el investigador desea prestar el dispositivo
	 */
	private Date fechaPrestamo;
	/**
	 * Número de horas que desea prestar el dispositivo
	 */
	private Integer cantidadHoras;
	/**
	 * Estado de la reserva, si fue aprobada o no
	 */
	private String aprobado;
	/**
	 * Nombre de usuario del administrador que aprobó la reserva.
	 * Si la reserva fue aprobada por el sistema, este campo llevaría null
	 */
	private Usuario administradorAprueba;
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
	 * @return the codigoEjemplarDispositivo
	 */
	
	/**
	 * @return the ejemplar
	 */
	public Ejemplar getEjemplar() {
		return ejemplar;
	}
	/**
	 * @param ejemplar the ejemplar to set
	 */
	public void setEjemplar(Ejemplar ejemplar) {
		this.ejemplar = ejemplar;
	}
	/**
	 * @return the investigador
	 */
	public Usuario getInvestigador() {
		return investigador;
	}
	/**
	 * @param investigador the investigador to set
	 */
	public void setInvestigador(Usuario investigador) {
		this.investigador = investigador;
	}
	/**
	 * @return the fechaSolicitud
	 */
	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}
	/**
	 * @param fechaSolicitud the fechaSolicitud to set
	 */
	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}
	/**
	 * @return the fechaPrestamo
	 */
	public Date getFechaPrestamo() {
		return fechaPrestamo;
	}
	/**
	 * @param fechaPrestamo the fechaPrestamo to set
	 */
	public void setFechaPrestamo(Date fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}
	/**
	 * @return the cantidadHoras
	 */
	public Integer getCantidadHoras() {
		return cantidadHoras;
	}
	/**
	 * @param cantidadHoras the cantidadHoras to set
	 */
	public void setCantidadHoras(Integer cantidadHoras) {
		this.cantidadHoras = cantidadHoras;
	}
	/**
	 * @return the aprobado
	 */
	public String getAprobado() {
		return aprobado;
	}
	/**
	 * @param aprobado the aprobado to set
	 */
	public void setAprobado(String aprobado) {
		this.aprobado = aprobado;
	}
	/**
	 * @return the administradorAprueba
	 */
	public Usuario getAdministradorAprueba() {
		return administradorAprueba;
	}
	/**
	 * @param administradorAprueba the administradorAprueba to set
	 */
	public void setAdministradorAprueba(Usuario administradorAprueba) {
		this.administradorAprueba = administradorAprueba;
	}
}
