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

import co.edu.udea.iw.dao.DispositivoDAO;
import co.edu.udea.iw.dto.Dispositivo;
import co.edu.udea.iw.dto.Dispositivo;
import co.edu.udea.iw.exception.IWDaoException;

/**
 * Implementación de la interfaz DispositivoDAO
 * @author Esteban Cataño
 * @author Vanesa Guzman
 * @author Jeison Triana
 * @version 1
 */
public class DispositivoDAOImpl extends HibernateDaoSupport implements DispositivoDAO {

	/* (non-Javadoc)
	 * @see co.edu.udea.iw.dao.DispositivoDAO#insertar(co.edu.udea.iw.dto.Dispositivo)
	 */
	@Override
	public void insertar(Dispositivo dispositivo) throws IWDaoException {
		// TODO Auto-generated method stub
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			// Se utiliza el objeto Transaction para evitar que no lo guarde en la
			// cache, sino que lo inserte inmediatamente en la base de datos
//			Transaction tx = session.beginTransaction();
			session.save(dispositivo);
//			tx.commit();
		}catch(HibernateException he){
			
			throw new IWDaoException(he);
		}
	}

	/* (non-Javadoc)
	 * @see co.edu.udea.iw.dao.DispositivoDAO#obtener()
	 */
	@Override
	public List<Dispositivo> obtener() throws IWDaoException {
		// TODO Auto-generated method stub
		Session session = null;
		List<Dispositivo> dispositivos = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();;
			Criteria criteria = session.createCriteria(Dispositivo.class);
			dispositivos = criteria.list();
		}catch(HibernateException he){
			throw new IWDaoException(he);
		}
		return dispositivos;
	}

	/* (non-Javadoc)
	 * @see co.edu.udea.iw.dao.DispositivoDAO#modificar(co.edu.udea.iw.dto.Dispositivo)
	 */
	@Override
	public void modificar(Dispositivo dispositivo) throws IWDaoException {
		// TODO Auto-generated method stub
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			// Se utiliza el objeto Transaction para evitar que no lo guarde en la
			// cache, sino que lo inserte inmediatamente en la base de datos
//			Transaction tx = session.beginTransaction();
			session.update(dispositivo);
//			tx.commit();
			
		}catch(HibernateException he){
			throw new IWDaoException(he);
		}
	}

	/* (non-Javadoc)
	 * @see co.edu.udea.iw.dao.DispositivoDAO#eliminar(co.edu.udea.iw.dto.Dispositivo)
	 */
	@Override
	public void eliminar(Dispositivo dispositivo) throws IWDaoException {
		// TODO Auto-generated method stub
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			// Se utiliza el objeto Transaction para evitar que no lo guarde en la
			// cache, sino que lo inserte inmediatamente en la base de datos
//			Transaction tx = session.beginTransaction();
			session.delete(dispositivo);
//			tx.commit();
			
		}catch(HibernateException he){
			throw new IWDaoException(he);
		}
	}

	/* (non-Javadoc)
	 * @see co.edu.udea.iw.dao.DispositivoDAO#obtener(java.lang.String)
	 */
	@Override
	public Dispositivo obtener(Long codigo) throws IWDaoException {
		// TODO Auto-generated method stub
		Dispositivo dispositivo = null;
		Session session = null;
		try{
			// Se obtiene la sessión a la base de datos
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			// Se crea el objeto criteria y se le agrega un restriccion de igualdad
			dispositivo = (Dispositivo)session.get(Dispositivo.class, codigo);
		}catch(HibernateException he){
			throw new IWDaoException(he);
		}
		return dispositivo;
	}

	/* (non-Javadoc)
	 * @see co.edu.udea.iw.dao.DispositivoDAO#obtener(java.lang.String, java.lang.String)
	 */
	@Override
	public List<Dispositivo> obtener(String nombreColumna, String valorColumna) throws IWDaoException {
		// TODO Auto-generated method stub
		List<Dispositivo> dispositivos = null;
		Session session = null;
		try{
			// Se obtiene la sessión a la base de datos
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			// Se crea el objeto criteria y se le agrega un restriccion de igualdad
			Criteria criteria = session.createCriteria(Dispositivo.class).add(
					Restrictions.eq(nombreColumna, valorColumna));
			/* Se obtienen los resultados de la consulta */
			dispositivos = criteria.list();
		}catch(HibernateException he){
			throw new IWDaoException(he);
		}
		return dispositivos;
	}

}
