package by.game.backend.records;

import java.util.List;

public interface RecordsIOHandlingInterface {

	List<Record> readRecords();
	void writeRecords(List<Record> listOfRecords);
	
}
