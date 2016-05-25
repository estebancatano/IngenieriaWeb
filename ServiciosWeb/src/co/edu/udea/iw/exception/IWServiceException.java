package co.edu.udea.iw.exception;

import org.apache.log4j.Logger;

public class IWServiceException extends Exception {
	private Logger log = Logger.getLogger(IWServiceException.class);
	
	public IWServiceException() {
		super();
		// TODO Auto-generated constructor stub
		log.error("IWServiceException");
	}


	public IWServiceException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
		log.error(arg0,arg1);
	}

	public IWServiceException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
		log.error(arg0);
	}

	public IWServiceException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
		log.error(arg0);
	}

}
