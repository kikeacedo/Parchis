package com.entrega2.casilla;

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

public class CasillaMeta extends Casilla{

	public CasillaMeta(int numeroCasilla) {
		super(numeroCasilla);
		fichas = new int[4];
		this.numeroCasilla = numeroCasilla;
	}//Constructor
	
	
	/**
	 * @return FALSE si hay menos de 2 fichas
	 * 		   TRUE si esta llena
	 */
	public boolean estaLlena(){
		return num_fichas == 4;
	}//estaVacia


	public String tipoCasilla() {
		return "Meta";
	}

}//class
