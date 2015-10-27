package com.entrega1.casilla;

public class CasillaMeta extends Casilla{

	public CasillaMeta(int numeroCasilla) {
		super(numeroCasilla);
		fichas = new int[4];
		this.numeroCasilla = numeroCasilla;
	}
	
	
	/**
	 * @return FALSE si hay menos de 2 fichas
	 * 		   TRUE si esta llena
	 */
	public boolean estaLlena(){
		return num_fichas == 4;
	}//estaVacia

}//class
