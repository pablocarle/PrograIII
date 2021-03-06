package impl;

import Implementaciones.Matriz;
import TDA.MatrizTDA;

public class SudokuBacktracking {
	
	public static MatrizTDA<Integer> resolverSudoku(MatrizTDA<Integer> tablero) {
		return resolverSudokuBK(tablero.obtenerDimension(), tablero, new Posicion(0, 0), 0);
	}
	
	public static MatrizTDA<Integer> resolverSudokuPoda(MatrizTDA<Integer> tablero) {
		MatrizTDA<Boolean> filas = new Matriz<Boolean>();
		MatrizTDA<Boolean> columnas = new Matriz<Boolean>();
		MatrizTDA<Boolean> cuadrante = new Matriz<Boolean>();
		filas.inicializarMatriz(tablero.obtenerDimension());
		columnas.inicializarMatriz(tablero.obtenerDimension());
		cuadrante.inicializarMatriz(tablero.obtenerDimension());
		for (int i = 0; i < tablero.obtenerDimension(); i++) {
			for (int j = 0; i < tablero.obtenerDimension(); j++) {
				filas.setearValor(i, j, Boolean.FALSE);
				columnas.setearValor(i, j, Boolean.FALSE);
				cuadrante.setearValor(i, j, Boolean.FALSE);
			}
		}
		return resolverSudokuBKConPoda(tablero.obtenerDimension(), tablero, new Posicion(0, 0), 0, filas, columnas, cuadrante);
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
	
	public static MatrizTDA<Integer> resolverSudokuBKConPoda(int maxDigitoPosible ,MatrizTDA<Integer> matrizActual, Posicion posActual,
			int numerosUbicados, MatrizTDA<Boolean> filas, MatrizTDA<Boolean> columnas, MatrizTDA<Boolean> cuadrante) {
		MatrizTDA<Integer> res = null;
		
		if (numerosUbicados == (maxDigitoPosible * maxDigitoPosible)){
			if (SudokuUtil.sudokuValido(matrizActual, maxDigitoPosible)){
				res = matrizActual;
			}
		} else {
			int cuad = consultarCuadrante(posActual, matrizActual);
			if (matrizActual.obtenerValor(posActual.getX(), posActual.getY()) == null){
				boolean encontrado = false;
				for (int i = 1 ; i <= maxDigitoPosible && !encontrado; i++){
					//Pregunta si el elemento i ya fue cargado en alguna fila, columna o cuadrante
					//Solo admite los valores que no fueron cargados
					if (!filas.obtenerValor(i - 1, posActual.getX()) && !columnas.obtenerValor(i - 1, posActual.getY()) && !cuadrante.obtenerValor(i - 1, cuad - 1)){
						matrizActual.setearValor(posActual.getX(), posActual.getY(), i);
						filas.setearValor(i - 1, posActual.getX(), true);
						columnas.setearValor(i - 1 , posActual.getY(), true);
						cuadrante.setearValor(i - 1, cuad - 1, true);
						
						res = resolverSudokuBKConPoda(maxDigitoPosible, matrizActual, SudokuUtil.proximaPosicion(posActual), numerosUbicados + 1, filas, columnas, cuadrante);
						
						if (res != null){
							encontrado = true;
 						} else {
							//No es solucion pasa a false valor de matriz que probaste (columnas / cuadrante / filas)
 							filas.setearValor(i - 1, posActual.getX(), false);
 							columnas.setearValor(i - 1 , posActual.getY(), false);
 							cuadrante.setearValor(i - 1, cuad - 1, false);
 							matrizActual.setearValor(posActual.getX(),posActual.getY(), null);
						}
					}
				}
			} else {
	 			int elem = matrizActual.obtenerValor(posActual.getX(), posActual.getY());
				filas.setearValor(elem - 1, posActual.getX(), true);
				columnas.setearValor(elem - 1, posActual.getY(), true);
				cuadrante.setearValor(elem - 1, cuad - 1, true);
				
				res = resolverSudokuBKConPoda(maxDigitoPosible, matrizActual, SudokuUtil.proximaPosicion(posActual), numerosUbicados + 1, filas, columnas, cuadrante);
			}
		}
		return res;
	}
	
	public static int consultarCuadrante (Posicion pos ,MatrizTDA<Integer> matrizActual){
		int dimension = matrizActual.obtenerDimension();
		int tamanioCuadrante = dimension % 2 == 0 ? dimension / 2 : dimension / 3;
		int res = 0;
		int inix = 0;
		int iniy = 0;
		dimension--;
		tamanioCuadrante--;
		int finx = tamanioCuadrante;
		int finy = tamanioCuadrante;
		int cuadrante = 1;
		boolean encontrado = false;
		while (encontrado == false){
			for (int i = inix ;i <= finx; i++){
				for (int j = iniy; j<= finy; j++){
					if (i == pos.getX() && j== pos.getY()){
						encontrado = true;
					}
				}
			}
			if (!encontrado){
				cuadrante++;
				if (finx == dimension){
					if (finy == dimension && finx == dimension){
						encontrado = true;
					}else{
						inix = 0;
						finx = tamanioCuadrante;
						iniy = iniy + tamanioCuadrante + 1;
						finy = iniy + tamanioCuadrante;
					}
				}else{
					inix = finx + 1;
					finx = finx + tamanioCuadrante + 1;
				}
			}else{
				res = cuadrante;
			}
			 
		}
		return res;
	}
}
