/**
 * 
 */
package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Prestamo;
import co.edu.udea.iw.exception.IWDaoException;

/**
 * Interface que define los metodos que va a proveer el dao de Prestamo
 * @author Esteban Cataño
 * @author Vanesa Guzman
 * @author Jeison Triana
 * @version 1
 */
public interface PrestamoDAO {
	/**
	 * Metodo para insertar un prestamo en la base datos
	 * @param prestamo Objeto Prestamo con la información del prestamo a insertar
	 * @throws IWDaoException Manejador de excepciones personalizado para los daos
	 */
	public void insertar(Prestamo prestamo)throws IWDaoException;
	
	/**
	 * Metodo para obtener todos los prestamos en la base datos
	 * @return Lista con todas los prestamos almacenados en la base de datos
	 * @throws IWDaoException Manejador de excepciones personalizado para los daos
	 */
	public List<Prestamo> obtener()throws IWDaoException;
	
	/**
	 *  Metodo para modificar un prestamo de la base de datos
	 * @param prestamo Objeto Prestamo con la información del prestamo a modificar
	 * @throws IWDaoException Manejador de excepciones personalizado para los daos
	 */
	public void modificar(Prestamo prestamo) throws IWDaoException;
	
	/**
	 *  Metodo para eliminar un prestamo de la base de datos
	 * @param prestamo Objeto prestamo con la información del prestamo a eliminar
	 * @throws IWDaoException Manejador de excepciones personalizado para los daos
	 */
	public void eliminar(Prestamo prestamo) throws IWDaoException;
	
	/**
	 *  Metodo para obtener un solo prestamo de la base de datos
	 * @param codigo Codigo del prestamo que se desea consultar
	 * @return Objeto Prestamo con la información del prestamo consultado
	 * @throws IWDaoException Manejador de excepciones personalizado para los daos
	 */
	public Prestamo obtener(String codigo) throws IWDaoException;
	/**
	 * Método para obtener los prestamos por medio de una columna diferente a la clave primaria
	 * @param nombreColumna Nombre de la columna por la cual se desea buscar
	 * @param valorColumna Dato de la columna de los prestamos que se desean obtener
	 * @return Lista con los prestamos que tiene el dato dado en la columna dada
	 * @throws IWDaoException Manejador de excepciones personalizado para los daos
	 */
	public List<Prestamo> obtener(String nombreColumna, String valorColumna) throws IWDaoException;
}
