package impl;

import Implementaciones.Matriz;
import TDA.MatrizTDA;

public class SudokuUtil {
	
	public static final int DIMENSION = 4;
	
	public SudokuUtil() {
		super();
	}
	
	public static void mostrarTablero(MatrizTDA<Integer> tablero){
		int cantFilas = tablero.obtenerDimension();
		System.out.println("-------------------------------------------------");
		for (int i = 0; i < cantFilas; i++) {
			System.out.print("\n||");
			for (int j = 0; j < cantFilas;j++){
				System.out.print("|" + tablero.obtenerValor(i, j) + "|");
			}
			System.out.print("||\n");
		}
		System.out.println("-------------------------------------------------");
	}
	
	public static boolean sudokuValido(MatrizTDA<Integer> tablero, int cantDigitos){
		boolean res = true;
		Integer valorAbuscar = 0;
		for (int i = 0; res && (i < cantDigitos); i++) {
			for (int j = 0; res && (j < cantDigitos); j++) {
				valorAbuscar = tablero.obtenerValor(i, j);
				if (valorAbuscar != null && (!esUnicoEnCuadrante(tablero, valorAbuscar, new Posicion(i, j)) 
						|| (!esUnicoEnFila(tablero, valorAbuscar, i) || !esUnicoEnColumna(tablero, valorAbuscar, j)))) {
					res = false;
				}
			}
		}
		return res;
	}
	
	public static boolean esUnicoEnCuadrante(MatrizTDA<Integer> tablero, int valorAbuscar, Posicion posicion) {
		MatrizTDA<Integer> cuadrante = obtenerCuadrante(posicion, tablero);
		boolean unico = true;
		int count = 0;
		for (int i = 0; i < cuadrante.obtenerDimension() && unico; i++) {
			for (int j = 0; j < cuadrante.obtenerDimension() && unico; j++) {
				if (cuadrante.obtenerValor(i, j) != null && cuadrante.obtenerValor(i, j) == valorAbuscar) {
					count++;
				}
				if (count > 1)
					unico = false;
			}
		}
		return unico;
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
		if (pos.getX() == (DIMENSION - 1) && (pos.getY() == DIMENSION - 1)) { //Ultimo elemento
			res = null;
		} else if (pos.getY() == (DIMENSION - 1)){ //Ultima columna, aumento fila y vuelvo a primera columna
        	res = new Posicion(pos.getX() + 1, 0); 
        } else if (pos.getX() == (DIMENSION - 1)) { //Ultima fila, aumento columna y mantengo fila 
        	res = new Posicion(pos.getX(), pos.getY() + 1);
        } else {
        	res = new Posicion(pos.getX(), pos.getY() + 1);
        }
		return res;
	}
	
	@SuppressWarnings("unused")
	private static MatrizTDA<Integer> obtenerCuadrante(Posicion p, MatrizTDA<Integer> tablero) {
		int tamanioCuadrante = DIMENSION % 2 == 0 ? DIMENSION / 2 : DIMENSION / 3;
		int modulo = DIMENSION % 2 == 0 ? 2 : 3;
		final MatrizTDA<Integer> retMatriz = new Matriz<Integer>();
		retMatriz.inicializarMatriz(tamanioCuadrante);
		int filaComienzo = 0;
		int columnaComienzo = 0;
		int filaFin = 0;
		int columnaFin = 0;
		boolean encontrado = false;
		if (p.getX() < DIMENSION && p.getY() < DIMENSION) {
			for (int i = 0; i < DIMENSION && !encontrado; i++) {
				for (int j = 0; i < DIMENSION && !encontrado; i++) {
					if ((j == 0 && i == 0) || (i % modulo == 0 && j % modulo == 0)) {
						filaComienzo = i;
						columnaComienzo = j;
					}
					if (p.getX() == i && p.getY() == j) {
						filaFin = filaComienzo + modulo;
						columnaFin = columnaComienzo + modulo;
						encontrado = true;
					}
				}
			}
		}
		if (tamanioCuadrante != 1) {
			for (int i = filaComienzo, k = 0; i < filaFin && k < tamanioCuadrante; i++, k++) {
				for (int j = columnaComienzo, w = 0; j < columnaFin && w < tamanioCuadrante; j++, w++) {
					retMatriz.setearValor(k, w, tablero.obtenerValor(i, j));
				}
			}
		} else {
			retMatriz.setearValor(0, 0, tablero.obtenerValor(filaComienzo, columnaComienzo));
		}
		return retMatriz;
	}
}
