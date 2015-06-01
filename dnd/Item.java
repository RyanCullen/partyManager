package dnd;

public class Item {
	private String name, description;
	private int value;

	public Item(String name, String description, int value) {
		this.name = name;
		this.description = description;
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String toString() {
		return name + "`" + description + "`" + String.valueOf(value);
	}
}
