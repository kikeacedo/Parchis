package com.entrega1.jugador;

import java.util.ArrayList;

import com.entrega1.motor.Parchis;
import com.entrega1.jugador.Color;

/**
 * @author Enrique Acedo
 * @version 1.0
 * @date 17/11/2015
 *
 */

/**
 * En esta clase utilizamos el patron de comportamiento Fachada. Cada jugador la utilizara a la hora de mostrar las fichas
 * por pantalla para que se muestre de una manera mas entendible
 * 
 * Ademas estamos refactorizando el codigo pues coge codigo de distintas clases que hacian lo mismo y lo pone en una directamente
 */
public class TraduccionMovimiento {

	/**
	 * 
	 * @param fichas_posibles
	 * @param fichas
	 * @param tirada
	 */
	public static void traducirMovimientos(ArrayList<Integer> fichas_posibles, int[] fichas, int tirada, Color color_jugador, int id_jugador){
		System.out.println("_____________ MOVIMIENTOS _____________");

		for(int i = 0; i < fichas_posibles.size() ;i++){
			System.out.println("- Ficha " + color_jugador.toString() +"_"+ (fichas_posibles.get(i))
					+ " de casilla: " + getTipoCasilla(fichas[fichas_posibles.get(i)], id_jugador)
					+ " a: " + getTipoCasilla((fichas[fichas_posibles.get(i)] + tirada), id_jugador));
		}//for
		System.out.println("_______________________________________");

	}//traducirMovimientos

	public static String getTipoCasilla(int casilla,int id_jugador){
		String tipoCasilla = "";
		Parchis parchis = Parchis.getParchis();

		if(casilla == 76)
			tipoCasilla = "META!!";
		else if(5+(id_jugador*17) == casilla)
			tipoCasilla = "Salida";
		else
			if((parchis.getNumJugadores()>=4)? casilla < parchis.getNumJugadores()*17 : casilla<17*4 ){
				tipoCasilla = Parchis.getParchis().getRecorridoPrincipal().getRecorrido()[casilla].tipoCasilla();
			}else{
				tipoCasilla = "Casilla Pasillo";
			}//if-else

		if(tipoCasilla != "Casa" && tipoCasilla != "Salida" && tipoCasilla != "META!!"){
			if(tipoCasilla == "Casilla Pasillo")
				tipoCasilla += "_"+(casilla-(4*17));
			else
				tipoCasilla += "_"+casilla;
		}

		return tipoCasilla;
	}//getTipoCasilla

}//class
