package co.edu.udea.iw.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.IWDaoException;

/**
 * Implementación de la interfaz RolDAO
 * @author Esteban Cataño
 * @author Vanesa Guzman
 * @author Jeison Triana
 * @version 1
 */
public class UsuarioDAOImpl extends HibernateDaoSupport implements UsuarioDAO {

	/**
	 * Metodo que permite la insersion de un usuario
	 */	
	@Override
	public void insertar(Usuario usuario) throws IWDaoException {
		
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			session.save(usuario);
		}catch(HibernateException e){
			throw new IWDaoException(e);
		}
	}

	/**
	 * Metodo que permite modificar un usuario existente
	 */
	@Override
	public Usuario modificar(Usuario usuario) throws IWDaoException {
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			
			session.update(usuario);
			
		}catch(HibernateException e){
			throw new IWDaoException(e);
		}
		
		return usuario;
	}

	/**
	 * Metodo que obtiene una lista con los usuarios existentes
	 */
	@Override
	public List<Usuario> obtener() throws IWDaoException {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			
			Criteria criteria = session.createCriteria(Usuario.class);
			
			usuarios = criteria.list();
			
		}catch(HibernateException e){
			throw new IWDaoException(e);
		}
		
		return usuarios;
	}

	/**
	 * Metodo que obtiene un usuario por su nombreUsuario unico
	 */
	@Override
	public Usuario obtener(String nombreUsuario) throws IWDaoException {
		Usuario usuario = null;
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			
			usuario = (Usuario)session.get(Usuario.class, nombreUsuario);
			
		}catch(HibernateException e){
			throw new IWDaoException(e);
		}
		
		return usuario;
	}

}
