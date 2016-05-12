package co.edu.udea.iw.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import co.edu.udea.iw.dao.DispositivoDAO;
import co.edu.udea.iw.dto.Dispositivo;
import co.edu.udea.iw.exception.IWDaoException;
import co.edu.udea.iw.exception.IWServiceException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:configuracionSpring.xml")
@Transactional

public class DispositivoServiceTest {

	@Autowired
	DispositivoService DispositivoService;

	@Test
	public void testGuardar() {

		try {
			DispositivoService.guardar(984L, "LALAL", "TABLET", "SAMSUNG", "1234556", "DISPONIBLE", "HOLA");
		} catch (IWDaoException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} catch (IWServiceException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}

	}
}
