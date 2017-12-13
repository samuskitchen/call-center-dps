/**
 * 
 */
package com.dps.call.center.services.impl;

import java.util.Random;
import java.util.concurrent.PriorityBlockingQueue;

import org.apache.log4j.Logger;

import com.dps.call.center.model.Empleado;
import com.dps.call.center.services.Dispatcher;

/**
 * @author <a href="mailto:daniel.samkit@gmail.com">Daniel De La Pava Suarez</a>
 * @project call-center-dps
 * @class DispatcherImpl
 * @since 12/12/2017
 *
 */
public class DispatcherImpl implements Dispatcher {

	private PriorityBlockingQueue<Empleado> empleados;

	private static final Integer MAX_CALL_DURATION = 10000;
	private static final Integer MIN_CALL_DURATION = 5000;

	private static final Logger LOG = Logger.getLogger(Dispatcher.class);

	/**
	 * Constructor de la clase DispatcherImpl
	 * 
	 * @author <a href="mailto:daniel.samkit@gmail.com">Daniel De La Pava Suarez</a>
	 * @since 12/12/2017
	 * @param empleados
	 */
	public DispatcherImpl(PriorityBlockingQueue<Empleado> empleados) {
		this.empleados = empleados;
	}

	/**
	 * Toma un empleado disponible y realiza la llamada, luego vuelva a colocarlo en
	 * la cola de los empleados. Si no hay empleados disponibles, el método take()
	 * bloquea todas las nuevas llamadas entrantes hasta que esté disponible otra
	 * vez.
	 * 
	 * @author <a href="mailto:daniel.samkit@gmail.com">Daniel De La Pava Suarez</a>
	 * @since 12/12/2017
	 * @see com.dps.call.center.services.Dispatcher#asignarLlamada(java.lang.Integer)
	 */
	public Empleado asignarLlamada(Integer llamada) throws InterruptedException {
		Empleado empleado = null;
		try {
			empleado = this.empleados.take();
			LOG.info("Llamada entrante # " + llamada + " Asignado al empleado " + empleado);
			hacerLlamadas(llamada, empleado);
		} catch (InterruptedException e) {
			LOG.error("Error al asignar la llamada ", e);
		}
		return empleado;
	}

	/**
	 * Simula la ejecución de la llamada y cuando la llamada finaliza, el empleado
	 * vuelve a la cola
	 * 
	 * @author <a href="mailto:daniel.samkit@gmail.com">Daniel De La Pava Suarez</a>
	 * @since 12/12/2017
	 * @param llamada
	 * @param empleado
	 */
	private void hacerLlamadas(Integer llamada, Empleado empleado) {
		try {
			Integer duracion = new Random().nextInt((MAX_CALL_DURATION - MIN_CALL_DURATION) + 1) + MIN_CALL_DURATION;
			Thread.sleep(duracion);
			LOG.info("Finalizar llamada # " + llamada + " con el empleado " + empleado + " terminó con la duración "
					+ duracion);
			empleados.add(empleado);
		} catch (InterruptedException e) {
			LOG.error("Error al realizar la llamada ", e);
		}
	}
}