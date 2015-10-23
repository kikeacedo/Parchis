package com.entrega1.motor;

public class Dado {

	
	/** DECLARACION DE ATRIBUTOS**/
	
	private final int num_caras;
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
	
}//class
