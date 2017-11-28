import java.util.Random;

/**
 * Write a description of class Human here.
 * 
 * @author Emeka Okonkwo 
 * @version 11.20.17
 */
public class CyberDemon extends Demon
{
    // instance variables - replace the example below with your own
    private static final int MAX_DEMON_HP = 100;
    private static final int MIN_DEMON_HP = 25;
    private static final int MAX_DEMON_STR = 40;
    private static final int MIN_DEMON_STR = 20;

    /**
     * Constructor for objects of class Elf
     */
    public CyberDemon()
    {
        // note how the class uses the static randomizer class to
        // generate the values. This localizes the need to know 
        // max and min values to this class only
        // max-min is range of values
        // range + min ensures that the values don't start at one.
        super(
            Randomizer.nextInt(MAX_DEMON_HP-MIN_DEMON_HP)+MIN_DEMON_HP,    
            Randomizer.nextInt(MAX_DEMON_STR-MIN_DEMON_STR)+MIN_DEMON_STR
        );
          
    }
    
    /**
     * Overriding the damage method
     * @return dmg
     */
    public int damage()
    {
        int dmg;
        dmg = super.damage();
        
        if(Randomizer.nextInt(100)+1 <= 10){
            System.err.println("Magic!");
            dmg *= 2;
        }
        return dmg;
    }

}
