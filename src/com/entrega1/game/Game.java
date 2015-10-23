package com.entrega1.game;

import com.entrega1.motor.Parchis;

public class Game {

	public static void main(String[] args) {
	
		Parchis parchis = Parchis.getParchis();
		
		parchis.setJugadores(1);
		parchis.iniciarRecorrido();
		parchis.iniciarJugadores();
		
		parchis.start();
		
		parchis.imprimirSituacion();

	}//main
}//class
