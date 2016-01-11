package com.entrega1.motor;

import java.util.ArrayList;
import java.util.Scanner;

import com.entrega1.jugador.Color;
import com.entrega1.jugador.Jugador;
import com.entrega1.jugador.JugadorMaquina;
import com.entrega1.jugador.JugadorPersona;
import com.entrega1.recorrido.*;
import com.entrega1.jugador.*;

/**
 * @author Enrique Acedo
 * @version 1.0
 * @date 27/10/2015
 *
 */

/**
 * En esta clase utilizamos el patron de construccion Singleton para que solo pueda haber una instancia de Parchis en la clase Game
 *
 * En esta clase utilizamos el patron de construccion Singleton para que solo pueda haber una instancia de Juez en la clase Parchis
 */

public class Parchis {

	/** ATRIBUTOS **/
	private Jugador[] jugadores;
	private Recorrido recorridoPrincipal;
	private Recorrido[] recorridoFinal;
	private int num_jugadores;
	private int num_jugadores_persona;
	private final int num_jugadores_tablero = 4;
	private Juez juez;
	private static Parchis miParchis;
	private final int numeroCarasDado = 6;
	private boolean juegoTerminado = false;
	public static Scanner entrada;


	/** METODOS **/
	private Parchis(){

		entrada = new Scanner(System.in);
	}//constructor

	/**
	 * Metodo para empezar el juego
	 */
	public void start(){
		// Creamos un juez y un dado para este juego 
		juez = Juez.getJuez(num_jugadores, numeroCarasDado);

		// Creamos una variable jugadorActual que es el jugador que jugara cada turno;
		Jugador jugadorActual;
		int tiradaActual;

		while(!juegoTerminado){
			// El juez elige jugador
			int num_jugador = juez.elegirJugador();
			jugadorActual = jugadores[num_jugador];

			// Tiramos el dado 
			tiradaActual = juez.tira(jugadorActual);


			// El juez mira a ver que fichas puede mover ese jugador
			ArrayList<Integer> fichas_posibles = juez.verOpciones(jugadorActual,tiradaActual);

			// El jugador elige la ficha que mover si hay alguna opcion
			if(!fichas_posibles.isEmpty()){
				System.out.println("_____________ JUGADOR "+jugadorActual.getColor()+" ____________");
				System.out.println("_____________ TIRADA: "+tiradaActual+" _______________");

				int ficha_elegida = jugadorActual.seleccionarFicha(fichas_posibles, tiradaActual);
				jugadorActual.moverFicha(ficha_elegida,tiradaActual);
			}//if

			// Comprueba si hay algun ganador para continuar o terminar la partida
			int ganador;
			if( (ganador = comprobarGanador()) >= 0){
				System.out.println("_____________ JUGADOR "+jugadores[ganador].getColor()+" ____________");
				System.out.println("_____________ HA GANADO !! ____________");
				juegoTerminado = true;
			}
		}//whilePrincipal
	}//

	/**
	 *  Metodo que comprueba si algun jugador tiene sus 4 fichas en la casilla meta
	 * @return el jugador ganador
	 */
	private int comprobarGanador() {
		int ganador = -1;
		for(int i = 0; i < jugadores.length; i++){
			int num_fichas = -1;
			for(int j = 0; j < jugadores[i].getFichas().length; j++){
				if(jugadores[i].getFichas()[j] == jugadores[i].getCasillaFinalColor()){
					num_fichas++;
					if(num_fichas == 3)
						ganador = i;
				}//if
			}//for
		}//for


		return ganador;
	}

	/**
	 * Metodo que manda la ficha que esta en la casilla numeroCasilla 
	 * del jugador "jugador" a casa ya sea porque se la han comido o porque ha sacado tres veces 6.
	 * @param numeroCasilla
	 * @param jugador
	 */
	public void mandarFichaCasa(int numeroCasilla, int jugador) {
		int[] fichas_aux = jugadores[jugador].getFichas();

		for(int i = 0; i < fichas_aux.length; i++){
			if(fichas_aux[i] == numeroCasilla){
				fichas_aux[i] = 0;
			}//if
		}//for

	}//mandarFichaCasa

	/**
	 * Metodo que crea los jugadores y sus fichas y las inicializa
	 */
	public void iniciarJugadores(){
		jugadores = new Jugador[num_jugadores];

		int aux = num_jugadores_persona;

		for(int i = 0; i < num_jugadores; i++){
			int[] fichas_inicial ={0,0,0,0};
			if(aux > 0){
				jugadores[i] = new JugadorPersona(Color.getColor(i), i);
				aux--;
			}else{
				jugadores[i] = new JugadorMaquina(Color.getColor(i), i);
			}//if-else
			jugadores[i].setCasillaInicial(17*i + 5);
			jugadores[i].setCasillaFinal((i==0)?68:i*17);
			jugadores[i].setCasillaFinalColor((i==0)?68 + 8:i*17 + 8);

			jugadores[i].setFichas(fichas_inicial);

			//			System.out.println("jugador " + i + " casilla inicial " + jugadores[i].getCasillaInicial()+ " casilla final " + jugadores[i].getCasillaFinal());
		}//for
	}//iniciarJugadores

	/**
	 * Metodo que crea el recorrido general y el recorrido de color y los inicializa
	 */
	public void iniciarRecorrido(){
		recorridoPrincipal = new RecorridoGeneral();
		recorridoPrincipal.inicializarRecorrido(num_jugadores_tablero);

		recorridoFinal = new Recorrido[num_jugadores];

		for(int i = 0; i < num_jugadores; i++){

			recorridoFinal[i]= new RecorridoColor();

			recorridoFinal[i].inicializarRecorrido(jugadores[i].getCasillaFinal() + 1);
		}
	}//iniciarRecorrido


	/**
	 * Imprime por consola la situacion actual de las fichas de cada jugador
	 */
	public void imprimirSituacion(){

		for(int i = 0; i < jugadores.length; i++){
			int[] fichas = jugadores[i].getFichas();

			for(int j = 1; j <= fichas.length; j++)
				System.out.println("Jugador " + i + ", ficha " + j + " esta en: "+ fichas[j-1]);

		}//for
	}//imprimirSituacionJugadores


	
	/** GETTERS AND SETTERS **/
	public static Parchis getParchis(){
		if(miParchis == null)
			miParchis = new Parchis();

		return miParchis;
	}//getParchis

	public Recorrido getRecorridoPrincipal() {
		return recorridoPrincipal;
	}

	public void setRecorridoPrincipal(Recorrido recorridoPrincipal) {
		this.recorridoPrincipal = recorridoPrincipal;
	}

	public Recorrido[] getRecorridoFinal() {
		return recorridoFinal;
	}

	public void setRecorridoFinal(Recorrido[] recorridoFinal) {
		this.recorridoFinal = recorridoFinal;
	}

	public void setNumJugadores(int num){
		num_jugadores = num;
	}//setJugadores

	public void setNumJugadoresPersona(int num){
		num_jugadores_persona = num;
	}//setJugadores

	public int getNumJugadores(){
		return num_jugadores;
	}//getNumJugadores

	public int getNum_jugadores_tablero() {
		return num_jugadores_tablero;
	}


}//class

