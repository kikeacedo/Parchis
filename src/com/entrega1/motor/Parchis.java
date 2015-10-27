package com.entrega1.motor;

import java.util.Scanner;

import com.entrega1.jugador.*;
import com.entrega1.recorrido.*;

/**
 * En esta clase utilizamos el patron de construccion Singleton para que solo pueda haber una instancia de Parchis
 */
public class Parchis {
	/** ATRIBUTOS **/
	
	private Jugador[] jugadores;
	private Recorrido recorridoPrincipal;
	private Recorrido recorridoFinal;
	private int num_jugadores;
	private final int num_jugadores_tablero = 4;
	private Juez juez;
	private Dado dado;
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
		juez = Juez.getJuez(num_jugadores);
		dado = Dado.getDado(numeroCarasDado);
	
		// Creamos una variable jugadorActual que es el jugador que jugara cada turno;
		Jugador jugadorActual;
		
		
		while(!juegoTerminado){
			// El juez elige jugador
			jugadorActual = jugadores[juez.elegirJugador()];
			
			// El jugador mueve ficha con el resultado de tirar dado
			
			jugadorActual.moverFicha(dado.tirarDado());
			
			//imprimirSituacion();
		}//whilePrincipal
	}//
	
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

		for(int i = 0; i < num_jugadores; i++){
			int[] fichas_inicial ={0,0,0,0};
			jugadores[i] = new JugadorHumano(Color.getColor(i), i);
			jugadores[i].setCasillaInicial(17*i + 5);
			jugadores[i].setCasillaFinal((i==0)?68:i*17);
			jugadores[i].setFichas(fichas_inicial);
			
//			System.out.println("jugador " + i + " casilla inicial " + jugadores[i].getCasillaInicial()+ " casilla final " + jugadores[i].getCasillaFinal());
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
	public void setNumJugadores(int num){
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

