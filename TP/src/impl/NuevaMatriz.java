package impl;

import TDA.MatrizTDA;

public class NuevaMatriz<E> implements MatrizTDA<E>{
	E[][] matriz;
	
	public void inicializarMatriz(int arg0){
		matriz = new E[arg0][arg0];
	}

	public int obtenerDimension() {
		int i;
		int j;
		for (i = 1; obtenerValor(i, 1) != null;i++);
		for (j = 1; obtenerValor(1, j) != null;j++);
		return i*j;
	}

	public E obtenerValor(int arg0, int arg1) {
		return matriz[arg0][arg1];
	}

	public void setearValor(int arg0, int arg1, E arg2) {
		matriz[arg0][arg1] = arg2;
	}
}
