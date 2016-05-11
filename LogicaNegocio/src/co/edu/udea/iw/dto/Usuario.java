package co.edu.udea.iw.dto;

import java.io.Serializable;
import java.util.Date;

/**
* Clase DTO para los datos de la tabla Usuario
* @author Esteban Cata�o
* @author Vanesa Guzman
* @author Jeison Triana
* @version 1
*/
public class Usuario implements Serializable{
	
  	/**
	* Nombre de usuario en el sistema, es la clave primaria
	*/
    private String usuario;
    /**
    *Contraseña de acceso
    */
    private String contrasena;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

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
