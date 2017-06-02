// ---------------       imports          ------------------------------
import wheelsunh.users.*;
import java.awt.Color;
import java.awt.event.MouseEvent;

/**
 * This a class that creatures a sea creature object with 
 * a special flashlight ability.
 * 
 * @author Travis Calley
 */
public class FlashlightCreature extends Creature
{
    // --------------------- instance variables ------------------------
    private Rectangle _antenna;
    private Ellipse _bulb;
    private Ellipse _flash;
    private Color _bulbColor;
    
    // --------------------- constructors ------------------------------
    /**
     * This constructor creates a super Creature object and makes the
     * Flashlight extension on the super Creature object at location (0,0).
     */
    public FlashlightCreature()
    {
        super();
        makeFlashlight();
    }
    
    /**
     * Makes a FlashlightCreature at location (x,y).
     * 
     * @param x x-location
     * @param y y-location
     */
    public FlashlightCreature( int x, int y )
    {
        super( x, y );
        makeFlashlight();
    }
    
    /**
     * Makes a FlashlightCreature with bodyColor c.
     * 
     * @param c bodyColor of creature
     */
    public FlashlightCreature( Color c )
    {
        super( c );
        makeFlashlight();
    }
    
    // -----------------------------------------------------------------
    /**
     * Makes the extension of the super Creature object
     * and makes this FlashlightCreature have the flashlight.
     */
    private void makeFlashlight()
    {
        _antenna = new Rectangle();
        _antenna.setLocation( _fishBody.getXLocation() - 35,
                             _fishBody.getYLocation() + 5 );
        _antenna.setSize( 56, 5 );
        _antenna.setFrameColor( Color.BLACK );
        _antenna.setFillColor( this.getColor() );
        
        _bulb = new Ellipse();
        _bulb.setSize( 10, 10 );
        _bulb.setFillColor( Color.GRAY );
        _bulb.setFrameColor( Color.BLACK );
        _bulb.setLocation( _antenna.getXLocation() - 5,
                          _antenna.getYLocation()  - 3 );
    }
    
    // -----------------------------------------------------------------
    /**
     * Moves the antenna and bulb to new location.
     * 
     * @param x x-location
     * @param y y-location
     */
    public void setLocation( int x, int y )
    {
        super.setLocation( x, y );
        _antenna.setLocation( _fishBody.getXLocation() - 35,
                             _fishBody.getYLocation() + 5 );
        
        _bulb.setLocation( _antenna.getXLocation() - 5,
                          _antenna.getYLocation()  - 3 );
    }
    
    /**
     * Sets the color of the creature antenna.
     * 
     * @param c color
     */
    public void setColor( Color c )
    {
        super.setColor( c );
        _antenna.setFillColor( c );
    }
    
    // -----------------------------------------------------------------
    /**
     * Activates the flashLight to display a yellow circle.
     */
    public void activate()
    {
        _flash = new Ellipse();
        _flash.setSize( 20, 90 );
        _flash.setFillColor( Color.YELLOW );
        _flash.setFrameColor( Color.YELLOW.darker() );
        _flash.setLocation( this.getXLocation() - 70, this.getYLocation() );
        
        _bulbColor = Color.YELLOW;
        _bulb.setFillColor( _bulbColor );
        _bulbColor = Color.GRAY;
    }
    
    // -----------------------------------------------------------------
    /**
     * Deactivates the flashLight to hide a yellow circle.
     */
    public void deactivate()
    {
        _flash.hide();
        _bulb.setFillColor( _bulbColor );
    }
    
    // ------------------------------ main -----------------------------
    /**
     * Main method tests the FlashlightCreature and its capabilities.
     * 
     * @param args String
     */
    public static void main( String[] args )
    {
        new Frame();
        FlashlightCreature c = new FlashlightCreature( 250, 250 );
        c.activate();
        Utilities.sleep( 2000 );
        c.deactivate();
        c.setLocation( 50, 50 );
    }
}