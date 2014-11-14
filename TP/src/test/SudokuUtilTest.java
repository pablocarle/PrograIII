package test;

import static org.junit.Assert.*;
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
		
		tablero2 = new Matriz<Integer>(); //Tablero commpleto invalido
		tablero2.inicializarMatriz(SudokuUtil.DIMENSION);
		
		tablero3 = new Matriz<Integer>(); //Tablero incompleto
		tablero3.inicializarMatriz(SudokuUtil.DIMENSION);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMostrarTablero() {
		
	}

	@Test
	public void testSudokuValido() {
		boolean valido = SudokuUtil.sudokuValido(tablero1, SudokuUtil.DIMENSION);
		assertTrue("Tablero 1 debia ser valido y volvio invalido", valido);
		
		valido = SudokuUtil.sudokuValido(tablero2, SudokuUtil.DIMENSION);
		assertFalse("", valido);
		
		
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
	public void testProximaPosicion() {
		fail("Not yet implemented"); // TODO
	}

}
