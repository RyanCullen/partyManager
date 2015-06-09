package dnd;

public class NPC implements Comparable {
	
	private int reward, level, maxHP, currentHP, ac, fort, ref, will, speed, initiative;

	private String name, notes;
	
	public NPC(String name, int level, int hp, int speed, int ac, int fort, int ref, int will, int rewardExp) {
		this.name = name;
		this.level = level;
		this.maxHP = hp;
		this.currentHP = hp;
		this.ac = ac;
		this.fort = fort;
		this.ref = ref;
		this.will = will;
		this.speed = speed;
		this.reward = rewardExp;
		this.notes = "";
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public int getInitiative() {
		return initiative;
	}

	public void setInitiative(int initiative) {
		this.initiative = initiative;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
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

	public void setCurrentHP(int currentHP) {
		this.currentHP = currentHP;
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

	public int getReward() {
		return reward;
	}

	public void setReward(int reward) {
		this.reward = reward;
	}

	@Override
	public int compareTo(Object compareNpc) {
		return ((NPC)compareNpc).getInitiative() - this.initiative;
	}
	
}
