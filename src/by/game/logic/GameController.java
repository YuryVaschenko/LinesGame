package by.game.logic;

import java.util.ArrayList;
import java.util.List;

import by.game.face.BallColor;
import by.game.face.StaticVars;
import by.game.face.panels.CellPanel;
import by.game.face.panels.ScorePanel;

public class GameController {

	public void refreshField() {
		for (CellPanel cp : StaticVars.listOfCellPanels) {
			cp.refreshStatus();
			cp.drawImage(BallColor.EMPTY);
		}
	}

	public void addBallsByCount(int count) {

		int tmp = 0;
		for (CellPanel cp : StaticVars.listOfCellPanels) {
			if (cp.getStatus() == 0) {
				tmp++;
			}
			
		}

		if (tmp < count) {
			count = tmp;
		}

		int x = 0;
		int y = 0;
		int num = 0;
		tmp = 0;

		while (tmp < count) {
			x = (int) ((Math.random() * StaticVars.GRID_ROWS_COUNT) + 1);
			y = (int) ((Math.random() * StaticVars.GRID_COLS_COUNT) + 1);
			num = Point.getCellNumber(x, y);
			if (StaticVars.listOfCellPanels.get(num).getStatus() == 0) {
				StaticVars.listOfCellPanels.get(num).drawImage(StaticVars.listOfNewBallsPanels.get(tmp).getCellBallColor());
				StaticVars.listOfNewBallsPanels.get(tmp).drawImage(BallColor.EMPTY);
				tmp++;
				checkForCleanUpBalls(num);
			}
			
		}

		for (int i = 0; i < 3; i++) {
			StaticVars.listOfNewBallsPanels.get(i).drawImage(BallColor.randomColor());
		}
		
		

	}

	public boolean checkForCleanUpBalls(int cellNumber) {

		Controller ctler = new Controller();
		boolean success = false;
		List<Integer> listBallsForCleanUp = new ArrayList<>();
		BallColor color = StaticVars.listOfCellPanels.get(cellNumber).getCellBallColor();

		listBallsForCleanUp.add(cellNumber);
		listBallsForCleanUp.addAll(ctler.cleanUpDirectionUpLeftDownRight(cellNumber, color));
		listBallsForCleanUp.addAll(ctler.cleanUpDirectionUpRightDownLeft(cellNumber, color));
		listBallsForCleanUp.addAll(ctler.cleanUpDirectionUpDown(cellNumber, color));
		listBallsForCleanUp.addAll(ctler.cleanUpDirectionLeftRight(cellNumber, color));

		if (listBallsForCleanUp.size() > 4){
			ScorePanel.increaseCountByNum(listBallsForCleanUp.size());
			while (!listBallsForCleanUp.isEmpty()){
				StaticVars.listOfCellPanels.get(listBallsForCleanUp.remove(0)).drawImage(BallColor.EMPTY);
			}
			success = true;
		} 
		
		
		return success;
		

	}

}
