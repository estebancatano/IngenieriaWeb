package co.edu.udea.iw.service;

import java.util.Date;

import co.edu.udea.iw.dao.PrestamoDAO;
import co.edu.udea.iw.dao.ReservaDAO;
import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dto.Prestamo;
import co.edu.udea.iw.dto.Reserva;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.IWDaoException;
import co.edu.udea.iw.exception.IWServiceException;
import co.edu.udea.iw.util.dates.UtilFecha;
import co.edu.udea.iw.util.validations.Validaciones;

public class PrestamoService {
	PrestamoDAO prestamoDao;
	ReservaDAO reservaDao;
	UsuarioDAO usuarioDao;
	ReservaService reservaService;
	UsuarioService usuarioService;

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

		if (codigoReserva == null) {
			throw new IWServiceException("El codigo de reserva no puede ser nulo");
		}
		if (codigoReserva.equals("")) {
			throw new IWServiceException("El codigo ingresado no puede ser una cadena vacia");
		}
		if (Validaciones.isTextoVacio(nombreUsuario)) {
			throw new IWServiceException("El nombre de usuario no puede ser nulo, ni una cadena vacia");
		}
		/* Se crea un objeto prestamo */
		Prestamo prestamo = new Prestamo();

		/* Se crea un obj de tipo reserva */
		Reserva reserva;

		/* Se obtiene la reserva de acuerdo al código ingresado por parametro */
		reserva = reservaDao.obtener(codigoReserva);

		/* Se envia a prestamo toda la informacion de la reserva */
		prestamo.setCodigoReserva(reserva);

		prestamo.setFechaEntrega(new Date());

		/*
		 * Se obtiene el usuario que realiza la entrega del dispositivo y se
		 * almacena en prestamo
		 */
		Usuario usuario;
		usuario = usuarioDao.obtener(nombreUsuario);
		prestamo.setAdministradorEntrega(usuario);

		prestamo.setFechaMaximaDevolucion(
				UtilFecha.sumarRestarHorasFecha(prestamo.getFechaEntrega(), reserva.getCantidadHoras()));

		prestamoDao.insertar(prestamo);
	}

	public void devolucion(Long codigoPrestamo, String nombreUsuario) throws IWDaoException, IWServiceException {

		/* Se realiza las validaciones pertinentes */
		if (codigoPrestamo == null) {
			throw new IWServiceException("El codigo de reserva no puede ser nulo");
		}
		if (codigoPrestamo.equals("")) {
			throw new IWServiceException("El codigo ingresado no puede ser una cadena vacia");
		}
		if (Validaciones.isTextoVacio(nombreUsuario)) {
			throw new IWServiceException("El nombre de usuario no puede ser nulo, ni una cadena vacia");
		}

		Prestamo prestamo;

		/*
		 * Se guarda el prestamo correspondiente al codigo ingresado por
		 * parametro
		 */
		prestamo = prestamoDao.obtener(codigoPrestamo.toString());

		/* Se llena la informacion correspondiente a la devolucion */

		/*
		 * Se obtiene el usuario que realiza la entrega del dispositivo y se
		 * almacena en prestamo
		 */
		Usuario usuario;
		usuario = usuarioDao.obtener(nombreUsuario);
		prestamo.setAdministradorDevolucion(usuario);
		
		/*Se agrega la fecha en la que devuelve el dispositivo*/
		prestamo.setFechaDevolucion(new Date());
		
	}

}
