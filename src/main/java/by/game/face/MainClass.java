package by.game.face;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import org.apache.log4j.Logger;

import by.game.backend.records.RecordsFileHandling;
import by.game.backend.records.RecordsIOHandlingInterface;

public class MainClass {

	private static final Logger log = Logger.getLogger(MainClass.class);

	public static void main(String[] args) {

		RecordsIOHandlingInterface recordsHandling = new RecordsFileHandling();

		try {
			for (int i = 0; i < 9; i++) {
				Constants.listOfBallsImages.add(ImageIO.read(new File("resources/balls/back/" + i + ".png")));
			}
			for (int i = 1; i < 8; i++){
				Constants.listOfBallsChooseAnimationIcons.add(new ImageIcon("resources/balls/animation/animation_of_selection/" + i + "_motion.gif"));
			}
		} catch (IOException e) {
			log.error(e);
			System.exit(0);
		}

		Constants.listOfRecords = recordsHandling.readRecords();

		BasicFrame bframe = new BasicFrame();
		bframe.setVisible(true);

	}

}
