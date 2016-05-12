/**
 * 
 */
package co.edu.udea.iw.service;

import java.util.Date;

import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dao.DispositivoDAO;
import co.edu.udea.iw.dao.ReservaDAO;
import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dto.Dispositivo;
import co.edu.udea.iw.dto.Reserva;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.IWDaoException;
import co.edu.udea.iw.exception.IWServiceException;
import co.edu.udea.iw.util.validations.Validaciones;

/**
 * Clase que implementa los métodos de lógica del negocio necesarios para la 
 * tabla reserva
 * @author Esteban Cataño
 * @author Vanesa Guzman
 * @author Jeison Triana
 * @version 1
 */

@Transactional
public class ReservaService {
	private ReservaDAO reservaDao;
	private UsuarioDAO usuarioDao;
	private DispositivoDAO dispositivoDao;
	
	public void agregarReserva(Long codigoDispositivo, String usuarioInvestigador,
			Date fechaPrestamo, Integer cantidadHoras) throws IWDaoException, IWServiceException{
		Reserva reserva = null;
		if(Validaciones.isTextoVacio(Long.toString(codigoDispositivo))){
			throw new IWServiceException("El código del dispositivo no puede ser nulo");
		}
		if(Validaciones.isTextoVacio(usuarioInvestigador)){
			throw new IWServiceException("El nombre de usuario del investigador no puede ser nulo");
		}
		if(fechaPrestamo == null){
			throw new IWServiceException("La fecha para la que se quiere presta no puede ser nulo");
		}
		if(fechaPrestamo.before(new Date())){
			throw new IWServiceException("La fecha no puede ser menor a la actual");
		}
		if(cantidadHoras < 1){
			throw new IWServiceException("La cantidad de horas a prestar no puede ser nula");
		}
		Dispositivo dispositivo = dispositivoDao.obtener(codigoDispositivo);
	}

	/**
	 * @return the reservaDao
	 */
	public ReservaDAO getReservaDao() {
		return reservaDao;
	}

	/**
	 * @param reservaDao the reservaDao to set
	 */
	public void setReservaDao(ReservaDAO reservaDao) {
		this.reservaDao = reservaDao;
	}

	/**
	 * @return the usuarioDao
	 */
	public UsuarioDAO getUsuarioDao() {
		return usuarioDao;
	}

	/**
	 * @param usuarioDao the usuarioDao to set
	 */
	public void setUsuarioDao(UsuarioDAO usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	/**
	 * @return the dispositivoDao
	 */
	public DispositivoDAO getDispositivoDao() {
		return dispositivoDao;
	}

	/**
	 * @param dispositivoDao the dispositivoDao to set
	 */
	public void setDispositivoDao(DispositivoDAO dispositivoDao) {
		this.dispositivoDao = dispositivoDao;
	}
	
}
