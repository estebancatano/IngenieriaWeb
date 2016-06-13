package co.edu.udea.iw.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
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
	DispositivoService dispositivoService;

	@Test
	public void testGuardar() {

		try {
			dispositivoService.guardar("LALAL", "TABLET", "SAMSUNG", "1234556", "DISPONIBLE", "HOLA");
		} catch (IWDaoException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} catch (IWServiceException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}

	}
	
	@Test 
	public void testEliminar(){
		try {
			dispositivoService.eliminar(Long.valueOf(1), "admin");
					
		} catch (IWDaoException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} catch (IWServiceException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test 
	public void testActualizar(){
		try {
			dispositivoService.actualizar(Long.valueOf(1), "JOJOJ", "JAJAJA", "ÑLKJ", "JOJOJ", "DISPONIBLE", "NINGUNA");					
		} catch (IWDaoException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} catch (IWServiceException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	@Test 
	public void testObtener(){
		Dispositivo d =null;
		try {
			d = dispositivoService.obtener(Long.valueOf(1));
			
			} catch (IWDaoException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} catch (IWServiceException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		assertNotNull(d);
	}
	
	
	@Test 
	public void testObtenerLista(){
		List<Dispositivo> lista = null;

		try {
			lista = dispositivoService.obtener();
			System.out.println(lista.size());
			} catch (IWDaoException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		assertNotNull(lista);
		
	}
	
	}
