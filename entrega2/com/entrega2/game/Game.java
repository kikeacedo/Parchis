package com.entrega2.game;

import java.util.ArrayList;
import java.util.Scanner;

import com.entrega2.jugador.Color;
import com.entrega2.jugador.Jugador;
import com.entrega2.jugador.JugadorPersona;
import com.entrega2.tablero.Tablero;

/**
 * @author Enrique Acedo
 * @version 2.0
 * @date 10/1/2016
 *
 */

/**
 * En esta clase utilizamos el patron de construccion Singleton para que solo pueda haber una instancia de Parchis en la clase Game
 */
public class Game {

	/** ATRIBUTOS **/
	public static Scanner entrada;


	/** METODOS **/
	public static void main(String[] args) {
		final int NUM_JUGADORES = 4;


//		while(leyendo){
//			try{
//				entrada =new Scanner(System.in);
//				System.out.println("Bienvenido al PARCHIS\n" + 
//						"Por favor, elija el numero de jugadores (1-4)");
//
//				num_jugadores = entrada.nextInt();
//				leyendo = false;
//
//				entrada.close();
//			}catch(Exception e){
//				System.out.println("Error, empieza una nueva partida");
//				entrada.close();
//			}//try
//		}//while


		// INICIALIZO LOS JUGADORES
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();

		for(int i= 0; i < NUM_JUGADORES; i++)
			jugadores.add(new JugadorPersona(Color.getColor(i), i));


		// INICIALIZO EL TABLERO
		Tablero tablero = new Tablero(jugadores);
		tablero.empezarJuego();
		
//		tablero.mostrar();
		//		parchis.imprimirSituacion();

	}//main
}//class
