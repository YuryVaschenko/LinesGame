package by.game.face.panels;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import by.game.face.PanelsCoords;
import by.game.face.StaticVars;

public class BestScorePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	Dimension dim;

	public BestScorePanel() {

		PanelsCoords coords = new PanelsCoords();
		dim = coords.getBestScorePanelDimention();

		setBounds(dim.width, dim.height, StaticVars.WIDTH_SCORE_PANELS, StaticVars.HEIGHT_SCORE_PANELS);
		setBorder(BorderFactory.createEtchedBorder());

		fillPanel();

		setVisible(true);
	}

	private void fillPanel() {

		//InitialPanelsCoords ipcoords = new InitialPanelsCoords();
		//int x = ipcoords.getCenterPanelDimention().width;
		//int y = ipcoords.getCenterPanelDimention().height;
		JLabel text = new JLabel("<html><font size=10 color=green>" + StaticVars.RECORD_PANEL);
		
		add(text);

	}

}
