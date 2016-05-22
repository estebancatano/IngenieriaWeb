package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Reserva;
import co.edu.udea.iw.exception.IWDaoException;

/**
 * Interface que define los metodos que va a proveer el dao de Reserva
 * @author Esteban Cataño
 * @author Vanesa Guzman
 * @author Jeison Triana
 * @version 1
 */
public interface ReservaDAO {
	/**
	 * Metodo para insertar una reserva en la base datos
	 * @param reserva Objeto Reserva con la información de la reserva a insertar
	 * @throws IWDaoException Manejador de excepciones personalizado para los daos
	 */
	public void insertar(Reserva reserva)throws IWDaoException;
	
	/**
	 * Metodo para obtener todos las reservas en la base datos
	 * @return Lista con todas las reservas almacenadas en la base de datos
	 * @throws IWDaoException Manejador de excepciones personalizado para los daos
	 */
	public List<Reserva> obtener()throws IWDaoException;
	
	/**
	 *  Metodo para modificar una reserva de la base de datos
	 * @param reserva Objeto Reserva con la información de la reserva a modificar
	 * @throws IWDaoException Manejador de excepciones personalizado para los daos
	 */
	public void modificar(Reserva reserva) throws IWDaoException;
	
	/**
	 *  Metodo para eliminar una reserva de la base de datos
	 * @param reserva Objeto Reserva con la información de la reserva a eliminar
	 * @throws IWDaoException Manejador de excepciones personalizado para los daos
	 */
	public void eliminar(Reserva reserva) throws IWDaoException;
	
	/**
	 *  Metodo para obtener una sola reserva de la base de datos
	 * @param codigo Codigo de la reserva que se desea consultar
	 * @return Objeto Reserva con la información de la reserva consultada
	 * @throws IWDaoException Manejador de excepciones personalizado para los daos
	 */
	public Reserva obtener(Long codigo) throws IWDaoException;
	/**
	 * Método para obtener las reservas por medio de una columna diferente a la clave primaria
	 * @param nombreColumna Nombre de la columna por la cual se desea buscar
	 * @param valorColumna Dato de la columna de las reservas que se desean obtener
	 * @return Lista con las reservas que tiene el dato dado en la columna dada
	 * @throws IWDaoException Manejador de excepciones personalizado para los daos
	 */
	public List<Reserva> obtener(String nombreColumna, Object valorColumna) throws IWDaoException;
}
