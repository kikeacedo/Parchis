package com.entrega2.motor;

import java.util.ArrayList;
import com.entrega2.recorrido.RecorridoColor;
import com.entrega2.casilla.Casilla;
import com.entrega2.jugador.Jugador;
import com.entrega2.recorrido.*;

/**
 * @author Enrique Acedo
 * @version 2.0
 * @date 10/1/2016
 *
 */


public class Parchis {

	/** ATRIBUTOS */
	private static RecorridoGeneral recorrido_general;
	private static RecorridoColor recorrido_color;

	private static int[] fichas;

	/** METODOS */

	public Parchis(int numJugadores){
		recorrido_general = new RecorridoGeneral();
		recorrido_general.inicializarRecorrido(numJugadores);

		recorrido_color = new RecorridoColor();
		recorrido_color.inicializarRecorrido(69);

		iniciarFichas(numJugadores);
	}//constructor


	private void iniciarFichas(int numJugadores){

		fichas = new int[numJugadores*4];

		for(int i = 0; i < fichas.length; i++){
			fichas[i] = 0;
		}//for1

	}//iniciarFichas

	public int isTerminado(){
		boolean terminado = false;
		int ganador = -1;
		int[] casilla_final = recorrido_color.getCasillas()[7].getFichas();

		for(int i = 0; i < 4 && !terminado; i++){
			int cont = 0;
			for(int j = 0; j < casilla_final.length; j++){
				if(casilla_final[j] == i){
					cont++;
				}//if
			}//for2
			if(cont == 4){
				terminado = true;
				ganador = i;
			}//if
		}//for
		return ganador;
	}//isTerminado

	public boolean puedeMover(Jugador jugador, int ficha, int tirada){
		return verOpciones(jugador, tirada).contains(ficha);
	}//puedeMover

	public static int fichasEnJuego(Jugador jugador){
		int fichas_en_juego = 0;

		for(int i = 0; i < 4; i++){
			if(fichasJugador(jugador)[i] != 0){
				fichas_en_juego++;
			}//if
		}//for

		return fichas_en_juego;
	}//todasEnJuego

	public static int[] fichasJugador(Jugador jugador){
		int[] fichas_jugador = new int[4];

		for(int i = 0; i < 4; i++){
			fichas_jugador[i] = fichas[jugador.getId()*4 + i];
		}//for

		return fichas_jugador;
	}//fichasJugador

	public static boolean sacarFicha(Jugador jugador){
		boolean puede_sacar = true;

		if(fichasEnJuego(jugador) >= 4)
			puede_sacar = false;

		else{
			Casilla casilla_inicial =recorrido_general.getCasillas()[jugador.primeraCasilla(jugador)];

			if(casilla_inicial.estaLlena())
				puede_sacar = false;
		}//if-else

		return puede_sacar;
	}//sacarFicha

	public ArrayList<Integer> verOpciones(Jugador jugadorActual, int tiradaActual) {
		int[] fichas = fichasJugador(jugadorActual);
		ArrayList<Integer> opciones = new ArrayList<Integer>();

		// Si puede sacar ficha y ha sacado 5, saca ficha
		if(sacarFicha(jugadorActual) && tiradaActual == 5 ){
			for(int i = 0; i < fichas.length; i++){
				if(fichas[i] == 0){
					opciones.add(i);
				}//if
			}//for

			// Si no puede sacar ficha o la tirada es distinto de 5 mueve otra ficha
		}else if(opciones.isEmpty() && fichasEnJuego(jugadorActual) > 0){

			for(int i = 0; i < fichas.length ; i++){

				// Si la ficha no esta en casa
				if(	fichas[i] > 0 && fichas[i] < 69){
					boolean hayPuente = false;
					int casilla_nueva = fichas[i]+tiradaActual;
					if(casilla_nueva > 68)
						casilla_nueva -= 68;
					for(int j = fichas[i]+1; j <= casilla_nueva && !hayPuente; j++){
						if(recorrido_general.getCasillas()[j].estaLlena())
							hayPuente = true;
					}//for
					if(!hayPuente)
						opciones.add(i);
				}else if(fichas[i] + tiradaActual <= 76) 
						opciones.add(i);
			}//for
		}

		return opciones;
	}//verOpciones

	public int moverFicha(Jugador jugador, int ficha, int tirada){

		int suma = 0;

		int numero_casilla_actual = fichas[jugador.getId() * 4 + ficha];
		int numero_casilla_nueva = fichas[jugador.getId() * 4 + ficha] + tirada;

		if(numero_casilla_nueva > 68)
			numero_casilla_nueva -= 68;


		if(numero_casilla_actual == 0)
			numero_casilla_nueva = fichas[jugador.getId() * 4 + ficha] + jugador.primeraCasilla(jugador);


		if( numero_casilla_nueva == jugador.ultimaCasilla(jugador) + 1 ||
				numero_casilla_nueva == jugador.ultimaCasilla(jugador) + 2 ||
				numero_casilla_nueva == jugador.ultimaCasilla(jugador) + 3 ||
				numero_casilla_nueva == jugador.ultimaCasilla(jugador) + 4 ){

			numero_casilla_nueva = 68 + numero_casilla_nueva - jugador.ultimaCasilla(jugador);
			recorrido_general.getCasillas()[numero_casilla_actual].sacarFicha(jugador.getId());
			recorrido_color.getCasillas()[numero_casilla_nueva - 69].meterFicha(jugador.getId());
			fichas[jugador.getId() * 4 + ficha] = numero_casilla_nueva;

		}else{
			int ficha_comida = -1;

			Casilla casilla_nueva = recorrido_general.getCasillas()[numero_casilla_nueva];

			if(!casilla_nueva.estaLlena()){
				if(!casilla_nueva.estaVacia())
					ficha_comida = casilla_nueva.getFicha();

				// Realizo la operacion de sacar ficha y meterla en la nueva
				recorrido_general.getCasillas()[numero_casilla_actual].sacarFicha(jugador.getId());
				recorrido_general.getCasillas()[numero_casilla_nueva].meterFicha(jugador.getId());
				fichas[jugador.getId() * 4 + ficha] = numero_casilla_nueva;
			}//if1

			// Si he comido ficha
			if(ficha_comida > -1 && ficha_comida != jugador.getId() && casilla_nueva.tipoCasilla() == "Normal"){
				// Sumo 20
				suma += 20;

				// Mando la ficha a casa
				casilla_nueva.sacarFicha(ficha_comida);
				recorrido_general.getCasillas()[0].meterFicha(ficha_comida);
				fichas[numeroFicha(ficha_comida, numero_casilla_nueva)] = 0;
			}//if
		}//if-else

		return suma;
	}//moverFicha

	public static int numeroFicha(int id_jugador, int numero_casilla){
		int ficha = -1;

		for(int i = id_jugador * 4; i < ((id_jugador * 4) + 4) && ficha == -1; i++){
			if(fichas[i] == numero_casilla)
				ficha = i;
		}//for

		return ficha;
	}//numeroFicha

	/** GETTERS AND SETTERS */

	public Recorrido getRecorrido(){
		return recorrido_general;
	}
	
	public Recorrido getRecorridoColor(){
		return recorrido_color;
	}

	public int[] getFichas(){
		return fichas;
	}


}//class
