package com.entrega1.jugador;

public enum Color {
	
	Rojo, Azul, Amarillo, Verde;
	
	
	public static Color getColor(int i){
		return Color.values()[i];
	}

}//class
