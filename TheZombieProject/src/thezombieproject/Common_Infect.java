
public class Common_Infect extends Actor{
	String team;
	int health;
	int attack;
	
	public Common_Infect() {
		this.team = "Zombie";
		this.health = 30;
		this.attack = 5; 
	}
	
	public int getAttack() {
		return attack;
	}
	
	public void setAttack(int a) {
		this.attack = a;
	}
	public void setHealth(int x){
            this.health = x;
        }
        public int getHealth(){
            return health;
        }
}
