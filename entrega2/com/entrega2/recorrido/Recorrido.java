package com.entrega2.recorrido;

import com.entrega2.casilla.Casilla;

/**
 * @author Enrique Acedo
 * @version 2.0
 * @date 10/1/2016
 *
 */

/**
 * En esta clase utilizamos el patron Abstract Factory.
 * 
 * Por una parte el RecorridoGeneral tendra CasillaCasa, CasillaSalida, CasillaNormal y CasillaSeguro
 * Por otra parte el RecorridoColor tendra CasillaPasillo y CasillaMeta
 * 
 * Todas las casillas serán del tipo casilla y cuando inicialicemos los recorridos iremos metiendo casillas sin 
 * tener que saber de que tipo es cada una
 */
public abstract class Recorrido {

	/** ATRIBUTOS**/
	protected Casilla[] casillas;
	
	/** METODOS**/
	 public Casilla[] getCasillas(){
		 return casillas;
	 }//getRecorrido
	 
	 public abstract void inicializarRecorrido(int numJugadores);
	 
	 /**
	  * Devuelve el color de la casilla segun el numero
	  * @param numero_casilla
	  * @return Color
	  */
	 public String getColor(int numero_casilla){
			String color;
			
			if(numero_casilla > 8 && numero_casilla < 26)
				color = "Azul";
			else if(numero_casilla > 25 && numero_casilla < 43)
				color = "Rojo";
			else if(numero_casilla > 42 && numero_casilla < 60)
				color = "Verde";
			else
				color = "Amarillo";
			return color;	
		}//getColor

	
}//class
