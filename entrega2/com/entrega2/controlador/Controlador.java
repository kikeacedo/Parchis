package com.entrega2.controlador;

import java.util.ArrayList;

import com.entrega2.jugador.Jugador;
import com.entrega2.motor.Parchis;
import com.entrega2.tablero.Ficha;
import com.entrega2.tablero.Tablero;

/**
 * @author Enrique Acedo
 * @version 2.0
 * @date 10/1/2016
 *
 */

public class Controlador {

	private static Parchis parchis;
	private ArrayList<Jugador> jugadores;
	private static int turno = 0;
	private static ArrayList<Integer> tiradas;

	public Controlador(ArrayList<Jugador> jugadores){
		this.jugadores = jugadores;
		parchis = new Parchis(jugadores.size());
		tiradas = new ArrayList<Integer>();
	}//constructor

	public void empezar(){
		//		while(!parchis.isTerminado()){
		Jugador jugador = gestionarTurnos();
		
		Tablero.mostrar();

		boolean puedeMover = false;
		int intentos = 0;
		while(!puedeMover && intentos < 5){
			int ficha_a_mover = Tablero.cogerFicha(jugador);

			if(parchis.puedeMover(jugador, ficha_a_mover)){
				moverFicha(jugador, ficha_a_mover);
				puedeMover = true;
			}else{
				intentos++;
				System.out.println("Esa ficha no se puede mover, elige otra por favor");
			}//if-else
		}//while
		//		}//while		
		
		
	}//empezar

	/**
	 * Se coge el siguiente jugador, y tira el dado. En funcion de lo que saque, pasa turno
	 * o repite turno
	 * @return jugador que tiene el turno
	 */
	public Jugador gestionarTurnos(){
		Jugador jugador = jugadores.get(turno);

		int tirada = jugador.tirarDado();
		
		if(tirada == 6 && parchis.todasEnJuego(jugador))
			tirada = 7;
		
		tiradas.add(tirada);
		
		if((tirada != 6 && tirada != 7) || tiradas.size() == 3){
			tiradas.clear();
			turno++;
		}//if
		
		if(turno >= 4)
			turno = 0;
		
		return jugador;
	}//gestionarTurnos


	public boolean moverFicha(Jugador jugador, int ficha){


		return true;
	}//moverFicha

	public boolean notificarMovimiento(Jugador jugador, Ficha ficha, int tirada){


		return true;
	}//notificarMovimiento


	public String getTipoCasilla(int casilla,int id_jugador){
		String tipoCasilla = "";

		if(casilla == 76)
			tipoCasilla = "META!!";
		else if(5+(id_jugador*17) == casilla)
			tipoCasilla = "Salida";
		else
			if(casilla<17*4 ){
				tipoCasilla = parchis.getRecorrido().getCasillas()[casilla].tipoCasilla();
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


	/** GETTERS AND SETTERS */
	public Parchis getParchis(){
		return parchis;
	}//getParchis

	public int getTurno(){
		return turno;
	}//getTurno

	public int getUltimaTirada(){
		return tiradas.get(tiradas.size()-1);
	}//getUltimaTirada

}//class
