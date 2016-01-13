package com.entrega2.recorrido;

import com.entrega2.casilla.*;

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

public class RecorridoColor extends Recorrido{

	/**
	 * Crea el recorrido para cada color teniendo en cuenta que su casilla
	 * inicial es la siguiente a la casilla final del recorrido normal 
	 * Tendran 7 CasillaPasillo y 1 CasillaMeta
	 */
	public void inicializarRecorrido(int casillaInicial) {
		casillas= new Casilla[8];
		for(int i = 0; i < 7; i++){
			casillas[i] = new CasillaPasillo(i + casillaInicial);
		}//for

		casillas[7] = new CasillaMeta(casillaInicial + 7);

	}//inicializarRecorrido

}//class
