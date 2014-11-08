package impl;
public class Posicion{
	public Posicion(int x, int y) {
		this.x = x; //Numero de fila
		this.y = y; //Numero de columna
	}

	private int x;
	private int y;
	
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
}