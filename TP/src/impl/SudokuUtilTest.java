package impl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Implementaciones.Matriz;
import TDA.MatrizTDA;

public class SudokuUtilTest {

	private int dimension = 0;
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
		dimension = 4;
		tablero1 = new Matriz<Integer>(); //Tablero completo valido
		tablero1.inicializarMatriz(dimension);
		
		tablero2 = new Matriz<Integer>(); //Tablero commpleto invalido
		tablero2.inicializarMatriz(dimension);
		
		tablero3 = new Matriz<Integer>(); //Tablero incompleto
		tablero3.inicializarMatriz(dimension);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMostrarTablero() {
		
	}

	@Test
	public void testSudokuValido() {
		boolean valido = SudokuUtil.sudokuValido(tablero1, dimension);
		assertTrue("Tablero 1 debia ser valido y volvio invalido", valido);
		
		valido = SudokuUtil.sudokuValido(tablero2, dimension);
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
