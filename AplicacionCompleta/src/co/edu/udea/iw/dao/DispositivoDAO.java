/**
 * 
 */
package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Dispositivo;
import co.edu.udea.iw.exception.IWDaoException;

/**
 * Interface que define los metodos que va a proveer el dao de Dispositivo
 * @author Esteban Cataño
 * @author Vanesa Guzman
 * @author Jeison Triana
 * @version 1
 */
public interface DispositivoDAO {
	/**
	 * Metodo para insertar un prestamo en la base datos
	 * @param prestamo Objeto Dispositivo con la información del dispositivo a insertar
	 * @throws IWDaoException Manejador de excepciones personalizado para los daos
	 */
	public void insertar(Dispositivo dispositivo)throws IWDaoException;
	
	/**
	 * Metodo para obtener todos los dispositivos de la base datos
	 * @return Lista con todas los dispositivos almacenados en la base de datos
	 * @throws IWDaoException Manejador de excepciones personalizado para los daos
	 */
	public List<Dispositivo> obtener()throws IWDaoException;
	
	/**
	 *  Metodo para modificar un dispositivo de la base de datos
	 * @param dispositivo Objeto Dispositivo con la información del dispositivo a modificar
	 * @throws IWDaoException Manejador de excepciones personalizado para los daos
	 */
	public void modificar(Dispositivo dispositivo) throws IWDaoException;
	
	/**
	 *  Metodo para eliminar un dispositivo de la base de datos
	 * @param dispositivo Objeto Dispositivo con la información del dispositivo a eliminar
	 * @throws IWDaoException Manejador de excepciones personalizado para los daos
	 */
	public void eliminar(Dispositivo dispositivo) throws IWDaoException;
	
	/**
	 *  Metodo para obtener un solo dispositivo de la base de datos
	 * @param codigo Codigo del dispositivo que se desea consultar
	 * @return Objeto Dispositivo con la información del dispositivo consultado
	 * @throws IWDaoException Manejador de excepciones personalizado para los daos
	 */
	public Dispositivo obtener(Long codigo) throws IWDaoException;
	/**
	 * Método para obtener los dispositivo por medio de una columna diferente a la clave primaria
	 * @param nombreColumna Nombre de la columna por la cual se desea buscar
	 * @param valorColumna Dato de la columna de los dispositivo que se desean obtener
	 * @return Lista con los dispositivo que tiene el dato dado en la columna dada
	 * @throws IWDaoException Manejador de excepciones personalizado para los daos
	 */
	public List<Dispositivo> obtener(String nombreColumna, String valorColumna) throws IWDaoException;

}
