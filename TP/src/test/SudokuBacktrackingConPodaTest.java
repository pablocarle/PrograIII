package test;

import static org.junit.Assert.*;
import impl.Posicion;
import impl.SudokuBacktracking;
import impl.SudokuUtil;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Implementaciones.Matriz;
import TDA.MatrizTDA;

public class SudokuBacktrackingConPodaTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		;
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		;
	}

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
		;
	}

	@Test
	public void testResolverSudokuBKConPoda() {
	
		MatrizTDA<Integer> tablero1 = new Matriz<Integer>();
		tablero1.inicializarMatriz(4);
		tablero1.setearValor(0, 0, 2);
		tablero1.setearValor(1, 1, 4);
		tablero1.setearValor(2, 2, 4);
		tablero1.setearValor(3, 3, 2);
		
		MatrizTDA<Boolean> filas = new Matriz<Boolean>();
		MatrizTDA<Boolean> columnas = new Matriz<Boolean>();
		MatrizTDA<Boolean> cuadrante = new Matriz<Boolean>();
		
		filas.inicializarMatriz(4);
		filas.setearValor(0, 0, false);
		filas.setearValor(0, 1, false);
		filas.setearValor(0, 2, false);
		filas.setearValor(0, 3, false);
		filas.setearValor(1, 0, false);
		filas.setearValor(1, 1, false);
		filas.setearValor(1, 2, false);
		filas.setearValor(1, 3, false);
		filas.setearValor(2, 0, false);
		filas.setearValor(2, 1, false);
		filas.setearValor(2, 2, false);
		filas.setearValor(2, 3, false);
		filas.setearValor(3, 0, false);
		filas.setearValor(3, 1, false);
		filas.setearValor(3, 2, false);
		filas.setearValor(3, 3, false);
		
		columnas.inicializarMatriz(4);
		columnas.setearValor(0, 0, false);
		columnas.setearValor(0, 1, false);
		columnas.setearValor(0, 2, false);
		columnas.setearValor(0, 3, false);
		columnas.setearValor(1, 0, false);
		columnas.setearValor(1, 1, false);
		columnas.setearValor(1, 2, false);
		columnas.setearValor(1, 3, false);
		columnas.setearValor(2, 0, false);
		columnas.setearValor(2, 1, false);
		columnas.setearValor(2, 2, false);
		columnas.setearValor(2, 3, false);
		columnas.setearValor(3, 0, false);
		columnas.setearValor(3, 1, false);
		columnas.setearValor(3, 2, false);
		columnas.setearValor(3, 3, false);
		
		cuadrante.inicializarMatriz(4);
		cuadrante.setearValor(0, 0, false);
		cuadrante.setearValor(0, 1, false);
		cuadrante.setearValor(0, 2, false);
		cuadrante.setearValor(0, 3, false);
		cuadrante.setearValor(1, 0, false);
		cuadrante.setearValor(1, 1, false);
		cuadrante.setearValor(1, 2, false);
		cuadrante.setearValor(1, 3, false);
		cuadrante.setearValor(2, 0, false);
		cuadrante.setearValor(2, 1, false);
		cuadrante.setearValor(2, 2, false);
		cuadrante.setearValor(2, 3, false);
		cuadrante.setearValor(3, 0, false);
		cuadrante.setearValor(3, 1, false);
		cuadrante.setearValor(3, 2, false);
		cuadrante.setearValor(3, 3, false); 
	
		MatrizTDA<Integer> sudoku = SudokuBacktracking.resolverSudokuBKConPoda(4, tablero1, new Posicion(0, 0), 0, filas, columnas, cuadrante);
		System.out.println(sudoku);
		if (sudoku != null)
			SudokuUtil.mostrarTablero(sudoku);
	/*
		MatrizTDA<Integer> tablero2 = new Matriz<Integer>();
		tablero2.inicializarMatriz(2);
		tablero2.setearValor(0, 0, 1);
		tablero2.setearValor(1, 1, 1);
		
		MatrizTDA<Boolean> filas2 = new Matriz<Boolean>();
		MatrizTDA<Boolean> columnas2 = new Matriz<Boolean>();
		MatrizTDA<Boolean> cuadrante2 = new Matriz<Boolean>();
		filas2.inicializarMatriz(2);
		filas2.setearValor(0, 0, false);
		filas2.setearValor(0, 1, false);
		filas2.setearValor(1, 0, false);
		filas2.setearValor(1, 1, false);
		
		columnas2.inicializarMatriz(2);
		columnas2.setearValor(0, 0, false);
		columnas2.setearValor(0, 1, false);
		columnas2.setearValor(1, 0, false);
		columnas2.setearValor(1, 1, false);
		
		cuadrante2.inicializarMatriz(4);
		cuadrante2.setearValor(0, 0, false);
		cuadrante2.setearValor(0, 1, false);
		cuadrante2.setearValor(0, 2, false);
		cuadrante2.setearValor(0, 3, false);
		cuadrante2.setearValor(1, 0, false);
		cuadrante2.setearValor(1, 1, false);
		cuadrante2.setearValor(1, 2, false);
		cuadrante2.setearValor(1, 3, false);
		cuadrante2.setearValor(2, 0, false);
		cuadrante2.setearValor(2, 1, false);
		cuadrante2.setearValor(2, 2, false);
		cuadrante2.setearValor(2, 3, false);
		cuadrante2.setearValor(3, 0, false);
		cuadrante2.setearValor(3, 1, false);
		cuadrante2.setearValor(3, 2, false);
		cuadrante2.setearValor(3, 3, false);

		MatrizTDA<Integer> sudoku2 = SudokuBacktracking.resolverSudokuBKConPoda(2, tablero2, new Posicion(0, 0), 0, filas2, columnas2, cuadrante2);
		System.out.println(sudoku2);
		if (sudoku2 != null)
			SudokuUtil.mostrarTablero(sudoku2);
	*/
	}
	
		
}