// imports ----------------------------------------------------------------
import wheelsunh.users.*;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.Point;

/**
 * Slingshot class.
 * 
 * @author Travis Calley
 */
public class Slingshot extends ShapeGroup
{
    // instance variables
    private Ellipse _pocket;
    private Line _string;
    private Point _lastPoint;
    private int _startX, _startY, _dx, _dy;
    
    /**
     * Default constructor.
     * 
     * @param x x-location
     * @param y y-location
     */
    public Slingshot( int x, int y )
    {
        _string = new Line();
        _string.setP1( x + 5, y + 5 );
        _string.setP2( x + 5, y + 5 );
        _string.setColor( Color.BLACK );
        _string.setThickness( 2 );
        add( _string );
        
        _pocket = new Ellipse();
        _pocket.setSize( 10, 10 );
        _pocket.setLocation( x, y );
        add( _pocket );
        
        _startX = x;
        _startY = y;
    }

    /**
     * Calls super and sets _startX and _startY.
     * 
     * @param x x-location
     * @param y y-location
     */
    public void setLocation( int x, int y )
    {
        super.setLocation( x, y );
        _startX = x;
        _startY = y;
    }
    
    /**
     * Gets the first point when the mouse is pressed.
     * 
     * @param e MouseEvent
     */
    public void mousePressed( MouseEvent e )
    {
        _lastPoint = e.getPoint();
    }
    
    /**
     * Sets the endpoint of the _string and the pocket to the 
     * current mouse location.
     * 
     * @param e MouseEvent
     */
    public void mouseDragged( MouseEvent e )
    {
        Point currentPoint = e.getPoint();
        
        int diffX = currentPoint.x - _lastPoint.x;
        int diffY = currentPoint.y - _lastPoint.y;
        _dx = currentPoint.x - _startX;
        _dy = currentPoint.y - _startY;
        
        _pocket.setLocation( _pocket.getLocation().x + diffX,
                             _pocket.getLocation().y + diffY );
        _string.setP2( _pocket.getLocation().x + 5,
                       _pocket.getLocation().y + 5 );
        
        _lastPoint = currentPoint;
    }
    
    /**
     * Sets the location of the _pocket and _string back to the 
     * starting location. Also, creates a projectile.
     * 
     * @param e MouseEvent
     */
    public void mouseReleased( MouseEvent e )
    {
        //TODO: CREATE PROJECTILE AT THE LOCATION OF THE _POCKET
        Projectile p = new Projectile( _pocket.getXLocation(), 
                                       _pocket.getYLocation(), _dx, _dy );
        _pocket.setLocation( _startX, _startY );
        _string.setP2( _startX + 5, _startY + 5 );
        
        _dx = 0;
        _dy = 0;
    }
    
    /**
     * Main method to initialize a frame and test Slingshot.
     * 
     * @param args String
     */
    public static void main( String[] args )
    {
        new Frame();
        Slingshot s = new Slingshot( 200, 150 );
        s.setLocation( 150, 150 );
    }
}