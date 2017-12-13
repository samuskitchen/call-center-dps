/**
 * 
 */
package com.dps.call.center.model;

import com.dps.call.center.enums.Prioridad;

/**
 * @author <a href="mailto:daniel.samkit@gmail.com">Daniel De La Pava Suarez</a>
 * @project call-center-dps
 * @class Director
 * @since 12/12/2017
 *
 */
public class Director extends Empleado {

	private Prioridad prioridad;

	/**
	 * Constructor de la clase director
	 * 
	 * @author <a href="mailto:daniel.samkit@gmail.com">Daniel De La Pava Suarez</a>
	 * @since 12/12/2017
	 * @param nombre
	 * @param prioridad
	 */
	public Director(String nombre, Prioridad prioridad) {
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