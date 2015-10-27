package com.entrega1.game;

import com.entrega1.motor.Parchis;

/**
 * @author Enrique Acedo
 * @author Adrian Ojeda
 * @author Luis Miguel Garcia
 * @version 1.0
 * @date 27/10/2015
 *
 */

/**
 * En esta clase utilizamos el patron de construccion Singleton para que solo pueda haber una instancia de Parchis en la clase Game
 */
public class Game {
	
	/** ATRIBUTOS **/
	private static Parchis parchis = Parchis.getParchis();

	/** METODOS **/
	public static void main(String[] args) {
		boolean leyendo = true;
		int num_jugadores = 0;

		while(leyendo){
			try{
				System.out.println("Bienvenido al PARCHIS\n" + 
						"Por favor, elija el numero de jugadores (1-4)");
				
				num_jugadores = Parchis.entrada.nextInt();

				leyendo = false;
			}catch(Exception e){
				System.out.println("Ficha incorrecta, elige otra");
			}//try
		}//while


		parchis.setNumJugadores(num_jugadores);
		parchis.iniciarJugadores();
		parchis.iniciarRecorrido();

		parchis.start();

		//		parchis.imprimirSituacion();

	}//main
}//class
