package by.game.backend.records;

public class Record implements Comparable<Record> {

	String name;
	String score;
	
	public Record(String name, String score) {
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public String getScore() {
		return score;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((score == null) ? 0 : score.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Record other = (Record) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (score == null) {
			if (other.score != null)
				return false;
		} else if (!score.equals(other.score))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Record [name=" + name + ", score=" + score + "]";
	}

	@Override
	public int compareTo(Record o) {
		return this.getScore().compareTo(o.getScore());
	}
	
	
	
}
