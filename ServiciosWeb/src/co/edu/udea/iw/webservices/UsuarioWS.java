package co.edu.udea.iw.webservices;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.udea.iw.exception.IWDaoException;
import co.edu.udea.iw.exception.IWServiceException;
import co.edu.udea.iw.service.UsuarioService;
import javassist.tools.rmi.RemoteException;

@Component
@Path("Usuario")
public class UsuarioWS {
	@Autowired
	UsuarioService usuarioService;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("Validar")
	public String ingresarSistema(@QueryParam("login") String login,@QueryParam("clave") String clave){
			Boolean respuesta;
			try {
				respuesta = usuarioService.validar(login, clave);
				if(respuesta){
					return "";
				}
			} catch (IWDaoException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				return e.getMessage();
			} catch (IWServiceException e) {
				// TODO Auto-generated catch block
				return e.getMessage();
			}
			return "Usuario no valido";

	}
	
	

}
