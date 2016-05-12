package co.edu.udea.iw.service;

import java.util.Date;

import co.edu.udea.iw.dao.ReservaDAO;
import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.IWDaoException;
import co.edu.udea.iw.exception.IWServiceException;
import co.edu.udea.iw.util.encode.Cifrar;
import co.edu.udea.iw.util.validations.Validaciones;

/**
 * Clase que implementa los m�todos de l�gica del negocio necesarios para la 
 * tabla usuario
 * @author Esteban Cata�o
 * @author Vanesa Guzman
 * @author Jeison Triana
 * @version 1
 */
public class UsuarioService {
	private ReservaDAO reservaDao;
	private UsuarioDAO usuarioDao;
	

	public UsuarioDAO getUsuarioDao() {
		return usuarioDao;
	}
	public void setUsuarioDao(UsuarioDAO usuarioDao) {
		this.usuarioDao = usuarioDao;
	}
	
	/**
	 * Metodo que valida los datos para ingresar al sistema, pidiendo el usuario y la contrase�a
	 * @param login   El username, o nombre unico de usuario del investigador/administrador
	 * @param clave	  La contrase�a de acceso del investigador/estudiante
	 * @return Retorna verdadero el usuario existe en la base de datos y la contrase�a concuerda
	 * @throws IWDaoException
	 * @throws IWServiceException
	 */
	public Boolean validar(String login, String clave) throws IWDaoException, IWServiceException{
		
		Cifrar cifrar = new Cifrar();
		
		if(Validaciones.isTextoVacio(login)){
			throw new IWServiceException("El login del usuario no puede ser nula, ni una cadena de caracteres vacia");
		}
		
		if(Validaciones.isTextoVacio(clave)){
			throw new IWServiceException("La clave del usuario no puede ser nula, ni una cadena de caracteres vacia");
		}
		
		Usuario usuario = usuarioDao.obtener(login);
		if(usuario == null){
			throw new IWServiceException("Usuario o contrase�a no v�lidos");
		}
		
		
		if(!cifrar.encrypt(clave).equals(usuario.getContrasena())){
			throw new IWServiceException("Usuario o contrase�a no v�lidos");
		}
		
		return Boolean.TRUE;
	}
	
	
	

}
