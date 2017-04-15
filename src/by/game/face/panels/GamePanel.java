package by.game.face.panels;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import by.game.face.BallColor;
import by.game.face.PanelsCoords;
import by.game.face.StaticVars;
import by.game.logic.GameController;
import by.game.logic.PathHandler;

public class GamePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public GamePanel() {

		PanelsCoords coords = new PanelsCoords();
		setBounds(coords.getCenterPanelDimention().width, coords.getCenterPanelDimention().height,
				StaticVars.WIDTH_GAME_PANEL, StaticVars.HEIGHT_GAME_PANEL);
		setLayout(null);
		setBorder(BorderFactory.createSoftBevelBorder(0));
		setVisible(true);

		fillPanel();

	}

	private void fillPanel() {

		int num = 0;

		for (int i = 4; i < StaticVars.WIDTH_GAME_PANEL; i += 57) {
			for (int j = 4; j < StaticVars.HEIGHT_GAME_PANEL; j += 57) {
				CellPanel cp = new CellPanel();
				cp.setBounds(j, i, 55, 55);
				cp.setBorder(BorderFactory.createEtchedBorder());
				cp.setCellNum(num);
				StaticVars.listOfCellPanels.add(cp);
				add(cp);
				num++;

				cp.addMouseListener(new MouseAdapter() {

					@Override
					public void mousePressed(MouseEvent e) {

						GameController gmctr = new GameController();
						PathHandler pathHandler = new PathHandler();
						List<Integer> ballPath;
						
						if (StaticVars.path.isEmpty() && cp.getStatus() != 0) {
							StaticVars.path.add(cp.getCellNum());
							pathHandler.fillingFieldToGetShortestPath(cp.getCellNum());
							StaticVars.tmpColor = cp.getCellBallColor();
							cp.drawImage(BallColor.ANGRY);
						} else {
							if (!StaticVars.path.isEmpty() && cp.getStatus() != 0) {
								StaticVars.listOfCellPanels.get(StaticVars.path.get(0)).drawImage(StaticVars.tmpColor);
								StaticVars.path.set(0, cp.getCellNum());
								pathHandler.fillingFieldToGetShortestPath(cp.getCellNum());
								StaticVars.tmpColor = cp.getCellBallColor();
								cp.drawImage(BallColor.ANGRY);
							} else {
								if (!StaticVars.path.isEmpty() && cp.getStatus() == 0 && pathHandler.isPathExists(cp.getCellNum())) {
								
									ballPath = pathHandler.findingShortesrWay(cp.getCellNum());
									new Thread(new Runnable() {
										
										@Override
										public void run() {
											for(int i = ballPath.size() - 1; i > 0; i--){
												StaticVars.listOfCellPanels.get(ballPath.get(i)).drawImage(StaticVars.tmpColor);
												try {
													Thread.sleep(40);
												} catch (InterruptedException e1) {
													e1.printStackTrace();
												}
												StaticVars.listOfCellPanels.get(ballPath.get(i)).drawImage(BallColor.EMPTY);
											}
											cp.drawImage(StaticVars.tmpColor);
											if(!gmctr.checkForCleanUpBalls(cp.getCellNum())){
												gmctr.addBallsByCount(3);
											}
											
											StaticVars.path.clear();
										}
									}).start();
									
								}
							}
						}
						

					}

				});
			}
		}

	}

}
