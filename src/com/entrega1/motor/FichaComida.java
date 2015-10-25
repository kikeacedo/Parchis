package com.entrega1.motor;

public class FichaComida extends Exception {
	
	private static final long serialVersionUID = 3487996695973612004L;
	
	
	Parchis parchis = Parchis.getParchis();

	public FichaComida(int numeroCasilla, int jugador) {
		parchis.mandarFichaCasa(numeroCasilla, jugador);
	}//constructor

}//clase
