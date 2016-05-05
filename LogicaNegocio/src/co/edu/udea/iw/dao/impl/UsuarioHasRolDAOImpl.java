package co.edu.udea.iw.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.iw.dao.UsuarioHasRolDAO;
import co.edu.udea.iw.dto.UsuarioHasRol;
import co.edu.udea.iw.exception.IWDaoException;

public class UsuarioHasRolDAOImpl extends HibernateDaoSupport implements UsuarioHasRolDAO {

	@Override
	public UsuarioHasRol insertar(UsuarioHasRol usuario_has_Rol) throws IWDaoException {
		
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			session.save(usuario_has_Rol);
		}catch(HibernateException e){
			throw new IWDaoException(e);
		}
		return usuario_has_Rol;
	}

	@Override
	public UsuarioHasRol modificar(UsuarioHasRol usuario_has_Rol) throws IWDaoException {
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			
			session.update(usuario_has_Rol);
			
		}catch(HibernateException e){
			throw new IWDaoException(e);
		}
		
		return usuario_has_Rol;
	}

	
	@Override
	public List<UsuarioHasRol> obtener() throws IWDaoException {
		List<UsuarioHasRol> usuario_has_Rols = new ArrayList<UsuarioHasRol>();
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			
			Criteria criteria = session.createCriteria(UsuarioHasRol.class);
			
			usuario_has_Rols = criteria.list();
			
		}catch(HibernateException e){
			throw new IWDaoException(e);
		}
		
		return usuario_has_Rols;
	}

	@Override
	public UsuarioHasRol obtener(String usuario) throws IWDaoException {
		UsuarioHasRol usuario_has_Rol = null;
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			
			usuario_has_Rol = (UsuarioHasRol)session.get(UsuarioHasRol.class, usuario);
			
		}catch(HibernateException e){
			throw new IWDaoException(e);
		}
		
		return usuario_has_Rol;
	}

}
