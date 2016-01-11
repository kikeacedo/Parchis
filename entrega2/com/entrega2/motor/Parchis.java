package com.entrega2.motor;

import com.entrega2.jugador.Jugador;
import com.entrega2.recorrido.Recorrido;

/**
 * @author Enrique Acedo
 * @version 2.0
 * @date 10/1/2016
 *
 */


public class Parchis {

	/** ATRIBUTOS */
	private Recorrido recorrido;
	private int[] fichas;

	/** METODOS */

	public Parchis(int numJugadores){
		recorrido = new Recorrido();
		recorrido.inicializarRecorrido(numJugadores);

		iniciarFichas(numJugadores);
	}//constructor


	private void iniciarFichas(int numJugadores){

		fichas = new int[numJugadores*4];

		for(int i = 0; i < fichas.length; i++){
			fichas[i] = 0;
		}//for1

	}//iniciarFichas

	public boolean isTerminado(){
		return true;
	}//isTerminado

	public boolean puedeMover(Jugador jugador, int ficha){

		return false;
	}//puedeMover
	
	public boolean todasEnJuego(Jugador jugador){
		
		return true;
	}//todasEnJuego

	/** GETTERS AND SETTERS */

	public Recorrido getRecorrido(){
		return recorrido;
	}

	public int[] getFichas(){
		return fichas;
	}

}//class
