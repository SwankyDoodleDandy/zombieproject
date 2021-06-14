
public class Soldier extends Actor{
	String team;
	int health;
	int attack;
	
	
	public Soldier() {
		this.team = "Survivor";
		this.health = 100;
		this.attack = 10;
	}
	
	public int getAttack() {
		return attack;
	}
	
	public void setAttack(int a) {
		this.attack = a;
	}

}
