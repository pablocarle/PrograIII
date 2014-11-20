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
	public void testResolverSudokuBK() {
		MatrizTDA<Integer> tablero1 = new Matriz<Integer>();
		tablero1.inicializarMatriz(SudokuUtil.DIMENSION);
		tablero1.setearValor(0, 0, 1);
		tablero1.setearValor(1, 1, 4);
		tablero1.setearValor(3, 2, 4);
		System.out.println("Tablero inicial: ");
		SudokuUtil.mostrarTablero(tablero1);
		MatrizTDA<Integer> sudoku = SudokuBacktracking.resolverSudoku(tablero1);
		assertNotNull("No se encontro solucion al sudoku de tablero1", sudoku);
		System.out.println("Sudoku Resuelto: ");
		SudokuUtil.mostrarTablero(sudoku);
	}

}
