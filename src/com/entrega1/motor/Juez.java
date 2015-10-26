package com.entrega1.motor;

public class Juez {

	/**
	 * En esta clase utilizamos el patron de construccion Singleton para que solo pueda haber una instancia de Juez
	 */

	private static Juez miJuez;
	private int turno_jugador;
	private int num_jugadores;

	private Juez(int num_jugadores){
		this.num_jugadores = num_jugadores;
		turno_jugador = seleccionarPrimerJugador();
	}//Constructor

	private int seleccionarPrimerJugador() {
		//Cada jugador tira el dado y el que mas saque empieza

		int mejor_tirada = 0;
		int mejor_jugador = 0;
		int tirada_i;
		for(int i =  0; i < num_jugadores; i++){
			tirada_i= Dado.getDado(6).tirarDado();
			if(tirada_i > mejor_tirada){
				mejor_tirada = tirada_i;
				mejor_jugador = i;
			}else if(tirada_i == mejor_tirada){
				int aux_1 = tirada_i;
				int aux_2 = mejor_tirada;
				while(aux_1 == aux_2){
					aux_1 = Dado.getDado(6).tirarDado();
					aux_2 = Dado.getDado(6).tirarDado();
				}//while
					if(aux_1 > aux_2){
						mejor_tirada = tirada_i;
						mejor_jugador = i;
					}//if
			}//if-else
		}//for

		return mejor_jugador;
	}//seleccionarPrimerJugador

	/**
	 * 
	 * @return miJuez
	 */
	public static Juez getJuez(int num_jugadores){
		if(miJuez == null)
			miJuez = new Juez(num_jugadores);

		return miJuez;
	}//getParchis

	/**
	 * Metodo que elige el siguiente jugador.
	 * @return num_jugador del siguiente turno
	 */
	public int elegirJugador(){
		int proximo_jugador = turno_jugador;
		
		turno_jugador = (num_jugadores + turno_jugador + 1) % num_jugadores;
		return proximo_jugador;//(int) (Math.random()*3);
	}//elegirJugador


}//class
