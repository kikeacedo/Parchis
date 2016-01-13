package com.entrega2.tablero;


/**
 * @author Enrique Acedo
 * @version 2.0
 * @date 10/1/2016
 *
 */

public class Dado {

	/**
	 * En esta clase utilizamos el patron de construccion Singleton para que solo pueda haber una instancia de Dado en la clase Juez
	 */
	
	/** DECLARACION DE ATRIBUTOS**/
	
	private static int NUM_CARAS = 6;
	private static Dado miDado;
	
	
	/** DECLARACION DE METODOS**/
	private Dado(int caras){
		NUM_CARAS = caras;
	}//constructor
	
	/**
	 * 
	 * @return numero aleatorio entre 1 y num_caras
	 */
	public static int tirarDado(){
		return (int) (Math.random()*NUM_CARAS+1);
	}//tirar dado
	
	
	/** GETTERS AND SETTERS **/
	public static Dado getDado(int caras){
		if(miDado == null)
			miDado = new Dado(caras);
		return miDado;
	}
	
	public static int getNumCaras(){
		return NUM_CARAS;
	}
	
}//class
