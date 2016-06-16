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

import co.edu.udea.iw.util.dates.UtilFecha;

/**
 * Clase para realizar las pruebas unitarias a ReservaService
 * @author Esteban Cataño
 * @author Vanesa Guzman
 * @author Jeison Triana
 * @version 1
 */

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracionSpring.xml")
public class ReservaServiceTest {
	@Autowired
	ReservaService reservaService;
	
	/**
	 * Test method for {@link co.edu.udea.iw.service.ReservaService#agregarReserva(java.lang.Long, java.lang.String, java.util.Date, java.lang.Integer)}.
	 */
	@Test
	public void testAgregarReserva() {
		try{
			reservaService.agregarReserva(Long.valueOf(1), "user", 
					UtilFecha.sumarRestarHorasFecha(new Date(), 1), 2);
		}catch(Exception e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}
