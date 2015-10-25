package com.entrega1.casilla;

public abstract class Casilla {

	/** ATRIBUTOS **/
	
	private int[] fichas;
	private int num_fichas;
	private int numeroCasilla;
	
	/** METODOS **/

	public Casilla(int numeroCasilla){
		fichas = new int[2];
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
	public boolean meterFicha(int jugador){
		boolean metida = false;
		
		for(int i = 0; i < fichas.length && !metida; i++){
			if(fichas[i] < 0){
				fichas[i] = jugador;
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
	public boolean sacarFicha(int jugador){
		boolean sacada = false;
		
		for(int i = 0; i < fichas.length && !sacada; i++){
			if(fichas[i] == jugador){
				fichas[i] = -1;
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
	
	public int getFicha(){
		int ficha;
		if(fichas[0] != -1)
			ficha = fichas[0];
		else
			ficha = fichas[1];
		
		return ficha;
	}//getFicha
	
}//class
