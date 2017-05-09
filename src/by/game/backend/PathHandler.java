package by.game.backend;

import java.util.ArrayList;
import java.util.List;

import by.game.face.Constants;

public class PathHandler {

	public void fillingFieldToGetShortestPath(int start) {

		int arrayWidth = Constants.GRID_ROWS_COUNT + 2;
		int arrayHeight = Constants.GRID_COLS_COUNT + 2;
		List<Integer> xCoords = new ArrayList<>();
		List<Integer> yCoords = new ArrayList<>();
		Point startPoint = Point.getPointCoordsByNum(start);

		xCoords.add(startPoint.getX());
		yCoords.add(startPoint.getY());

		int index = 0;

		for (int i = 0; i < arrayWidth; i++) {
			for (int j = 0; j < arrayHeight; j++) {
				Constants.fieldArrayToPathHandling[i][j] = -1;
			}
		}

		for (int i = 1; i < arrayWidth - 1; i++) {
			for (int j = 1; j < arrayHeight - 1; j++) {
				if (Constants.listOfCellPanels.get(index).getStatus() == 0) {
					Constants.fieldArrayToPathHandling[i][j] = 0;
				}
				index++;
			}
		}

		Constants.fieldArrayToPathHandling[startPoint.getY()][startPoint.getX()] = 1;

		while (xCoords.size() > 0) {
			findingNeighboursFillTheField(xCoords, yCoords);
		}

	}

	private void findingNeighboursFillTheField(List<Integer> xCoords, List<Integer> yCoords) {

		int x = xCoords.remove(0);
		int y = yCoords.remove(0);

		if (Constants.fieldArrayToPathHandling[y + 1][x] == 0) {
			Constants.fieldArrayToPathHandling[y + 1][x] = Constants.fieldArrayToPathHandling[y][x] + 1;
			yCoords.add(y + 1);
			xCoords.add(x);
		}
		if (Constants.fieldArrayToPathHandling[y - 1][x] == 0) {
			Constants.fieldArrayToPathHandling[y - 1][x] = Constants.fieldArrayToPathHandling[y][x] + 1;
			yCoords.add(y - 1);
			xCoords.add(x);

		}
		if (Constants.fieldArrayToPathHandling[y][x + 1] == 0) {
			Constants.fieldArrayToPathHandling[y][x + 1] = Constants.fieldArrayToPathHandling[y][x] + 1;
			yCoords.add(y);
			xCoords.add(x + 1);

		}
		if (Constants.fieldArrayToPathHandling[y][x - 1] == 0) {
			Constants.fieldArrayToPathHandling[y][x - 1] = Constants.fieldArrayToPathHandling[y][x] + 1;
			yCoords.add(y);
			xCoords.add(x - 1);
		}

	}

	public List<Integer> findingShortesrWay(int end) {

		List<Integer> pathList = new ArrayList<>();
		Point endPoint = Point.getPointCoordsByNum(end);
		pathList.add(Point.getCellNumber(endPoint.getX(), endPoint.getY()));

		while (Constants.fieldArrayToPathHandling[endPoint.getY()][endPoint.getX()] != 1) {
			findingPathFromEndToStart(pathList, endPoint);
		}

		return pathList;
	}

	private void findingPathFromEndToStart(List<Integer> pathList, Point endPoint) {

		if (Constants.fieldArrayToPathHandling[endPoint.getY() + 1][endPoint.getX()] == 
				Constants.fieldArrayToPathHandling[endPoint.getY()][endPoint.getX()] - 1) {
			endPoint.setY(endPoint.getY() + 1);
			pathList.add(Point.getCellNumber(endPoint.getX(), endPoint.getY()));
		}
		if (Constants.fieldArrayToPathHandling[endPoint.getY() - 1][endPoint.getX()] == 
				Constants.fieldArrayToPathHandling[endPoint.getY()][endPoint.getX()] - 1) {
			endPoint.setY(endPoint.getY() - 1);
			pathList.add(Point.getCellNumber(endPoint.getX(), endPoint.getY()));
		}
		if (Constants.fieldArrayToPathHandling[endPoint.getY()][endPoint.getX() + 1] == 
				Constants.fieldArrayToPathHandling[endPoint.getY()][endPoint.getX()] - 1) {
			endPoint.setX(endPoint.getX() + 1);
			pathList.add(Point.getCellNumber(endPoint.getX(), endPoint.getY()));
		}
		if (Constants.fieldArrayToPathHandling[endPoint.getY()][endPoint.getX() - 1] == 
				Constants.fieldArrayToPathHandling[endPoint.getY()][endPoint.getX()] - 1) {
			endPoint.setX(endPoint.getX() - 1);
			pathList.add(Point.getCellNumber(endPoint.getX(), endPoint.getY()));
		}

	}
	
	public boolean isPathExists(int end){
		
		Point endPoint = Point.getPointCoordsByNum(end);
		
		if(Constants.fieldArrayToPathHandling[endPoint.getY()][endPoint.getX()] == 0){
			return false;
		} else {
			return true;
		}
		
	}

}
