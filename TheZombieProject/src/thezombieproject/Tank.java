
public class Tank extends Actor{
	String team;
	int health;
	int attack;
	
	public Tank() {
		this.team =  "Zombie";
		this.health = 150;
		this.attack = 20;
	}
	
	public int getAttack() {
		return attack;
	}
	
	public void setAttack(int a) {
		this.attack = a;
	}
	
}
