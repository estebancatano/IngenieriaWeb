package co.edu.udea.iw.dto;

import java.io.Serializable;

/**
* Clase DTO para los datos de la tabla UsuarioHasRol
* @author Esteban Cataño
* @author Vanesa Guzman
* @author Jeison Triana
* @version 1
*/
public class UsuarioHasRol implements Serializable{
	
  
    /**
     * Nombre de usuario del sistema (username)
     */
    private Usuario usuario;
    /**
     *  Rol del usuario
     */
    private Rol rol;
	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}
	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
}
