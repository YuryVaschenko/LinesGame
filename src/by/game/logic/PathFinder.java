package by.game.logic;

import java.util.ArrayList;
import java.util.List;

import by.game.face.StaticVars;

public class PathFinder {

	public final static int FIELD_WIDTH = 9;
	public final static int FIELD_HEIGHT = 9;

	public static List<Integer> getShortestPath(int start, int end) {

		List<Integer> shortestPathList = new ArrayList<>();
		int[][] fieldArray = new int[FIELD_WIDTH + 2][FIELD_HEIGHT + 2];
		int index = 0;

		for (int i = 0; i < FIELD_WIDTH + 2; i++) {
			for (int j = 0; j < FIELD_HEIGHT + 2; j++) {
				fieldArray[i][j] = -1;
			}
		}

		for (int i = 1; i < FIELD_WIDTH + 1; i++) {
			for (int j = 1; j < FIELD_HEIGHT + 1; i++) {
				if (StaticVars.listOfCellPanels.get(index).getStatus() == 0) {
					fieldArray[i][j] = 0;
				}
				index++;
			}
		}

		Point startPoint = Point.getPointCoordsByNum(start);
		Point endPoint = Point.getPointCoordsByNum(end);
		
		return shortestPathList;
	}

}
