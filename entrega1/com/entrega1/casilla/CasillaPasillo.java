package com.entrega1.casilla;

import com.entrega1.casilla.Casilla;

/**
 * @author Enrique Acedo

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

public class CasillaPasillo extends Casilla{

	public CasillaPasillo(int numeroCasilla) {
		super(numeroCasilla);
		fichas = new int[16];
		for(int i = 0; i < fichas.length; i++)
			fichas[i] = -1;
	}//Constructor

	public String tipoCasilla() {
		return "Pasillo";
	}
	


}//class
