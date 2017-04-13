package by.game.logic;

import by.game.face.BallColor;
import by.game.face.StaticVars;

public class Logic {
	
	public Logic() {

	}	
	
	public void init(){
		int [][] pole = StaticVars.field;
	 
		for (int g=1; g<=9; g++){
			for (int v=1; v<=9; v++){
				pole [g][v] = 0;
			}			
		}
    //    TEST 
		for (int g=1; g<=8; g++){       
			pole[g][3]=2;
			pole[g+1][5]=2;
		}
		        pole[5][2]=8;
                pole[6][6]=8;
                pole[5][8]=8;
                pole[4][9]=8;
                
                
        Controller ctrl = new Controller();
        for (int g=1; g<=9; g++){
		   for (int v=1; v<=9; v++){
		     System.out.print(" " + pole [v][g]);	
	         ctrl.drawBallInCell(g, v, BallColor.getColorByNum(pole[g][v]));
   		   } System.out.println("");		
	    } System.out.println("");
			
	}
	
	
	public void findingPath(){		

	}

}