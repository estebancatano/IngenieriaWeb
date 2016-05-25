package co.edu.udea.iw.exception;

import org.apache.log4j.Logger;


public class IWDaoException extends Exception {
	private Logger log = Logger.getLogger(IWDaoException.class);
	
	public IWDaoException() {
		// TODO Auto-generated constructor stub
		log.error("IWDaoException");
	}

	public IWDaoException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
		log.error(arg0);
	}

	public IWDaoException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
		log.error(arg0);
	}

	public IWDaoException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
		log.error(arg0,arg1);
	}

}
