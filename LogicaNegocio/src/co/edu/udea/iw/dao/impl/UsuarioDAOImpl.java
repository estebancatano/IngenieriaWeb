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

public class UsuarioDAOImpl extends HibernateDaoSupport implements UsuarioDAO {

	@Override
	public Usuario insertar(Usuario usuario) throws IWDaoException {
		
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			session.save(usuario);
		}catch(HibernateException e){
			throw new IWDaoException(e);
		}
		return usuario;
	}

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
