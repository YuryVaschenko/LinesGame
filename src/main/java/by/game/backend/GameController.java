package by.game.backend;

import java.util.ArrayList;
import java.util.List;

import by.game.backend.records.Record;
import by.game.backend.records.RecordsFileHandling;
import by.game.backend.records.RecordsIOHandlingInterface;
import by.game.face.BallColor;
import by.game.face.Constants;
import by.game.face.panels.CellPanel;
import by.game.face.panels.MainPanel;
import by.game.face.panels.ScorePanel;

public class GameController {

	public void refreshField() {
		for (CellPanel cp : Constants.listOfCellPanels) {
			cp.stopBallAnimation();
			cp.refreshStatus();
			cp.drawImage(BallColor.EMPTY);
		}
	}

	public void addBallsByCount(int count) {

		RecordsIOHandlingInterface recordsHandling = new RecordsFileHandling();

		int tmp = 0;
		for (CellPanel cp : Constants.listOfCellPanels) {
			if (cp.getStatus() == 0) {
				tmp++;
			}
		}

		if (tmp <= count) {
			count = tmp;
			MainPanel.stepBackButton.setEnabled(false);
			for (int i = 0; i < Constants.listOfRecords.size(); i++) {
				if (ScorePanel.getScoreValue() > Constants.listOfRecords.get(i).getScore()) {
					Constants.listOfRecords.add(i, new Record("dummy", ScorePanel.getScoreValue()));
					Constants.listOfRecords.remove(Constants.listOfRecords.size() - 1);
					recordsHandling.writeRecords(Constants.listOfRecords);
					break;
				}
			}

		}

		int x = 0;
		int y = 0;
		int num = 0;
		tmp = 0;

		while (tmp < count) {
			x = (int) ((Math.random() * Constants.GRID_ROWS_COUNT) + 1);
			y = (int) ((Math.random() * Constants.GRID_COLS_COUNT) + 1);
			num = Point.getCellNumber(x, y);
			if (Constants.listOfCellPanels.get(num).getStatus() == 0) {
				Constants.listOfCellPanels.get(num)
						.drawImage(Constants.listOfNewBallsPanels.get(tmp).getCellBallColor());
				Constants.listOfNewBallsPanels.get(tmp).drawImage(BallColor.EMPTY);
				tmp++;
				checkForCleanUpBalls(num);
			}

		}

		for (int i = 0; i < 3; i++) {
			Constants.listOfNewBallsPanels.get(i).drawImage(BallColor.randomColor());
		}

	}

	public boolean checkForCleanUpBalls(int cellNumber) {

		Controller ctler = new Controller();
		boolean success = false;
		List<Integer> listBallsForCleanUp = new ArrayList<>();
		BallColor color = Constants.listOfCellPanels.get(cellNumber).getCellBallColor();

		listBallsForCleanUp.add(cellNumber);
		listBallsForCleanUp.addAll(ctler.cleanUpDirectionUpLeftDownRight(cellNumber, color));
		listBallsForCleanUp.addAll(ctler.cleanUpDirectionUpRightDownLeft(cellNumber, color));
		listBallsForCleanUp.addAll(ctler.cleanUpDirectionUpDown(cellNumber, color));
		listBallsForCleanUp.addAll(ctler.cleanUpDirectionLeftRight(cellNumber, color));

		if (listBallsForCleanUp.size() >= 6) {
			MainPanel.increaseStepBackCount();
			MainPanel.stepBackButton.setEnabled(true);
		}
		if (listBallsForCleanUp.size() >= 5) {
			Constants.STEP_BACK_COUNT_TO_DECREASE_SCORE = listBallsForCleanUp.size();
			ScorePanel.increaseScoreByNum(listBallsForCleanUp.size());
			while (!listBallsForCleanUp.isEmpty()) {
				Constants.listOfCellPanels.get(listBallsForCleanUp.remove(0)).drawImage(BallColor.EMPTY);
			}
			success = true;
		} else {
			Constants.STEP_BACK_COUNT_TO_DECREASE_SCORE = 0;
		}

		return success;

	}

}
