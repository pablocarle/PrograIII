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
	
	public static MatrizTDA<Integer> resolverSudokuBKConPoda(int maxDigitoPosible ,MatrizTDA<Integer> matrizActual, Posicion posActual,
			int numerosUbicados, MatrizTDA<Boolean> filas, MatrizTDA<Boolean> columnas, MatrizTDA<Boolean> cuadrante) {
		MatrizTDA<Integer> res = null;
		
		if (numerosUbicados == (maxDigitoPosible * maxDigitoPosible)){
			SudokuUtil.mostrarTablero(matrizActual);
			if (SudokuUtil.sudokuValido(matrizActual, maxDigitoPosible)){
				res = matrizActual;
			}
		}else{
			int cuad = consultarCuadrante(posActual, matrizActual);
			if (matrizActual.obtenerValor(posActual.getX(), posActual.getY()) == null){
				boolean encontrado = false;
				for (int i = 1 ; i <= maxDigitoPosible && !encontrado;i++){
					if (filas.obtenerValor(i, posActual.getX()) == false && 
				     columnas.obtenerValor(i, posActual.getY())== false &&
				     cuadrante.obtenerValor(i, cuad) == false){
						matrizActual.setearValor(posActual.getX(), posActual.getY(), i);
						System.out.println("Posicion " + posActual.getX() + " " + posActual.getY());
						System.out.println("Valor " + matrizActual.obtenerValor(posActual.getX(), posActual.getY()));
						filas.setearValor(i, posActual.getX(), true);
						columnas.setearValor(i, posActual.getY(), true);
						cuadrante.setearValor(i, cuad, true);
						
						res = resolverSudokuBKConPoda(maxDigitoPosible, matrizActual, SudokuUtil.proximaPosicion(posActual), numerosUbicados + 1, filas, columnas, cuadrante);
						
						if (res != null){
							encontrado = true;
 						}else{
 							matrizActual.setearValor(posActual.getX(),posActual.getY(), null);
						}
					}
				}
			}else{
				
				int elem = matrizActual.obtenerValor(posActual.getX(), posActual.getY());
				filas.setearValor(elem, posActual.getX(), true);
				columnas.setearValor(elem, posActual.getY(), true);
				cuadrante.setearValor(elem, cuad, true);
				
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
	//		System.out.println("Posicion consultada : " + pos.getX() + " " + pos.getY());
			for (int i = inix ;i <= finx; i++){
				for (int j = iniy; j<= finy; j++){
					if (i == pos.getX() && j== pos.getY()){
						encontrado = true;
					}
				}
			}
			if (encontrado == false){
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
