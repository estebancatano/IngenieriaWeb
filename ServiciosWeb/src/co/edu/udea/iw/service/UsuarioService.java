package co.edu.udea.iw.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.transaction.annotation.Transactional;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import co.edu.udea.iw.dao.ReservaDAO;
import co.edu.udea.iw.dao.RolDAO;
import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dto.Dispositivo;
import co.edu.udea.iw.dto.Prestamo;
import co.edu.udea.iw.dto.Reserva;
import co.edu.udea.iw.dto.Rol;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.IWDaoException;
import co.edu.udea.iw.exception.IWServiceException;
import co.edu.udea.iw.util.encode.Cifrar;
import co.edu.udea.iw.util.validations.Validaciones;
import co.edu.udea.iw.util.dates.UtilFecha;

/**
 * Clase que implementa los métodos de lógica del negocio necesarios para la
 * tabla usuario
 * 
 * @author Esteban Cataño
 * @author Vanesa Guzman
 * @author Jeison Triana
 * @version 1
 */

@Transactional
public class UsuarioService {
	private UsuarioDAO usuarioDao;
	private ReservaDAO reservaDao;
	private RolDAO rolDao;

	public UsuarioDAO getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDAO usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	/**
	 * Metodo que valida los datos para ingresar al sistema, pidiendo el usuario
	 * y la contraseña
	 * 
	 * @param login
	 *            El username, o nombre unico de usuario del
	 *            investigador/administrador
	 * @param clave
	 *            La contraseña de acceso del investigador/estudiante
	 * @return Retorna verdadero el usuario existe en la base de datos y la
	 *         contraseña concuerda
	 * @throws IWDaoException
	 * @throws IWServiceException
	 */
	public Usuario validar(String login, String clave) throws IWDaoException, IWServiceException {

		Cifrar cifrar = new Cifrar();

		if (Validaciones.isTextoVacio(login)) {
			throw new IWServiceException("El login del usuario no puede ser nula, ni una cadena de caracteres vacia");
		}

		if (Validaciones.isTextoVacio(clave)) {
			throw new IWServiceException("La clave del usuario no puede ser nula, ni una cadena de caracteres vacia");
		}

		Usuario usuario = usuarioDao.obtener(login);
		if (usuario == null) {
			throw new IWServiceException("Usuario o contraseña no válidos");
		}

		if (!cifrar.encrypt(clave).equals(usuario.getContrasena())) {
			throw new IWServiceException("Usuario o contraseña no válidos");
		}

		return usuario;
	}

	/**
	 * Metodo que es llamado al momento de la devolucion del prestamo, y
	 * verifica si la fecha es correcta, si la fecha es mayor a la fecha limite
	 * se genera una sancion de x dias * @param fecha1
	 * @throws IWDaoException 
	 * 
	 */
	public void sancionar(Prestamo prestamo, Usuario usuario) throws IWDaoException {

		Date fechaEntrega = prestamo.getFechaDevolucion();
		Date fechaMaximaEntrega = prestamo.getFechaMaximaDevolucion();

		if (fechaMaximaEntrega.before(fechaEntrega)) {
			// La fecha de devolucion es mayor a la esperada y hay sancion.
			Date fechaSancion = UtilFecha.sumarRestarDiasFecha(fechaEntrega, 1);
			usuario.setFechaSancion(fechaSancion);
			usuarioDao.modificar(usuario);
		}
	}

	/**
	 * Método de la lógica del negocio que permite agregar un nuevo usuario a la base de datos
	 * @param nombreUsuario Nombre de usuario para realizar el login en la aplicación
	 * @param clave Contraseña del usuario
	 * @param nombres Nombres del usuario
	 * @param apellidos Apellidos del usuario
	 * @param codigoRol Código del rol a otorgar al usuario
	 * @param documento Número de documento del usuario
	 * @throws IWServiceException Manejador de excepciones personalizado
	 * @throws IWDaoException Manejador de excepciones personalizado
	 */
	public void insertarUsuario(String nombreUsuario, String clave, String nombres, String apellidos,
			Integer codigoRol, String documento) throws IWServiceException, IWDaoException{
		Cifrar cifrar = new Cifrar();

		if (Validaciones.isTextoVacio(nombreUsuario)) {
			throw new IWServiceException("El login del usuario no puede ser nula, ni una cadena de caracteres vacia");
		}

		if (Validaciones.isTextoVacio(clave)) {
			throw new IWServiceException("La clave del usuario no puede ser nula, ni una cadena de caracteres vacia");
		}
		if (Validaciones.isTextoVacio(nombres)) {
			throw new IWServiceException("Los nombres del usuario no puede ser nulos, ni una cadena de caracteres vacia");
		}
		if (Validaciones.isTextoVacio(apellidos)) {
			throw new IWServiceException("Los apellidos del usuario no puede ser nulos, ni una cadena de caracteres vacia");
		}
		if (Validaciones.isTextoVacio(documento)) {
			throw new IWServiceException("El documento del usuario no puede ser nulo, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(Integer.toString(codigoRol))){
			throw new IWServiceException("El codigo del rol no puede ser nulo, ni una cadena de caracteres vacia");
		}
		Usuario existeUsuario = usuarioDao.obtener(nombreUsuario);
		if(existeUsuario != null){
			throw new IWServiceException("Ya existe un usuario con el nombre de usuario ingresado");
		}
		Rol rol = rolDao.obtener(codigoRol);
		if(rol == null){
			throw new IWServiceException("El codigo de rol no existe");
		}
		Usuario usuario = new Usuario();
		usuario.setNombreUsuario(nombreUsuario);
		usuario.setContrasena(cifrar.encrypt(clave));
		usuario.setNombres(nombres);
		usuario.setApellidos(apellidos);
		usuario.setNumeroDocumento(documento);
		usuario.setRol(rol);
		usuarioDao.insertar(usuario);
	}
	
	/**
	 * @return the reservaDao
	 */
	public ReservaDAO getReservaDao() {
		return reservaDao;
	}

	/**
	 * @param reservaDao
	 *            the reservaDao to set
	 */
	public void setReservaDao(ReservaDAO reservaDao) {
		this.reservaDao = reservaDao;
	}

	/**
	 * @return the rolDao
	 */
	public RolDAO getRolDao() {
		return rolDao;
	}

	/**
	 * @param rolDao the rolDao to set
	 */
	public void setRolDao(RolDAO rolDao) {
		this.rolDao = rolDao;
	}

	
}
