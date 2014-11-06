package impl;

import TDA.MatrizTDA;

public class NuevaMatriz<E> implements MatrizTDA<E>{
	private E[][] matriz;
	
	@Override
	public void inicializarMatriz(int arg0){
		matriz = new E[arg0][arg0];
	}

	@Override
	public int obtenerDimension() {
		return matriz.length;
	}
	
	@Override
	public E obtenerValor(int arg0, int arg1) {
		return matriz[arg0][arg1];
	}
	
	@Override
	public void setearValor(int arg0, int arg1, E arg2) {
		matriz[arg0][arg1] = arg2;
	}
}
