package by.game.face;

public enum BallColor {

	EMPTY,	//0
	WHITE,	//1
	BLUE,   //2
	GREEN,  //3
	RED,	//4
	YELLOW,	//5
	PURPLE,	//6
	CYAN,	//7
	ANGRY;	//8
	
	public static BallColor randomColor(){
		
		BallColor [] bc = BallColor.values();
		
		return bc[(int)( (Math.random() * StaticVars.NUMBER_OF_COLORS) + 1)];
	}
	
	public static BallColor getColorByNum(int num){
	
		if (num < 0 || num > 8) {
			return BallColor.EMPTY;
		}
		
		BallColor [] bc = BallColor.values();
		
		return bc[num];
	}
	
}
