package by.game.face.panels;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import by.game.face.PanelsCoords;
import by.game.face.StaticVars;

public class ScorePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private Dimension dim;
	private static int textCount = 0;
	private static JLabel text = new JLabel("<html><font size=8 color=green>" + textCount);
	
	public ScorePanel() {
		
		PanelsCoords coords = new PanelsCoords();
		dim = coords.getScorePanelDimention();

		setBounds(dim.width, dim.height, StaticVars.WIDTH_SCORE_PANELS, StaticVars.HEIGHT_SCORE_PANELS);
		setBorder(BorderFactory.createEtchedBorder());
		
		add(text);
		
		setVisible(true);
		
		
	}
	
	public static void increaseCountByNum(int num){
		text.setText("<html><font size=8 color=green>" + (textCount+=num));
	}
	
	public static void setCount(int count){
		textCount = count; 
		text.setText("<html><font size=8 color=green>" + textCount);
	}


	
	
}
