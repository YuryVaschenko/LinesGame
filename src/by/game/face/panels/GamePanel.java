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
import by.game.face.StaticVars;

public class GamePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private MouseListener listener;

	public GamePanel() {

		setBounds(15, 110, StaticVars.WIDTH_GAME_PANEL, StaticVars.HEIGHT_GAME_PANEL);
		setLayout(null);
		setBorder(BorderFactory.createSoftBevelBorder(0));
		setVisible(true);

		addCellsListener();
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
				cp.addMouseListener(listener);
			}
		}

	}

	private void addCellsListener() {

		listener = new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {

				GameController gmctr = new GameController();
				PathHandler pathHandler = new PathHandler();
				CellPanel cp = (CellPanel) e.getComponent();
				List<Integer> ballPath;

				if (StaticVars.selectBallLogicPath.isEmpty() && cp.getStatus() != 0) {
					StaticVars.selectBallLogicPath.add(cp.getCellNum());
					pathHandler.fillingFieldToGetShortestPath(cp.getCellNum());
					StaticVars.tmpColor = cp.getCellBallColor();
					cp.drawImage(BallColor.ANGRY);
				} else {
					if (!StaticVars.selectBallLogicPath.isEmpty() && cp.getStatus() != 0) {
						StaticVars.listOfCellPanels.get(StaticVars.selectBallLogicPath.get(0)).drawImage(StaticVars.tmpColor);
						StaticVars.selectBallLogicPath.set(0, cp.getCellNum());
						pathHandler.fillingFieldToGetShortestPath(cp.getCellNum());
						StaticVars.tmpColor = cp.getCellBallColor();
						cp.drawImage(BallColor.ANGRY);
					} else {
						if (!StaticVars.selectBallLogicPath.isEmpty() && cp.getStatus() == 0
								&& pathHandler.isPathExists(cp.getCellNum())) {
							// step back staff
							StaticVars.stapBackFieldBallsColorList.clear();
							for (CellPanel cell : StaticVars.listOfCellPanels) {
								if (cell.getCellBallColor() == BallColor.ANGRY) {
									StaticVars.stapBackFieldBallsColorList.add(StaticVars.tmpColor);
								} else {
									StaticVars.stapBackFieldBallsColorList.add(cell.getCellBallColor());
								}
							}
							StaticVars.stapBackNewBallsColorList.clear();
							for (int i = 0; i < 3; i++) {
								StaticVars.stapBackNewBallsColorList
										.add(StaticVars.listOfNewBallsPanels.get(i).getCellBallColor());
							}
							if(StaticVars.STEP_BACK_COUNT > 0){
								MainPanel.stepBackButton.setEnabled(true);
							}
							// -----
							ballPath = pathHandler.findingShortesrWay(cp.getCellNum());
							new Thread(new Runnable() {

								@Override
								public void run() {

									for (int i = ballPath.size() - 1; i > 0; i--) {
										StaticVars.listOfCellPanels.get(ballPath.get(i)).drawImage(StaticVars.tmpColor);
										try {
											Thread.sleep(40);
										} catch (InterruptedException e) {
											e.printStackTrace();
										}
										StaticVars.listOfCellPanels.get(ballPath.get(i)).drawImage(BallColor.EMPTY);
									}
									cp.drawImage(StaticVars.tmpColor);
									try {
										Thread.sleep(80);
									} catch (InterruptedException e) {
										e.printStackTrace();
									}
									if (!gmctr.checkForCleanUpBalls(cp.getCellNum())) {
										gmctr.addBallsByCount(3);
									}

								}
							}).start();
							StaticVars.selectBallLogicPath.clear();

						}
					}
				}

			}

		};

	}

}
