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
@Component
@Path("Dispositivo")
public class DispositivoWS {

	@Autowired
	DispositivoService dispositivoService;

	@POST
	@Path("Almacenar")
	public void almacenarDispositivo(@QueryParam("codigo") Long codigo, @QueryParam("descripcion") String descripcion,
			@QueryParam("tipo") String tipo, @QueryParam("marca") String marca, @QueryParam("valor") String valor,
			@QueryParam("estado") String estado, @QueryParam("observacion") String observacion)
			throws IWServiceException, IWDaoException {

		try {
			dispositivoService.guardar(codigo, descripcion, tipo, marca, valor, estado, observacion);
		} catch (IWServiceException e) {

			throw new IWServiceException(e);
		} catch (IWDaoException e) {

			throw new IWDaoException(e);
		}
	}

	@PUT
	@Path("Eliminar")
	public void eliminarDispositivo(@QueryParam("codigo") Long codigo,
			@QueryParam("administrador") String administrador) throws IWServiceException, IWDaoException {
		try {
			dispositivoService.eliminar(codigo, administrador);
		} catch (IWServiceException e) {

			throw new IWServiceException(e);
		} catch (IWDaoException e) {

			throw new IWDaoException(e);
		}

	}

	@PUT
	public void actualizarDispositivo(@QueryParam("codigo") Long codigo, @QueryParam("descripcion") String descripcion,
			@QueryParam("tipo") String tipo, @QueryParam("marca") String marca, @QueryParam("valor") String valor,
			@QueryParam("estado") String estado, @QueryParam("observacion") String observacion)
			throws IWServiceException, IWDaoException {

		try {
			dispositivoService.actualizar(codigo, descripcion, tipo, marca, valor, estado, observacion);
		} catch (IWServiceException e) {

			throw new IWServiceException(e);
		} catch (IWDaoException e) {

			throw new IWDaoException(e);
		}
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("Listar")
	public List<DispositivoDTOWS> listarDispositivos() throws IWDaoException {
		List<DispositivoDTOWS> lista = new ArrayList<DispositivoDTOWS>();
		try{
			for(Dispositivo dispositivo : dispositivoService.obtener()){
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

			throw new IWDaoException(e);
		}
		return lista;
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("Consultar/{cod}")
	public Dispositivo consultarDispositivo(@QueryParam("cod") Long cod) throws IWServiceException, IWDaoException {
		
		try {
			return dispositivoService.obtener(cod);
			
		}catch (IWServiceException e) {

			throw new IWServiceException(e);
		} catch (IWDaoException e) {

			throw new IWDaoException(e);
		}
		

	}
}
