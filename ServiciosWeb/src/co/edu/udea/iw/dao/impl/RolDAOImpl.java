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

/**
 * Implementación de la interfaz RolDAO
 * @author Esteban Cataño
 * @author Vanesa Guzman
 * @author Jeison Triana
 * @version 1
 */
public class RolDAOImpl extends HibernateDaoSupport implements RolDAO {

	/**
	 * Metodo que permite la insersion de un Rol
	 */
	@Override
	public void insertar(Rol rol) throws IWDaoException {
		
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			session.save(rol);
			// Se utiliza el objeto Transaction para evitar que no lo guarde en la
			// cache, sino que lo inserte inmediatamente en la base de datos
		}catch(HibernateException e){
			throw new IWDaoException(e);
		}
	}

	/**
	 * Metodo que permite modificar un rol existente
	 */
	@Override
	public Rol modificar(Rol rol) throws IWDaoException {
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			// Se utiliza el objeto Transaction para evitar que no lo guarde en la
			// cache, sino que lo inserte inmediatamente en la base de datos
			
			session.update(rol);
			
		}catch(HibernateException e){
			throw new IWDaoException(e);
		}
		
		return rol;
	}

	/**
	 * Metodo que retorna una lista con los roles
	 */
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
	/**
	 * Metodo que obtiene un rol dado un codigo
	 */
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
