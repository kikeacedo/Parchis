package com.entrega1.motor;

import java.util.ArrayList;

import com.entrega1.jugador.Jugador;

public class Juez {

	/**
	 * En esta clase utilizamos el patron de construccion Singleton para que solo pueda haber una instancia de Juez
	 */

	private static Juez miJuez;
	private int turno_jugador;
	private int num_jugadores;
	private Dado dado;
	private ArrayList<Integer> ultimas_tiradas;
	private Parchis parchis;


	private Juez(int num_jugadores, int numeroCarasDado){
		this.num_jugadores = num_jugadores;
		turno_jugador = seleccionarPrimerJugador() - 1;
		dado = Dado.getDado(numeroCarasDado);
		ultimas_tiradas = new ArrayList<Integer>();
		parchis = Parchis.getParchis();
	}//Constructor

	/**
	 * Elige el primer jugador de la partida.
	 * @return el numero de jugador que empieza la partida
	 */
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
	 * Metodo que elige el siguiente jugador.
	 * Si hay una ultima tirada, no se cambia de jugador
	 * @return num_jugador del siguiente turno
	 */
	public int elegirJugador(){

		if(ultimas_tiradas.isEmpty())
			turno_jugador = (num_jugadores + turno_jugador + 1) % num_jugadores;

		return turno_jugador;
	}//elegirJugador

	public ArrayList<Integer> verOpciones(Jugador jugadorActual, int tiradaActual) {
		int[] fichas = jugadorActual.getFichas();
		ArrayList<Integer> opciones = new ArrayList<Integer>();

		// Si puede sacar ficha y ha sacado 5, saca ficha
		if(jugadorActual.sacarFicha() && tiradaActual == 5 ){
			for(int i = 0; i < fichas.length; i++){
				if(fichas[i] == 0){
					opciones.add(i);
				}//if
			}//for

			// Si no puede sacar ficha o la tirada es distinto de 5 mueve otra ficha
		}else if(opciones.isEmpty() && jugadorActual.fichasEnTablero() > 0){

			for(int i = 0; i < fichas.length ; i++){

				if(	fichas[i] >= jugadorActual.getCasillaInicial() && 
						fichas[i] + tiradaActual <= jugadorActual.getCasillaFinalColor() ){

					if(fichas[i]+tiradaActual <= jugadorActual.getCasillaFinal()){
						if(! parchis.getRecorridoPrincipal().getRecorrido()[fichas[i]+tiradaActual].estaLlena())
							opciones.add(i);
					}else if(fichas[i]+tiradaActual <= jugadorActual.getCasillaFinalColor()){
						if(! parchis.getRecorridoFinal()[jugadorActual.getId()].getRecorrido()[fichas[i] + tiradaActual - (parchis.getNum_jugadores_tablero()*17 +1)].estaLlena()
								&& fichas[i] + tiradaActual <= jugadorActual.getCasillaFinalColor())
							opciones.add(i);
					}//if-else
				}//if
			}//for
		}

		return opciones;
	}//verOpciones

	/**
	 * Tira el dado y si sale 6 y no hay fichas en casa, le suma 1.
	 * Si sale 6, mete la ultima tirada en una lista para ver que repita turno en la siguiente tirada
	 * @param jugadorActual
	 * @return numero que ha salido en el dado
	 */
	@SuppressWarnings("static-access")
	public int tira(Jugador jugadorActual) {
		int tirada = dado.tirarDado();	

		if(tirada == dado.getNumCaras()){
			if(jugadorActual.fichasEnCasa() == 0 )
				tirada++;

			ultimas_tiradas.add(6);
		}else{
			ultimas_tiradas.clear();
		}//if-else

		return tirada;
	}//tira

	/**
	 * 
	 * @return miJuez
	 */
	public static Juez getJuez(int num_jugadores, int numero_caras_dado){
		if(miJuez == null)
			miJuez = new Juez(num_jugadores, numero_caras_dado);

		return miJuez;
	}//getParchis



}//class
