/**
 * 
 */
package co.edu.udea.iw.service;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.util.dates.UtilFecha;

/**
 * Clase para realizar las pruebas unitarias a UsuarioService
 * @author Esteban Cataño
 * @author Vanesa Guzman
 * @author Jeison Triana
 * @version 1
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracionSpring.xml")
public class UsuarioServiceTest {
	@Autowired
	UsuarioService usuarioService;
	/**
	 * Test method for {@link co.edu.udea.iw.service.UsuarioService#validar(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testValidar() {
		try{
			Usuario usuario = usuarioService.validar("inves", "inves");
			assertTrue(usuario != null);
		}catch(Exception e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	/**s
	 * Test method for {@link co.edu.udea.iw.service.UsuarioService#insertarUsuario(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String)}.
	 */
	@Test
	public void testInsertarUsuario() {
		try{
			usuarioService.insertarUsuario("investigador", "investigadr", "Investigador", " Investigador", 
					2, "2765757");
			assertTrue(true);
		}catch(Exception e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
