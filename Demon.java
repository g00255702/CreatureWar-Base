import java.util.Random;

/**
 * Write a description of class Human here.
 * 
 * @author Emeka Okonkwo 
 * @version 11.20.17
 */
public class Demon extends Creature
{
    // instance variables - replace the example below with your own


    /**
     * Constructor for objects of class Elf
     */
    public Demon(int hp, int str)
    {
        super(hp,str);
    }
    
    /**
     * Overriding the damage method
     * @return dmg
     */
    public int damage()
    {
        int dmg;
        dmg = super.damage();
        
        if(Randomizer.nextInt(100) <= 5){
            System.err.println("Override");
            dmg += 50;
        }
        return dmg;
    }

}
