package com.entrega1.recorrido;

import com.entrega1.casilla.*;

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

public class RecorridoColor extends Recorrido{

	/**
	 * Crea el recorrido para cada color teniendo en cuenta que su casilla
	 * inicial es la siguiente a la casilla final del recorrido normal 
	 * Tendran 7 CasillaPasillo y 1 CasillaMeta
	 */
	public void inicializarRecorrido(int casillaInicial) {
		casillas= new Casilla[8];
		for(int i = 0; i < 7; i++){
			casillas[i] = new CasillaPasillo(i + casillaInicial);
		}//for

		casillas[7] = new CasillaMeta(casillaInicial + 7);

	}//inicializarRecorrido

	/**
	 * Metodo que mete la ficha del jugador num_jugador en la casilla num_casilla
	 * @param num_jugador numero de jugador que va a mover la ficha
	 * @param num_casilla numero de casilla a la que mover la ficha
	 */
	public boolean meterFicha(int num_jugador, int num_casilla) {
		boolean metida = false;
		Casilla casilla = casillas[num_casilla];
		if(!casilla.estaLlena()){
			//Meto esta ficha
			casilla.meterFicha(num_jugador);
			metida = true;

		}//if

		return metida;	
	}//meterFicha

	/**
	 * Metodo que saca la ficha del jugador num_jugador de la casilla num_casilla
	 * @param num_jugador numero de jugador que va a sacar la ficha
	 * @param num_casilla numero de casilla de la que sacar la ficha
	 */
	public boolean sacarFicha(int num_jugador, int num_casilla) {
		return casillas[num_casilla].sacarFicha(num_jugador);
	}//sacarFicha

}//class
