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

public class CasillaSeguro extends Casilla{

	public CasillaSeguro(int numeroCasilla) {
		super(numeroCasilla);
	}//Constructor

	public String tipoCasilla() {
		return "Seguro";
	}

}//class
