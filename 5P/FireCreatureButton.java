// ---------------       imports          ------------------------------
import wheelsunh.users.*;
import java.awt.Color;
import java.awt.event.MouseEvent;

/**
 * This is a subclass of CreatureButton. This button works specifically
 * with the  FireCreature object.
 * 
 * @author Travis Calley
 */
public class FireCreatureButton extends CreatureButton
{
    // -----------------------------------------------------------------
    /**
     * Default constructor for the Creature class.
     *
     * @param x x-location
     * @param y y-location
     * @param c peer Creature object
     */
    public FireCreatureButton( int x, int y, FireCreature c )
    {
        super( x, y, c );
    }
    
    // ------------------------- main ----------------------------------
    /**
     * Main method to test this class.
     * 
     * @param args String
     */
    public static void main( String[] args )
    {
        new Frame();
        FireCreature c = new FireCreature( 100, 100 );
        new FireCreatureButton( 0, 0, c );
    }
    
}