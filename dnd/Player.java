package dnd;

import java.util.ArrayList;

public class Player extends Character {
	private int exp, gold, maxSurges, currentSurges;
	private ArrayList<Item> items = new ArrayList<Item>();
	private static final int[] EXP_TABLE = { Integer.MIN_VALUE, 0, 1000, 2250,
			3750, 5500, 7500, 10000, 13000, 16500, 20500, 26000, 32000, 39000,
			47000, 57000, 69000, 83000, 99000, 119000, 143000, 175000, 210000,
			255000, 310000, 375000, 450000, 550000, 675000, 825000, 1000000,
			Integer.MAX_VALUE };

	// Constructor for new Players
	public Player(String name, int exp, int hp, int surges, int ac, int fort,
			int ref, int will, int speed, int gold) {
		super(name, hp, ac, fort, ref, will, speed);
		this.exp = exp;
		this.maxSurges = surges;
		this.currentSurges = surges;		
		this.gold = gold;
		this.type = 'P';
	}

	// Constructor for loading a Player
	public Player(String name, int exp, int maxHp, int currHp, int maxSurges,
			int currSurges, int ac, int fort, int ref, int will, int speed,
			String notes, String itemString, int gold) {
		super(name, maxHp, ac, fort, ref, will, speed);
		this.exp = exp;
		this.currentHP = currHp;
		this.maxSurges = maxSurges;
		this.currentSurges = currSurges;
		this.notes = notes;
		loadItems(itemString);
		this.gold = gold;
		this.type = 'P';
	}

	private int calculateLevel() {
		for (int i = 1; i < EXP_TABLE.length; i++) {
			if (exp >= EXP_TABLE[i - 1] && exp < EXP_TABLE[i])
				return i - 1;
		}
		return -1;
	}

	public void loadItems(String itemString) {
		if (!itemString.isEmpty()) {
			String[] itemPairs = itemString.split("\\|");
			for (String pair : itemPairs) {
				String[] temp = pair.split("`");
				items.add(new Item(temp[0], temp[1], Integer.parseInt(temp[2])));
			}
		}
	}

	public void addItem(String name, String desc, int value) {
		items.add(new Item(name, desc, value));
	}

	public ArrayList<Item> getItemList() {
		return items;
	}

	public void removeItem(Item item) {
		items.remove(item);
	}

	public void changeGold(int change) {
		this.gold += change;
	}

	public void changeSurges(int change) {
		this.currentSurges += change;
	}

	public void changeExp(int exp) {
		this.exp += exp;
	}

	public int getMaxSurges() {
		return maxSurges;
	}

	public void setMaxSurges(int maxSurges) {
		this.maxSurges = maxSurges;
	}

	public int getCurrentSurges() {
		return currentSurges;
	}

	public void setCurrentSurges(int currentSurges) {
		this.currentSurges = currentSurges;
	}

	public int getLevel() {
		return calculateLevel();
	}

	public void setLevel(int level) {
		this.exp = EXP_TABLE[level];
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public String getRecordString() {
		return name + "~" + String.valueOf(exp) + "~" + String.valueOf(maxHP)
				+ "~" + String.valueOf(currentHP) + "~"
				+ String.valueOf(maxSurges) + "~"
				+ String.valueOf(currentSurges) + "~" + String.valueOf(ac)
				+ "~" + String.valueOf(fort) + "~" + String.valueOf(ref) + "~"
				+ String.valueOf(will) + "~" + String.valueOf(speed) + "~"
				+ notes.replace("\n", "\\n") + "~" + stringifyItems() + "~"
				+ String.valueOf(gold);
	}

	public String stringifyItems() {
		String temp = "";
		for (Item item : items) {
			temp += item.toString() + "|";
		}
		if (!temp.isEmpty())
			return temp.substring(0, temp.length() - 1);
		else
			return temp;
	}

	@Override
	protected char getType() {
		return type;
	}
}
