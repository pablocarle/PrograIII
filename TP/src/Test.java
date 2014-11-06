import Implementaciones.Matriz;
import TDA.MatrizTDA;
import impl.NuevaMatriz;


public class Test {
	public class Posicion{
		public int x;
		public int y;
	}
	
	static  MatrizTDA<Integer> nuevaMatriz;
	
	public static void main(String[] args) {
		
		MatrizTDA<Integer> nuevaMatriz = new Matriz<Integer>();
		nuevaMatriz.inicializarMatriz(2);
		nuevaMatriz.setearValor(1, 1, 1);
		nuevaMatriz.setearValor(1, 2, 2);
		nuevaMatriz.setearValor(2, 1, 3);
		nuevaMatriz.setearValor(2, 2, 4);
		mostrarTablero(nuevaMatriz);
	}
	public static void mostrarTablero(MatrizTDA<Integer> tablero){
		int cantFilas = tablero.obtenerDimension()/2;
		
		for (int i=1; i<cantFilas;i++){
			for (int j=1; j<cantFilas;j++){
				System.out.println("|"+tablero.obtenerValor(i, j)+"|");
			}
		}
	}
	
	public boolean sudokuValido (MatrizTDA<Integer> tablero , int cantDigitos){
		boolean res = true;
		int valorAbuscar;
		for (int i=1; (res == true) && (i < cantDigitos);i++){
			for (int j=1;j< cantDigitos;j++){
				valorAbuscar = tablero.obtenerValor(i, j);
				if (!esUnicoEnFila(tablero, valorAbuscar, i) || !esUnicoEnColumna(tablero, valorAbuscar, j)){
					res=false;
				}
			}
		}
		return res;
	}
	
	public boolean esUnicoEnFila (MatrizTDA<Integer> tablero,int valorAbuscar,int filaActual){
		boolean res=true;
		int contar=0;
		for (int j=1;tablero.obtenerValor(filaActual, j)!= null && contar<=1;j++){
			if (tablero.obtenerValor(filaActual, j) == valorAbuscar){
				contar++;
			}
		}
		if (contar<=1){
			res=true;
		}else{
			res=false;
		}
		return res;
	}
	
	public boolean esUnicoEnColumna (MatrizTDA<Integer> tablero,int valorAbuscar,int columActual){
		boolean res=true;
		int contar=0;
		for (int i=1;tablero.obtenerValor(i, columActual)!= null && contar<=1;i++){
			if (tablero.obtenerValor(i, columActual) == valorAbuscar){
				contar++;
			}
		}
		if (contar<=1){
			res=true;
		}else{
			res=false;
		}
		return res;
	}
	
	public static Posicion proximaPosicion(Posicion pos) {
		Posicion res=null;
		int dimension;
		int limite;
        dimension = nuevaMatriz.obtenerDimension();
        limite = dimension / 2;
        
        if (pos.x == limite && pos.y == limite){
        	res.x = 1;
        	res.y = 1;
        }else{
        	res.x = pos.x + 1;
        	res.y = pos.y + 1;
        }
        	
		return res;
	}

}
