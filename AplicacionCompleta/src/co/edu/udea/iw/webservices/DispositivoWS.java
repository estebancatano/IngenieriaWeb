package co.edu.udea.iw.webservices;

import java.util.ArrayList;
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

import co.edu.udea.iw.exception.IWDaoException;
import co.edu.udea.iw.exception.IWServiceException;
import co.edu.udea.iw.service.DispositivoService;
import co.edu.udea.iw.webservices.dto.DispositivoDTOWS;
import co.edu.udea.iw.dto.Dispositivo;

/**
 * Clase que gestiona las peticiones que vienen desde la interfaz de usuario a
 * la lógica del negocio
 * 
 * @author Esteban Cataño
 * @author Vanesa Guzman
 * @author Jeison Triana
 * @version 1
 */

@Component
@Path("Dispositivo")
public class DispositivoWS {

	@Autowired
	DispositivoService dispositivoService;

	/**
	 * Recibe la petición para almacenar un dispositivo
	 * 
	 * @param descripcion
	 * @param tipo
	 * @param marca
	 * @param valor
	 * @param estado
	 * @param observacion
	 * @throws IWServiceException
	 * @throws IWDaoException
	 */
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Path("Almacenar")
	public String almacenarDispositivo(@QueryParam("descripcion") String descripcion,
			@QueryParam("tipo") String tipo, @QueryParam("marca") String marca, @QueryParam("valor") String valor,
			@QueryParam("estado") String estado, @QueryParam("observacion") String observacion) {

		try {
			dispositivoService.guardar(descripcion, tipo, marca, valor, estado, observacion);
			return "";
		} catch (IWServiceException e) {
			return e.getMessage();
		} catch (IWDaoException e) {
			return e.getMessage();
		}

	}

	/**
	 * Recibe la petición para eliminar un dispositivo
	 * 
	 * @param codigo
	 * @param administrador
	 * @throws IWServiceException
	 * @throws IWDaoException
	 */
	@PUT
	@Produces(MediaType.TEXT_PLAIN)
	@Path("Eliminar")
	public String eliminarDispositivo(@QueryParam("codigo") Long codigo,
			@QueryParam("administrador") String administrador) {
		try {
			dispositivoService.eliminar(codigo, administrador);
			return "";
		} catch (IWServiceException e) {
			return e.getMessage();
		} catch (IWDaoException e) {
			return e.getMessage();
		}

	}

	/**
	 * Recibe la petición para actualizar un dispositivo
	 * 
	 * @param codigo
	 * @param descripcion
	 * @param tipo
	 * @param marca
	 * @param valor
	 * @param estado
	 * @param observacion
	 * @throws IWServiceException
	 * @throws IWDaoException
	 */
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("Actualizar")
	public String actualizarDispositivo(@QueryParam("codigo") Long codigo, @QueryParam("descripcion") String descripcion,
			@QueryParam("tipo") String tipo, @QueryParam("marca") String marca, @QueryParam("valor") String valor,
			@QueryParam("estado") String estado, @QueryParam("observacion") String observacion)
			{

		try {
			dispositivoService.actualizar(codigo, descripcion, tipo, marca, valor, estado, observacion);
			return "Actualización exitosa";
		} catch (IWServiceException e) {
			return e.getMessage();
			} catch (IWDaoException e) {
				return e.getMessage();		}
	}

	/**
	 * Recibe la petición para listar los dispositivos
	 * 
	 * @return lista de dispositivos que no han sido eliminados lógicamente
	 * @throws IWDaoException
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("Listar")
	public List<DispositivoDTOWS> listarDispositivos() throws IWDaoException {
		List<DispositivoDTOWS> lista = new ArrayList<DispositivoDTOWS>();
		try {
			for (Dispositivo dispositivo : dispositivoService.obtener()) {
				DispositivoDTOWS disp = new DispositivoDTOWS();
				disp.setCodigo(dispositivo.getCodigo());
				disp.setDescripcion(dispositivo.getDescripcion());
				disp.setEstado(dispositivo.getEstado());
				disp.setMarca(dispositivo.getMarca());
				disp.setTipo(dispositivo.getTipo());
				disp.setValor(dispositivo.getValor());
				disp.setObservacion(dispositivo.getDescripcion());
				lista.add(disp);
			}
		} catch (IWDaoException e) {

			return null;
		}
		return lista;
	}
/**
 * Recibe la petición de consultar el dispositivo
 * @param codigo del dispositivo
 * @return el dispositivo o nul en caso de no encontrarlo
 * @throws IWServiceException
 * @throws IWDaoException
 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("Consultar")
	public Dispositivo consultarDispositivo(@QueryParam("codigo") Long cod) throws IWServiceException, IWDaoException {

		try {
			return dispositivoService.obtener(cod);

		} catch (IWServiceException e) {

			return null;
			} catch (IWDaoException e) {

			return null;
		}

	}
}
