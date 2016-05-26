package co.edu.udea.iw.service;

import java.util.Date;

import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dao.DispositivoDAO;
import co.edu.udea.iw.dao.PrestamoDAO;
import co.edu.udea.iw.dao.ReservaDAO;
import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dto.Dispositivo;
import co.edu.udea.iw.dto.Prestamo;
import co.edu.udea.iw.dto.Reserva;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.IWDaoException;
import co.edu.udea.iw.exception.IWServiceException;
import co.edu.udea.iw.util.dates.UtilFecha;
import co.edu.udea.iw.util.validations.Validaciones;

@Transactional
public class PrestamoService {
	PrestamoDAO prestamoDao;
	ReservaDAO reservaDao;
	UsuarioDAO usuarioDao;
	DispositivoDAO dispositivoDao;
	ReservaService reservaService;
	UsuarioService usuarioService;
	
	

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

	public ReservaDAO getReservaDao() {
		return reservaDao;
	}

	public void setReservaDao(ReservaDAO reservaDao) {
		this.reservaDao = reservaDao;
	}

	public UsuarioDAO getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDAO usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	public ReservaService getReservaService() {
		return reservaService;
	}

	public void setReservaService(ReservaService reservaService) {
		this.reservaService = reservaService;
	}

	public PrestamoDAO getPrestamoDao() {
		return prestamoDao;
	}

	public void setPrestamoDao(PrestamoDAO prestamoDao) {
		this.prestamoDao = prestamoDao;
	}

	public void registrar(Long codigoReserva, String nombreUsuario) throws IWDaoException, IWServiceException {

		if (Validaciones.isTextoVacio(Long.toString(codigoReserva))) {
			throw new IWServiceException("El codigo de reserva no puede ser nulo, ni una cadena vacia");
		}
		if (Validaciones.isTextoVacio(nombreUsuario)) {
			throw new IWServiceException("El nombre de usuario del administrador no puede ser nulo, ni una cadena vacia");
		}
		/* Se crea un objeto prestamo */
		Prestamo prestamo = new Prestamo();

		/* Se crea un obj de tipo reserva */
		Reserva reserva;

		/* Se obtiene la reserva de acuerdo al código ingresado por parametro */
		reserva = reservaDao.obtener(codigoReserva);
		if(reserva == null){
			throw new IWServiceException("La reserva con el codigo ingresado no existe");
		}
		/* Se envia a prestamo toda la informacion de la reserva */
		prestamo.setCodigoReserva(reserva);
		prestamo.setFechaEntrega(new Date());
		/*
		 * Se obtiene el administrador que realiza la entrega del dispositivo y se
		 * almacena en prestamo
		 */
		Usuario usuario;
		usuario = usuarioDao.obtener(nombreUsuario);
		if(usuario == null){
			throw new IWServiceException("El usuario no existe");
		}
		if(!"ADMINISTRADOR".equals(usuario.getRol().getNombre())){
			throw new IWServiceException("El usuario no es administrador");
		}
		prestamo.setAdministradorEntrega(usuario);
		prestamo.setFechaMaximaDevolucion(
				UtilFecha.sumarRestarHorasFecha(prestamo.getFechaEntrega(), reserva.getCantidadHoras()));

		prestamoDao.insertar(prestamo);
		Dispositivo dispositivo = reserva.getDispositivo();
		dispositivo.setEstado("PRESTAMO");
		dispositivoDao.modificar(dispositivo);
	}

	public void devolver(Long codigoPrestamo, String nombreUsuario) throws IWDaoException, IWServiceException {

		/* Se realiza las validaciones pertinentes */
		if (Validaciones.isTextoVacio(codigoPrestamo.toString())) {
			throw new IWServiceException("El codigo del prestamo no puede ser nulo, ni una cadena vacia");
		}
		if (Validaciones.isTextoVacio(nombreUsuario)) {
			throw new IWServiceException("El nombre de usuario no puede ser nulo, ni una cadena vacia");
		}
		Prestamo prestamo;
		/*
		 * Se obtiene el prestamo correspondiente al codigo ingresado por
		 * parametro
		 */
		prestamo = prestamoDao.obtener(codigoPrestamo);
		if(prestamo == null){
			throw new IWServiceException("El prestamo con el código ingresado no existe");
		}
		
		/* Se llena la informacion correspondiente a la devolucion */

		/*
		 * Se obtiene el usuario que realiza la entrega del dispositivo y se
		 * almacena en prestamo
		 */
		Usuario usuario;
		usuario = usuarioDao.obtener(nombreUsuario);
		if(usuario == null){
			throw new IWServiceException("El usuario no existe");
		}
		
		if(!"ADMINISTRADOR".equals(usuario.getRol().getNombre())){
			throw new IWServiceException("El usuario no es administrador");
		}
		
		/*Se agrega el usuario y la fecha en la que devuelve el dispositivo*/
		prestamo.setAdministradorDevolucion(usuario);
		prestamo.setFechaDevolucion(new Date());
		/*if(prestamo.getFechaDevolucion().before(prestamo.getFechaEntrega())){
			throw new IWServiceException("No se puede devolver un dispositivo que no se ha prestado");
		}*/		
		usuarioService.sancionar(prestamo, usuario);
		
		prestamoDao.modificar(prestamo);
	}

	/**
	 * @return the usuarioService
	 */
	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	/**
	 * @param usuarioService the usuarioService to set
	 */
	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	

}
