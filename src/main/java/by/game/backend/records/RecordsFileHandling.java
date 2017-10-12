package by.game.backend.records;

import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RecordsFileHandling implements RecordsIOHandlingInterface {

    private static final Logger log = Logger.getLogger(RecordsFileHandling.class);
    private static final String FILE_NAME = "/records.sco";
    private static final String DELIMITER = "_;_";

    @Override
    public List<Record> readRecords() {

        List<Record> listOfRecords = new ArrayList<>();
        int tmpScore = 0;
        //List<String> rawTmpList;
        String[] recordMaterial;

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(FILE_NAME)));
        String line;

        try {
            while ((line = bufferedReader.readLine()) != null) {

                recordMaterial = line.split(DELIMITER);
                try {
                    tmpScore = Integer.valueOf(recordMaterial[1]);
                } catch (NumberFormatException e) {
                    log.error(e);
                    System.exit(1);
                }

                listOfRecords.add(new Record(recordMaterial[0], tmpScore));
            }
        } catch (IOException e) {
            log.error(e);
        }

        // old style causing problems with reading resources
        /*try {
            rawTmpList = Files.readAllLines(new File(getClass().getResource(FILE_NAME).toURI()).toPath(), StandardCharsets.UTF_8);

            for (String aRawTmpList : rawTmpList) {
                recordMaterial = aRawTmpList.split(DELIMITER);
                try {
                    tmpScore = Integer.valueOf(recordMaterial[1]);
                } catch (NumberFormatException e) {
                    log.error(e);
                    System.exit(1);
                }

                listOfRecords.add(new Record(recordMaterial[0], tmpScore));
            }
        } catch (IOException | URISyntaxException e) {
            log.info(e);
        }*/

        if (listOfRecords.size() == 0) {
            for (int i = 0; i < 10; i++) {
                listOfRecords.add(new Record("empty", 0));
            }
        }

        return listOfRecords;
    }

    @Override
    public void writeRecords(List<Record> listOfRecords) {

        File recordsFile = new File(FILE_NAME);

        if (!recordsFile.exists()) {
            try {
                recordsFile.createNewFile();
                log.info("File of highscores created.");
            } catch (IOException e) {
                log.error(e);
            }
        }

        try (PrintWriter writer = new PrintWriter(recordsFile)) {
            for (int i = 0; i < listOfRecords.size(); i++) {
                writer.println(listOfRecords.get(i).getName() + DELIMITER + listOfRecords.get(i).getScore());
            }
            writer.flush();
        } catch (FileNotFoundException e) {
            log.error(e);
        }

    }

}
