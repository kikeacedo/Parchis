package com.entrega1.jugador;

public class Jugador {


	/** ATRIBUTOS**/
	private Color color;
	private int[] fichas;

	private int casillaInicial;
	private int casillaFinal;



	/** METODOS**/
	public Jugador(Color color, int numJugador){
		this.color = color;
		fichas = new int[4];
	}//constructor
	
	
	/**
	 * Si NO HAY fichas en juego:
	 *  - comprueba que se pueda sacar ficha
	 *  - saca ficha
	 * Si HAY fichas en juego:
	 * 	- coge la ficha mas retrasada
	 * @param tirada (numero que ha sacado en el dado)
	 * @return TRUE si ha podido mover; FALSE en caso contrario
	 */
	public boolean moverFicha(int tirada){
		boolean movida = false;
		
		if(sacarFicha() && tirada == 5 && !movida){
			for(int i = 0; i < fichas.length && !movida; i++){
				if(fichas[i] == 0){
					fichas[i] = fichas[i] + casillaInicial;
					
					movida = true;
				}//if
			}//for
		}//if
		
		if(!movida && fichasEnTablero() > 0){
			int mejor_ficha = fichas[0];
			int pos_mejor_ficha = 0;

			for(int i = 0; i < fichas.length && !movida; i++){
				if(fichas[i] < mejor_ficha && fichas[i] + tirada <= casillaFinal){
					mejor_ficha = fichas[i];
					pos_mejor_ficha = i;
				}//if
			}//for
			
			if(fichas[pos_mejor_ficha] + tirada <= casillaFinal)
			fichas[pos_mejor_ficha] = fichas[pos_mejor_ficha] + tirada;
		}//if
		
		return movida;
	}//moverFicha
	
	
	/**
	 * Puede sacar ficha si hay alguna ficha en casa y no hay 2 fichas en la casilla de salida
	 * @return TRUE si puede sacar ficha. FALSE en caso contrario
	 */
	private boolean sacarFicha(){
		int num_fichas_casa = 0;
		int num_fichas_salida = 0;
		
		for(int i = 0; i <  this.fichas.length; i++){
			if( this.fichas[i] == 0)
				num_fichas_casa ++;
			if( this.fichas[i] == casillaInicial)
				num_fichas_salida++;
		}//for
		
		
		return num_fichas_casa > 0 && num_fichas_salida < 2;
	}//hayFichaEnCasa
	
	/**
	 * 
	 * @return numero de fichas en el tablero
	 */
	private int fichasEnTablero(){
		int fichas_aux = 0;
		
		for(int i = 0; i <  this.fichas.length; i++){
			if(fichas[i] >= casillaInicial)
				fichas_aux++;
		}//for
		
		return fichas_aux;
		
	}//fichasEnTablero
	

	/** GETTERS AND SETTERS **/
	public Color getColor() {
		return color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public int[] getFichas() {
		return fichas;
	}
	
	public void setFichas(int[] fichas) {
		this.fichas = fichas;
	}
	
	public int getCasillaInicial() {
		return casillaInicial;
	}
	
	public void setCasillaInicial( int casillaInicial) {
		this.casillaInicial = casillaInicial;
	}
	
	public  int getCasillaFinal() {
		return casillaFinal;
	}
	
	public void setCasillaFinal( int casillaFinal) {
		this.casillaFinal = casillaFinal;
	}
}//class
