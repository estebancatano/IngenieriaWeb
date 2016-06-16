package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.IWDaoException;


/**
 * Inteface que describe los metodos que un Usuario puede realizar contra
 * la base de datos
 * @author Esteban Cata駉
 * @author Vanesa Guzman
 * @author Jeison Triana
 * @version 1
 *
 */
public interface UsuarioDAO {
	
	/**
	 * Crea un nuevo Usuario en el sistema
	 * @param Usuario instancia del Usuario a crear
	 * @return Usuario insertado
	 * @throws IWDaoException cuando ocurre cualquier error en la comunicaci贸n con la BD
	 */
	public Usuario insertar(Usuario usuario) throws IWDaoException;
	
	/**
	 * Modifica la informaci贸n de un Usuario en el sistema
	 * @param Usuario instancia del Usuario con los datos a modificar
	 * @return Usuario modificado
	 * @throws IWDaoException cuando ocurre cualquier error en la comunicaci贸n con la BD
	 */
	public Usuario modificar(Usuario usuario) throws IWDaoException;
	
	
	/**
	 * Entrega la lista de Usuarios activos en el sistema
	 * @return lista de Usuarios
	 * @throws IWDaoException cuando ocurre cualquier error en la comunicaci贸n con la BD
	 */
	public List<Usuario> obtener() throws IWDaoException;
	
	/**
	 * Entrega la informaci贸n de un Usuario dada su cedula
	 * @param cedula identificaci贸n del Usuario
	 * @return instancia con los datos del Usuario
	 * @throws IWDaoException cuando ocurre cualquier error en la comunicaci贸n con la BD
	 */
	public Usuario obtener(String nombreUsuario) throws IWDaoException;

}