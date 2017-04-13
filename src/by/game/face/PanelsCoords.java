package by.game.face;

import java.awt.Dimension;
import java.awt.Toolkit;

public class PanelsCoords {
	
	private Dimension screenSize;
	
	public PanelsCoords() {
		 screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	}
	
	
	public Dimension getScreenSize() {
		return screenSize;
	}
	
	public Dimension getCenterPanelDimention(){
		
		int x = (screenSize.width / 2) - (StaticVars.WIDTH_GAME_PANEL / 2);
		int y = (screenSize.height / 2) - (StaticVars.HEIGHT_GAME_PANEL / 2);
		
		return new Dimension(x, y);
	}
	
	public Dimension getBestScorePanelDimention(){
		
		int x = StaticVars.BSCORE_PANELS;
		int y = StaticVars.BSCORE_PANELS;
		
		return new Dimension(x, y);
	}
	
	public Dimension getScorePanelDimention(){
		
		PanelsCoords ipcoords = new PanelsCoords();
		
		int x = ipcoords.getScreenSize().width-StaticVars.WIDTH_SCORE_PANELS-StaticVars.BSCORE_PANELS;
		int y = StaticVars.BSCORE_PANELS;
		
		return new Dimension(x, y);
	}

	public Dimension getNewRandoBallsPanelDimention(){
		
		int x = (screenSize.width / 2) - (StaticVars.WIDTH_NEWBALLS_PANEL / 2);
		int y = (screenSize.height / 12) - (StaticVars.HEIGHT_NEWBALLS_PANEL / 2);
		
		return new Dimension(x, y);
		
	}
	
	
}
