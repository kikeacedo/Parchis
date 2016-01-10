package com.entrega2.jugador;

import com.entrega2.jugador.Color;

/**
 * @author Enrique Acedo

 * @version 2.0
 * @date 10/1/2016
 *
 */

public enum Color {
	
	Rojo, Azul, Amarillo, Verde;
	
	
	/**
	 * Devuelve el color en la posicion que indique
	 * @param numero_color
	 * @return Color de la posicion numero_color
	 */
	public static Color getColor(int numero_color){
		return Color.values()[numero_color];
	}

}//class
