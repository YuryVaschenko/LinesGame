package by.game.face.panels;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import by.game.face.BallColor;
import by.game.face.Constants;

public class NewBallsPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public NewBallsPanel() {

		setBounds(185, 14, Constants.WIDTH_NEWBALLS_PANEL, Constants.HEIGHT_NEWBALLS_PANEL);
		setLayout(null);
		setBorder(BorderFactory.createSoftBevelBorder(0));
		
		fillPanel();
		
		setVisible(true);

	}

	private void fillPanel() {
		
		for (int i = 4; i < Constants.HEIGHT_NEWBALLS_PANEL; i += 57) {
			for (int j = 4; j < Constants.WIDTH_NEWBALLS_PANEL; j += 57) {
				CellPanel cp = new CellPanel();
				cp.setBounds(j, i, 55, 55);
				cp.setBorder(BorderFactory.createEtchedBorder());
				cp.drawImage(BallColor.randomColor());
				Constants.listOfNewBallsPanels.add(cp);
				add(cp);
			}
		}
		
		
	}

}
