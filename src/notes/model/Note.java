package notes.model;

public class Note {

	private int id;
	private String date;
	private String description;
	
	public Note() {
		this.id = 0;
		this.date = "";
		this.description = "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return date + ";" + description;
	}
	
}
