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
		Jugador jugador = null;
		int ganador = -1;
		while((ganador =parchis.isTerminado()) < 0){
			// Cojo el jugador
			jugador = gestionarTurnos();

			// Tira y si es 6 y todas estan fuera, se suma 1
			int tirada = jugador.tirarDado();

			if(tirada == 6 && Parchis.fichasEnJuego(jugador) == 4)
				tirada = 7;

			// Guardo la tirada
			tiradas.add(tirada);

			// Muestro estado de tablero
			Tablero.mostrar();

			// Cojo eleccion del jugador y muevo ficha o paso turno si no puede
			boolean puedeMover = false;
			int intentos = 0;
			boolean pasa = false;
			while(!puedeMover && intentos < 5 && !pasa) {
				int ficha_a_mover = Tablero.cogerFicha(jugador);
				if(ficha_a_mover > 4)
					pasa = true;

				if(!pasa){
					if(parchis.puedeMover(jugador, ficha_a_mover, tirada)){
						parchis.moverFicha(jugador, ficha_a_mover, tirada);
						puedeMover = true;
					}else{
						intentos++;
						System.out.println("Esa ficha no se puede mover, elige otra por favor");
						if(intentos == 5)
							System.out.println("NO PUEDES MOVER, PIERDES TURNO");
					}//if-else
				}else{
					System.out.println("Jugador " + jugador.getColor().name() + " ha pasado");
				}//if-else
			}//while
		}//while		

		System.out.println("ENHORABUENA JUGADOR " + jugadores.get(ganador).getColor().name());
	}//empezar

	/**
	 * Se coge el siguiente jugador, y tira el dado. En funcion de lo que saque, pasa turno
	 * o repite turno
	 * @return jugador que tiene el turno
	 */
	public Jugador gestionarTurnos(){

		if(!tiradas.isEmpty()){
			int ultima_tirada = tiradas.get(tiradas.size()-1);

			if((ultima_tirada != 6 && ultima_tirada != 7) || tiradas.size() == 3){
				tiradas.clear();
				turno++;
			}//if

			if(turno >= 4)
				turno = 0;

		}//if

		Jugador jugador = jugadores.get(turno);

		return jugador;
	}//gestionarTurnos



	public boolean notificarMovimiento(Jugador jugador, Ficha ficha, int tirada){


		return true;
	}//notificarMovimiento


	public static String getTipoCasilla(int casilla,int id_jugador){
		String tipoCasilla = "";

		if(casilla == 76)
			tipoCasilla = "META!!";
		else 
			try{
				tipoCasilla = parchis.getRecorrido().getCasillas()[casilla].tipoCasilla();
			}catch(ArrayIndexOutOfBoundsException e){
				tipoCasilla = parchis.getRecorridoColor().getCasillas()[casilla-69].tipoCasilla();

			}//try-catch

		if(tipoCasilla != "Casa"  && tipoCasilla != "META!!"){
			if(tipoCasilla == "Casilla Pasillo")
				tipoCasilla += "_"+(casilla-(4*17));
			else if(tipoCasilla == "Salida"){
				tipoCasilla += " " + parchis.getRecorrido().getColor(casilla);
			}else
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
