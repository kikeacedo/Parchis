package com.entrega2.game;

import java.util.ArrayList;
import java.util.Scanner;
import com.entrega2.jugador.Color;
import com.entrega2.jugador.Jugador;
import com.entrega2.jugador.JugadorPersona;

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
		boolean leyendo = true;
		int num_jugadores = 0;


		while(leyendo){
			try{
				entrada =new Scanner(System.in);
				System.out.println("Bienvenido al PARCHIS\n" + 
						"Por favor, elija el numero de jugadores (1-4)");

				num_jugadores = entrada.nextInt();
				leyendo = false;

				entrada.close();
			}catch(Exception e){
				System.out.println("Error, empieza una nueva partida");
				entrada.close();
			}//try
		}//while


		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();

		int num_jugadores_aux = 0;
		for(int i= 0; i < num_jugadores; i++, num_jugadores_aux++)
			jugadores.add(new JugadorPersona(Color.getColor(num_jugadores_aux), num_jugadores_aux));


		

		//		parchis.imprimirSituacion();

	}//main
}//class
