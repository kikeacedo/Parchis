package com.entrega1.jugador;

import java.util.ArrayList;

import com.entrega1.motor.Juez;
import com.entrega1.motor.Parchis;
import com.entrega1.jugador.Color;
import com.entrega1.jugador.Jugador;
import com.entrega1.jugador.TraduccionMovimiento;

/**
 * @author Enrique Acedo

 * @version 1.0
 * @date 27/10/2015
 *
 */

/**
 * En esta clase utilizamos el patron de comportamiento Strategy. Cada jugador tendra un comportamiento dependiendo de su estado.
 * En esta clase creamos un JugadorHumano que se controla mediante consola
 */

public class JugadorPersona extends Jugador{
	
	/** METODOS **/
	public JugadorPersona(Color color, int numJugador) {
		super(color, numJugador);
	}//Constructor

	/**
	 * Metodo que mueve la ficha N casillas
	 */
	public void moverFicha(int numero_ficha, int tirada){
		
		fichas[numero_ficha] = fichas[numero_ficha] + tirada;
		// Si mete en meta la ficha, pone la variable a true;
		if(fichas[numero_ficha] == casillaFinalColor)
			Juez.setMeteFichaEnCasa(true);
		
		System.out.println("\tFicha " + numero_ficha + " movida a " + TraduccionMovimiento.getTipoCasilla(fichas[numero_ficha], id));
		System.out.println("-----------------------------------");

	}//moverFicha

	/**
	 * Muestra por pantalla las opciones que hay
	 * Devuelve la ficha que ha elegido el usuario
	 * @param fichas_posibles array de fichas que puede mover en este turno
	 * @param tirada (numero que ha sacado en el dado)
	 * @return numero de ficha que ha seleccionado
	 */
	public int seleccionarFicha(ArrayList<Integer> fichas_posibles, int tirada) {
		turno ++;
		int ficha = -1;

		TraduccionMovimiento.traducirMovimientos(fichas_posibles, fichas, tirada, color, id);

		boolean leyendo = true;
		while(leyendo){
			ficha = Parchis.entrada.nextInt();

			try{
				boolean elige_bien = false;
				for(int i = 0; i < fichas_posibles.size() && !elige_bien;i++){
					if(ficha == fichas_posibles.get(i))
						elige_bien = true;
				}//
				if(!elige_bien)
					throw new Exception();
				else
					leyendo = false;
			}catch(Exception e){
				System.out.println("Ficha incorrecta, elige otra");
			}//try
		}//while
		
		return ficha;
	}//moverFicha


}//class
