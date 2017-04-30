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
				StaticVars.listOfImages.add(ImageIO.read(new File("resources/balls/back/" + i + ".png")));
			}
			for (int i = 1; i < 8; i++){
				StaticVars.listOfBallsMotionIcons.add(new ImageIcon("resources/balls/motion/choosing_motion/" + i + "_motion.gif"));
			}
		} catch (IOException e) {
			log.error(e);
			System.exit(0);
		}

		StaticVars.listOfRecords = recordsHandling.readRecords();

		BasicFrame bframe = new BasicFrame();
		bframe.setVisible(true);

	}

}
