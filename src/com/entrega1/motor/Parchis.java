package com.entrega1.motor;

import com.entrega1.casilla.*;
import com.entrega1.jugador.*;
import com.entrega1.recorrido.*;

public class Parchis {
	/** ATRIBUTOS **/
	
	private static Jugador[] jugadores;
	private static Recorrido recorridoPrincipal;
	private static Recorrido recorridoFinal;
	private static int num_jugadores;
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
		@SuppressWarnings("unused")
		Jugador jugadorActual;
		
		
		while(!juegoTerminado){
			// El juez elige jugador
			jugadorActual = jugadores[juez.elegirJugador()];
			
			// El jugador mueve ficha con el resultado de tirar dado
			jugadorActual.moverFicha(dado.tirarDado());
			
			
		}//whilePrincipal
	}//
	
	/**
	 * Metodo que crea los jugadores y sus fichas y las inicializa
	 */
	public void iniciarJugadores(){
		jugadores = new Jugador[num_jugadores];
		Casilla[] fichas_inicial ={recorridoPrincipal.getRecorrido()[0],
									recorridoPrincipal.getRecorrido()[0],
									recorridoPrincipal.getRecorrido()[0],
									recorridoPrincipal.getRecorrido()[0]};

		for(int i = 0; i < num_jugadores; i++){
			jugadores[i] = new Jugador(Color.getColor(i), i);
			jugadores[i].setCasillaInicial(recorridoPrincipal.getRecorrido()[i*17+5]);
			jugadores[i].setFichas(fichas_inicial);
		}//for
	}//iniciarJugadores
	
	/**
	 * Metodo que crea el recorrido general y el recorrido de color y los inicializa
	 */
	public void iniciarRecorrido(){
		recorridoPrincipal = new RecorridoGeneral();
		recorridoFinal= new RecorridoColor();

		recorridoPrincipal.inicializarRecorrido(num_jugadores);
		recorridoFinal.inicializarRecorrido(num_jugadores);
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
			Casilla[] casillas = jugadores[i].getFichas();
			
			for(int j = 1; j <= casillas.length; j++)
				System.out.println("Jugador " + i + ", ficha " + j + " esta en: "+ casillas[j-1].getNumeroCasilla());
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

