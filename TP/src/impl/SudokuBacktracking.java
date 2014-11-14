package impl;

import TDA.MatrizTDA;

public class SudokuBacktracking {

	public static MatrizTDA<Integer> resolverSudokuBK(int maxDigitoPosible, MatrizTDA<Integer> matrizActual, Posicion posActual, int correctos) {
		if (correctos == (maxDigitoPosible * maxDigitoPosible)) {
			SudokuUtil.mostrarTablero(matrizActual);
		}
		MatrizTDA<Integer> res = null;
		if (correctos == (maxDigitoPosible * maxDigitoPosible)) {
			if (SudokuUtil.sudokuValido(matrizActual, maxDigitoPosible)) {
				res = matrizActual;
			}
		} else if (matrizActual.obtenerValor(posActual.getX(), posActual.getY()) == null) {
			for (int i = 1; i <= maxDigitoPosible; i++) {
				matrizActual.setearValor(posActual.getX(), posActual.getY(), i);
				res = resolverSudokuBK(maxDigitoPosible, matrizActual, SudokuUtil.proximaPosicion(posActual), correctos + 1);
			}
		} else {
			res = resolverSudokuBK(maxDigitoPosible, matrizActual, SudokuUtil.proximaPosicion(posActual), correctos + 1);
		}
		return res;
	}
	
	public static MatrizTDA<Integer> resolverSudokuBKConPoda(MatrizTDA<Integer> matrizActual, Posicion posActual,
			int numerosUbicados, MatrizTDA<Boolean> filas, MatrizTDA<Boolean> columnas, MatrizTDA<Boolean> cuadrante) {
		return null;
	}
}
