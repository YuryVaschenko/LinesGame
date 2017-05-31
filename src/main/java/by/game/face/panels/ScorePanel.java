package by.game.face.panels;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import by.game.face.Constants;

public class ScorePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private static int scoreValue = 0;
	private static JLabel recordText;
	private static JLabel scoreText;
	
	
	public ScorePanel() {

		setLayout(null);
		setBounds(15, 15, Constants.WIDTH_SCORE_PANEL, Constants.HEIGHT_SCORE_PANEL);
		setBorder(BorderFactory.createEtchedBorder());
		recordText = new JLabel("<html><font size=3 color=red>Record: " + Constants.listOfRecords.get(0).getScore());
		recordText.setBounds(15,-20, 170, 70);
		scoreText = new JLabel("<html><font size=5 color=green>Score: " + scoreValue);
		scoreText.setBounds(15, 5, 170, 70);
		
		add(recordText);
		add(scoreText);
		
		setVisible(true);
		
		
		
	}
	
	public static void increaseScoreByNum(int num){
		scoreText.setText("<html><font size=5 color=green>Score: " + (scoreValue+=num));
		if(scoreValue > Constants.listOfRecords.get(0).getScore()){
			setRecord(scoreValue);
		}
		
	}
	
	public static void decreaseScoreByNum(int num){
		scoreText.setText("<html><font size=5 color=green>Score: " + (scoreValue-=num));
	}
	
	public static void resetScore(){ 
		scoreText.setText("<html><font size=5 color=green>Score: " + 0);
		scoreValue = 0;
	}

	public static void setRecord(int num){
		recordText.setText("<html><font size=3 color=red>Record: " + num);
	}
	
	public static int getScoreValue(){
	 return scoreValue;
	}
		
	public static void refreshRecord(){
		recordText.setText("<html><font size=3 color=red>Record: " + Constants.listOfRecords.get(0).getScore());
	}

	
	
}
