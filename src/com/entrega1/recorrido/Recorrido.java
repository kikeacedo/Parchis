package com.entrega1.recorrido;

import com.entrega1.casilla.Casilla;

/**
 * @author Enrique Acedo
 * @author Adrian Ojeda
 * @author Luis Miguel Garcia
 * @version 1.0
 * @date 27/10/2015
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
public abstract class Recorrido {

	/** ATRIBUTOS**/
	protected Casilla[] casillas;
	
	/** METODOS**/
	 public Casilla[] getRecorrido(){
		 return casillas;
	 }//getRecorrido
	 
	 public abstract void inicializarRecorrido(int numJugadores);
	 public abstract boolean meterFicha(int num_jugador, int num_casilla);
	 public abstract boolean sacarFicha(int num_jugador, int num_casilla);

	
}//class
