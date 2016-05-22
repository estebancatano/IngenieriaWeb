/**
 * 
 */
package co.edu.udea.iw.webservices;

import java.util.Date;

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
import co.edu.udea.iw.service.ReservaService;
import javassist.tools.rmi.RemoteException;

/**
 * @author asus
 *
 */
@Component
@Path("Reserva")
public class ReservaWS {
	@Autowired
	ReservaService reservaService;
	
	/**
	 * 
	 * @param dispositivo
	 * @param investigador
	 * @param fechaPrestamo
	 * @param numeroHoras
	 * @throws RemoteException
	 */
	@Produces(MediaType.TEXT_PLAIN)
	@POST
	public String insertarReserva(@QueryParam("dispositivo") Long dispositivo,
			@QueryParam("investigador") String investigador,
			@QueryParam("fechaPrestamo") Date fechaPrestamo,
			@QueryParam("numeroHoras") Integer numeroHoras) 
	throws RemoteException{
		try {
			reservaService.agregarReserva(dispositivo, investigador, fechaPrestamo, numeroHoras);
			return "La reserva fue insertada";
		} catch (IWDaoException | IWServiceException e) {
			// TODO Auto-generated catch block
			throw new RemoteException(e);
		}
	}
	
	@Produces(MediaType.TEXT_PLAIN)
	@PUT
	public String actualizarReserva(@QueryParam("codigoReserva") Long codigo,
			@QueryParam("usuarioAdministrador") String administrador,
			@QueryParam("estadoReserva") String estado) 
	throws RemoteException{
		try {
			reservaService.actualizarReserva(codigo, administrador, estado);
			return "La reserva fue actualizada";
		} catch (IWDaoException | IWServiceException e) {
			// TODO Auto-generated catch block
			throw new RemoteException(e);
		}
	}
}
