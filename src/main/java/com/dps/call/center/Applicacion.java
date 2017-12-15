/**
 * 
 */
package com.dps.call.center;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;

import com.dps.call.center.enums.Prioridad;
import com.dps.call.center.model.Director;
import com.dps.call.center.model.Empleado;
import com.dps.call.center.model.Operador;
import com.dps.call.center.model.Supervisor;
import com.dps.call.center.services.Dispatcher;
import com.dps.call.center.services.LlamadaEntrante;
import com.dps.call.center.services.impl.DispatcherImpl;
import com.dps.call.center.services.impl.LlamadaEntranteImpl;

/**
 * @author <a href="mailto:daniel.samkit@gmail.com">Daniel De La Pava Suarez</a>
 * @project call-center-dps
 * @class Applicacion
 * @since 12/12/2017
 *
 */
public class Applicacion {

	public static void main(String[] args) throws Exception {
		new Applicacion().process();
	}

	public void process() throws ExecutionException, InterruptedException {
		PriorityBlockingQueue<Empleado> empleados = new PriorityBlockingQueue<>();

		for (int i = 0; i < 5; i++) {
			empleados.add(new Operador("Operador # " + i, Prioridad.OPERATOR));
		}

		for (int i = 0; i < 1; i++) {
			empleados.add(new Supervisor("Supervisor # " + i, Prioridad.SUPERVISOR));
		}

		for (int i = 0; i < 1; i++) {
			empleados.add(new Director("Director # " + i, Prioridad.DIRECTOR));
		}

		Dispatcher dispatcher = new DispatcherImpl(empleados);
		
		ExecutorService threadPool = Executors.newFixedThreadPool(10);

		List<Callable<Empleado>> callablesList = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			LlamadaEntrante llamadaEntrante = new LlamadaEntranteImpl(i, dispatcher);
			callablesList.add(llamadaEntrante);
		}

		threadPool.shutdown();
	}
}