package com.entrega1.recorrido;

import com.entrega1.casilla.Casilla;

public abstract class Recorrido {

	/** DECLARACION DE ATRIBUTOS**/
	protected Casilla[] casillas;
	
	/** DECLARACION DE METODOS**/
	 public Casilla[] getRecorrido(){
		 return casillas;
	 }//getRecorrido
	 
	 public abstract void inicializarRecorrido(int numJugadores);

	
}//class
