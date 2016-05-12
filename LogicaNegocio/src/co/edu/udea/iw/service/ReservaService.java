/**
 * 
 */
package co.edu.udea.iw.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dao.DispositivoDAO;
import co.edu.udea.iw.dao.ReservaDAO;
import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dto.Dispositivo;
import co.edu.udea.iw.dto.Reserva;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.IWDaoException;
import co.edu.udea.iw.exception.IWServiceException;
import co.edu.udea.iw.util.dates.UtilFecha;
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
	
	/**
	 * 
	 * @param codigoDispositivo
	 * @param usuarioInvestigador
	 * @param fechaPrestamo
	 * @param cantidadHoras
	 * @throws IWDaoException
	 * @throws IWServiceException
	 */
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
		if(cantidadHoras < 1 || cantidadHoras > 8){
			throw new IWServiceException("La cantidad de horas a prestar no puede estar por fuera del"
					+ "rango específicado");
		}
		Dispositivo dispositivo = dispositivoDao.obtener(codigoDispositivo);
		if(dispositivo == null){
			throw new IWServiceException("El dispositivo que desea prestar no existe");
		}
		Usuario usuario = usuarioDao.obtener(usuarioInvestigador);
		if(usuario == null){
			throw new IWServiceException("El nombre de usuario no existe");
		}
		if("Investigador".equals(usuario.getRol().getNombres())){
			throw new IWServiceException("El usuario no posee el rol de investigador");
		}
		if(usuario.getFechaSancion().after(fechaPrestamo)){
			throw new IWServiceException("El usuario se encuentra sancionado");
		}
		if(!this.verificarFechaReserva(dispositivo, fechaPrestamo,cantidadHoras)){
			throw new IWServiceException("La reserva se cruza con otra reserva realizada previamente");
		}
		reserva = new Reserva();
		reserva.setDispositivo(dispositivo);
		reserva.setInvestigador(usuario);
		reserva.setFechaSolicitud(new Date());
		reserva.setFechaPrestamo(fechaPrestamo);
		reserva.setCantidadHoras(cantidadHoras);
		reserva.setAprobado("SI");
		reservaDao.insertar(reserva);
	}
	/**
	 * 
	 * @param codigoReserva
	 * @param usuarioAdministracion
	 * @param estado
	 * @throws IWServiceException
	 * @throws IWDaoException
	 */
	public void actualizarReserva(Long codigoReserva,String usuarioAdministracion, 
			String estado) throws IWServiceException, IWDaoException{
		Reserva reserva;
		if(Validaciones.isTextoVacio(Long.toString(codigoReserva))){
			throw new IWServiceException("El código de la reserva no puede ser nulo");
		}
		if(Validaciones.isTextoVacio(usuarioAdministracion)){
			throw new IWServiceException("El nombre de usuario del administrador"
					+ " no puede ser nulo");
		}
		if(Validaciones.isTextoVacio(estado)){
			throw new IWServiceException("El nuevo estado de la reserva no puede ser nulo");
		}
		Usuario usuario = usuarioDao.obtener(usuarioAdministracion);
		if(usuario == null){
			throw new IWServiceException("El usuario no existe");
		}
		if("Administrador".equals(usuario.getRol().getNombres())){
			throw new IWServiceException("El usuario no posee el rol de administrador");
		}
		reserva = reservaDao.obtener(codigoReserva);
		if(reserva == null){
			throw new IWServiceException("La reserva no existe");
		}
		reserva.setAprobado(estado);
		reserva.setAdministradorAprueba(usuario);
		reservaDao.modificar(reserva);
	}

	/**
	 * 
	 * @param dispositivo
	 * @param fechaPrestamo
	 * @param cantidadHoras
	 * @return
	 * @throws IWDaoException
	 */
	private boolean verificarFechaReserva(Dispositivo dispositivo, Date fechaPrestamo, Integer cantidadHoras) throws IWDaoException {
		// TODO Auto-generated method stub
		List<Reserva> reservas = new ArrayList<Reserva>();
		Date fechaLimite;
		Date fechaLimiteOtrasReservas;
		reservas = reservaDao.obtener("dispositivo", dispositivo.getCodigo().toString());
		for(Reserva r:reservas){
			fechaLimite = UtilFecha.sumarRestarHorasFecha(fechaPrestamo, cantidadHoras);
			fechaLimiteOtrasReservas = UtilFecha.sumarRestarHorasFecha
					(r.getFechaPrestamo(), r.getCantidadHoras());
			if(fechaLimite.after(r.getFechaPrestamo()) 
					&& fechaLimite.before(fechaLimiteOtrasReservas)){
				return false;
			}
		}
		return true;
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
