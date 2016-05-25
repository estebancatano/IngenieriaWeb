/**
 * 
 */
package co.edu.udea.iw.webservices;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.udea.iw.dto.Reserva;
import co.edu.udea.iw.exception.IWDaoException;
import co.edu.udea.iw.exception.IWServiceException;
import co.edu.udea.iw.service.ReservaService;
import co.edu.udea.iw.webservices.dto.ReservaDTOWS;
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
	 */
	@Path("Insertar")
	@Produces(MediaType.TEXT_PLAIN)
	@POST
	public String insertarReserva(@QueryParam("dispositivo") Long dispositivo,
			@QueryParam("investigador") String investigador,
			@QueryParam("fechaPrestamo") Date fechaPrestamo,
			@QueryParam("numeroHoras") Integer numeroHoras){
		try {
			reservaService.agregarReserva(dispositivo, investigador, fechaPrestamo, numeroHoras);
			return "";
		} catch (IWDaoException | IWServiceException e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
	}
	
	@Path("Actualizar")
	@Produces(MediaType.TEXT_PLAIN)
	@PUT
	public String actualizarReserva(@QueryParam("codigoReserva") Long codigo,
			@QueryParam("usuarioAdministrador") String administrador,
			@QueryParam("estadoReserva") String estado) {
		try {
			reservaService.actualizarReserva(codigo, administrador, estado);
			return "";
		} catch (IWDaoException | IWServiceException e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
	}
	
	@Path("Listar")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public List<ReservaDTOWS> listarReservas(@QueryParam("usuario")String usuario){
		List<ReservaDTOWS> listaReservas = new ArrayList<>();
		try{
			for(Reserva reserva : reservaService.listarReservas(usuario)){
				ReservaDTOWS reservaDTOWS = new ReservaDTOWS();
				reservaDTOWS.setCodigo(reserva.getCodigo());
				reservaDTOWS.setDispositivo(reserva.getDispositivo());
				reservaDTOWS.setInvestigador(reserva.getInvestigador());
				reservaDTOWS.setFechaSolicitud(reserva.getFechaSolicitud());
				reservaDTOWS.setFechaPrestamo(reserva.getFechaPrestamo());
				reservaDTOWS.setCantidadHoras(reserva.getCantidadHoras());
				reservaDTOWS.setAprobado(reserva.getAprobado());
				reservaDTOWS.setAdministradorAprueba(reserva.getAdministradorAprueba());
				listaReservas.add(reservaDTOWS);
			}
		}catch(IWServiceException | IWDaoException e){
			return null;
		}
		return listaReservas;
	}
}
