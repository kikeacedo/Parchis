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
	
	public boolean moverFicha(int tirada){
		boolean movida = false;
		
		if(sacarFicha() && tirada == 5 && !movida){
			for(int i = 0; i < this.fichas.length && !movida; i++){
				if(this.fichas[i] == 0){
					this.fichas[i] = casillaInicial;
					movida = true;
				}//if
			}//for
		}//if
		
		if(!movida){
			int pos_mejor_ficha = 0;
			int mejor_ficha = fichas[0];
			System.out.println(fichas[0] +" " + fichas[3]);
			for(int i = 1; i < this.fichas.length && !movida; i++){
				if(this.fichas[i] < pos_mejor_ficha){
					mejor_ficha = fichas[i];
					pos_mejor_ficha = i;
				}//if
			}//for
			
			fichas[pos_mejor_ficha] = fichas[pos_mejor_ficha] + tirada;
			
			
		}//if
		
		return movida;
	}//moverFicha
	
	public boolean sacarFicha(){
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
