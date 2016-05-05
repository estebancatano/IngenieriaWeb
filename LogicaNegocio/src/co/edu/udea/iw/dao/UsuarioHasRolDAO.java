package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.UsuarioHasRol;
import co.edu.udea.iw.exception.IWDaoException;


/**
 * Inteface que describe los metodos que un Usuario_has_Rol puede realizar contra
 * la base de datos
 * @author Esteban Cata�o
 * @author Vanesa Guzman
 * @author Jeison Triana
 * @version 1
 *
 */
public interface UsuarioHasRolDAO {
	
	/**
	 * Crea un nuevo Usuario_has_Rol en el sistema
	 * @param Usuario_has_Rol instancia del Usuario_has_Rol a crear
	 * @return Usuario_has_Rol insertado
	 * @throws IWDaoException cuando ocurre cualquier error en la comunicación con la BD
	 */
	public UsuarioHasRol insertar(UsuarioHasRol usuario_has_Rol) throws IWDaoException;
	
	/**
	 * Modifica la información de un Usuario_has_Rol en el sistema
	 * @param Usuario_has_Rol instancia del Usuario_has_Rol con los datos a modificar
	 * @return Usuario_has_Rol modificado
	 * @throws IWDaoException cuando ocurre cualquier error en la comunicación con la BD
	 */
	public UsuarioHasRol modificar(UsuarioHasRol usuario_has_Rol) throws IWDaoException;
	
	
	/**
	 * Entrega la lista de Usuario_has_Rols activos en el sistema
	 * @return lista de Usuario_has_Rols
	 * @throws IWDaoException cuando ocurre cualquier error en la comunicación con la BD
	 */
	public List<UsuarioHasRol> obtener() throws IWDaoException;
	
	/**
	 * Entrega la información de un Usuario_has_Rol dada su cedula
	 * @param cedula identificación del Usuario_has_Rol
	 * @return instancia con los datos del Usuario_has_Rol
	 * @throws IWDaoException cuando ocurre cualquier error en la comunicación con la BD
	 */
	public UsuarioHasRol obtener(String usuario) throws IWDaoException;

}