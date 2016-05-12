package co.edu.udea.iw.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import co.edu.udea.iw.dao.DispositivoDAO;
import co.edu.udea.iw.dao.impl.DispositivoDAOImpl;
import org.springframework.transaction.annotation.Transactional;
import co.edu.udea.iw.dto.Dispositivo;
import co.edu.udea.iw.exception.IWDaoException;
import co.edu.udea.iw.exception.IWServiceException;
import co.edu.udea.iw.util.validations.Validaciones;

/**
 * 
 * @author Esteban Cataño
 * @author Vanesa Guzman
 * @author Jeison Triana
 * @version 1
 *
 */
public class DispositivoService {

	private DispositivoDAO dispositivoDao;

	public DispositivoDAO getDispositivoDao() {
		return dispositivoDao;
	}

	public void setDispositivoDao(DispositivoDAO dispositivoDao) {
		this.dispositivoDao = dispositivoDao;
	}

	/**
	 * 
	 * @param codigo
	 * @param descripcion
	 * @param tipo
	 * @param marca
	 * @param valor
	 * @throws IWDaoException
	 */
	public void guardar(Long codigo, String descripcion, String tipo, String marca, String valor, String observacion)
			throws IWDaoException {

		if (codigo == null) {
			throw new IWDaoException("El codigo de dispositivo no puede ser nulo");
		}

		if (Validaciones.isTextoVacio(descripcion)) {
			descripcion = "";
		}

		if (Validaciones.isTextoVacio(tipo)) {
			throw new IWDaoException("El tipo de dispositivo no puede ser nulo, ni una cadena de carácteres vacía");
		}

		if (Validaciones.isTextoVacio(marca)) {
			marca = "";
		}
		if (Validaciones.isTextoVacio(valor)) {
			valor = "";
		}
			if (Validaciones.isTextoVacio(estado)) {
			valor = "";
		}
		if (Validaciones.isTextoVacio(observacion)) {
			observacion = "";
		}
		Dispositivo dispositivo = new Dispositivo();

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

		Dispositivo existe;
		existe = dispositivoDao.obtener(codigo);

		if (existe != null) {
			throw new IWDaoException("El código: " + codigo + " del dispositivo ingresado ya existe en el sistema");
		}

		dispositivoDao.insertar(dispositivo);
	}

	/**
	 * Método que accede a dispositivoDao para modificar el campo de eliminado
	 * al dispositivo y así no tener que borrar el dispositivo lógicamente.
	 * 
	 * @param dispositivo
	 * @param administradorElimina
	 * @throws IWDaoException
	 */
	public void eliminar(Long codigo, String administradorElimina) throws IWDaoException {
		Dispositivo dispositivo;
		dispositivo = dispositivoDao.obtener(codigo);
		dispositivo.setAdministradorElimina(administradorElimina);
		dispositivo.setEliminado("SI");
		dispositivo.setFechaEliminacion(new Date());
		dispositivoDao.modificar(dispositivo);
	}

	/**
	 * 
	 * @param codigo
	 * @param descripcion
	 * @param tipo
	 * @param marca
	 * @param valor
	 * @throws IWDaoException
	 */
	public void actualizar(Long codigo, String descripcion, String tipo, String marca, String valor,String estado, String observacion)
			throws IWDaoException {

		if (Validaciones.isTextoVacio(descripcion)) {
			descripcion = "";
		}
		if (Validaciones.isTextoVacio(tipo)) {
			throw new IWDaoException("El tipo de dispositivo no puede ser nulo, ni una cadena de carácteres vacía");
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
		Dispositivo dispositivo = new Dispositivo();
		dispositivo = dispositivoDao.obtener(codigo);
		dispositivo.setDescripcion(descripcion);
		dispositivo.setTipo(tipo);
		dispositivo.setMarca(marca);
		dispositivo.setValor(valor);
		dispositivo.setEstado(estado);
		dispositivo.setObservacion(observacion);
		
		dispositivoDao.modificar(dispositivo);

	}

	/**
	 * 
	 * @param codigo
	 * @return
	 * @throws IWDaoException
	 * @throws IWServiceException
	 */
	public Dispositivo obtener(Long codigo) throws IWDaoException, IWServiceException {

		if (codigo == null) {
			throw new IWServiceException("El código ingresado no debe ser nulo");
		}
		if (codigo.equals("")) {
			throw new IWServiceException("El código ingresado no debe ser una cadena vacía");
		}
		return dispositivoDao.obtener(codigo);
	}

	/**
	 * 
	 * @return
	 * @throws IWDaoException
	 */
	public List<Dispositivo> obtener() throws IWDaoException {
		List<Dispositivo> lista = null;
		lista = dispositivoDao.obtener("eliminado", "NO");
		return lista;
	}
}
