package com.dps.call.center.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;

import org.junit.After;
import org.junit.Test;

import com.dps.call.center.enums.Prioridad;
import com.dps.call.center.model.Director;
import com.dps.call.center.model.Empleado;
import com.dps.call.center.model.Operador;
import com.dps.call.center.model.Supervisor;
import com.dps.call.center.services.impl.DispatcherImpl;
import com.dps.call.center.services.impl.LlamadaEntranteImpl;

/**
 * 
 * @author <a href="mailto:daniel.samkit@gmail.com">Daniel De La Pava Suarez</a>
 * @project call-center-dps
 * @class CallCenterTest
 * @since 12/12/2017
 *
 */
public class CallCenterTest {

	PriorityBlockingQueue<Empleado> empleados;
	ExecutorService llamadasEntrantesExecutor;
	DispatcherImpl dispatcher;

	/**
	 * 
	 * @author <a href="mailto:daniel.samkit@gmail.com">Daniel De La Pava Suarez</a>
	 * @since 12/12/2017
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	@Test
	public void testLlamadasConcurrentes() throws InterruptedException, ExecutionException {
		organizar(5, 3, 1, 10);

		List<Callable<Empleado>> listaEmpleados = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			listaEmpleados.add(new LlamadaEntranteImpl(i, dispatcher));
		}

		List<Future<Empleado>> empleadosFuturos = llamadasEntrantesExecutor.invokeAll(listaEmpleados);

		int contadorLlamadas = 0;
		for (Future<Empleado> future : empleadosFuturos) {
			assert future.get() != null;
			contadorLlamadas++;
		}

		assert contadorLlamadas == 10;
	}

	/**
	 * Agregue 7 operadores, 2 supervisores y 1 director y luego envíe 7 llamadas,
	 * todos los empleados que respondan la llamada deben ser Operadores
	 */
	@Test
	public void testPriorityCallAntedee() throws InterruptedException, ExecutionException {
		organizar(7, 2, 1, 10);

		List<Callable<Empleado>> listaEmpleados = new ArrayList<>();
		for (int i = 0; i < 7; i++) {
			listaEmpleados.add(new LlamadaEntranteImpl(i, dispatcher));
		}

		List<Future<Empleado>> empleadosFuturos = llamadasEntrantesExecutor.invokeAll(listaEmpleados);

		for (Future<Empleado> future : empleadosFuturos) {
			assert future.get() instanceof Operador;
		}
	}

	@Test
	/**
	 * Agregue 7 operadores, 2 supervisores y 1 director y luego envíe 8 llamadas,
	 * todos los empleados que respondan la llamada deben ser Operadores y el último
	 * debe estar Supervisor
	 */
	public void testPriorityCallWithSupervisor() throws InterruptedException, ExecutionException {
		organizar(7, 2, 1, 10);

		List<Callable<Empleado>> listaEmpleados = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			listaEmpleados.add(new LlamadaEntranteImpl(i, dispatcher));
		}

		List<Future<Empleado>> empleadosFuturos = llamadasEntrantesExecutor.invokeAll(listaEmpleados);

		for (Future<Empleado> future : empleadosFuturos) {
			Empleado empleado = future.get();
			assert empleado != null;
			assert empleado instanceof Operador || empleado instanceof Supervisor;
		}
	}

	/**
	 * 
	 * @author <a href="mailto:daniel.samkit@gmail.com">Daniel De La Pava Suarez</a>
	 * @since 12/12/2017
	 * @param operadores
	 * @param supervisores
	 * @param directores
	 * @param sizeLlamadas
	 */
	private void organizar(Integer operadores, Integer supervisores, Integer directores, Integer sizeLlamadas) {
		empleados = new PriorityBlockingQueue<>();

		for (int i = 0; i < operadores; i++) {
			empleados.add(new Operador("Operator #" + i, Prioridad.OPERATOR));
		}

		for (int i = 0; i < supervisores; i++) {
			empleados.add(new Supervisor("Supervisor #" + i, Prioridad.SUPERVISOR));
		}

		for (int i = 0; i < directores; i++) {
			empleados.add(new Director("Director #" + i, Prioridad.DIRECTOR));
		}

		llamadasEntrantesExecutor = Executors.newFixedThreadPool(sizeLlamadas);
		dispatcher = new DispatcherImpl(empleados);
	}

	/**
	 * 
	 * @author <a href="mailto:daniel.samkit@gmail.com">Daniel De La Pava Suarez</a>
	 * @since 12/12/2017
	 */
	@After
	public void demoler() {
		empleados = null;
		dispatcher = null;
		llamadasEntrantesExecutor.shutdown();
		if (llamadasEntrantesExecutor.isShutdown()) {
			llamadasEntrantesExecutor = null;
		}
	}

}