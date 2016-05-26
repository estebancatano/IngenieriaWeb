/**
 * 
 */
package co.edu.udea.iw.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.iw.dao.PrestamoDAO;
import co.edu.udea.iw.dto.Prestamo;
import co.edu.udea.iw.exception.IWDaoException;

/**
 * Implementación de la interfaz PrestamoDAO
 * @author Esteban Cataño
 * @author Vanesa Guzman
 * @author Jeison Triana
 * @version 1
 */
public class PrestamoDAOImpl extends HibernateDaoSupport implements PrestamoDAO {

	/* (non-Javadoc)
	 * @see co.edu.udea.iw.dao.PrestamoDAO#insertar(co.edu.udea.iw.dto.Prestamo)
	 */
	@Override
	public void insertar(Prestamo prestamo) throws IWDaoException {
		// TODO Auto-generated method stub
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			// Se utiliza el objeto Transaction para evitar que no lo guarde en la
			// cache, sino que lo inserte inmediatamente en la base de datos
//			Transaction tx = session.beginTransaction();
			session.save(prestamo);
//			tx.commit();
		}catch(HibernateException he){
			throw new IWDaoException(he);
		}
	}

	/* (non-Javadoc)
	 * @see co.edu.udea.iw.dao.PrestamoDAO#obtener()
	 */
	@Override
	public List<Prestamo> obtener() throws IWDaoException {
		// TODO Auto-generated method stub
		Session session = null;
		List<Prestamo> prestamos = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();;
			Criteria criteria = session.createCriteria(Prestamo.class);
			prestamos = criteria.list();
		}catch(HibernateException he){
			throw new IWDaoException(he);
		}
		return prestamos;
	}

	/* (non-Javadoc)
	 * @see co.edu.udea.iw.dao.PrestamoDAO#modificar(co.edu.udea.iw.dto.Prestamo)
	 */
	@Override
	public void modificar(Prestamo prestamo) throws IWDaoException {
		// TODO Auto-generated method stub
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			// Se utiliza el objeto Transaction para evitar que no lo guarde en la
			// cache, sino que lo inserte inmediatamente en la base de datos
//			Transaction tx = session.beginTransaction();
			session.update(prestamo);
//			tx.commit();
			
		}catch(HibernateException he){
			throw new IWDaoException(he);
		}
	}

	/* (non-Javadoc)
	 * @see co.edu.udea.iw.dao.PrestamoDAO#eliminar(co.edu.udea.iw.dto.Prestamo)
	 */
	@Override
	public void eliminar(Prestamo prestamo) throws IWDaoException {
		// TODO Auto-generated method stub
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			// Se utiliza el objeto Transaction para evitar que no lo guarde en la
			// cache, sino que lo inserte inmediatamente en la base de datos
//			Transaction tx = session.beginTransaction();
			session.delete(prestamo);
//			tx.commit();
			
		}catch(HibernateException he){
			throw new IWDaoException(he);
		}
	}

	/* (non-Javadoc)
	 * @see co.edu.udea.iw.dao.PrestamoDAO#obtener(java.lang.String)
	 */
	@Override
	public Prestamo obtener(Long codigo) throws IWDaoException {
		// TODO Auto-generated method stub
		Prestamo prestamo = null;
		Session session = null;
		try{
			// Se obtiene la sessión a la base de datos
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			// Se crea el objeto criteria y se le agrega un restriccion de igualdad
			prestamo = (Prestamo)session.get(Prestamo.class, codigo);
		}catch(HibernateException he){
			throw new IWDaoException(he);
		}
		return prestamo;
	}

	/* (non-Javadoc)
	 * @see co.edu.udea.iw.dao.PrestamoDAO#obtener(java.lang.String, java.lang.String)
	 */
	@Override
	public List<Prestamo> obtener(String nombreColumna, Object valorColumna) throws IWDaoException {
		// TODO Auto-generated method stub
		List<Prestamo> prestamos = null;
		Session session = null;
		try{
			// Se obtiene la sessión a la base de datos
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			// Se crea el objeto criteria y se le agrega un restriccion de igualdad
			Criteria criteria = session.createCriteria(Prestamo.class).add(
					Restrictions.eq(nombreColumna, valorColumna));
			/* Se obtienen los resultados de la consulta */
			prestamos = criteria.list();
		}catch(HibernateException he){
			throw new IWDaoException(he);
		}
		return prestamos;
	}

}
