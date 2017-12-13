/**
 * 
 */
package com.dps.call.center.model;

import com.dps.call.center.enums.Prioridad;

/**
 * @author <a href="mailto:daniel.samkit@gmail.com">Daniel De La Pava Suarez</a>
 * @project call-center-dps
 * @class Empleado
 * @since 12/12/2017
 *
 */
public class Empleado implements Comparable<Empleado> {

	private String nombre;
	private Prioridad prioridad;

	/**
	 * Constructor de la clase empleado
	 * 
	 * @author <a href="mailto:daniel.samkit@gmail.com">Daniel De La Pava Suarez</a>
	 * @since 12/12/2017
	 * @param nombre
	 * @param prioridad
	 */
	public Empleado(String nombre, Prioridad prioridad) {
		this.nombre = nombre;
		this.prioridad = prioridad;
	}

	/**
	 * @author <a href="mailto:daniel.samkit@gmail.com">Daniel De La Pava Suarez</a>
	 * @since 12/12/2017
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @author <a href="mailto:daniel.samkit@gmail.com">Daniel De La Pava Suarez</a>
	 * @since 12/12/2017
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	
	/**
	 * Metodo de comparacion por prioridad
	 * 
	 * @author <a href="mailto:daniel.samkit@gmail.com">Daniel De La Pava Suarez</a>
	 * @since 12/12/2017
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Empleado empleado) {
		return this.prioridad.getValor().compareTo(empleado.getPrioridad().getValor());
	}

}
