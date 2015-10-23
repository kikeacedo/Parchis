package com.entrega1.motor;

import com.entrega1.jugador.*;
import com.entrega1.recorrido.*;

public class Parchis {
	/** ATRIBUTOS **/
	
	private static Jugador[] jugadores;
	private static Recorrido recorridoPrincipal;
	private static Recorrido recorridoFinal;
	private static int num_jugadores;
	private static final int num_jugadores_tablero = 4;
	private static Juez juez;
	private static  Dado dado;
	private static Parchis miParchis;
	private static final int numeroCarasDado = 6;
	private static boolean juegoTerminado = false;
	
	/**
	 * En esta clase utilizamos el patron de construccion Singleton para que solo pueda haber una instancia de Parchis
	 */
	
	
	/** METODOS **/
	
	private Parchis(){}//constructor
	
	/**
	 * Metodo para empezar el juego
	 */
	public void start(){
		// Creamos un juez y un dado para este juego 
		juez = Juez.getJuez();
		dado = Dado.getDado(numeroCarasDado);
	
		// Creamos una variable jugadorActual que es el jugador que jugara cada turno;
		Jugador jugadorActual;
		
		
		while(!juegoTerminado){
			// El juez elige jugador
			jugadorActual = jugadores[juez.elegirJugador()];
			
			// El jugador mueve ficha con el resultado de tirar dado
			jugadorActual.moverFicha(dado.tirarDado());
			
			imprimirSituacion();
		}//whilePrincipal
	}//
	
	/**
	 * Metodo que crea los jugadores y sus fichas y las inicializa
	 */
	public void iniciarJugadores(){
		jugadores = new Jugador[num_jugadores];
		int[] fichas_inicial ={0,0,0,0};

		for(int i = 0; i < num_jugadores; i++){
			jugadores[i] = new Jugador(Color.getColor(i), i);
			jugadores[i].setCasillaInicial(i*17+5);
			jugadores[i].setFichas(fichas_inicial);
//			System.out.println("jugador " + i + " casilla inicial " + jugadores[i].getCasillaInicial());
		}//for
	}//iniciarJugadores
	
	/**
	 * Metodo que crea el recorrido general y el recorrido de color y los inicializa
	 */
	public void iniciarRecorrido(){
		recorridoPrincipal = new RecorridoGeneral();
		recorridoFinal= new RecorridoColor();

		recorridoPrincipal.inicializarRecorrido(num_jugadores_tablero);
		recorridoFinal.inicializarRecorrido(num_jugadores_tablero);
	}//iniciarRecorrido
	
	/**
	 * Establece el numero de jugadores de la partida.
	 * @param num Numero de jugadores
	 */
	public void setJugadores(int num){
		num_jugadores = num;
	}//setJugadores
	
	/**
	 * 
	 * @return numero de jugadores
	 */
	public int getNumJugadores(){
		return num_jugadores;
	}//getNumJugadores
	
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

	
	/**
	 * 
	 * @return miParchis
	 */
	public static Parchis getParchis(){
		if(miParchis == null)
			miParchis = new Parchis();
		
		return miParchis;
	}//getParchis

}//class

