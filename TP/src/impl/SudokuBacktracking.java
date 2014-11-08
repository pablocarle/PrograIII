package impl;

import TDA.MatrizTDA;

public class SudokuBacktracking {

	public static MatrizTDA<Integer> resolverSudokuBK(int maxDigitoPosible, MatrizTDA<Integer> matrizActual, Posicion posActual, int correctos) {
		MatrizTDA<Integer> res = null;
		if (posActual == null && SudokuUtil.sudokuValido(matrizActual, maxDigitoPosible)) {
			res = matrizActual;
		} else {
			for (int i = 1; i <= maxDigitoPosible && res == null; i++) {
				if (SudokuUtil.esUnicoEnFila(matrizActual, i, posActual.getX()) && SudokuUtil.esUnicoEnColumna(matrizActual, i, posActual.getY())) {
					matrizActual.setearValor(posActual.getX(), posActual.getY(), i);
					res = resolverSudokuBK(maxDigitoPosible, matrizActual, SudokuUtil.proximaPosicion(posActual), correctos + 1);
				}
			}
		}
		return res;
	}
	
	public static MatrizTDA<Integer> resolverSudokuBKConPoda(MatrizTDA<Integer> matrizActual, Posicion posActual,
			int numerosUbicados, MatrizTDA<Boolean> filas, MatrizTDA<Boolean> columnas, MatrizTDA<Boolean> cuadrante) {
		return null;
	}
}
