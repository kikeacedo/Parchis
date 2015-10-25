package com.entrega1.recorrido;

import com.entrega1.casilla.Casilla;
import com.entrega1.motor.FichaComida;

public abstract class Recorrido {

	/** DECLARACION DE ATRIBUTOS**/
	protected Casilla[] casillas;
	
	/** DECLARACION DE METODOS**/
	 public Casilla[] getRecorrido(){
		 return casillas;
	 }//getRecorrido
	 
	 public abstract void inicializarRecorrido(int numJugadores);
	 
	 public abstract boolean meterFicha(int num_jugador, int num_casilla) throws FichaComida;
	 public abstract boolean sacarFicha(int num_jugador, int num_casilla);

	
}//class
