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
import by.game.face.Constants;

public class GamePanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private MouseListener listener;
    private static GamePanel gamePanel;
    private BallColor tmpColor;

    public GamePanel() {

        setBounds(15, 110, Constants.WIDTH_GAME_PANEL, Constants.HEIGHT_GAME_PANEL);
        setLayout(null);
        setBorder(BorderFactory.createSoftBevelBorder(0));
        setVisible(true);
        gamePanel = this;

        addCellsListener();
        fillPanel();

    }

    public static void hidePanel() {
        if (gamePanel != null) {
            gamePanel.setVisible(false);
        }
    }

    public static void showPanel() {
        if (gamePanel != null) {
            gamePanel.setVisible(true);
        }
    }

    private void fillPanel() {

        int num = 0;

        for (int i = 4; i < Constants.WIDTH_GAME_PANEL; i += 57) {
            for (int j = 4; j < Constants.HEIGHT_GAME_PANEL; j += 57) {
                CellPanel cp = new CellPanel();
                cp.setBounds(j, i, 55, 55);
                cp.setLayout(null);
                cp.setBorder(BorderFactory.createEtchedBorder());
                cp.setCellNum(num);
                Constants.listOfCellPanels.add(cp);
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

                if (Constants.selectionBallHandling.isEmpty() && cp.getStatus() != 0) {
                    Constants.selectionBallHandling.add(cp.getCellNum());
                    pathHandler.fillingFieldToGetShortestPath(cp.getCellNum());
                    tmpColor = cp.getCellBallColor();
                    cp.startBallAnimation();

                } else {
                    if (!Constants.selectionBallHandling.isEmpty() && cp.getStatus() != 0) {
                        Constants.listOfCellPanels.get(Constants.selectionBallHandling.get(0)).stopBallAnimation();
                        Constants.selectionBallHandling.set(0, cp.getCellNum());
                        pathHandler.fillingFieldToGetShortestPath(cp.getCellNum());
                        tmpColor = cp.getCellBallColor();
                        cp.startBallAnimation();
                    } else {
                        if (!Constants.selectionBallHandling.isEmpty() && cp.getStatus() == 0
                                && pathHandler.isPathExists(cp.getCellNum())) {
                            // step back staff
                            Constants.stepBackFieldBallsColorList.clear();
                            for (CellPanel cell : Constants.listOfCellPanels) {
                                Constants.stepBackFieldBallsColorList.add(cell.getCellBallColor());
                            }
                            Constants.stepBackNewBallsColorList.clear();
                            for (int i = 0; i < 3; i++) {
                                Constants.stepBackNewBallsColorList
                                        .add(Constants.listOfNewBallsPanels.get(i).getCellBallColor());
                            }
                            if (Constants.STEP_BACK_COUNT > 0) {
                                MainPanel.stepBackButton.setEnabled(true);
                            }
                            // --------
                            Constants.listOfCellPanels.get(Constants.selectionBallHandling.get(0)).stopBallAnimation();
                            ballPath = pathHandler.findingShortestPath(cp.getCellNum());

                            new Thread(() -> {
                                for (int i = ballPath.size() - 1; i > 0; i--) {
                                    Constants.listOfCellPanels.get(ballPath.get(i)).drawImage(tmpColor);
                                    try {
                                        Thread.sleep(40);
                                    } catch (InterruptedException ex) {
                                        ex.printStackTrace();
                                    }
                                    Constants.listOfCellPanels.get(ballPath.get(i)).drawImage(BallColor.EMPTY);
                                }
                                cp.drawImage(tmpColor);
                                try {
                                    Thread.sleep(80);
                                } catch (InterruptedException ex) {
                                    ex.printStackTrace();
                                }
                                if (!gmctr.checkForCleanUpBalls(cp.getCellNum())) {
                                    gmctr.addBallsByCount(3);
                                }
                            }).start();

                            Constants.selectionBallHandling.clear();

                        }
                    }
                }

            }

        };

    }

}
