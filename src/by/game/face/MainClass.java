package by.game.face;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;

public class MainClass {

	private static final Logger log = Logger.getLogger(MainClass.class);

	public static void main(String[] args) {

		try {
			for (int i = 0; i < 9; i++) {
				StaticVars.listOfImages.add(ImageIO.read(new File("resources/png/balls/back/" + i + ".png")));
			}
		} catch (IOException e) {
			log.error(e);
			System.exit(0);
		}

		BasicFrame bframe = new BasicFrame();
		bframe.setVisible(true);

	}

}
