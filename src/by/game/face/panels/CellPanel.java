package by.game.face.panels;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import by.game.face.BallColor;
import by.game.face.StaticVars;

public class CellPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private Image backgroundImage;
	private int status = 0;
	private int cellNum = 0;
	private BallColor cellBallColor;
	

	public CellPanel() {
		drawImage(BallColor.EMPTY);
	}

	public void drawImage(BallColor color) {

		if (color.name() != BallColor.EMPTY.name()) {
			backgroundImage = StaticVars.listOfImages.get(color.ordinal());
			status++;
			cellBallColor = color;
		} else {
			backgroundImage = StaticVars.listOfImages.get(0);
			cellBallColor = color;
			status = 0;
		}
		updateUI();

	}

	public void refreshStatus() {

		this.status = 0;
	}

	public int getStatus() {
		return this.status;
	}

	public int getCellNum() {
		return cellNum;
	}

	public void setCellNum(int num) {
		this.cellNum = num;
	}
	
	public BallColor getCellBallColor() {
		return cellBallColor;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(backgroundImage, 0, 0, this);
	}

}
