package com.entrega1.casilla;

/**
 * @author Enrique Acedo
 * @author Adrian Ojeda
 * @author Luis Miguel Garcia
 * @version 1.0
 * @date 27/10/2015
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

public class CasillaSalida extends Casilla{

	public CasillaSalida(int numeroCasilla) {
		super(numeroCasilla);
	}//Constructor

}//class
