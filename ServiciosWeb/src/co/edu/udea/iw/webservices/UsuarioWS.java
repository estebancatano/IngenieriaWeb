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
import co.edu.udea.iw.service.UsuarioService;
import javassist.tools.rmi.RemoteException;

@Component
@Path("Usuario")
public class UsuarioWS {
	@Autowired
	UsuarioService usuarioService;

	@PUT
	@Path("Almacenar")
	public void ingresarSistema(@QueryParam("login") String login,@QueryParam("clave") String clave){
			try {
				usuarioService.validar(login, clave);
			} catch (IWDaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IWServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
	
	

}
