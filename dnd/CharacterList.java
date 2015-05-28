package dnd;

public class CharacterList
{
	private static final int NUM_TOKENS = 15;
	private String filename;
	private ArrayList<Character> charList = new ArrayList<Character>();
	public ArrayList<String> takenNames = new ArrayList<String>();
	
	public CharacterList(String filename) {
		this.filename = filename;
		load();
	}
	
	public void addCharacter(Character character) {
		charList.add(character);
		takenNames.add(character.getName());
		try {
			FileWriter out = new FileWriter(new File(filename), true);
			out.write(character.getRecordString() + "\r\n");
			out.close();
		}
		catch (IOException e) {
			
		}
	}
	
	public void load() {
		try {
			Scanner in = new Scanner(new File(filename));
			while (in.hasNext()) {
				String[] tokens = in.nextLine().split("~")
				if (tokens.length != NUM_TOKENS)
					continue;
				if (takenNames.contains(tokens[0])) {
					JOptionPane.showMessageDialog(null, "The name " + tokens[0] + "is already taken. Character not loaded.", "Error", JOptionPane.ERROR_MESSAGE);
					continue;
				}
				else {
					addCharacter(new Character(tokens[0], Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]), Integer.parseInt(tokens[4]), Integer.parseInt(tokens[5]), Integer.parseInt(tokens[6]), Integer.parseInt(tokens[7]), Integer.parseInt(tokens[8]), Integer.parseInt(tokens[9]), Integer.parseInt(tokens[10]), Integer.parseInt(tokens[11]), Integer.parseInt(tokens[12]), tokens[13], tokens[14]);
					takenNames.add(tokens[0]);
				}
			}
		}
		catch (FileNotFoundException e) {
			
		}
	}
	
	public void save() {
		try {
			FileWriter out = new FileWriter(new File(filename));
			for (Character aChar : charList) {
				out.write(aChar.getRecordString() + "\r\n");
			}
			out.close();
		}
		catch (IOException) {
			
		}
	}
	
	public Character getCharacter(String name) {
		for (Character aChar : charList) {
			if (aChar.getName().equalsIgnoreCase(name))
				return aChar;
		}
	}
	
	public boolean deleteCharacter(String name) {
		for (Character aChar : charList) {
			if (aChar.getName().equalsIgnoreCase(name)) {
				takenNames.remove(aChar.getName());
				charList.remove(aChar);
				save();
				return true;
			}
		}
		return false;
	}
	
	
}
