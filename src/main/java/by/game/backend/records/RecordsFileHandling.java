package by.game.backend.records;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class RecordsFileHandling implements RecordsIOHandlingInterface {

	private static final Logger log = Logger.getLogger(RecordsFileHandling.class);
	private static final String FILE_NAME = "resources/records.sco";
	private static final String DELIMITER = "_;_";

	@Override
	public List<Record> readRecords() {

		List<Record> listOfRecords = new ArrayList<>();
		int tmpScore = 0;
		List<String> rawTmpList;
		String[] recordMaterial;

		try {
			rawTmpList = Files.readAllLines(new File(FILE_NAME).toPath(), StandardCharsets.UTF_8);
			for (int i = 0; i < rawTmpList.size(); i++) {
				recordMaterial = rawTmpList.get(i).split(DELIMITER);
				
				try{
					tmpScore = Integer.valueOf(recordMaterial[1]);
				} catch (NumberFormatException e){
					log.error(e);
					System.exit(1);
				}
				
				listOfRecords.add(new Record(recordMaterial[0], tmpScore));
			}
		} catch (IOException e) {
			log.info(e);
		}

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
