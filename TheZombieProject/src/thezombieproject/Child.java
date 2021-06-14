
public class Child extends Actor{
	String team;
	int health;
	int attack;
	
	
	public Child() {
		this.team = "Survivor";
		this.health = 20;
		this.attack = 2;
	}
	
	public int getAttack() {
		return attack;
	}
	
	public void setAttack(int a) {
		this.attack = a;
	}

}
