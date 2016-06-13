/**
 * 
 */
package co.edu.udea.iw.webservices.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import co.edu.udea.iw.dto.Rol;

/**
 * Clase DTO para los servicios web de Usuario
 * 
 * @author Esteban Cata�o
 * @author Vanesa Guzman
 * @author Jeison Triana
 * @version 1
 */
@XmlRootElement
public class UsuarioDTOWS {
	/**
	* Nombre de usuario en el sistema, es la clave primaria
	*/
    private String nombreUsuario;
    /*/**
    *Contraseña de acceso
    */
    //private String contrasena;
    /**
    *Numero de identificación del usuario
    */
    private String numeroDocumento;
    /**
    *Nombres del usuario
    */
    private String nombres;
    /**
    *Apellidos del usuario
    */
    private String apellidos;
    
    private Rol rol;
    
    private Date fechaSancion;

	/**
	 * @return the nombreUsuario
	 */
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	/**
	 * @param nombreUsuario the nombreUsuario to set
	 */
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	/*
	/**
	 * @return the contrasena
	 */
	/*public String getContrasena() {
		return contrasena;
	}

	/**
	 * @param contrasena the contrasena to set
	 */
	/*public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}*/

	/**
	 * @return the numeroDocumento
	 */
	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	/**
	 * @param numeroDocumento the numeroDocumento to set
	 */
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	/**
	 * @return the nombres
	 */
	public String getNombres() {
		return nombres;
	}

	/**
	 * @param nombres the nombres to set
	 */
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * @return the rol
	 */
	public Rol getRol() {
		return rol;
	}

	/**
	 * @param rol the rol to set
	 */
	public void setRol(Rol rol) {
		this.rol = rol;
	}

	/**
	 * @return the fechaSancion
	 */
	public Date getFechaSancion() {
		return fechaSancion;
	}

	/**
	 * @param fechaSancion the fechaSancion to set
	 */
	public void setFechaSancion(Date fechaSancion) {
		this.fechaSancion = fechaSancion;
	}

    
}
