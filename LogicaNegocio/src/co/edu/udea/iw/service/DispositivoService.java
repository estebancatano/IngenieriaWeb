package co.edu.udea.iw.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import co.edu.udea.iw.dao.DispositivoDAO;
import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dao.impl.DispositivoDAOImpl;
import org.springframework.transaction.annotation.Transactional;
import co.edu.udea.iw.dto.Dispositivo;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.IWDaoException;
import co.edu.udea.iw.exception.IWServiceException;
import co.edu.udea.iw.util.validations.Validaciones;

/**
 * Clase que implementa los métodos de la lógica del negocio para Dispositivo.
 * @author Esteban Cataño
 * @author Vanesa Guzman
 * @author Jeison Triana
 * @version 1
 *
 */

@Transactional
public class DispositivoService {
	
	/*Se crea una instacia de DispositivoDao para realizar cada una de las transaciones */
	private DispositivoDAO dispositivoDao;
	private UsuarioDAO usuarioDao;
	

	/**
	 * @return the usuarioDAO
	 */
	public UsuarioDAO getUsuarioDao() {
		return usuarioDao;
	}

	/**
	 * @param usuarioDAO the usuarioDAO to set
	 */
	public void setUsuarioDao(UsuarioDAO usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	public DispositivoDAO getDispositivoDao() {
		return dispositivoDao;
	}

	public void setDispositivoDao(DispositivoDAO dispositivoDao) {
		this.dispositivoDao = dispositivoDao;
	}

	/**
	 * Método que guarda un dispositivo, realizando las validaciones pertinentes antes de almacenarlo. 
	 * @param codigo de dispositivo
	 * @param descripcion de dispositivo
	 * @param tipo de dispositivo
	 * @param marca de dispositivo
	 * @param valor de dispositivo
	 * @param estado de dispositivo
	 * @param observacion de dispositivo
	 * @throws IWDaoException
	 */

	public void guardar(Long codigo, String descripcion, String tipo, String marca, String valor, String estado, String observacion)
			throws IWServiceException, IWDaoException {

		/*Se verifica que cada uno de los parámetros esten correctamente diligenciados*/
		
		if (codigo == null) {
			throw new IWServiceException("El codigo de dispositivo no puede ser nulo");
		}
		if (codigo.equals("")) {
			throw new IWServiceException("El código ingresado no debe ser una cadena vacía");
		}

		/*if (Validaciones.isTextoVacio(descripcion)) {
			descripcion = "";
		}*/

		if (Validaciones.isTextoVacio(tipo)) {
			throw new IWServiceException("El tipo de dispositivo no puede ser nulo, ni una cadena de carácteres vacía");
		}

		/*if (Validaciones.isTextoVacio(marca)) {
			marca = "";
		}
		if (Validaciones.isTextoVacio(valor)) {
			valor = "";
		}
		if (Validaciones.isTextoVacio(estado)) {
			estado = "";
		}
		if (Validaciones.isTextoVacio(observacion)) {
			observacion = "";
		}*/
		
		
		/*Se verifica que el código del dispositivo no exista*/
		Dispositivo existe;
		existe = dispositivoDao.obtener(codigo);
		if (existe != null) {
			throw new IWDaoException("El código: " + codigo + " del dispositivo ingresado ya existe en el sistema");
		}
		
		/*Se crea un objeto dispositivo*/
		Dispositivo dispositivo = new Dispositivo();

		/*Se llena el objeto con la nueva información sumisnistrada*/
		dispositivo.setCodigo(codigo);
		dispositivo.setDescripcion(descripcion);
		dispositivo.setTipo(tipo);
		dispositivo.setMarca(marca);
		dispositivo.setValor(valor);
		dispositivo.setEstado(estado);
		dispositivo.setObservacion(observacion);
		dispositivo.setFechaAdquisicion(new Date());
		dispositivo.setFechaEliminacion(null);
		dispositivo.setAdministradorElimina(null);
		dispositivo.setEliminado("NO");
		
		
		/*Se inserta el dispositivo en la BD*/
		dispositivoDao.insertar(dispositivo);
	}


	/**
	 * Método que actualiza la información de un dispositivo dado su código.
	 * @param codigo de dispositivo
	 * @param descripcion de dispositivo
	 * @param tipo de dispositivo
	 * @param marca de dispositivo
	 * @param valor de dispositivo
	 * @param estado de dispositivo
	 * @param observacion de dispositivo
	 * @throws IWDaoException
	 */
	public void actualizar(Long codigo, String descripcion, String tipo, String marca, String valor, String estado, String observacion)
			throws IWServiceException, IWDaoException{

		/*Se verifica que cada uno de los parámetros esten correctamente diligenciados*/
		if (Validaciones.isTextoVacio(descripcion)) {
			descripcion = "";
		}
		if (Validaciones.isTextoVacio(tipo)) {
			throw new IWServiceException("El tipo de dispositivo no puede ser nulo, ni una cadena de carácteres vacía");
		}
		if (Validaciones.isTextoVacio(marca)) {
			marca = "";
		}
		if (Validaciones.isTextoVacio(valor)) {
			valor = "";
		}
		if (Validaciones.isTextoVacio(estado)) {
			estado = "";
		}
		if (Validaciones.isTextoVacio(observacion)) {
			observacion = "";
		}
		/*Se crea un objeto dispositivo*/
		Dispositivo dispositivo = new Dispositivo();
		
		/*Se busca el dispositivo a modificar y se guarda*/
		dispositivo = dispositivoDao.obtener(codigo);
		
		/*Se almacena la nueva información*/
		dispositivo.setDescripcion(descripcion);
		dispositivo.setTipo(tipo);
		dispositivo.setMarca(marca);
		dispositivo.setValor(valor);
		dispositivo.setValor(estado);
		
		/*Se actualiza el dispositivo en la BD*/
		dispositivoDao.modificar(dispositivo);
	}
	
	
	/**
	 * Método que cambia el campo "eliminado" a "SI" de un dispositivo, con el propósito
	 *  de que no sea borrado f�sicamente del sistema.
	 * @param codigo del dispositivo a eliminar.
	 * @param administradorElimina es el nombre del administrador que realiza la eliminación.
	 * @throws IWDaoException
	 * @throws IWServiceException 
	 */
	public void eliminar(Long codigo, String administradorElimina) throws IWDaoException, IWServiceException {
		
		/*Declaro un objeto dispositivo*/
		Dispositivo dispositivo;
		
		/*Obtengo el dispositivo a eliminar*/
		dispositivo = dispositivoDao.obtener(codigo);
		
		Usuario usuario = usuarioDao.obtener(administradorElimina);
		
		if(usuario == null){
			throw new IWServiceException("El usuario no existe");
		}
		
		if(!"ADMINISTRADOR".equals(usuario.getRol().getNombre())){
			throw new IWServiceException("El usuario no es administrador");
		}
		
		/*Lleno los campos pertinentes a la eliminación*/
		dispositivo.setAdministradorElimina(usuario);
		dispositivo.setEliminado("SI");
		dispositivo.setFechaEliminacion(new Date());
		
		/*Actualizo la informacion del dispositivo en la BD*/
		dispositivoDao.modificar(dispositivo);
	}


	/**
	 * Método que entrega un dispositivo dado su código.
	 * @param codigo
	 * @return
	 * @throws IWDaoException
	 * @throws IWServiceException
	 */
	public Dispositivo obtener(Long codigo) throws IWDaoException, IWServiceException {
		/*Se verifica que el código del dispositivo sea un valor válido*/
		if (codigo == null) {
			throw new IWServiceException("El código ingresado no debe ser nulo");
		}
		if (codigo.equals("")) {
			throw new IWServiceException("El código ingresado no debe ser una cadena vacía");
		}
		/*Se retorna el dispositivo*/
		return dispositivoDao.obtener(codigo);
	}

	/**
	 * Método que entrega la lista de dispositivos que NO esten eliminados en el sistema lógicamente.
	 * @return
	 * @throws IWDaoException
	 */
	public List<Dispositivo> obtener() throws IWDaoException {
		/*Se crea la lista que será retornada*/
		List<Dispositivo> lista = null;
		
		/*Se llena la lista con los dispositivos que no estén eliminados*/
		lista = dispositivoDao.obtener("eliminado", "NO");
		
		return lista;
	}
}
