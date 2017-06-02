// imports ----------------------------------------------------------------
import wheelsunh.users.*;
import java.awt.Color;
import java.awt.event.*;
import java.awt.Point;

/**
 * This is the Crosshair class. The CrossHair can be placed anywhere.
 * 
 * @author Travis Calley
 */
public class Crosshair extends ShapeGroup
{
    // instance variables -------------------------------------------------
    private Ellipse _circle;
    private Line _vLine, _hLine;
    private Color _circleCol = new Color( 0, 0, 0, 0 );
    private Point _centerPoint;
    
    /**
     * Constructor for Crosshair class.
     * 
     * @param x x-location
     * @param y y-location
     */
    public Crosshair( int x, int y ) 
    {
        _circle = new Ellipse();
        _circle.setSize( 20, 20 );
        _circle.setFrameColor( Color.BLACK );
        _circle.setFillColor( _circleCol );
        _circle.setLocation( x, y );
        add( _circle );
        
        _vLine = new Line();
        _vLine.setP1( x, y + _circle.getHeight() / 2 );
        _vLine.setP2( x + _circle.getWidth(), y + _circle.getHeight() / 2 );
        add( _vLine );
        
        _hLine = new Line();
        _hLine.setP1( x + _circle.getWidth() / 2, y );
        _hLine.setP2( x + _circle.getWidth() / 2, y + _circle.getHeight() );
        add( _hLine );
        
        int x1 = this.getXLocation();
        int y1 = this.getYLocation();
        int xDiff = ( x1 + this.getWidth() / 2 ) - 2;
        int yDiff = ( y1 + this.getHeight() / 2 ) - 2;
        _centerPoint = new Point( xDiff, yDiff );
    }
    
    /**
     * Gets the point of the center of the Crosshair.
     *
     * @return center point of Crosshair
     */
    public Point getPoint()
    {
        return _centerPoint;
    }
    
    /**
     * Calculates the new center location of the crosshair when it is dragged.
     * 
     * @param e MouseEvent
     */
    public void mouseDragged( MouseEvent e )
    {
        int x1 = this.getXLocation();
        int x2 = this.getXLocation() + this.getWidth();
        int y1 = this.getYLocation() + this.getHeight() / 2;
        
        int xDiff = ( x1 + ( x2 - x1 ) / 2 ) - 2;
        int yDiff = y1 - 2;
        _centerPoint = new Point( xDiff, yDiff );
    }
    
    /**
     * This is the main method to test the Crosshair.
     * 
     * @param args String
     */
    public static void main( String[] args )
    { 
        new Frame();
        Crosshair c = new Crosshair( 200, 200 );
        System.out.println( c.getPoint() );
    }   
}
