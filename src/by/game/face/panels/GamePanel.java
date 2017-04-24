package by.game.face.panels;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import by.game.backend.GameController;
import by.game.backend.PathHandler;
import by.game.face.BallColor;
import by.game.face.PanelsCoords;
import by.game.face.StaticVars;

public class GamePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private MouseListener listener;
	Thread movingBallThread;

	public GamePanel() {

		PanelsCoords coords = new PanelsCoords();
		setBounds(coords.getCenterPanelDimention().width, coords.getCenterPanelDimention().height,
				StaticVars.WIDTH_GAME_PANEL, StaticVars.HEIGHT_GAME_PANEL);
		setLayout(null);
		setBorder(BorderFactory.createSoftBevelBorder(0));
		setVisible(true);

		addCellsListener();
		fillPanel();

	}

	private void addCellsListener() {

		listener = new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {

				GameController gmctr = new GameController();
				PathHandler pathHandler = new PathHandler();
				CellPanel cp = (CellPanel) e.getComponent();
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
						if (!StaticVars.path.isEmpty() && cp.getStatus() == 0
								&& pathHandler.isPathExists(cp.getCellNum())) {

							ballPath = pathHandler.findingShortesrWay(cp.getCellNum());
							movingBallThread = new Thread(new Runnable() {

								@Override
								public void run() {

									for (int i = ballPath.size() - 1; i > 0; i--) {
										StaticVars.listOfCellPanels.get(ballPath.get(i)).drawImage(StaticVars.tmpColor);
										try {
											Thread.sleep(35);
										} catch (InterruptedException e) {
											e.printStackTrace();
										}
										StaticVars.listOfCellPanels.get(ballPath.get(i)).drawImage(BallColor.EMPTY);
									}
									cp.drawImage(StaticVars.tmpColor);
									try {
										Thread.sleep(100);
									} catch (InterruptedException e) {
										e.printStackTrace();
									}
									if (!gmctr.checkForCleanUpBalls(cp.getCellNum())) {
										gmctr.addBallsByCount(3);
									}

								}
							});
							movingBallThread.start();
							StaticVars.path.clear();

						}
					}
				}

			}

		};

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
				cp.addMouseListener(listener);
			}
		}

	}

}
