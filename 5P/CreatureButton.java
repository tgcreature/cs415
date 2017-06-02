// ---------------       imports          ------------------------------
import wheelsunh.users.*;
import java.awt.Color;
import java.awt.event.MouseEvent;

/**
 * Creates a super CreatureButton that activates and deactives the
 * paired creatures special ability.
 * 
 * @author Travis Calley
 */
public class CreatureButton extends TextBox
{
    //---------------- instance variables ------------------------------
    private Color _buttonColor;
    private Creature _cre;
    
    // -----------------------------------------------------------------
    /**
     * Default constructor for the CreatureButton class.
     *
     * @param x x-location
     * @param y y-location
     * @param c paired Creature object
     */
    public CreatureButton( int x, int y, Creature c )
    {
        super( x, y );
        
        _buttonColor = c.getColor();
        this.setColor( _buttonColor );
        this.setSize( 250, 150 );
        this.setSize( 80, 30 );
        this.setColor( _buttonColor );
        this.setText( "Creature" );
        
        _cre = c;
    }
    
    //-------------------------- mouse events --------------------------
    /**
     * Activates the Creature.activate() method and changes the color of
     * the button.
     * 
     * @param e MouseEvent
     */
    public void mousePressed( MouseEvent e )
    {
        Color tempColor = _buttonColor;
        _buttonColor = _buttonColor.darker();
        this.setColor( _buttonColor );
        _buttonColor = tempColor;
        _cre.activate();
    }
    
    /**
     * Activates the Creature.deactivate() method and changes the color
     * of the button back to normal.
     * 
     * @param e MouseEvent
     */
    public void mouseReleased( MouseEvent e )
    {
        this.setColor( _buttonColor );
        _cre.deactivate();
    }
    
    // ------------------------- main ----------------------------------
    /**
     * Main method to test the CreatureButton.
     * 
     * @param args String
     */
    public static void main( String[] args )
    {
        new Frame();
        Creature c = new Creature( 100, 100 );
        new CreatureButton( 0, 0, c );
    }
    
}