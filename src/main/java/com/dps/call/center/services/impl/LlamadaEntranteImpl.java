/**
 * 
 */
package com.dps.call.center.services.impl;

import com.dps.call.center.model.Empleado;
import com.dps.call.center.services.Dispatcher;
import com.dps.call.center.services.LlamadaEntrante;

/**
 * @author <a href="mailto:daniel.samkit@gmail.com">Daniel De La Pava Suarez</a>
 * @project call-center-dps
 * @class LlamadaEntranteImpl
 * @since 12/12/2017
 *
 */
public class LlamadaEntranteImpl implements LlamadaEntrante {

	private Integer llamada;
	private Dispatcher dispatcher;
	
	
	/**
	 * Constructor de la clase LlamadaEntranteImpl
	 * 
	 * @author <a href="mailto:daniel.samkit@gmail.com">Daniel De La Pava Suarez</a>
	 * @since 12/12/2017
	 * @param llamada
	 * @param dispatcher
	 */
	public LlamadaEntranteImpl(Integer llamada, Dispatcher dispatcher) {
		super();
		this.llamada = llamada;
		this.dispatcher = dispatcher;
	}


	/**
	 * 
	 * @author <a href="mailto:daniel.samkit@gmail.com">Daniel De La Pava Suarez</a>
	 * @since 12/12/2017
	 * @see com.dps.call.center.services.LlamadaEntrante#call()
	 */
	@Override
	public Empleado call() throws Exception {
		return dispatcher.asignarLlamada(llamada);
	}
}