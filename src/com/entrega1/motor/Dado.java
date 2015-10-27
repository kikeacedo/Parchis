package com.entrega1.motor;

public class Dado {

	/**
	 * En esta clase utilizamos el patron de construccion Singleton para que solo pueda haber una instancia de Dado
	 */
	
	/** DECLARACION DE ATRIBUTOS**/
	
	private static int num_caras;
	private static Dado miDado;
	
	/** DECLARACION DE METODOS**/
	
	private Dado(int caras){
		num_caras = caras;
	}//constructor
	
	public int tirarDado(){
		return (int) (Math.random()*num_caras+1);
	}//tirar dado
	
	public static Dado getDado(int caras){
		if(miDado == null)
			miDado = new Dado(caras);
		return miDado;
	}
	
	public static int getNumCaras(){
		return num_caras;
	}
	
}//class
