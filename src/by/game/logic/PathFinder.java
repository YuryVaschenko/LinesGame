package by.game.logic;


public class PathFinder {

	class Point{
		private int x;
		private int y;

		Point(int x, int y) {
			this.x=x;
			this.y=y;
		}

		public int getX() {
			return x;		
		}

		public int getY() {
			return y;
		}

		@Override
		public boolean equals(Object o){
			if(!(o instanceof Point)) return false;
				return (((Point)o).getX()==x) &&(((Point)o).getY()==y);
		}

		@Override
		public int hashCode(){
			return Integer.valueOf(x) ^ Integer.valueOf(y);
		}

		@Override
                public String toString(){
                	return "x: "+Integer.toString(x)+" y:"+Integer.toString(y);
		}

	}
}
