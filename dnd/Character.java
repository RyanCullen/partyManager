package dnd;


public abstract class Character implements Comparable<Character> {
	protected int maxHP, currentHP, ac, fort, ref, will, speed,
			initiative;
	protected String name, notes;
	protected char type;
	
	// Constructor for new characters
	public Character(String name,  int hp, int ac,
			int fort, int ref, int will, int speed) {
		this.name = name;
		this.maxHP = hp;
		this.currentHP = hp;
		this.ac = ac;
		this.fort = fort;
		this.ref = ref;
		this.will = will;
		this.speed = speed;
		this.notes = "";
	}

	protected abstract char getType();
	
	protected abstract int getLevel();
	
	public void changeHP(int change) {
		this.currentHP += change;
	}
	
	public int getInitiative() {
		return initiative;
	}

	public void setInitiative(int initiative) {
		this.initiative = initiative;
	}

	public int getMaxHP() {
		return maxHP;
	}

	public void setMaxHP(int maxHP) {
		this.maxHP = maxHP;
	}

	public int getCurrentHP() {
		return currentHP;
	}

	public void setCurrentHP(int currentHp) {
		this.currentHP = currentHp;
	}

	public int getAc() {
		return ac;
	}

	public void setAc(int ac) {
		this.ac = ac;
	}

	public int getFort() {
		return fort;
	}

	public void setFort(int fort) {
		this.fort = fort;
	}

	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public int getWill() {
		return will;
	}

	public void setWill(int will) {
		this.will = will;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String toString() {
		return name;
	}

	@Override
	public int compareTo(Character compareChar) {
		return compareChar.getInitiative() - this.initiative;
	}
}