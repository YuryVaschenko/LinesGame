package by.game.face;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import by.game.face.panels.CellPanel;

public final class StaticVars {

	private StaticVars() {
	}

	public static int WIDTH_GAME_PANEL = 517;
	public static int HEIGHT_GAME_PANEL = 517;
	public static int WIDTH_NEWBALLS_PANEL = 175;
	public static int HEIGHT_NEWBALLS_PANEL = 61;
	public static int WIDTH_SCORE_PANELS = 220;
	public static int HEIGHT_SCORE_PANELS = 70;
	public static int BSCORE_PANELS = 30;
	public static int RECORD_PANEL = 0;// read file
	public static int SCORE_PANEL = 0;
	public static int COLOR_BOWL = 0;
	public static int GRID_ROWS_COUNT = 9;
	public static int GRID_COLS_COUNT = 9;
	public static int NUMBER_OF_COLORS = 7; // 1 to 7
	public static int[][] fieldArrayToPathHandling = new int[GRID_ROWS_COUNT + 2][GRID_COLS_COUNT + 2];
	public static ArrayList<CellPanel> listOfCellPanels = new ArrayList<>();
	public static ArrayList<CellPanel> listOfNewBallsPanels = new ArrayList<>();
	public static ArrayList<Image> listOfImages = new ArrayList<>();
	public static ArrayList<Integer> path = new ArrayList<>();
	public static BallColor tmpColor;

	static {

		try {
			for (int i = 0; i < 9; i++) {
				listOfImages.add(ImageIO.read(new File("resources/png/balls/back/" + i + ".png")));
			}
		} catch (IOException e) {
			System.out.println("Can`t read image file");
			System.exit(0);
		}

	}

}
