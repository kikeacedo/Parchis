package com.entrega1.motor;

/**
 * @author Enrique Acedo
 * @author Adrian Ojeda
 * @author Luis Miguel Garcia
 * @version 1.0
 * @date 27/10/2015
 *
 */

public class Dado {

	/**
	 * En esta clase utilizamos el patron de construccion Singleton para que solo pueda haber una instancia de Dado en la clase Juez
	 */
	
	/** DECLARACION DE ATRIBUTOS**/
	
	private static int num_caras;
	private static Dado miDado;
	
	
	/** DECLARACION DE METODOS**/
	private Dado(int caras){
		num_caras = caras;
	}//constructor
	
	/**
	 * 
	 * @return numero aleatorio entre 1 y num_caras
	 */
	public int tirarDado(){
		return (int) (Math.random()*num_caras+1);
	}//tirar dado
	
	
	/** GETTERS AND SETTERS **/
	public static Dado getDado(int caras){
		if(miDado == null)
			miDado = new Dado(caras);
		return miDado;
	}
	
	public static int getNumCaras(){
		return num_caras;
	}
	
}//class
