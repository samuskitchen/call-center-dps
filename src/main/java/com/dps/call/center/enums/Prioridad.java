/**
 * 
 */
package com.dps.call.center.enums;

/**
 * @author <a href="mailto:daniel.samkit@gmail.com">Daniel De La Pava Suarez</a>
 * @project call-center-dps
 * @class Prioridad
 * @since 12/12/2017
 *
 */
public enum Prioridad {

	OPERATOR(1), SUPERVISOR(2), DIRECTOR(3);

	private Integer valor;

	public Integer getValor() {
		return valor;
	}

	Prioridad(Integer valor) {
		this.valor = valor;
	}
}