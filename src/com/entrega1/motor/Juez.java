package com.entrega1.motor;

public class Juez {
	
	/**
	 * En esta clase utilizamos el patron de construccion Singleton para que solo pueda haber una instancia de Juez
	 */
	
	private static Juez miJuez;
	
	private Juez(){};
	
	/**
	 * 
	 * @return miJuez
	 */
	public static Juez getJuez(){
		if(miJuez == null)
			miJuez = new Juez();
		
		return miJuez;
	}//getParchis
	
	/**
	 * Metodo que elige el siguiente jugador.
	 * @return num_jugador del siguiente turno
	 */
	public int elegirJugador(){
		return 0;//(int) (Math.random()*3);
	}//elegirJugador
	

}//class
