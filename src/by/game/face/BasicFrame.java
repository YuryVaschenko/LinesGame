package by.game.face;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.WindowConstants;

import by.game.backend.GameController;
import by.game.face.panels.GamePanel;
import by.game.face.panels.MainPanel;
import by.game.face.panels.RecordsPanel;
import by.game.face.panels.ScorePanel;

public class BasicFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public BasicFrame() {

		super("Lines ver 0.7");

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(385, 30, 550, 690);
		Container container = getContentPane();
		setVisible(true);

		createMenu();

		MainPanel mainPanel = new MainPanel();
		container.add(mainPanel);
	}

	private void createMenu() {
		JMenuBar menu = new JMenuBar();
		JMenu basicMenu = new JMenu("Menu");

		for (String menuItem : new String[] { "New game", "Records", "Exit" }) {
			JMenuItem item = new JMenuItem(menuItem);
			item.setActionCommand(menuItem.toLowerCase());
			item.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String command = e.getActionCommand();
					if ("new game".equals(command)) {
						GameController mc = new GameController();
						mc.refreshField();
						ScorePanel.resetScore();
						ScorePanel.refreshRecord();
						mc.addBallsByCount(3);
						Constants.STEP_BACK_COUNT = 5;
						MainPanel.stepBackButton.setText("< " + Constants.STEP_BACK_COUNT);
						MainPanel.stepBackButton.setEnabled(false);
						GamePanel.showPanel();
						RecordsPanel.hidePanel();

					}
					if ("records".equals(command)) {
						GamePanel.hidePanel();
						RecordsPanel.showPanel();
					}
					if ("exit".equals(command)) {
						System.exit(0);
					}
				}
			});

			basicMenu.add(item);
		}
		basicMenu.insertSeparator(2);
		menu.add(basicMenu);
		setJMenuBar(menu);
	}

}
