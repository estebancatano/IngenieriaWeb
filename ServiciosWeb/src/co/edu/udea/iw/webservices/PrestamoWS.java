package co.edu.udea.iw.webservices;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

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
	
	@PUT
	@Path("Registrar")
	public void registrarPrestamo(@QueryParam("codigoReserva") Long codigoReserva,@QueryParam("nombreUsuario") String nombreUsuario){
		try {
			prestamoService.registrar(codigoReserva, nombreUsuario);
		} catch (IWDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IWServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@PUT
	@Path("Devolver")
	public void devolverDispositivo(@QueryParam("codigoPrestamo")Long codigoPrestamo, @QueryParam("nombreUsuario") String nombreUsuario){
		
		try {
			prestamoService.devolver(codigoPrestamo, nombreUsuario);
		} catch (IWDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IWServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
