/**
 * 
 */
package com.dps.call.center.services;

import com.dps.call.center.model.Empleado;

/**
 * @author <a href="mailto:daniel.samkit@gmail.com">Daniel De La Pava Suarez</a>
 * @project call-center-dps
 * @class Dispatcher
 * @since 12/12/2017
 *
 */
public interface Dispatcher {

	/**
	 * 
	 * @author <a href="mailto:daniel.samkit@gmail.com">Daniel De La Pava Suarez</a>
	 * @since 12/12/2017
	 * @param llamada
	 * @return
	 * @throws InterruptedException
	 */
	Empleado asignarLlamada(Integer llamada) throws InterruptedException;

}
