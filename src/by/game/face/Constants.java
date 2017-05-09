package by.game.face;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.JLabel;

import by.game.backend.records.Record;
import by.game.face.panels.CellPanel;

public final class Constants {

	public static int WIDTH_GAME_PANEL = 517;
	public static int HEIGHT_GAME_PANEL = 517;
	public static int WIDTH_NEWBALLS_PANEL = 175;
	public static int HEIGHT_NEWBALLS_PANEL = 61;
	public static int WIDTH_SCORE_PANEL = 150;
	public static int HEIGHT_SCORE_PANEL = 60;
	public static int GRID_ROWS_COUNT = 9;
	public static int GRID_COLS_COUNT = 9;
	public static int NUMBER_OF_COLORS = 7; // 1 to 7
	public static int STEP_BACK_COUNT_TO_DECREASE_SCORE = 0;
	public static int[][] fieldArrayToPathHandling = new int[GRID_ROWS_COUNT + 2][GRID_COLS_COUNT + 2];
	public static List<BallColor> stapBackFieldBallsColorList = new ArrayList<>();
	public static List<BallColor> stapBackNewBallsColorList = new ArrayList<>();
	public static List<CellPanel> listOfCellPanels = new ArrayList<>();
	public static List<CellPanel> listOfNewBallsPanels = new ArrayList<>();
	public static List<Image> listOfBallsImages = new ArrayList<>();
	public static List<Icon> listOfBallsChooseAnimationIcons = new ArrayList<>();
	public static List<Integer> selectBallLogicPath = new ArrayList<>();
	public static List<Record> listOfRecords;
	public static List<JLabel> listOfRecordsTableLabels = new ArrayList<>();
	
	public static BallColor tmpColor;
	public static int STEP_BACK_COUNT = 5;

	

}
