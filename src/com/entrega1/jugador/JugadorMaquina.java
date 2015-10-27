package com.entrega1.jugador;

import java.util.ArrayList;

/**
 * En esta clase utilizamos el patron de comportamiento State. Cada jugador tendra un comportamiento dependiendo de su estado.
 * En esta primera entrega creamos solo un JugadorHumano que se controla mediante consola
 */

public class JugadorMaquina extends Jugador{
	
	/** METODOS **/
	public JugadorMaquina(Color color, int numJugador) {
		super(color, numJugador);
	}//Constructor

	public void moverFicha(int numero_ficha, int tirada){
		
		fichas[numero_ficha] = fichas[numero_ficha] + tirada;
		System.out.println("\tFicha " + numero_ficha + " movida a " + fichas[numero_ficha]);
		System.out.println("-----------------------------------");

	}//moverFicha

	/**
	 * Muestra por pantalla las opciones que hay
	 * Devuelve la ficha que ha elegido el usuario
	 * @param fichas_posibles array de fichas que puede mover en este turno
	 * @param tirada (numero que ha sacado en el dado)
	 * @return numero de ficha que ha seleccionado
	 */
	public int seleccionarFicha(ArrayList<Integer> fichas_posibles, int tirada) {
		turno ++;
		int ficha = -1;

		System.out.println("___________ MOVIMIENTOS ____________");

		for(int i = 0; i < fichas_posibles.size() ;i++){
			System.out.println("- Ficha " + fichas_posibles.get(i) 
							 + " de casilla: " + fichas[fichas_posibles.get(i)] 
							 + " a: " + (fichas[fichas_posibles.get(i)] + tirada));
		}//for
		System.out.println("____________________________________");

		ficha = fichas_posibles.get(0);
		
		return ficha;
	}//moverFicha


}//class
