package com.entrega1.jugador;

/**
 * @author Enrique Acedo

 * @version 1.0
 * @date 27/10/2015
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
