/**
 * 
 */
package com.dps.call.center.services;

import java.util.concurrent.Callable;

import com.dps.call.center.model.Empleado;

/**
 * @author <a href="mailto:daniel.samkit@gmail.com">Daniel De La Pava Suarez</a>
 * @project call-center-dps
 * @class LlamadaEntrante
 * @since 12/12/2017
 *
 */
public interface LlamadaEntrante extends Callable<Empleado>{

	/**
	 * 
	 * @author <a href="mailto:daniel.samkit@gmail.com">Daniel De La Pava Suarez</a>
	 * @since 12/12/2017
	 * @return
	 * @throws Exception
	 */
	Empleado call() throws Exception;

}
