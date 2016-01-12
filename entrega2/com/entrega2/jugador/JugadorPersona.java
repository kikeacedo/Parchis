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

	//	/**
	//	 * Metodo que mueve la ficha N casillas
	//	 */
	//	public void moverFicha(int numero_ficha, int tirada){
	//		
	//		fichas[numero_ficha] = fichas[numero_ficha] + tirada;
	//		// Si mete en meta la ficha, pone la variable a true;
	//		if(fichas[numero_ficha] == casillaFinalColor)
	//			Juez.setMeteFichaEnCasa(true);
	//		
	//		System.out.println("\tFicha " + numero_ficha + " movida a " + TraduccionMovimiento.getTipoCasilla(fichas[numero_ficha], id));
	//		System.out.println("-----------------------------------");
	//
	//	}//moverFicha

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
		ficha = entrada.nextInt();

		return ficha;
	}//moverFicha


}//class
