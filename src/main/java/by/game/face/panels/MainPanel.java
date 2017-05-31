package by.game.face.panels;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import by.game.face.Constants;

public class MainPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	public static JButton stepBackButton;

	public MainPanel() {

		setLayout(null);
		setVisible(true);

		ScorePanel spanel = new ScorePanel();
		GamePanel gamePanel = new GamePanel();
		NewBallsPanel nbp = new NewBallsPanel();
		HighscoresPanel recordsPanel = new HighscoresPanel();
		// recordsPanel.setVisible(false);
		gamePanel.setVisible(false);

		/*
		 * JButton addBallsButton = new JButton("+");
		 * addBallsButton.setToolTipText("Add balls");
		 * addBallsButton.setMargin(new Insets(-1, 1, 0, 0));
		 * addBallsButton.setBounds(375, 17, 25, 25);
		 * addBallsButtonListener(addBallsButton);
		 */

		stepBackButton = new JButton();
		stepBackButton.setEnabled(false);
		stepBackButton.setToolTipText("Step back");
		stepBackButton.setMargin(new Insets(-1, 1, 0, 0));
		stepBackButton.setBounds(375, 48, 50, 25);
		stepBackButtonListener(stepBackButton);

		add(recordsPanel);
		add(spanel);
		add(gamePanel);
		add(nbp);
		// add(addBallsButton);
		add(stepBackButton);

	}

	public static void increaseStepBackCount() {
		stepBackButton.setText("< " + (++Constants.STEP_BACK_COUNT));
	}

	private void stepBackButtonListener(JButton stepBackButton) {

		stepBackButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				for (int i = 0; i < Constants.stepBackFieldBallsColorList.size(); i++) {

					Constants.listOfCellPanels.get(i).drawImage(Constants.stepBackFieldBallsColorList.get(i));
					Constants.listOfCellPanels.get(i).stopBallAnimation();
				}
				for (int i = 0; i < Constants.stepBackNewBallsColorList.size(); i++) {
					Constants.listOfNewBallsPanels.get(i).drawImage(Constants.stepBackNewBallsColorList.get(i));
				}
				ScorePanel.decreaseScoreByNum(Constants.STEP_BACK_COUNT_TO_DECREASE_SCORE);
				stepBackButton.setEnabled(false);
				Constants.selectionBallHandling.clear();
				Constants.STEP_BACK_COUNT--;
				stepBackButton.setText("< " + Constants.STEP_BACK_COUNT);
			}
		});

	}

	/*
	 * private void addBallsButtonListener(JButton addBallsButton) {
	 * 
	 * addBallsButton.addActionListener(new ActionListener() {
	 * 
	 * @Override public void actionPerformed(ActionEvent e) {
	 * 
	 * GameController gcon = new GameController(); gcon.addBallsByCount(3);
	 * 
	 * } });
	 * 
	 * }
	 */

}
