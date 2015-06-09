package dnd;

public class NPC extends Character {

	private int reward, level;

	public NPC(String name, int level, int hp, int speed, int ac, int fort,
			int ref, int will, int rewardExp) {
		super(name, hp, ac, fort, ref, will, speed);
		this.level = level;
		this.reward = rewardExp;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getReward() {
		return reward;
	}

	public void setReward(int reward) {
		this.reward = reward;
	}

}
