package impl;

import Implementaciones.Matriz;
import TDA.MatrizTDA;

public class SudokuUtil {
	
	public SudokuUtil() {
		super();
	}
	
	private static MatrizTDA<Integer> nuevaMatriz;
	
	public static void main(String[] args) {
		MatrizTDA<Integer> nuevaMatriz = new Matriz<Integer>();
		nuevaMatriz.inicializarMatriz(2);
		nuevaMatriz.setearValor(0, 0, 1);
		nuevaMatriz.setearValor(0, 1, 2);
		nuevaMatriz.setearValor(1, 0, 3);
		nuevaMatriz.setearValor(1, 1, 4);
		mostrarTablero(nuevaMatriz);
	}
	
	public static void mostrarTablero(MatrizTDA<Integer> tablero){
		int cantFilas = tablero.obtenerDimension();
		for (int i = 0; i < cantFilas; i++) {
			System.out.print("\n||");
			for (int j = 0; j < cantFilas;j++){
				System.out.print("|" + tablero.obtenerValor(i, j) + "|");
			}
			System.out.print("||\n");
		}
	}
	
	public static boolean sudokuValido(MatrizTDA<Integer> tablero, int cantDigitos){
		boolean res = true;
		int valorAbuscar = 0;
		for (int i = 0; res && (i < cantDigitos); i++) {
			for (int j = 0; j < cantDigitos; j++) {
				valorAbuscar = tablero.obtenerValor(i, j);
				if (!esUnicoEnFila(tablero, valorAbuscar, i) || !esUnicoEnColumna(tablero, valorAbuscar, j)) {
					res = false;
				}
			}
		}
		return res;
	}
	
	public static boolean esUnicoEnFila (MatrizTDA<Integer> tablero, int valorAbuscar, int filaActual) {
		boolean res = true;
		int contar = 0;
		for (int j = 0; tablero.obtenerValor(filaActual, j) != null && contar<=1; j++) {
			if (tablero.obtenerValor(filaActual, j) == valorAbuscar){
				contar++;
			}
		}
		if (contar <= 1){
			res = true;
		} else {
			res = false;
		}
		return res;
	}
	
	public static boolean esUnicoEnColumna (MatrizTDA<Integer> tablero, int valorAbuscar, int columnaActual) {
		boolean res = true;
		int contar = 0;
		for (int i = 0; tablero.obtenerValor(i, columnaActual) != null && contar <= 1; i++) {
			if (tablero.obtenerValor(i, columnaActual) == valorAbuscar){
				contar++;
			}
		}
		if (contar <= 1){
			res = true;
		} else {
			res = false;
		}
		return res;
	}
	
	public static Posicion proximaPosicion(Posicion pos) {
		Posicion res;
		int limite = nuevaMatriz.obtenerDimension();
        
		if (pos.getX() == limite && pos.getY() == limite) {
			res = null; //Ultimo elemento
		} else if (pos.getY() == limite){
        	res = new Posicion(pos.getX() + 1, 0);
        } else {
        	res = new Posicion(pos.getX(), pos.getY() + 1);
        }
		return res;
	}
}
