package com.entrega2.casilla;

/**
 * @author Enrique Acedo
 * @version 2.0
 * @date 10/1/2016
 *
 */

/**
 * En esta clase utilizamos el patron Abstract Factory.
 * 
 * Por una parte el RecorridoGeneral tendra CasillaCasa, CasillaSalida, CasillaNormal y CasillaSeguro
 * Por otra parte el RecorridoColor tendra CasillaPasillo y CasillaMeta
 * 
 * Todas las casillas serán del tipo casilla y cuando inicialicemos los recorridos iremos metiendo casillas sin 
 * tener que saber de que tipo es cada una
 */
public abstract class Casilla {

	/** ATRIBUTOS **/
	
	protected int[] fichas;
	protected int numeroCasilla;
	
	/** METODOS **/

	public abstract String tipoCasilla();
	
	public Casilla(int numeroCasilla){
		fichas = new int[2];
		fichas[0] = -1;
		fichas[1] = -1;
		this.numeroCasilla = numeroCasilla;
	}//constructor
	
	/**
	 * @return FALSE si hay alguna ficha en la casilla
	 * 		   TRUE si esta vacia
	 */
	public boolean estaVacia(){
		return (fichas[0] == -1 && fichas[1] == -1);
	}//estaVacia

	/**
	 * @return FALSE si hay menos de 2 fichas
	 * 		   TRUE si esta llena
	 */
	public boolean estaLlena(){
		return (fichas[0] != -1 && fichas[1] != -1);
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
			}//if
		}//for
		return sacada;
	}//sacarFicha

	
	/** GETTERS AND SETTERS **/
	
	public int getNumeroCasilla() {
		return numeroCasilla;
	}//getNumeroCasilla
	
	public int getFicha(){
		int ficha;
		if(fichas[0] != -1)
			ficha = fichas[0];
		else
			ficha = fichas[1];
		
		return ficha;
	}//getFicha
	
	public int[] getFichas(){
		return fichas;
	}
	
}//class
