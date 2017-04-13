package by.game.face.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import by.game.face.PanelsCoords;
import by.game.logic.GameController;

public class MainPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public MainPanel() {

		setLayout(null);
		setVisible(true);

		BestScorePanel bspanel = new BestScorePanel();
		ScorePanel spanel = new ScorePanel();
		GamePanel gamePanel = new GamePanel();
		NewBallsPanel nbp = new NewBallsPanel();

		PanelsCoords ipc = new PanelsCoords();
		JButton addBallsButton = new JButton("Abb Balls");
		addBallsButton.setBounds(ipc.getScreenSize().width / 2 + 350, 150, 100, 40);
		addButtonListener(addBallsButton);

		add(bspanel);
		add(spanel);
		add(gamePanel);
		add(nbp);
		add(addBallsButton);

	}

	private void addButtonListener(JButton addBallsButton) {

		addBallsButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				GameController gcon = new GameController();
				gcon.addBallsByCount(3);

			}
		});

	}

}
