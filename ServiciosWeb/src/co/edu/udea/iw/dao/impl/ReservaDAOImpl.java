/**
 * 
 */
package co.edu.udea.iw.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.iw.dao.ReservaDAO;
import co.edu.udea.iw.dto.Reserva;
import co.edu.udea.iw.exception.IWDaoException;

/**
 * Implementación de la interfaz ReservaDAO
 * @author Esteban Cataño
 * @author Vanesa Guzman
 * @author Jeison Triana
 * @version 1
 */
public class ReservaDAOImpl extends HibernateDaoSupport implements ReservaDAO {
	/* (non-Javadoc)
	 * @see co.edu.udea.iw.dao.ReservaDAO#insertar(co.edu.udea.iw.dto.Reserva)
	 */
	@Override
	public void insertar(Reserva reserva) throws IWDaoException {
		// TODO Auto-generated method stub
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			// Se utiliza el objeto Transaction para evitar que no lo guarde en la
			// cache, sino que lo inserte inmediatamente en la base de datos
//			Transaction tx = session.beginTransaction();
			session.save(reserva);
//			tx.commit();
		}catch(HibernateException he){
			throw new IWDaoException(he);
		}
	}

	/* (non-Javadoc)
	 * @see co.edu.udea.iw.dao.ReservaDAO#obtener()
	 */
	@Override
	public List<Reserva> obtener() throws IWDaoException {
		// TODO Auto-generated method stub
		Session session = null;
		List<Reserva> reservas = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();;
			Criteria criteria = session.createCriteria(Reserva.class);
			reservas = criteria.list();
		}catch(HibernateException he){
			throw new IWDaoException(he);
		}
		return reservas;
	}

	/* (non-Javadoc)
	 * @see co.edu.udea.iw.dao.ReservaDAO#modificar(co.edu.udea.iw.dto.Reserva)
	 */
	@Override
	public void modificar(Reserva reserva) throws IWDaoException {
		// TODO Auto-generated method stub
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			// Se utiliza el objeto Transaction para evitar que no lo guarde en la
			// cache, sino que lo inserte inmediatamente en la base de datos
//			Transaction tx = session.beginTransaction();
			session.update(reserva);
//			tx.commit();
			
		}catch(HibernateException he){
			throw new IWDaoException(he);
		}
	}

	/* (non-Javadoc)
	 * @see co.edu.udea.iw.dao.ReservaDAO#eliminar(co.edu.udea.iw.dto.Reserva)
	 */
	@Override
	public void eliminar(Reserva reserva) throws IWDaoException {
		// TODO Auto-generated method stub
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			// Se utiliza el objeto Transaction para evitar que no lo guarde en la
			// cache, sino que lo inserte inmediatamente en la base de datos
//			Transaction tx = session.beginTransaction();
			session.delete(reserva);
//			tx.commit();
			
		}catch(HibernateException he){
			throw new IWDaoException(he);
		}
	}

	/* (non-Javadoc)
	 * @see co.edu.udea.iw.dao.ReservaDAO#obtener(java.lang.String)
	 */
	@Override
	public Reserva obtener(Long codigo) throws IWDaoException {
		// TODO Auto-generated method stub
		Reserva reserva = null;
		Session session = null;
		try{
			// Se obtiene la sessión a la base de datos
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			// Se crea el objeto criteria y se le agrega un restriccion de igualdad
			reserva = (Reserva)session.get(Reserva.class, codigo);
		}catch(HibernateException he){
			throw new IWDaoException(he);
		}
		return reserva;
	}

	/* (non-Javadoc)
	 * @see co.edu.udea.iw.dao.ReservaDAO#obtener(java.lang.String, java.lang.String)
	 */
	@Override
	public List<Reserva> obtener(String nombreColumna, Object valorColumna) throws IWDaoException {
		// TODO Auto-generated method stub
		List<Reserva> reservas = null;
		Session session = null;
		try{
			// Se obtiene la sessión a la base de datos
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			// Se crea el objeto criteria y se le agrega un restriccion de igualdad
			Criteria criteria = session.createCriteria(Reserva.class).add(
					Restrictions.eq(nombreColumna, valorColumna));
			/* Se obtienen los resultados de la consulta */
			reservas = criteria.list();
		}catch(HibernateException he){
			throw new IWDaoException(he);
		}
		return reservas;
	}

}
