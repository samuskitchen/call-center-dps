/**
 * 
 */
package com.dps.call.center.model;

import com.dps.call.center.enums.Prioridad;

/**
 * @author <a href="mailto:daniel.samkit@gmail.com">Daniel De La Pava Suarez</a>
 * @project call-center-dps
 * @class Operador
 * @since 12/12/2017
 *
 */
public class Operador extends Empleado {

	private Prioridad prioridad;

	/**
	 * Constructor de la clase operador
	 * 
	 * @author <a href="mailto:daniel.samkit@gmail.com">Daniel De La Pava Suarez</a>
	 * @since 12/12/2017
	 * @param nombre
	 * @param prioridad
	 */
	public Operador(String nombre, Prioridad prioridad) {
		super(nombre, prioridad);
		this.prioridad = prioridad;
	}

	/**
	 * @author <a href="mailto:daniel.samkit@gmail.com">Daniel De La Pava Suarez</a>
	 * @since 12/12/2017
	 * @return the prioridad
	 */
	public Prioridad getPrioridad() {
		return prioridad;
	}

	/**
	 * @author <a href="mailto:daniel.samkit@gmail.com">Daniel De La Pava Suarez</a>
	 * @since 12/12/2017
	 * @param prioridad
	 *            the prioridad to set
	 */
	public void setPrioridad(Prioridad prioridad) {
		this.prioridad = prioridad;
	}
}