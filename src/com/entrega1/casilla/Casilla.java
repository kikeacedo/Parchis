package com.entrega1.casilla;

public abstract class Casilla {

	/** ATRIBUTOS **/
	
	private Casilla[] fichas;
	private int num_fichas;
	private int numeroCasilla;
	
	/** METODOS **/

	public Casilla(int numeroCasilla){
		fichas = new Casilla[2];
		this.numeroCasilla = numeroCasilla;
	}//constructor
	
	/**
	 * @return FALSE si hay alguna ficha en la casilla
	 * 		   TRUE si esta vacia
	 */
	public boolean estaVacia(){
		return num_fichas == 0;
	}//estaVacia
	
	/**
	 * @return FALSE si hay menos de 2 fichas
	 * 		   TRUE si esta llena
	 */
	public boolean estaLlena(){
		return num_fichas == 2;
	}//estaVacia
	
	
	/**  meterFicha mete la ficha en la casilla
	 * @param ficha 
	 * @return TRUE si se ha metido la ficha
	 * 		   FALSE si no se ha podido meter
	 */
	public boolean meterFicha(Casilla ficha){
		boolean metida = false;
		
		for(int i = 0; i < fichas.length && !metida; i++){
			if(fichas[i] == null){
				fichas[i] = ficha;
				metida = true;
				num_fichas++;
			}//if
		}//for
		
		return metida;
	}//meterFicha
	
	
	/** sacarFicha saca la ficha de la casilla
	 * @param ficha 
	 * @return TRUE si se ha sacado la ficha
	 * 		   FALSE si no se ha podido sacar
	 */
	public boolean sacarFicha(Casilla ficha){
		boolean sacada = false;
		
		for(int i = 0; i < fichas.length && !sacada; i++){
			if(fichas[i] == ficha){
				fichas[i] = null;
				sacada = true;
				num_fichas--;
			}//if
		}//for
		return sacada;
	}//sacarFicha

	
	/** GETTERS AND SETTERS **/
	
	public int getNumeroCasilla() {
		return numeroCasilla;
	}
	
}//class
