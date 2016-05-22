package co.edu.udea.iw.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.iw.dao.RolDAO;
import co.edu.udea.iw.dto.Rol;
import co.edu.udea.iw.exception.IWDaoException;

public class RolDAOImpl extends HibernateDaoSupport implements RolDAO {

	@Override
	public Rol insertar(Rol rol) throws IWDaoException {
		
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			session.save(rol);
		}catch(HibernateException e){
			throw new IWDaoException(e);
		}
		return rol;
	}

	@Override
	public Rol modificar(Rol rol) throws IWDaoException {
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			
			session.update(rol);
			
		}catch(HibernateException e){
			throw new IWDaoException(e);
		}
		
		return rol;
	}

	
	@Override
	public List<Rol> obtener() throws IWDaoException {
		List<Rol> rols = new ArrayList<Rol>();
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			
			Criteria criteria = session.createCriteria(Rol.class);
			
			rols = criteria.list();
			
		}catch(HibernateException e){
			throw new IWDaoException(e);
		}
		
		return rols;
	}

	@Override
	public Rol obtener(Integer codigo) throws IWDaoException {
		Rol rol = null;
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			
			rol = (Rol)session.get(Rol.class, codigo);
			
		}catch(HibernateException e){
			throw new IWDaoException(e);
		}
		
		return rol;
	}

}
