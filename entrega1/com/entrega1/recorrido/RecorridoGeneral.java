package com.entrega1.recorrido;

import com.entrega1.casilla.Casilla;
import com.entrega1.casilla.CasillaCasa;
import com.entrega1.casilla.CasillaNormal;
import com.entrega1.casilla.CasillaSalida;
import com.entrega1.casilla.CasillaSeguro;
import com.entrega2.casilla.*;

/**
 * @author Enrique Acedo

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

public class RecorridoGeneral extends Recorrido{

	/**
	 * Crea el recorrido para general teniendo en cuenta el numero de jugadores 
	 * Siempre que sean menor que 4, se creara un recorrido de 4 jugadores (el clasico)
	 *  
	 * Tendran por jugador:
	 *  4 CasillaNormal - 1 CasillaSalida - 6 CasillasNormal  
	 *  1 CasillaSeguro - 4 CasillaNormal - 1 CasillaSeguro
	 * 
	 */
	public void inicializarRecorrido(int numJugadores) {
		casillas = new Casilla[numJugadores*17 + 1];

		casillas[0] = new CasillaCasa(0);

		for(int i = 0; i < numJugadores; i++){
			for(int j = 1; j <= 17;  j++){
				switch (j) {
				case 4:
					casillas[i*17 + j] = new CasillaSalida(i*17 + j);
					break;

				case 11:
				case 16:
					casillas[i*17 + j] = new CasillaSeguro(i*17 + j);
					break;

				default:
					casillas[i*17 + j] = new CasillaNormal(i*17 + j);
					break;
				}
			}//for j

		}//for i
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
	 */	public boolean sacarFicha(int num_jugador, int num_casilla) {
		return casillas[num_casilla].sacarFicha(num_jugador);
	}//sacarFicha

}//class
