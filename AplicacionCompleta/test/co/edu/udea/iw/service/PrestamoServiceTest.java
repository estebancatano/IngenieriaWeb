/**
 * 
 */
package co.edu.udea.iw.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Clase para realizar las pruebas unitarias a PrestamoService
 * @author Esteban Cataño
 * @author Vanesa Guzman
 * @author Jeison Triana
 * @version 1
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracionSpring.xml")
public class PrestamoServiceTest {
	@Autowired
	PrestamoService prestamoService;
	
	/**
	 * Test method for {@link co.edu.udea.iw.service.PrestamoService#registrar(java.lang.Long, java.lang.String)}.
	 */
	@Test
	public void testRegistrar() {
		try{
			prestamoService.registrar(Long.valueOf(1), "admin");
			assertTrue(true);
		}catch(Exception e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	/**
	 * Test method for {@link co.edu.udea.iw.service.PrestamoService#devolver(java.lang.Long, java.lang.String)}.
	 */
	@Test
	public void testDevolver() {
		try{
			prestamoService.devolver(Long.valueOf(1), "admin");
			assertTrue(true);
		}catch(Exception e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
