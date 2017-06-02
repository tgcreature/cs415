// ---------------       imports          ------------------------------
import wheelsunh.users.*;
import java.awt.Color;
import java.awt.event.MouseEvent;

/**
 * This a class that creatures a sea creature object with 
 * a special fire breathing ability.
 * 
 * @author Travis Calley
 */
public class FireCreature extends Creature
{
    // --------------------- instance variables ------------------------
    private Ellipse _yellowFire, _orangeFire, _redFire;
    
    // --------------------- constructors ------------------------------
    /**
     * This constructor creates a super Creature object and makes the
     * fire breath extension on the super Creature object at location (0,0).
     */
    public FireCreature()
    {
        super();
        this.setColor( Color.RED );
        makeFire( 0, 0 );
    }
    
    /**
     * Makes a Creature at location (x,y).
     * 
     * @param x x-location
     * @param y y-location
     */
    public FireCreature( int x, int y )
    {
        super( x, y );
        this.setColor( Color.RED );
        makeFire( x, y );
    }
    
    //------------------------------------------------------------------
    /**
     * This makes the fire breath of the Creature at ( x, y ).
     * 
     * @param x x-location
     * @param y y-location
     */
    private void makeFire( int x, int y )
    {
        _yellowFire = new Ellipse();
        _yellowFire.setColor( Color.YELLOW );
        _yellowFire.setSize( 20, 50 );
        _yellowFire.setRotation( 90 );
        _yellowFire.setLocation( x - 45, y + 30 );
        
        _orangeFire = new Ellipse();
        _orangeFire.setColor( Color.ORANGE );
        _orangeFire.setSize( 15, 40 );
        _orangeFire.setRotation( 90 );
        _orangeFire.setLocation( x - 55, y + 35 );
        
        _redFire = new Ellipse();
        _redFire.setColor( Color.RED );
        _redFire.setSize( 10, 30 );
        _redFire.setRotation( 90 );
        _redFire.setLocation( x - 65, y + 40 );
        
        _yellowFire.hide();
        _orangeFire.hide();
        _redFire.hide();
    }
    
    //------------------------------------------------------------------
    /**
     * This sets the location of the Creature and its fire breath.
     * 
     * @param x x-location
     * @param y y-location
     */
    public void setLocation( int x, int y )
    {
        super.setLocation( x, y );
        _yellowFire.setLocation( x - 45, y + 30 );
        _orangeFire.setLocation( x - 55, y + 35 );
        _redFire.setLocation( x - 65, y + 40 );
    }
    
    // -----------------------------------------------------------------
    /**
     * Activates the fire breath to display three Ellipses.
     */
    public void activate()
    {
        _yellowFire.show();
        _orangeFire.show();
        _redFire.show();
    }
    
    // -----------------------------------------------------------------
    /**
     * Deactivates the fire breath to hide three Ellipses.
     */
    public void deactivate()
    {
        _yellowFire.hide();
        _orangeFire.hide();
        _redFire.hide();
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
        FireCreature sc = new FireCreature( 100, 100 );
        sc.activate();
        Utilities.sleep( 2000 );
        sc.deactivate();
        sc.setLocation( 50, 50 );
    }
}