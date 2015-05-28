package dnd;

import java.util.Vector;

public class Character
{
	private int level, maxHP, currentHP, ac, fort, ref, will, speed, exp, gold, initiative, healingSurges;
	private String name;
	private ArrayList<Item> items = new ArrayList<String>();
	
	public Character(String name, int level, int hp, int surges, int ac, int fort, int ref, int will, int speed)
	{
		this.name = name;
		this.level = level;
		this.maxHP = hp;
		this.currentHP = hp;
		this.healingSurges = surges;
		this.ac = ac;
		this.fort = fort;
		this.ref = ref;
		this.will = will;
		this.speed = speed;
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
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getName.equalsIgnoreCase(itemName)) {
				items.remove(i);
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

}