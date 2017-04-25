package by.game.face;

import java.awt.Image;
import java.util.ArrayList;

import by.game.face.panels.CellPanel;

public final class StaticVars {

	public static int WIDTH_GAME_PANEL = 517;
	public static int HEIGHT_GAME_PANEL = 517;
	public static int WIDTH_NEWBALLS_PANEL = 175;
	public static int HEIGHT_NEWBALLS_PANEL = 61;
	public static int WIDTH_SCORE_PANEL = 150;
	public static int HEIGHT_SCORE_PANEL = 60;
	public static int RECORD_TEXT = 0;// read file
	public static int GRID_ROWS_COUNT = 9;
	public static int GRID_COLS_COUNT = 9;
	public static int NUMBER_OF_COLORS = 7; // 1 to 7
	public static int STEP_BACK_COUNT_TO_DECREASE = 0;
	public static int[][] fieldArrayToPathHandling = new int[GRID_ROWS_COUNT + 2][GRID_COLS_COUNT + 2];
	public static ArrayList<BallColor> stapBackFieldBallsColorList = new ArrayList<>();
	public static ArrayList<BallColor> stapBackNewBallsColorList = new ArrayList<>();
	public static ArrayList<CellPanel> listOfCellPanels = new ArrayList<>();
	public static ArrayList<CellPanel> listOfNewBallsPanels = new ArrayList<>();
	public static ArrayList<Image> listOfImages = new ArrayList<>();
	public static ArrayList<Integer> path = new ArrayList<>();
	public static BallColor tmpColor;

	

}
