package co.edu.udea.iw.webservices;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.IWDaoException;
import co.edu.udea.iw.exception.IWServiceException;
import co.edu.udea.iw.service.UsuarioService;
import co.edu.udea.iw.webservices.dto.UsuarioDTOWS;
import javassist.tools.rmi.RemoteException;

@Component
@Path("Usuario")
public class UsuarioWS {
	@Autowired
	UsuarioService usuarioService;

	/**
	 * Método tipo GET para validar un usuario en el sistema
	 * @param login Nombre de usuario del que va a iniciar sesión
	 * @param clave Contraseña del usuario en el sistema
	 * @return Objeto UsuarioDTOWS si la validación es correcta, o null en caso contrario
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("Validar")
	public UsuarioDTOWS ingresarSistema(@QueryParam("login") String login,@QueryParam("clave") String clave){
		UsuarioDTOWS usuarioDTOWS = null;
		Usuario usuario = null;
		try {
			usuario = usuarioService.validar(login, clave);
			if(usuario != null){
				usuarioDTOWS = new UsuarioDTOWS();
				usuarioDTOWS.setNombreUsuario(usuario.getNombreUsuario());
				usuarioDTOWS.setNombres(usuario.getNombres());
				usuarioDTOWS.setNumeroDocumento(usuario.getNumeroDocumento());
				usuarioDTOWS.setRol(usuario.getRol());
				usuarioDTOWS.setApellidos(usuario.getApellidos());
				usuarioDTOWS.setFechaSancion(usuario.getFechaSancion());
			}
		} catch (IWDaoException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return null;
		} catch (IWServiceException e) {
			// TODO Auto-generated catch block
			return null;
		}
		return usuarioDTOWS;

	}
	/**
	 * Método tipo POST para insertar un usuario en la base de datos
	 * @param nombreUsuario Nombre con el que se va a logear el usuario en el sistema
	 * @param contraseña Clave con la que se va a logear el usuario en el sistema
	 * @param nombres Nombres del usuario
	 * @param apellidos Apellidos del usuario
	 * @param rol Código del rol a asignar al usuario
	 * @param documento Número de documento del usuario
	 * @return String vacío si se inserta el usuario o
	 * string con el mensaje de error en caso de no insertar el usuario
	 */
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Path("Insertar")
	public String insertarUsuario(@QueryParam("usuario")String nombreUsuario,
			@QueryParam("clave")String contraseña, @QueryParam("nombres")String nombres,
			@QueryParam("apellidos")String apellidos, @QueryParam("rol")Integer rol,
			@QueryParam("documento")String documento){
		try{
			usuarioService.insertarUsuario(nombreUsuario, contraseña, nombres, apellidos, rol, documento);
			return "";
		}catch(Exception e){
			return e.getMessage();
		}
	}
}
