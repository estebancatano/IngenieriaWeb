/**
 * 
 */
package co.edu.udea.iw.webservices;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
 * Clase que gestiona las peticiones que vienen desde la interfaz de usuario a
 * la lógica del negocio
 * 
 * @author Esteban CataÃ±o
 * @author Vanesa Guzman
 * @author Jeison Triana
 * @version 1
 */
@Component
@Path("Reserva")
public class ReservaWS {
	@Autowired
	ReservaService reservaService;
	
	/**
	 * Método tipo POST para insertar un reserva en la base de datos
	 * @param dispositivo Código del dispositivo a reservar
	 * @param investigador Nombre de usuario del investigador
	 * @param fechaPrestamo Fecha y hora para la cual desea prestar el dispositivo
	 * 	\n Formato: "AAAA-MM-DDTHH:MM:SS"
	 * @param numeroHoras Número de horas que desea prestar el dispositivo
	 * @return String vacío si se inserta la reserva o
	 * string con el mensaje de error en caso de no insertar la reserva
	 */
	@Path("Insertar")
	@Produces(MediaType.TEXT_PLAIN)
	@POST
	public String insertarReserva(@QueryParam("dispositivo") Long dispositivo,
			@QueryParam("investigador") String investigador,
			@QueryParam("fechaPrestamo") String fechaPrestamo,
			@QueryParam("numeroHoras") Integer numeroHoras){
		Date fechaPrestamoDate;
		Calendar calendar = Calendar.getInstance();
		try {
			// Formato: "2016-05-25T16:00:00"
			// Calendar.set(year + 1900, month, date, hrs, min, sec)
			calendar.set(Integer.parseInt(fechaPrestamo.substring(0, 4)), 
					Integer.parseInt(fechaPrestamo.substring(5, 7)) - 1, 
					Integer.parseInt(fechaPrestamo.substring(8, 10)), 
					Integer.parseInt(fechaPrestamo.substring(11, 13)), 
					Integer.parseInt(fechaPrestamo.substring(14, 16)), 
					Integer.parseInt(fechaPrestamo.substring(17, 19)));
			fechaPrestamoDate = calendar.getTime();
			reservaService.agregarReserva(dispositivo, investigador, fechaPrestamoDate, numeroHoras);
			return "";
		} catch (IWDaoException | IWServiceException e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
	}
	/**
	 * Método tipo PUT para actualizar un reserva en la base de datos
	 * @param codigo Código de la reserva que se quiere actualizar
	 * @param administrador Nombre de usuario del administrador que va actualizar la reserva
	 * @param estado Estado de aprobación para el que se va a actualizar la reserva.
	 * 				 \nSI: Para aprobado
	 * 				 \nNO: Para no aprobado
	 * @return String vacío si se inserta la reserva o
	 * string con el mensaje de error en caso de no insertar la reserva
	 */
	@Path("Actualizar")
	@Produces(MediaType.TEXT_PLAIN)
	@PUT
	public String actualizarReserva(@QueryParam("codigo") Long codigo,
			@QueryParam("administrador") String administrador,
			@QueryParam("estado") String estado) {
		try {
			reservaService.actualizarReserva(codigo, administrador, estado);
			return "";
		} catch (IWDaoException | IWServiceException e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
	}
	
	/**
	 * Método tipo GET para obtener las reservas de un usuario
	 * @param usuario Nombre de usuario del que se quiere obtener las rservas
	 * @return Lista de reservas del usuario ingresado
	 */
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
