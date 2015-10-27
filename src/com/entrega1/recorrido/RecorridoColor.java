package com.entrega1.recorrido;

import com.entrega1.casilla.*;

public class RecorridoColor extends Recorrido{

	public void inicializarRecorrido(int casillaInicial) {
		casillas= new Casilla[8];
		for(int i = 0; i < 7; i++){
			casillas[i] = new CasillaPasillo(i + casillaInicial);
		}//for

		casillas[7] = new CasillaMeta(casillaInicial + 7);

	}//inicializarRecorrido

	@Override
	public boolean meterFicha(int num_jugador, int num_casilla) {
		return false;
	}

	@Override
	public boolean sacarFicha(int num_jugador, int num_casilla) {
		return false;
	}

}//class
