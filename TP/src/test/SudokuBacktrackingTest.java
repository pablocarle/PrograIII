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

public class SudokuBacktrackingTest {

	private MatrizTDA<Integer> tablero1;
	@SuppressWarnings("unused")
	private MatrizTDA<Integer> tablero2;
	@SuppressWarnings("unused")
	private MatrizTDA<Integer> tablero3;
	
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
		tablero1 = new Matriz<Integer>();
		tablero1.inicializarMatriz(SudokuUtil.DIMENSION);
//		tablero1.setearValor(0, 0, 1);
//		tablero1.setearValor(1, 1, 3);
//		tablero1.setearValor(3, 1, 1);
//		tablero1.setearValor(3, 3, 3);
	}

	@After
	public void tearDown() throws Exception {
		;
	}

	@Test
	public void testResolverSudokuBK() {
		MatrizTDA<Integer> sudoku = SudokuBacktracking.resolverSudokuBK(SudokuUtil.DIMENSION, tablero1, new Posicion(0, 0), 0);
		System.out.println(sudoku);
		if (sudoku != null)
			SudokuUtil.mostrarTablero(sudoku);
	}

	@Test
	public void testResolverSudokuBKConPoda() {
		fail("Not yet implemented"); // TODO
	}
}
