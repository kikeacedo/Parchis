package com.entrega2.jugador;

import java.util.Scanner;

import com.entrega2.jugador.Color;
import com.entrega2.jugador.Jugador;

/**
 * @author Enrique Acedo
 * @version 2.0
 * @date 10/1/2016
 *
 */

/**
 * En esta clase utilizamos el patron de comportamiento Strategy. Cada jugador tendra un comportamiento dependiendo de su estado.
 * En esta clase creamos un JugadorHumano que se controla mediante consola
 */

public class JugadorPersona extends Jugador{

	/** ATRIBUTOS */
	Scanner entrada;
	
	/** METODOS **/
	public JugadorPersona(Color color, int numJugador) {
		super(color, numJugador);
		entrada =new Scanner(System.in);

	}//Constructor

	/**
	 * Muestra por pantalla las opciones que hay
	 * Devuelve la ficha que ha elegido el usuario
	 * @param fichas_posibles array de fichas que puede mover en este turno
	 * @param tirada (numero que ha sacado en el dado)
	 * @return numero de ficha que ha seleccionado
	 */
	public int seleccionarFicha() {
		turno ++;
		int ficha = -1;
		entrada =new Scanner(System.in);
		ficha = entrada.nextInt() - 1;

		if(ficha == -1)
			ficha = 9;
		
		return ficha;
	}//moverFicha
	

}//class
