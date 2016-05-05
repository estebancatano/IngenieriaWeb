package co.edu.udea.iw.dto;

import java.io.Serializable;

/**
* Clase DTO para los datos de la tabla Rol
* @author Esteban Cataño
* @author Vanesa Guzman
* @author Jeison Triana
* @version 1
*/
public class Rol implements Serializable{
	
	/**
	 * Código del rol
	 */
	private Integer codigo;
	/**
	 * Nombre del rol
	 */
	private String nombre;
	


	public String getNombres() {
		return nombre;
	}
	public void setNombres(String nombre) {
		this.nombre = nombre;
	}
	public Integer getcodigo() {
		return codigo;
	}
	public void setcodigo(Integer codigo) {
		this.codigo = codigo;
	}
}
