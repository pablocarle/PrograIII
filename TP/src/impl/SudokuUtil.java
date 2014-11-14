package impl;

import Implementaciones.Matriz;
import TDA.MatrizTDA;

public class SudokuUtil {
	
	public static final int DIMENSION = 4;
	
	public SudokuUtil() {
		super();
	}
	
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
		Integer valorAbuscar = 0;
		for (int i = 0; res && (i < cantDigitos); i++) {
			for (int j = 0; res && (j < cantDigitos); j++) {
				valorAbuscar = tablero.obtenerValor(i, j); //Falta evaluar en cuadrante
				if (valorAbuscar == null || !esUnicoEnFila(tablero, valorAbuscar, i) || !esUnicoEnColumna(tablero, valorAbuscar, j)) {
					res = false;
				}
			}
		}
		System.out.println("sudokuvalido: " + res);
		return res;
	}
	
	public static boolean esUnicoEnFila (MatrizTDA<Integer> tablero, int valorAbuscar, int filaActual) {
		boolean res = true;
		int contar = 0;
		for (int j = 0; j < tablero.obtenerDimension() && tablero.obtenerValor(filaActual, j) != null && contar<=1; j++) {
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
		for (int i = 0; i < tablero.obtenerDimension() && tablero.obtenerValor(i, columnaActual) != null && contar <= 1; i++) {
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
		if (pos.getX() == (SudokuUtil.DIMENSION - 1) && (pos.getY() == SudokuUtil.DIMENSION - 1)) {
			res = new Posicion(0, 0); //Ultimo elemento
		} else if (pos.getY() == (SudokuUtil.DIMENSION - 1)){
        	res = new Posicion(pos.getX() + 1, 0);
        } else {
        	res = new Posicion(pos.getX(), pos.getY() + 1);
        }
		return res;
	}
}
