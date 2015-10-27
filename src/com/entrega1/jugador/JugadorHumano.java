package com.entrega1.jugador;

import com.entrega1.motor.Dado;
import com.entrega1.motor.Parchis;

/**
 * En esta clase utilizamos el patron de comportamiento State. Cada jugador tendra un comportamiento dependiendo de su estado.
 * En esta primera entrega creamos solo un JugadorHumano que se controla mediante consola
 */

public class JugadorHumano extends Jugador{
	
	public JugadorHumano(Color color, int numJugador) {
		super(color, numJugador);
	}//Constructor

	/**
	 * Si NO HAY fichas en juego:
	 *  - comprueba que se pueda sacar ficha
	 *  - saca ficha
	 * Si HAY fichas en juego:
	 * 	- coge la ficha mas retrasada
	 * @param tirada (numero que ha sacado en el dado)
	 * @return TRUE si ha podido mover; FALSE en caso contrario
	 */
	public boolean moverFicha(int tirada){
		turno++;

		boolean movida = false;


		// Si no tiene fichas en casa y ha sacado 6, mueve 7
		if(fichasEnTablero() == 4 && tirada == Dado.getNumCaras())
			tirada = 7;

		System.out.println("Turno "+ turno + " - tirada: " + tirada +"\n");

		// Si puede sacar ficha y ha sacado 5, saca ficha
		if(sacarFicha() && tirada == 5 && !movida){
			for(int i = 0; i < fichas.length && !movida; i++){
				if(fichas[i] == 0){
					fichas[i] = fichas[i] + casillaInicial;
					System.out.println("\tFicha "+ i + " sacada de casa\n");
					movida = true;
				}//if
			}//for

			// Si no puede sacar ficha o la tirada es distinto de 5 mueve otra ficha
		}else if(!movida && fichasEnTablero() > 0){

			for(int i = 0; i < fichas.length && !movida; i++){
				
				if(fichas[i] >= casillaInicial && fichas[i] + tirada <= casillaFinal){
					System.out.println("- Ficha " + i + " de casilla: " + fichas[i] + " a: " + (fichas[i] + tirada));
				}//if
			}//for


			boolean leyendo = true;
			while(leyendo){
				int eleccion = Parchis.entrada.nextInt();

				try{
					if(fichas[eleccion] == 0)
						throw new Exception();
					
					if(fichas[eleccion] + tirada <= casillaFinal){
						fichas[eleccion] = fichas[eleccion] + tirada;
						movida=true;
						leyendo = false;
						System.out.println("\t- Ficha " + eleccion + " movida a casilla: " + fichas[eleccion] +"\n");
					}//if
				}catch(Exception e){
					System.out.println("Ficha incorrecta, elige otra");
				}//try
			}//while
		}//if-else

		return movida;
	}//moverFicha


}
