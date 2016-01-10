package com.entrega2.tablero;

import com.entrega2.casilla.Casilla;
import com.entrega2.casilla.CasillaCasa;
import com.entrega2.casilla.CasillaNormal;
import com.entrega2.casilla.CasillaSalida;
import com.entrega2.casilla.CasillaSeguro;

/**
 * @author Enrique Acedo
 * @version 2.0
 * @date 10/1/2016
 *
 */

public class Tablero {
	
	private Casilla[] casillas;

	
	/**
	 * Crea el recorrido para general teniendo en cuenta el numero de jugadores 
	 * Siempre que sean menor que 4, se creara un recorrido de 4 jugadores (el clasico)
	 *  
	 * Tendran por jugador:
	 *  4 CasillaNormal - 1 CasillaSalida - 6 CasillasNormal  
	 *  1 CasillaSeguro - 4 CasillaNormal - 1 CasillaSeguro
	 * 
	 */
	public void inicializarTablero(int numJugadores) {
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
	}//inicializarTablero
	
}//class
