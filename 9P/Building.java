// imports ----------------------------------------------------------------
import wheelsunh.users.*;
import java.util.Random;
import java.awt.Color;

/**
 * Building class creates a building with a random width
 * and random heigth with a random number of windows.
 * 
 * @author Travis Calley
 */
public class Building extends ShapeGroup
{
    // instance variables -------------------------------------------------
    private Rectangle _building;
    private Random rand;
    
    /**
     * Default Constructor for the building class.
     * 
     * @param x x-location
     */
    public Building( int x )
    {
        rand = new Random();
        int width = rand.nextInt( 50 ) + 30;
        int height = rand.nextInt( 100 ) + 50;
        int y = 499 - height;
        _building = new Rectangle();
        _building.setSize( width, height );
        _building.setLocation( x, y );
        _building.setFillColor( Color.GRAY );
        _building.setFrameColor( Color.BLACK );
        add( _building );
        
        int numWindows = rand.nextInt( 5 ) + 2;
        int heightWindow = 20;
        for( int i = 1; i <= numWindows; i++ )
        {
            int widthWindow = rand.nextInt( 20 ) + 10;
            int xWindow = x + ( i * 5 );
            if( widthWindow + xWindow - x + 5 < width )
            {
                Rectangle window = new Rectangle();
                window.setFillColor( Color.YELLOW );
                window.setFrameColor( Color.GRAY.darker() );
                window.setSize( widthWindow, heightWindow );
                window.setLocation( xWindow, y + 15 );
                add( window );
            }
        }
    }
    
    /**
     * Gets the width of the building.
     * 
     * @return width
     */
    public int getWidth()
    {
        return _building.getWidth();
    }
    
    /**
     * Returns the x-location of the Building.
     * 
     * @return x
     */
    public int getXLocation()
    {
        return _building.getXLocation();
    }
    
    /**
     * Main method to make a few buildings.
     * 
     * @param args String
     */
    public static void main( String[] args )
    {
        new Frame();
        Building b = new Building( 150 );
        Building f = new Building( 150 + b.getWidth() );
        Building h = new Building( f.getXLocation() + f.getWidth() );
        Building x = new Building( h.getXLocation() + h.getWidth() );
        Building k = new Building( x.getXLocation() + x.getWidth() );
        Building a = new Building( k.getXLocation() + k.getWidth() );
        Building q = new Building( a.getXLocation() + a.getWidth() );
        Building w = new Building( q.getXLocation() + q.getWidth() );
        Building e = new Building( w.getXLocation() + w.getWidth() );
        Building r = new Building( e.getXLocation() + e.getWidth() );
        Slingshot s = new Slingshot( 50, 400 );
    }
}