package com.entrega2.tablero;

import java.util.ArrayList;
import java.util.Scanner;

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

		for(int i = 0; i < jugadores.size(); i++){

			if(jugadores.get(i).getNombre().length() < 5 )
				result  += "\t  " + jugadores.get(i).getNombre() + " \t\t\t |\t";
			else  if(jugadores.get(i).getNombre().length() < 16)
				result  += "\t  " + jugadores.get(i).getNombre() + " \t\t |\t";
			else
				result  += "\t  " + jugadores.get(i).getNombre() + " \t|\t";
		}//for
		
		result += "\n|";

		for(int i = 0; i < 76; i++)
			result += "__";

		result += "|\n|";

		for(int i = 0; i < jugadores.size(); i++){
			for(int j = 0; j < 4; j++){
				if(Controlador.getTipoCasilla(fichas[j*4+i], i).length() < 10)
					result  += " Ficha "+ (i+1) +" en " + Controlador.getTipoCasilla(fichas[j*4+i], i) + " \t\t |\t";
				else
					result  += " Ficha "+ (i+1) +" en " + Controlador.getTipoCasilla(fichas[j*4+i], i) + " \t |\t";

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

	public void bienvenida(){
		boolean empezar = false;
		Scanner entrada =new Scanner(System.in);

		while(!empezar){
			System.out.println("***************   BIENVENIDO AL JUEGO DEL PARCHIS   ***************");
			System.out.println("*******************************************************************");
			System.out.println("*****************************   MENU   ****************************");
			System.out.println("\t 1) EMPEZAR!!");
			System.out.println("\t 2) ¿Cómo se juega?");
			System.out.println("\t 3) Ver Reglas");



			entrada =new Scanner(System.in);
			int opcion = entrada.nextInt();

			switch (opcion) {
			case 1:
				empezar = true;
				break;

			case 2:
				System.out.println(comoSeJuega());
				break;

			case 3:
				System.out.println(controller.getReglas());
				break;

			default:
				break;
			}//switch

		}//while

		//entrada.close();
	}//bienvenida


	public static String comoSeJuega(){
		String result= "";

		result += "************************* ¿ CÓMO JUGAR ?  *************************\n";
		result += "| En esta version del Parchis se mostrará la informacion del ta-  |\n";
		result += "| blero por consola. Cada vez que haya un cambio se imprimirá     |\n";
		result += "| por pantalla todo el tablero.                                   |\n";
		result += "|                                                                 |\n";
		result += "| A su vez, se mostrará a quien corresponde el turno y la tirada  |\n";
		result += "| que ha sacado.                                                  |\n";
		result += "|                                                                 |\n";
		result += "| El jugador que tenga el turno tendrá que seleccionar la ficha   |\n";
		result += "| que desea mover indicando el numero de ficha.                   |\n";
		result += "|                                                                 |\n";
		result += "| En cada turno tendrá 5 intentos de seleccionar una ficha, en    |\n";
		result += "| caso de pasarse, se pasará el turno.                            |\n";
		result += "|                                                                 |\n";
		result += "| En caso de seleccionar una ficha que no pueda moverse, se no-   |\n";
		result += "| tificará mediante un mensaje y se dará opcion de seleccionar    |\n";
		result += "| otra ficha.                                                     |\n";
		result += "*******************************************************************\n";

		return result;
	}//comoSejuega

	public void nombrarJugadores(){
		Scanner entrada =new Scanner(System.in);

		String[] jugadores = new String[4];

		for(int i = 0; i < jugadores.length; i++){
			System.out.println("\tNombre jugador "+ (i+1)+": ");
			jugadores[i] = entrada.nextLine();
		}//for

		controller.nombrarJugadores(jugadores);
	}//nombrarJugadores
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
