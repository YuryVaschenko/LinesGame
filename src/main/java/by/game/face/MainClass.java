package by.game.face;

import by.game.backend.records.RecordsFileHandling;
import by.game.backend.records.RecordsIOHandlingInterface;
import org.apache.log4j.Logger;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;

public class MainClass {

    private static final Logger log = Logger.getLogger(MainClass.class);

    public static void main(String[] args) {

        RecordsIOHandlingInterface recordsHandling = new RecordsFileHandling();

        try {
            for (int i = 0; i < 9; i++) {
                Constants.listOfBallsImages.add(ImageIO.read(MainClass.class.getResource("/balls/back/" + i + ".png")));
            }
            for (int i = 1; i < 8; i++) {
                Constants.listOfBallsChooseAnimationIcons.add(new ImageIcon(MainClass.class.getResource("/balls/animation/animation_of_selection/" + i + "_motion.gif")));
            }
        } catch (IOException e) {
            log.error(e);
            System.out.println(e.getMessage());
            System.exit(0);
        }

        Constants.listOfRecords = recordsHandling.readRecords();

        BasicFrame bframe = new BasicFrame();
        bframe.setVisible(true);

    }

}
