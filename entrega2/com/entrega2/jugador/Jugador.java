package com.entrega2.jugador;

import com.entrega2.jugador.Color;
import com.entrega2.tablero.Dado;

/**
 * @author Enrique Acedo

 * @version 2.0
 * @date 10/1/2016
 *
 */

/**
 * En esta clase utilizamos el patron de comportamiento Strategy. Cada jugador tendra un comportamiento dependiendo de su estado.
 * En esta primera entrega creamos solo un JugadorHumano que se controla mediante consola
 */

public abstract class Jugador {

	/** ATRIBUTOS**/
	protected int id;
	protected Color color;
	protected int turno;
	protected String nombre;


	/** METODOS**/
	public abstract int seleccionarFicha();


	public Jugador(Color color2, int numJugador){
		this.color = color2;
		turno = 0;
		id = numJugador;
		//System.out.println("\tJugador "+color.name() + " ----> ID: "+ id);
	}//constructor

	/**
	 * Calcula la primera casilla de jugador
	 * @param jugador
	 * @return numero de la primera casilla
	 */
	public int primeraCasilla(Jugador jugador){		
		return 17*jugador.getId() + 5;
	}//primeraCasilla

	/**
	 * Calcula la ultima casilla de jugador
	 * @param jugador
	 * @return numero de la ultima casilla
	 */
	public int ultimaCasilla(Jugador jugador){		
		return (jugador.getId()==0) ? 68 : jugador.getId()*17;
	}//primeraCasilla

	/**
	 * Tira el dado
	 * @return puntuacion sacada
	 */
	public int tirarDado(){
		return 	Dado.tirarDado();
	}//tirarDado


	/** GETTERS AND SETTERS **/
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}


	public int getId() {
		return id;
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	public String getNombre(){
		return nombre;
	}

}//class
