
public class Teacher extends Actor{
	String team;
	int health;
	int attack;
	
	
	public Teacher() {
		this.team = "Survivor";
		this.health = 50;
		this.attack = 5;
	}
	
	public int getAttack() {
		return attack;
	}
	
	public void setAttack(int a) {
		this.attack = a;
	}

}
