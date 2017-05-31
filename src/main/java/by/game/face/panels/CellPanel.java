package by.game.face.panels;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JPanel;

import by.game.face.BallColor;
import by.game.face.Constants;

public class CellPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private Image backgroundImage;
	private int status = 0;
	private int cellNum = 0;
	private BallColor cellBallColor;
	private JLabel motionLabel;

	public CellPanel() {
		drawImage(BallColor.EMPTY);
		motionLabel = new JLabel();
		motionLabel.setVisible(false);
		motionLabel.setBounds(1, 1, 52, 52);
		add(motionLabel);
	}

	public void drawImage(BallColor color) {

		if (color.name() != BallColor.EMPTY.name()) {
			backgroundImage = Constants.listOfBallsImages.get(color.ordinal());
			status++;
			cellBallColor = color;
		} else {
			backgroundImage = Constants.listOfBallsImages.get(0);
			cellBallColor = color;
			status = 0;
		}
		revalidate();
		repaint();

	}

	public void startBallAnimation(){
		
		switch(cellBallColor){
		case WHITE:
			motionLabel.setIcon(Constants.listOfBallsChooseAnimationIcons.get(0));
			break;
		case BLUE:
			motionLabel.setIcon(Constants.listOfBallsChooseAnimationIcons.get(1));
			break;
		case GREEN:
			motionLabel.setIcon(Constants.listOfBallsChooseAnimationIcons.get(2));
			break;
		case RED:
			motionLabel.setIcon(Constants.listOfBallsChooseAnimationIcons.get(3));
			break;
		case YELLOW:
			motionLabel.setIcon(Constants.listOfBallsChooseAnimationIcons.get(4));
			break;
		case PURPLE:
			motionLabel.setIcon(Constants.listOfBallsChooseAnimationIcons.get(5));
			break;
		case CYAN:
			motionLabel.setIcon(Constants.listOfBallsChooseAnimationIcons.get(6));
			break;
		default:
			break;
		}
		motionLabel.setVisible(true);
	}
	
	public void stopBallAnimation(){
		motionLabel.setIcon(null);
		motionLabel.setVisible(false);
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
