package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Rol;
import co.edu.udea.iw.exception.IWDaoException;


/**
 * Inteface que describe los metodos que un Rol puede realizar contra
 * la base de datos
 * @author Esteban Cata駉
 * @author Vanesa Guzman
 * @author Jeison Triana
 * @version 1
 *
 */
public interface RolDAO {
	
	/**
	 * Crea un nuevo Rol en el sistema
	 * @param Rol instancia del Rol a crear
	 * @return Rol insertado
	 * @throws IWDaoException cuando ocurre cualquier error en la comunicaci贸n con la BD
	 */
	public void insertar(Rol rol) throws IWDaoException;
	
	/**
	 * Modifica la informaci贸n de un Rol en el sistema
	 * @param Rol instancia del Rol con los datos a modificar
	 * @return Rol modificado
	 * @throws IWDaoException cuando ocurre cualquier error en la comunicaci贸n con la BD
	 */
	public Rol modificar(Rol rol) throws IWDaoException;
	
	
	/**
	 * Entrega la lista de Rols activos en el sistema
	 * @return lista de Rols
	 * @throws IWDaoException cuando ocurre cualquier error en la comunicaci贸n con la BD
	 */
	public List<Rol> obtener() throws IWDaoException;
	
	/**
	 * Entrega la informaci贸n de un Rol dada su cedula
	 * @param cedula identificaci贸n del Rol
	 * @return instancia con los datos del Rol
	 * @throws IWDaoException cuando ocurre cualquier error en la comunicaci贸n con la BD
	 */
	public Rol obtener(Integer codigo) throws IWDaoException;

}