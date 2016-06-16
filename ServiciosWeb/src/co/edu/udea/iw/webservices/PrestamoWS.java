package co.edu.udea.iw.webservices;

import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.udea.iw.exception.IWDaoException;
import co.edu.udea.iw.exception.IWServiceException;
import co.edu.udea.iw.service.PrestamoService;

@Component
@Path("Prestamo")
public class PrestamoWS {
	@Autowired
	PrestamoService prestamoService;
	
	/**
	 * Método tipo POST para insertar un Prestamo en la base de datos
	 * @param codigoReserva Código de la Reserva para la cual se va a asociar el prestamo
	 * @param nombreUsuario Nombre de usuario del administrador que entrega el dispositivo
	 * @return String vacío si se inserta el prestamo o
	 * string con el mensaje de error en caso de no insertar el prestamo
	 */
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Path("Registrar")
	public String registrarPrestamo(@QueryParam("codigoReserva") Long codigoReserva,
			@QueryParam("administrador") String nombreUsuario){
		try {
			prestamoService.registrar(codigoReserva, nombreUsuario);
			return "";
		} catch (IWDaoException e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		} catch (IWServiceException e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
	}
	@PUT
	@Produces(MediaType.TEXT_PLAIN)
	@Path("Devolver")
	public String devolverDispositivo(@QueryParam("codigoPrestamo")Long codigoPrestamo, @QueryParam("nombreUsuario") String nombreUsuario){
		
		try {
			prestamoService.devolver(codigoPrestamo, nombreUsuario);
			return "";
		} catch (IWDaoException e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		} catch (IWServiceException e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
	}
	

}
