package by.game.logic;

import java.util.ArrayList;
import java.util.List;

import by.game.face.StaticVars;

public class PathHandler {

	public void fillingFieldToGetShortestPath(int start) {

		int arrayWidth = StaticVars.GRID_ROWS_COUNT + 2;
		int arrayHeight = StaticVars.GRID_COLS_COUNT + 2;
		List<Integer> xCoords = new ArrayList<>();
		List<Integer> yCoords = new ArrayList<>();
		Point startPoint = Point.getPointCoordsByNum(start);

		xCoords.add(startPoint.getX());
		yCoords.add(startPoint.getY());

		int index = 0;

		for (int i = 0; i < arrayWidth; i++) {
			for (int j = 0; j < arrayHeight; j++) {
				StaticVars.fieldArrayToPathHandling[i][j] = -1;
			}
		}

		for (int i = 1; i < arrayWidth - 1; i++) {
			for (int j = 1; j < arrayHeight - 1; j++) {
				if (StaticVars.listOfCellPanels.get(index).getStatus() == 0) {
					StaticVars.fieldArrayToPathHandling[i][j] = 0;
				}
				index++;
			}
		}

		StaticVars.fieldArrayToPathHandling[startPoint.getY()][startPoint.getX()] = 1;
		
		while (xCoords.size() > 0) {
			findingNeighboursFillTheField(xCoords, yCoords);
		}

		/*for (int i = 0; i < arrayWidth; i++) {
			for (int j = 0; j < arrayHeight; j++) {
				System.out.print(StaticVars.fieldArrayToPathHandling[i][j] + " ");
			}
			System.out.println();
		}*/

	}

	private void findingNeighboursFillTheField(List<Integer> xCoords, List<Integer> yCoords) {

		int x = xCoords.remove(0);
		int y = yCoords.remove(0);

		if (StaticVars.fieldArrayToPathHandling[y + 1][x] == 0) {
			StaticVars.fieldArrayToPathHandling[y + 1][x] = StaticVars.fieldArrayToPathHandling[y][x] + 1;
			yCoords.add(y + 1);
			xCoords.add(x);
		}
		if (StaticVars.fieldArrayToPathHandling[y - 1][x] == 0) {
			StaticVars.fieldArrayToPathHandling[y - 1][x] = StaticVars.fieldArrayToPathHandling[y][x] + 1;
			yCoords.add(y - 1);
			xCoords.add(x);
			
		}
		if (StaticVars.fieldArrayToPathHandling[y][x + 1] == 0) {
			StaticVars.fieldArrayToPathHandling[y][x + 1] = StaticVars.fieldArrayToPathHandling[y][x] + 1;
			yCoords.add(y);
			xCoords.add(x + 1);
			
		}
		if (StaticVars.fieldArrayToPathHandling[y][x - 1] == 0) {
			StaticVars.fieldArrayToPathHandling[y][x - 1] = StaticVars.fieldArrayToPathHandling[y][x] + 1;
			yCoords.add(y);
			xCoords.add(x - 1);
		}

	}

	public List<Integer> findingShortesrWay(int end) {

		List<Integer> pathList = new ArrayList<>();

		return pathList;
	}

}
