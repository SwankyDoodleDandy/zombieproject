import java.lang.reflect.Array;
import java.util.Random;

public class Main {
	static int survivorCount = (int) Math.floor(Math.random()* 20);
	static int zombieCount = (int) Math.floor(Math.random()* 20);
	
	static Actor[] zombies = new Actor[zombieCount];
	static Actor[] survivors = new Actor[survivorCount];
        static int numChild = 0;
        static int numTeach = 0;
        static int numSold = 0;
        static int numInfect = 0;
        static int numTank = 0;
        
        static int childCount = 1;
        static int teachCount = 1;
        static int soldCount = 1;
        static int infectCount = 1;
        static int tankCount = 1;
	
	public static void main(String[] args){
	//Creates right number of Zombies and Survivors
	createZombies();
        createSurvivors();
        
        System.out.print("We have " + survivorCount + " survivors trying to make it to saftey.(" + numChild
                + " children, " + numTeach + " teachers, " + numSold + " soldiers)\n"
        + "But there are " + zombieCount + " zombies waiting for them. (" + numInfect +
                " common infected, " + numTank + " tanks)\n");
        
        while(survivorCount > 0 && zombieCount > 0){
            survivorFight();
            zombieFight();
        }
        
        if(survivorCount > 0) {
            System.out.print("It seems " + survivorCount +  " have made it to safety.\n");
        }
        else{
            System.out.print("None of the survivors made it.\n");
        }
		
	}
	
	public static void createZombies() {
		for (int i = 0; i < zombieCount; i++) {
			//Creates random number 1 or 2
			 int number = (int)Math.floor(Math.random()*(2-1+1)+1);
			 switch (number) {
			 case 1:
				 zombies[i] = new Common_Infect();
                                 numInfect++;
				 break;
			 case 2:
				 zombies[i] = new Tank();
                                 numTank++;
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
                                 numChild++;
				 break;
			 case 2:
				 survivors[i] = new Soldier();
                                 numSold++;
				 break;
			 case 3:
				 survivors[i] = new Teacher();
                                 numTeach++;
				 break;
			 
			 }
		}
	}
	
	public static void survivorFight() {
            Class heroClass = null;
            String hClass;
            Class villainClass = null;
            String vClass;
            String vName;
            String hName;
            Actor hero;
            Actor villain;
            int attack = 0;
            int health = 0;
            
            for(int k = 0; k < survivors.length; k++) {
                if(zombieCount == 0){
                    break;
                }
                hero = (Actor) Array.get(survivors, k);
                villain = (Actor) Array.get(zombies, 0);
                
                heroClass = hero.getClass();
                hClass = heroClass.toString();
                villainClass = villain.getClass();
                vClass = villainClass.toString();
                
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
                    
                    vName = vClass.replace("class ", "");
                if("Tank".equals(vName)){
                    vName = vName + " " + tankCount;
                    tankCount++;
                }
                else if ("Common_Infect".equals(vName)){
                    vName = "Common Infected " + infectCount;
                    infectCount++;
                }
                
                hName = hClass.replace("class ", "");
                if("Child".equals(hName)){
                    hName = hName + " " + childCount;
                    childCount++;
                }
                else if("Teacher".equals(hName)){
                    hName = hName + " " + teachCount;
                    teachCount++;
                }
                else if("Soldier".equals(hName)){
                    hName = hName + " " + soldCount;
                    soldCount++;
                }
                    
                    System.out.print(hName + " killed " + vName +"\n");
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
            Class heroClass = null;
            String hClass;
            String vName;
            String hName;
            Actor hero;
            Actor villain;
            int attack = 0;
            int health = 0;
            
            for(int k = 0; k < zombieCount; k++) {
                if(survivorCount == 0){
                    break;
                }
                hero = (Actor) Array.get(survivors, 0);
                villain = (Actor) Array.get(zombies, k);
                
                villainClass = villain.getClass();
                vClass = villainClass.toString();
                heroClass = hero.getClass();
                hClass = heroClass.toString();
                
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
                    
                    vName = vClass.replace("class ", "");
                if("Tank".equals(vName)){
                    vName = vName + " " + tankCount;
                    tankCount++;
                }
                else if ("Common_Infect".equals(vName)){
                    vName = "Common Infected " + infectCount;
                    infectCount++;
                }
                
                hName = hClass.replace("class ", "");
                if("Child".equals(hName)){
                    hName = hName + " " + childCount;
                    childCount++;
                }
                else if("Teacher".equals(hName)){
                    hName = hName + " " + teachCount;
                    teachCount++;
                }
                else if("Soldier".equals(hName)){
                    hName = hName + " " + soldCount;
                    soldCount++;
                }
                    
                    System.out.print(vName + " killed " + hName +"\n");
                    for(int i = 0; i< survivorCount - 1; i++){
                        survivors[i] = survivors[i + 1];
                    }
                    survivorCount--;
                } 
            }
        }
}
