package dnd;

import java.util.Vector;

public class Character
{
	private int level, maxHP, currentHP, ac, fort, ref, will, speed, exp, gold, initiative, maxSurges, currentSurges;
	private String name, notes;
	private ArrayList<Item> items = new ArrayList<String>();
	private static final int[] EXP_TABLE = [-1, 0, 1000, 2250, 3750, 5500, 7500, 10000, 13000, 16500, 20500, 26000, 32000, 39000, 47000, 57000, 69000, 83000, 99000, 119000, 143000, 175000, 210000, 255000, 310000, 375000, 450000, 550000, 675000, 825000, 1000000];
	
	public Character(String name, int level, int exp; int hp, int surges, int ac, int fort, int ref, int will, int speed, int gold)
	{
		this.name = name;
		this.level = level;
		this.exp = exp;
		this.maxHP = hp;
		this.currentHP = hp;
		this.maxSurges = surges;
		this.currentSurges = surges;
		this.ac = ac;
		this.fort = fort;
		this.ref = ref;
		this.will = will;
		this.speed = speed;
		this.gold = gold;
		this.notes = "";
	}
	
	public Character(String name, int level, int exp; int maxHp, int currHp, int maxSurges, int currSurges, int ac, int fort, int ref, int will, int speed, int gold, String notes, String itemString)
	{
		this.name = name;
		this.level = level;
		this.exp = exp;
		this.maxHP = maxHp;
		this.currentHP = currHp;
		this.maxSurges = maxSurges;
		this.currentSurges = currSurges;
		this.ac = ac;
		this.fort = fort;
		this.ref = ref;
		this.will = will;
		this.speed = speed;
		this.gold = gold;
		this.notes = notes;
		loadItems(itemString);
	}
	
	public void loadItems(String itemString) {
		String[] itemPairs = itemString.split("|");
		for (String pair : itemPairs) {
			String[] temp = pair.split(":");
			items.add(temp[0], temp[1]);
		}
	}
	
	public void addItem(String name, String desc)
	{
		items.add(new Item(name, desc));
	}
	
	public ArrayList getItemList() {
		return items;
	}

	public boolean removeItem(String itemName)
	{
		for (Item item : items) {
			if (item.getName.equalsIgnoreCase(itemName)) {
				items.remove(item);
				return true;
			}
		}
		return false;
	}
	
	public void changeGold(int change)
	{
		this.gold += change;
	}
	
	public void addExp(int exp)
	{
		this.exp += exp;
	}
		
	public void changeHP(int change)
	{
		this.currentHP += change;
	}
	
	public int getLevel()
	{
		return level;
	}

	public void setLevel(int level)
	{
		this.level = level;
	}

	public int getMaxHP()
	{
		return maxHP;
	}

	public void setMaxHP(int maxHP)
	{
		this.maxHP = maxHP;
	}

	public int getAc()
	{
		return ac;
	}

	public void setAc(int ac)
	{
		this.ac = ac;
	}

	public int getFort()
	{
		return fort;
	}

	public void setFort(int fort)
	{
		this.fort = fort;
	}

	public int getRef()
	{
		return ref;
	}

	public void setRef(int ref)
	{
		this.ref = ref;
	}

	public int getWill()
	{
		return will;
	}

	public void setWill(int will)
	{
		this.will = will;
	}

	public int getSpeed()
	{
		return speed;
	}

	public void setSpeed(int speed)
	{
		this.speed = speed;
	}

	public int getExp()
	{
		return exp;
	}

	public void setExp(int exp)
	{
		this.exp = exp;
	}

	public int getGold()
	{
		return gold;
	}

	public void setGold(int gold)
	{
		this.gold = gold;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getRecordString() {
		return name + "~" + String.valueOf(level) + "~" + String.valueOf(exp) + "~" + String.valueOf(maxHP) + "~" + String.valueOf(currentHP) + "~" + String.valueOf(ac) + "~" + String.valueOf(fort) + "~" + String.valueOf(ref) + "~" + String.valueOf(will) + "~" + String.valueOf(gold) + "~" + notes + "~" + stringifyItems();
	}
	
	public String stringifyItems() {
		String temp = "";
		for (Item item : items) {
			temp += item.toString() + "|";
		}
		return temp.substring(0, temp.length() - 1)
	}
}