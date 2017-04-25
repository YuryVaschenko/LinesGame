package by.game.face.panels;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import by.game.face.BallColor;
import by.game.face.StaticVars;

public class NewBallsPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public NewBallsPanel() {

		setBounds(185, 14, StaticVars.WIDTH_NEWBALLS_PANEL, StaticVars.HEIGHT_NEWBALLS_PANEL);
		setLayout(null);
		setBorder(BorderFactory.createSoftBevelBorder(0));
		
		fillPanel();
		
		setVisible(true);

	}

	private void fillPanel() {
		
		for (int i = 4; i < StaticVars.HEIGHT_NEWBALLS_PANEL; i += 57) {
			for (int j = 4; j < StaticVars.WIDTH_NEWBALLS_PANEL; j += 57) {
				CellPanel cp = new CellPanel();
				cp.setBounds(j, i, 55, 55);
				cp.setBorder(BorderFactory.createEtchedBorder());
				cp.drawImage(BallColor.randomColor());
				StaticVars.listOfNewBallsPanels.add(cp);
				add(cp);
			}
		}
		
		
	}

}
