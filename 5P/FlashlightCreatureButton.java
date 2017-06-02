// --------------------------- imports -----------------------------------
import wheelsunh.users.*;
import java.awt.Color;
import java.awt.event.MouseEvent;

/**
 * This FlashlightCreatureButton interacts with FlashlightCreatures.
 * 
 * @author Travis Calley
 */
public class FlashlightCreatureButton extends CreatureButton
{
    // -----------------------------------------------------------------
    /**
     * Constructor for the FlashlightCreatureButton class.
     *
     * @param x x-coordinate
     * @param y y-coordinate
     * @param c Creature object the button is paired with
     */
    public FlashlightCreatureButton( int x, int y, FlashlightCreature c )
    {
        super( x, y, c );
        this.setText( "Flashlight Creature" );
    }
    
    // ------------------------- main ----------------------------------
    /**
     * Main method tests the FlashlightCreatureButton.
     * 
     * @param args String
     */
    public static void main( String[] args )
    {
        new Frame();
        FlashlightCreature c = new FlashlightCreature( 100, 100 );
        new FlashlightCreatureButton( 0, 0, c );
    }
    
}