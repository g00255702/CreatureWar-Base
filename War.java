import java.util.ArrayList;
import java.util.Random;

/**
 * Write a description of class War here.
 * 
 * @author Emeka Okonkwo
 * @version 2017.11.128
 */
public class War
{
    private ArrayList<Creature> goodArmy = new ArrayList<Creature>();
    private ArrayList<Creature> evilArmy = new ArrayList<Creature>();
    private Randomizer r = new Randomizer();
    Random rand = new Random();
    
    public War() {
        ArmyOne(100);
        ArmyTwo(100);
        Fight();
    }
    
    
    private void  ArmyOne(int Good) {
        for (int i = 0; i < Good; i++) {
            if (Randomizer.nextInt(10) < 7) {
                goodArmy.add(new Human());
            } else {
                goodArmy.add(new Elf());
            }
        }   
    }
    
       private void  ArmyTwo(int Evil) {
        for (int i = 0; i < Evil; i++) {
            int temp = Randomizer.nextInt(100);
            if(temp < 50){
                evilArmy.add(new Human());
            }
            else if (temp < 75) {
                evilArmy.add(new Demon(rand.nextInt(10) +1, rand.nextInt(10)+1));
            } else if (temp < 97) {
                evilArmy.add(new CyberDemon());
            } else {
                evilArmy.add(new Balrog());
                System.out.println("The Balrog has been summoned");
            }
            }
        }   
    
    public void Fight() {
        
        Creature goodWarrior=null;
        Creature evilWarrior=null;
        do {
            System.out.println("--------");
            if (goodWarrior == null) goodWarrior = goodArmy.remove(0);
            
            if (evilWarrior == null) evilWarrior = evilArmy.remove(0);
            
            while (goodWarrior.isAlive() && evilWarrior.isAlive()){
                evilWarrior.takeDamage(goodWarrior.damage());
                if(evilWarrior.isAlive())
                    goodWarrior.takeDamage(evilWarrior.damage());
                String s="\t";
                s += goodWarrior.getClass();
                s += (goodWarrior.isAlive()? " is standing":" has died");
                s += "\t::\t";
                s += evilWarrior.getClass();
                s += (evilWarrior.isAlive()?  " is standing":" has died");
                System.out.println(s);
            }
            if(!goodWarrior.isAlive()) goodWarrior= null;
            if(!evilWarrior.isAlive()) evilWarrior = null;
                
        } while (goodArmy.size() != 0 && evilArmy.size() != 0) ;
        System.out.println("Good Guys: " + goodArmy.size() + " , Evil Guys: "
            + evilArmy.size());
        
        if (goodArmy.size() > 0) {
            System.out.println ("Let us celebrate our victory!"); 
        } else if (evilArmy.size() > 0) {
            System.out.println ("All Hope is lost");
        } else{
            System.out.println("The only winner is DEATH!");
        }
        
        
    }
    
}