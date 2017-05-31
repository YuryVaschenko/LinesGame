package by.game.backend;

import java.util.ArrayList;
import java.util.List;

import by.game.face.BallColor;
import by.game.face.Constants;
import by.game.face.panels.CellPanel;

public class Controller {

	public Controller() {
	}

	public void drawBallInCell(int x, int y, BallColor color) {

		int cellNum = Point.getCellNumber(x, y);
		CellPanel cell = Constants.listOfCellPanels.get(cellNum);
		cell.drawImage(color);

	}

	public List<Integer> cleanUpDirectionUpLeftDownRight(int cellNumber, BallColor color) {

		List<Integer> listOfBalls = new ArrayList<>();
		Point point = Point.getPointCoordsByNum(cellNumber);

		while (point.getX() - 1 > 0 && point.getY() - 1 > 0) {
			if (Constants.listOfCellPanels.get(Point.getCellNumber(point.getX() - 1, point.getY() - 1))
					.getCellBallColor().name() == color.name()) {
				listOfBalls.add(Point.getCellNumber(point.getX() - 1, point.getY() - 1));
				point.setX(point.getX() - 1);
				point.setY(point.getY() - 1);
			} else {
				break;
			}
		}

		point = Point.getPointCoordsByNum(cellNumber);

		while (point.getX() + 1 < 10 && point.getY() + 1 < 10) {
			if (Constants.listOfCellPanels.get(Point.getCellNumber(point.getX() + 1, point.getY() + 1))
					.getCellBallColor().name() == color.name()) {
				listOfBalls.add(Point.getCellNumber(point.getX() + 1, point.getY() + 1));
				point.setX(point.getX() + 1);
				point.setY(point.getY() + 1);
			} else {
				break;
			}
		}

		if (listOfBalls.size() < 4) {
			listOfBalls.clear();
		}

		return listOfBalls;

	}

	public List<Integer> cleanUpDirectionUpRightDownLeft(int cellNumber, BallColor color) {

		List<Integer> listOfBalls = new ArrayList<>();
		Point point = Point.getPointCoordsByNum(cellNumber);

		while (point.getX() + 1 < 10 && point.getY() - 1 > 0) {
			if (Constants.listOfCellPanels.get(Point.getCellNumber(point.getX() + 1, point.getY() - 1))
					.getCellBallColor().name() == color.name()) {
				listOfBalls.add(Point.getCellNumber(point.getX() + 1, point.getY() - 1));
				point.setX(point.getX() + 1);
				point.setY(point.getY() - 1);
			} else {
				break;
			}
		}

		point = Point.getPointCoordsByNum(cellNumber);

		while (point.getX() - 1 > 0 && point.getY() + 1 < 10) {
			if (Constants.listOfCellPanels.get(Point.getCellNumber(point.getX() - 1, point.getY() + 1))
					.getCellBallColor().name() == color.name()) {
				listOfBalls.add(Point.getCellNumber(point.getX() - 1, point.getY() + 1));
				point.setX(point.getX() - 1);
				point.setY(point.getY() + 1);
			} else {
				break;
			}
		}
		;
		if (listOfBalls.size() < 4) {
			listOfBalls.clear();
		}

		return listOfBalls;
	}

	public List<Integer> cleanUpDirectionUpDown(int cellNumber, BallColor color) {

		List<Integer> listOfBalls = new ArrayList<>();
		Point point = Point.getPointCoordsByNum(cellNumber);

		while (point.getY() - 1 > 0) {
			if (Constants.listOfCellPanels.get(Point.getCellNumber(point.getX(), point.getY() - 1)).getCellBallColor()
					.name() == color.name()) {
				listOfBalls.add(Point.getCellNumber(point.getX(), point.getY() - 1));
				point.setY(point.getY() - 1);
			} else {
				break;
			}
		}

		point = Point.getPointCoordsByNum(cellNumber);

		while (point.getY() + 1 < 10) {
			if (Constants.listOfCellPanels.get(Point.getCellNumber(point.getX(), point.getY() + 1)).getCellBallColor()
					.name() == color.name()) {
				listOfBalls.add(Point.getCellNumber(point.getX(), point.getY() + 1));
				point.setY(point.getY() + 1);
			} else {
				break;
			}
		}

		if (listOfBalls.size() < 4) {
			listOfBalls.clear();
		}

		return listOfBalls;

	}

	public List<Integer> cleanUpDirectionLeftRight(int cellNumber, BallColor color) {

		List<Integer> listOfBalls = new ArrayList<>();
		Point point = Point.getPointCoordsByNum(cellNumber);

		while (point.getX() - 1 > 0) {
			if (Constants.listOfCellPanels.get(Point.getCellNumber(point.getX() - 1, point.getY())).getCellBallColor()
					.name() == color.name()) {
				listOfBalls.add(Point.getCellNumber(point.getX() - 1, point.getY()));
				point.setX(point.getX() - 1);
			} else {
				break;
			}
		}

		point = Point.getPointCoordsByNum(cellNumber);

		while (point.getX() + 1 < 10) {
			if (Constants.listOfCellPanels.get(Point.getCellNumber(point.getX() + 1, point.getY())).getCellBallColor()
					.name() == color.name()) {
				listOfBalls.add(Point.getCellNumber(point.getX() + 1, point.getY()));
				point.setX(point.getX() + 1);
			} else {
				break;
			}
		}

		if (listOfBalls.size() < 4) {
			listOfBalls.clear();
		}

		return listOfBalls;

	}
}
