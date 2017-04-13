package by.game.logic;


public class Point {

	private int x;
	private int y;

	Point(int x, int y) {
		this.x=x;
		this.y=y;
	}

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

	public static int getCellNumber(int x, int y){
		return (9*(y-1))+x-1;
	}
	
	public static Point getPointCoordsByNum(int number){
		
		int y = number / 9 + 1;
		int x = number % 9 + 1;
		
		return new Point(x,y);
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	
	
}
