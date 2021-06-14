import java.lang.reflect.Array;
import java.util.Random;

public class Main {
	static int survivorCount = 17;
	static int zombieCount = 8;
	
	static Actor[] zombies = new Actor[zombieCount];
	static Actor[] survivors = new Actor[survivorCount];
	
	public static void main(String[] args){
	//Creates right number of Zombies and Survivors
	createZombies();
        createSurvivors();
        
        System.out.print("We have " + survivorCount + " survivors trying to make it to saftey.\n"
        + "But there are " + zombieCount + " zombies waiting for them.\n");
        
        while(survivorCount > 0 && zombieCount > 0){
            survivorFight();
            zombieFight();
        }
        
        System.out.print("It seems " + survivorCount +  " have made it to safety.\n");
	
		
	}
	
	public static void createZombies() {
		for (int i = 0; i < zombieCount; i++) {
			//Creates random number 1 or 2
			 int number = (int)Math.floor(Math.random()*(2-1+1)+1);
			 switch (number) {
			 case 1:
				 zombies[i] = new Common_Infect();
				 break;
			 case 2:
				 zombies[i] = new Tank();
				 break;
			 
			 }
		}
	}
	
	public static void createSurvivors() {
		for (int i = 0; i < survivorCount; i++) {
			//Creates random number 1 through 3
			 int number = (int) Math.floor(Math.random()*(3-1+1)+1);
			 switch (number) {
			 case 1:
				 survivors[i] = new Child();
				 break;
			 case 2:
				 survivors[i] = new Soldier();
				 break;
			 case 3:
				 survivors[i] = new Teacher();
				 break;
			 
			 }
		}
	}
	
	public static void survivorFight() {
            Class heroClass = null;
            String hClass;
            Actor hero;
            Actor villain;
            int attack = 0;
            int health = 0;
            
            for(int k = 0; k < survivors.length; k++) {
                hero = (Actor) Array.get(survivors, k);
                villain = (Actor) Array.get(zombies, 0);
                
                heroClass = hero.getClass();
                hClass = heroClass.toString();
                
                if ("class Child".equals(hClass)){
                    attack = 2;
                }
                else if ("class Teacher".equals(hClass)){
                    attack = 5;
                }
                else if ("class Soldier".equals(hClass)){
                    attack = 10;
                }
                
                health = villain.getHealth();
                health = health - attack;
                villain.setHealth(health);
                    
                if (health <= 0){
                    for(int i = 0; i< zombieCount - 1; i++){
                        zombies[i] = zombies[i + 1];
                    }
                    zombieCount--;
                }
            }
        }
        
        public static void zombieFight(){
            Class villainClass = null;
            String vClass;
            Actor hero;
            Actor villain;
            int attack = 0;
            int health = 0;
            
            for(int k = 0; k < zombieCount; k++) {
                hero = (Actor) Array.get(survivors, 0);
                villain = (Actor) Array.get(zombies, k);
                
                villainClass = villain.getClass();
                vClass = villainClass.toString();
                
                if ("class Tank".equals(vClass)){
                    attack = 20;
                }
                else if ("class Common_Infect".equals(vClass)){
                    attack = 5;
                }
                
                health = hero.getHealth();
                health = health - attack;
                hero.setHealth(health);
                
                if (health <= 0){
                    for(int i = 0; i< survivorCount - 1; i++){
                        survivors[i] = survivors[i + 1];
                    }
                    survivorCount--;
                } 
            }
        }
}
