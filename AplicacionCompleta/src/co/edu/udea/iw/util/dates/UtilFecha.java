package co.edu.udea.iw.util.dates;

import java.util.Calendar;
import java.util.Date;

/**
 * Clase con metodos utiles para manejar las fechas
 * @author Jeison
 *
 */
public class UtilFecha {
	/**
	 * Metodo que permite sumar o restar horas a una fecha
	 * @param fecha Fecha a la que se desea sumar o restar horas
	 * @param horas Horas a sumar o restar
	 * @return
	 */
	public static Date sumarRestarHorasFecha(Date fecha, int horas) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha); // Configuramos la fecha que se recibe
		calendar.add(Calendar.HOUR, horas); // numero de horas a a�adir, o
											// restar en caso de horas<0
		return calendar.getTime(); // Devuelve el objeto Date con las nuevas
									// horas a�adidas
	}
	
	/**
	 *  Suma los d�as recibidos a la fecha, util para agregar dias de sanci�n
	 * @param fecha  fecha a la que se le desea agregar dias
	 * @param dias dias a agregar
	 * @return
	 */
	 public static Date sumarRestarDiasFecha(Date fecha, int dias){
	 
	      Calendar calendar = Calendar.getInstance();
	      calendar.setTime(fecha); // Configuramos la fecha que se recibe
	      calendar.add(Calendar.DAY_OF_YEAR, dias);  // numero de d�as a a�adir, o restar en caso de d�as<0
	 
	      return calendar.getTime(); // Devuelve el objeto Date con los nuevos d�as a�adidos
	 
	 }

}




