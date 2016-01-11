package com.entrega2.tablero;

import java.util.ArrayList;
import com.entrega2.controlador.Controlador;
import com.entrega2.jugador.Jugador;

/**
 * @author Enrique Acedo
 * @version 2.0
 * @date 10/1/2016
 *
 */

public class Tablero {

	/** ATRIBUTOS */	
	private static Controlador controller;
	private static ArrayList<Jugador> jugadores;

	/** METODOS */
	public Tablero(ArrayList<Jugador> jugadores ){
		Tablero.jugadores = jugadores;
		controller = new Controlador(jugadores);
	}//constructor


	/**
	 * Imprime la situacion de la partida
	 */
	public static void mostrar(){
		int[] fichas = controller.getParchis().getFichas();

		String result = "|";

		for(int i = 0; i < 76; i++)
			result += "**";

		result+="|\n|";

		for(int i = 0; i < jugadores.size(); i++){
			if(jugadores.get(i).getColor().name().length() < 8)
				result  += "\t JUGADOR " + jugadores.get(i).getColor().name() + " \t\t |\t";
			else 
				result  += "\t JUGADOR " + jugadores.get(i).getColor().name() + " \t|\t";
		}//for

		result += "\n|";

		for(int i = 0; i < 76; i++)
			result += "__";

		result += "|\n|";

		for(int i = 0; i < jugadores.size(); i++){
			for(int j = 0; j < 4; j++){
				result  += "\t Ficha "+ i +" en " + controller.getTipoCasilla(fichas[i*4+j], i) + " \t |\t";
			}//for2
			result +="\n|";
		}//for1

		for(int i = 0; i < 76; i++)
			result += "__";

		result += "|\n|";

		for(int i = 0; i < jugadores.size(); i++){
			if( controller.getTurno() == i)
				result  += "\t TU TURNO --> "+ controller.getUltimaTirada()  + " \t |\t";
			else 
				result  += "\t\t\t\t |\t";
		}//for

		result += "\n|";

		for(int i = 0; i < 76; i++)
			result += "__";

		result += "|";

		System.out.println(result);

	}//mostrar

	/**
	 * Pregunta al jugador que ficha mover
	 * @param jugador
	 * @return
	 */
	public static int cogerFicha(Jugador jugador){
		return jugador.seleccionarFicha();
	}//cogerMovimiento

	
	public void empezarJuego(){
		controller.empezar();
	}//empezarJuego
	
	/** GETTERS AND SETTERS */


}//class
