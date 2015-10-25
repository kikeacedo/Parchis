package com.entrega1.recorrido;

import com.entrega1.casilla.*;
import com.entrega1.jugador.Jugador;
import com.entrega1.motor.FichaComida;

public class RecorridoGeneral extends Recorrido{

	public void inicializarRecorrido(int numJugadores) {
		casillas = new Casilla[numJugadores*17 + 1];

		casillas[0] = new CasillaCasa(0);

		for(int i = 0; i < numJugadores; i++){
			for(int j = 1; j <= 17;  j++){
				switch (j) {
				case 4:
					casillas[i*17 + j] = new CasillaSalida(i*17 + j);
					break;

				case 11:
				case 16:
					casillas[i*17 + j] = new CasillaSeguro(i*17 + j);
					break;

				default:
					casillas[i*17 + j] = new CasillaNormal(i*17 + j);
					break;
				}
			}//for j

		}//for i
	}//inicializarRecorrido


	public boolean meterFicha(int num_jugador, int num_casilla) throws FichaComida {
		boolean metida = false;
		Casilla casilla = casillas[num_casilla];
		if(!casilla.estaLlena()){
			//Meto esta ficha
			casilla.meterFicha(num_jugador);
			metida = true;

		}//if

		return metida;
	}

	@Override
	public boolean sacarFicha(int num_jugador, int num_casilla) {
		return casillas[num_casilla].sacarFicha(num_jugador);
	}

}//class
