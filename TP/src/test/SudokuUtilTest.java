package test;

import static org.junit.Assert.*;
import impl.Posicion;
import impl.SudokuUtil;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Implementaciones.Matriz;
import TDA.MatrizTDA;

public class SudokuUtilTest {

	private MatrizTDA<Integer> tablero1;
	private MatrizTDA<Integer> tablero2;
	private MatrizTDA<Integer> tablero3;
	private MatrizTDA<Integer> tablero4;
	private MatrizTDA<Integer> tablero5;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		tablero1 = new Matriz<Integer>(); //Tablero completo valido
		tablero1.inicializarMatriz(SudokuUtil.DIMENSION);
		tablero1.setearValor(0, 0, 1);
		tablero1.setearValor(0, 1, 2);
		tablero1.setearValor(0, 2, 3);
		tablero1.setearValor(0, 3, 4);
		tablero1.setearValor(1, 0, 3);
		tablero1.setearValor(1, 1, 4);
		tablero1.setearValor(1, 2, 2);
		tablero1.setearValor(1, 3, 1);
		tablero1.setearValor(2, 0, 2);
		tablero1.setearValor(2, 1, 1);
		tablero1.setearValor(2, 2, 4);
		tablero1.setearValor(2, 3, 3);
		tablero1.setearValor(3, 0, 4);
		tablero1.setearValor(3, 1, 3);
		tablero1.setearValor(3, 2, 1);
		tablero1.setearValor(3, 3, 2);
		
		tablero2 = new Matriz<Integer>(); //Tablero commpleto invalido repetido en fila
		tablero2.inicializarMatriz(SudokuUtil.DIMENSION);
		tablero2.setearValor(0, 0, 1);
		tablero2.setearValor(0, 1, 1); //repe
		tablero2.setearValor(0, 2, 3);
		tablero2.setearValor(0, 3, 4);
		tablero2.setearValor(1, 0, 3);
		tablero2.setearValor(1, 1, 4);
		tablero2.setearValor(1, 2, 2);
		tablero2.setearValor(1, 3, 1);
		tablero2.setearValor(2, 0, 2);
		tablero2.setearValor(2, 1, 1);
		tablero2.setearValor(2, 2, 4);
		tablero2.setearValor(2, 3, 3);
		tablero2.setearValor(3, 0, 4);
		tablero2.setearValor(3, 1, 3);
		tablero2.setearValor(3, 2, 1);
		tablero2.setearValor(3, 3, 2);
		
		tablero3 = new Matriz<Integer>(); //Tablero completo invalido repetido en columna
		tablero3.inicializarMatriz(SudokuUtil.DIMENSION);
		tablero3.setearValor(0, 0, 1);
		tablero3.setearValor(0, 1, 2);
		tablero3.setearValor(0, 2, 3);
		tablero3.setearValor(0, 3, 4);
		tablero3.setearValor(1, 0, 3);
		tablero3.setearValor(1, 1, 4);
		tablero3.setearValor(1, 2, 2);
		tablero3.setearValor(1, 3, 1);
		tablero3.setearValor(2, 0, 2);
		tablero3.setearValor(2, 1, 1);
		tablero3.setearValor(2, 2, 4);
		tablero3.setearValor(2, 3, 3);
		tablero3.setearValor(3, 0, 1); //repe
		tablero3.setearValor(3, 1, 3);
		tablero3.setearValor(3, 2, 1);
		tablero3.setearValor(3, 3, 2);
		
		tablero4 = new Matriz<Integer>(); //Tablero incompleto valido
		tablero4.inicializarMatriz(SudokuUtil.DIMENSION);
		tablero4.setearValor(0, 0, 1);
		tablero4.setearValor(0, 1, 2);
		tablero4.setearValor(0, 3, 4);
		tablero4.setearValor(1, 2, 2);
		tablero4.setearValor(1, 3, 1);
		tablero4.setearValor(2, 2, 4);
		tablero4.setearValor(3, 0, 4);
		tablero4.setearValor(3, 2, 1);
		tablero4.setearValor(3, 3, 2);
		
		tablero5 = new Matriz<Integer>(); //Tablero completo con repeticion en cuadrante
		tablero5.inicializarMatriz(SudokuUtil.DIMENSION);
		tablero5.setearValor(0, 0, 1);
		tablero5.setearValor(0, 1, 2);
		tablero5.setearValor(0, 2, 3);
		tablero5.setearValor(0, 3, 4);
		tablero5.setearValor(1, 0, 3); 
		tablero5.setearValor(1, 1, 1); //repe
		tablero5.setearValor(1, 2, 2);
		tablero5.setearValor(1, 3, 1);
		tablero5.setearValor(2, 0, 2);
		tablero5.setearValor(2, 1, 1);
		tablero5.setearValor(2, 2, 4);
		tablero5.setearValor(2, 3, 3);
		tablero5.setearValor(3, 0, 4);
		tablero5.setearValor(3, 1, 3);
		tablero5.setearValor(3, 2, 1);
		tablero5.setearValor(3, 3, 2);
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testMostrarTablero() {
		SudokuUtil.mostrarTablero(tablero1);
		SudokuUtil.mostrarTablero(tablero2);
		SudokuUtil.mostrarTablero(tablero3);
		SudokuUtil.mostrarTablero(tablero4);
		SudokuUtil.mostrarTablero(tablero5);
	}

	@Test
	public void testSudokuValido() {
		System.out.println("Sudoku Valido:");
		SudokuUtil.mostrarTablero(tablero1);
		boolean valido = SudokuUtil.sudokuValido(tablero1, SudokuUtil.DIMENSION);
		assertTrue("tablero1 debia ser valido y volvio invalido", valido);
		
		System.out.println("Sudoku Invalido - Repeticion en Fila");
		SudokuUtil.mostrarTablero(tablero2);
		valido = SudokuUtil.sudokuValido(tablero2, SudokuUtil.DIMENSION);
		assertFalse("tablero2 es invalido por repeticion en fila y volvio valido", valido);
		
		System.out.println("Sudoku Invalido - Repeticion en columna");
		SudokuUtil.mostrarTablero(tablero3);
		valido = SudokuUtil.sudokuValido(tablero3, SudokuUtil.DIMENSION);
		assertFalse("tablero3 es invalido por repeticion en columna y volvio valido", valido);
		
		System.out.println("Sudoku Valido - Incompleto");
		SudokuUtil.mostrarTablero(tablero4);
		valido = SudokuUtil.sudokuValido(tablero4, SudokuUtil.DIMENSION);
		assertTrue("tablero4 es valido incompleto y volvio invalido", valido);
		
		System.out.println("Sudoku Invalido - Repeticion en cuadrante");
		SudokuUtil.mostrarTablero(tablero5);
		valido = SudokuUtil.sudokuValido(tablero5, SudokuUtil.DIMENSION);
		assertFalse("tablero5 es invalido por repeticion en cuadrante y volvio valido", valido);
	}

	@Test
	public void testEsUnicoEnFila() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testEsUnicoEnColumna() {
		fail("Not yet implemented"); // TODO
	}
	
	@Test
	public void testEsUnicoEnCuadrante() {
		MatrizTDA<Integer> tablero = new Matriz<Integer>();
		tablero.inicializarMatriz(SudokuUtil.DIMENSION);
		tablero.setearValor(0, 0, 2);
		tablero.setearValor(0, 1, 1);
		tablero.setearValor(0, 2, 3);
		tablero.setearValor(0, 3, 4);
		tablero.setearValor(1, 0, 1);
		tablero.setearValor(1, 1, 4);
		tablero.setearValor(1, 2, 2);
		tablero.setearValor(1, 3, 3);
		tablero.setearValor(2, 0, 3);
		tablero.setearValor(2, 1, 2);
		tablero.setearValor(2, 2, 4);
		tablero.setearValor(2, 3, 1);
		tablero.setearValor(3, 0, 4);
		tablero.setearValor(3, 1, 3);
		tablero.setearValor(3, 2, 1);
		tablero.setearValor(3, 3, 2);
		
		boolean success = true;
		for (int i = 0; i < SudokuUtil.DIMENSION; i++) {
			for (int j = 0; j < SudokuUtil.DIMENSION; j++) {
				success = SudokuUtil.esUnicoEnCuadrante(tablero, tablero.obtenerValor(i, j), new Posicion(i, j));
			}
		}
		assertFalse(success);
	}

	@Test
	public void testProximaPosicion() {
		fail("Not yet implemented"); // TODO
	}
}
