package by.game.face.panels;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import by.game.face.StaticVars;

public class ScorePanel extends JPanel {

	private static final long serialVersionUID = 1L;


	private static int textCount = 0;
	private static JLabel recordText;
	private static JLabel scoreText;
	
	
	public ScorePanel() {

		setLayout(null);
		setBounds(15, 15, StaticVars.WIDTH_SCORE_PANEL, StaticVars.HEIGHT_SCORE_PANEL);
		setBorder(BorderFactory.createEtchedBorder());
		recordText = new JLabel("<html><font size=3 color=red>Record: "+ "\t" + StaticVars.RECORD_TEXT);
		recordText.setBounds(15,-20, 170, 70);
		scoreText = new JLabel("<html><font size=5 color=green>Score: " + textCount);
		scoreText.setBounds(15, 5, 170, 70);
		
		
		add(recordText);
		add(scoreText);
		
		setVisible(true);
		
		
		
	}
	
	public static void increaseCountByNum(int num){
		scoreText.setText("<html><font size=5 color=green>Score: " + (textCount+=num));
	}
	
	public static void decreaseCountByNum(int num){
		scoreText.setText("<html><font size=5 color=green>Score: " + (textCount-=num));
	}
	
	public static void setCount(int count){
		textCount = count; 
		scoreText.setText("<html><font size=5 color=green>Score: " + textCount);
	}


	
	
}
