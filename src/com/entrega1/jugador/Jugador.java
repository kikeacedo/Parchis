package com.entrega1.jugador;

import com.entrega1.casilla.Casilla;

public class Jugador {


	/** ATRIBUTOS**/
	private Color color;
	private Casilla[] fichas;

	private Casilla casillaInicial;
	private Casilla casillaFinal;



	/** METODOS**/
	public Jugador(Color color, int numJugador){
		this.color = color;
		fichas = new Casilla[4];
	}//constructor
	
	public boolean moverFicha(int tirada){
		
		
		return true;
	}//moverFicha
	
	

	/** GETTERS AND SETTERS **/
	public Color getColor() {
		return color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public Casilla[] getFichas() {
		return fichas;
	}
	
	public void setFichas(Casilla[] fichas) {
		this.fichas = fichas;
	}
	
	public Casilla getCasillaInicial() {
		return casillaInicial;
	}
	
	public void setCasillaInicial(Casilla casillaInicial) {
		this.casillaInicial = casillaInicial;
	}
	
	public Casilla getCasillaFinal() {
		return casillaFinal;
	}
	
	public void setCasillaFinal(Casilla casillaFinal) {
		this.casillaFinal = casillaFinal;
	}
}//class
