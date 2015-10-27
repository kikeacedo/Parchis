package com.entrega1.jugador;

/**
 * En esta clase utilizamos el patron de comportamiento State. Cada jugador tendra un comportamiento dependiendo de su estado.
 * En esta primera entrega creamos solo un JugadorHumano que se controla mediante consola
 */

public abstract class Jugador {

	/** ATRIBUTOS**/
	protected Color color;
	protected int[] fichas;

	protected int casillaInicial;
	protected int casillaFinal;
	protected int turno;



	/** METODOS**/
	public Jugador(Color color, int numJugador){
		this.color = color;
		fichas = new int[4];
		turno = 0;
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
	public abstract boolean moverFicha(int tirada);
		


	/**
	 * Puede sacar ficha si hay alguna ficha en casa y no hay 2 fichas en la casilla de salida
	 * @return TRUE si puede sacar ficha. FALSE en caso contrario
	 */
	protected boolean sacarFicha(){
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
	protected int fichasEnTablero(){
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
