package impl;

import TDA.MatrizTDA;

public class SudokuBacktracking {
	
	public static MatrizTDA<Integer> resolverSudoku(MatrizTDA<Integer> tablero) {
		return resolverSudokuBK(tablero.obtenerDimension(), tablero, new Posicion(0, 0), 0);
	}

	public static MatrizTDA<Integer> resolverSudokuBK(int maxDigitoPosible, MatrizTDA<Integer> matrizActual, Posicion posActual, int correctos) {
		MatrizTDA<Integer> res = null;
		if (correctos == (maxDigitoPosible * maxDigitoPosible)) {
			if (SudokuUtil.sudokuValido(matrizActual, maxDigitoPosible)) {
				res = matrizActual;
			}
		} else {
			if (matrizActual.obtenerValor(posActual.getX(), posActual.getY()) == null) {
				boolean encontrado = false;
				for (int i = 1; i <= maxDigitoPosible && !encontrado; i++) {
					matrizActual.setearValor(posActual.getX(), posActual.getY(), i);
					res = resolverSudokuBK(maxDigitoPosible, matrizActual, SudokuUtil.proximaPosicion(posActual), correctos + 1);
					
					if (res != null)
						encontrado = true;
					else
						matrizActual.setearValor(posActual.getX(), posActual.getY(), null);
				}
			} else {
				res = resolverSudokuBK(maxDigitoPosible, matrizActual, SudokuUtil.proximaPosicion(posActual), correctos + 1);
			}
		}
		return res;
	}
	
	public static MatrizTDA<Integer> resolverSudokuBKConPoda(MatrizTDA<Integer> matrizActual, Posicion posActual,
			int numerosUbicados, MatrizTDA<Boolean> filas, MatrizTDA<Boolean> columnas, MatrizTDA<Boolean> cuadrante) {
		return null;
	}
}
