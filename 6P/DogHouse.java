// imports ----------------------------------------------------------------
import java.awt.Color;
import wheelsunh.users.*;
import java.awt.event.MouseEvent;
import java.awt.Point;

/**
 * DogHouse class makes a red DogHouse.
 * 
 * @author Travis Calley
 */
public class DogHouse extends ShapeGroup implements TemperatureSensitive
{
    // instance variables -------------------------------------------------
    private Color _tempColor;
    private Point _lastMousePosition;
    private Color _dogHouseColor = Color.RED;
    private Rectangle _leftRoof, _rightRoof;
    private Rectangle _house, _houseBottom;
    private Ellipse _doorCircle;
    private Rectangle _doorRectangle;
    private Ellipse _leftSnowMound, _rightSnowMound;
    
    // constructors -------------------------------------------------------
    /**
     * Default constructor that takes no parameters and makes a DogHouse at 0,0.
     */
    public DogHouse() 
    {
        makeDogHouse( 0, 0 );
    }
    
    /**
     * Constructor to make a DogHouse at x, y.
     * 
     * @param x x-location
     * @param y y-location
     */
    public DogHouse( int x, int y )
    {
        makeDogHouse( x, y );
    }
    
    /**
     * This is a makeDogHouse method that creates a DogHouse at x, y.
     * 
     * @param x x-location
     * @param y y-location
     */
    private void makeDogHouse( int x, int y )
    {
        _house = new Rectangle( _dogHouseColor );
        _house.setSize( 100, 100 );
        _house.setRotation( 45 );
        _house.setLocation( x, y );
        add( _house );
        
        _houseBottom = new Rectangle( _dogHouseColor );
        _houseBottom.setSize( 125, 80 );
        _houseBottom.setLocation( x - 13, y + 41 );
        add( _houseBottom );
        
        _leftRoof = new Rectangle();
        _leftRoof.setSize( 100, 10 );
        _leftRoof.setColor( Color.BLACK );
        _leftRoof.setRotation( -45 );
        _leftRoof.setLocation( x - 32, y + 12 );
        add( _leftRoof );
        
        _rightRoof = new Rectangle();
        _rightRoof.setSize( 100, 10 );
        _rightRoof.setColor( Color.BLACK );
        _rightRoof.setRotation( 45 );
        _rightRoof.setLocation( x + 32, y + 12 );
        add( _rightRoof );
        
        _doorCircle = new Ellipse();
        _doorCircle.setColor( Color.BLACK );
        _doorCircle.setSize( 40, 40 );
        _doorCircle.setLocation( x + ( _house.getWidth() - 
                                       _doorCircle.getWidth() ) / 2, 
                                 y + 50 );
        add( _doorCircle );
        
        _doorRectangle = new Rectangle();
        _doorRectangle.setColor( Color.BLACK );
        _doorRectangle.setSize( 40, 46 );
        _doorRectangle.setLocation( x + ( _house.getWidth() - 
                                          _doorRectangle.getWidth() ) / 2, 
                                    y + 75 );
        add( _doorRectangle );
        
        _leftSnowMound = new Ellipse();
        _leftSnowMound.setColor( Color.WHITE );
        _leftSnowMound.setRotation( -45 );
        _leftSnowMound.setSize( 90, 40 );
        _leftSnowMound.setLocation( x - 20, y );
        add( _leftSnowMound );
        
        _rightSnowMound = new Ellipse();
        _rightSnowMound.setColor( Color.WHITE );
        _rightSnowMound.setRotation( 45 );
        _rightSnowMound.setSize( 90, 40 );
        _rightSnowMound.setLocation( x + 30, y );
        add( _rightSnowMound );
        
        _leftSnowMound.hide();
        _rightSnowMound.hide();
    }
    
    /**
     * Sets the color of DogHouse.
     * 
     * @param c house color
     */
    public void setColor( Color c )
    {
        _dogHouseColor = c;
        _house.setColor( _dogHouseColor );
        _houseBottom.setColor( _dogHouseColor );
    }
    
    /**
     * Gets the color of DogHouse.
     * 
     * @return house color
     */
    public Color getColor()
    {
        return _dogHouseColor;
    }
    
    // MouseClick methods -------------------------------------------------
    /**
     * This changes the _dogHouseColor to a darker color.
     * 
     * @param e MouseEvent
     */
    public void mousePressed( MouseEvent e )
    {
        _lastMousePosition = e.getPoint();
        _tempColor = _dogHouseColor;
        _dogHouseColor = _dogHouseColor.darker();
        this.setColor( _dogHouseColor );
    }
    
    /**
     * This changes the DogHouse color back to normal.
     * 
     * @param e MouseEvent
     */
    public void mouseReleased( MouseEvent e )
    {
        _dogHouseColor = _tempColor;
        this.setColor( _dogHouseColor );
    }
    
    /**
     * This moves the DogHouse when it is clicked on and dragged.
     * 
     * @param e MouseEvent
     */
    public void mouseDragged( MouseEvent e )
    {
        Point currentPoint = e.getPoint();
        int diffX = currentPoint.x - _lastMousePosition.x;
        int diffY = currentPoint.y - _lastMousePosition.y;
        this.setLocation( this.getLocation().x + diffX,
                          this.getLocation().y + diffY );
        _lastMousePosition = currentPoint;
    }
    
    // TemperatureSensitive methods ---------------------------------------
    /**
     * This changes the DogHouse object to a cold state.
     */
    public void cold()
    {
        _leftSnowMound.show();
        _rightSnowMound.show();
        _leftRoof.setColor( Color.WHITE );
        _rightRoof.setColor( Color.WHITE );
    }
    
    /**
     * This changes the DogHouse object to a warm state.
     */
    public void warm()
    {
        _leftSnowMound.hide();
        _rightSnowMound.hide();
        _leftRoof.setColor( Color.BLACK );
        _rightRoof.setColor( Color.BLACK );
    }
    
    // main ---------------------------------------------------------------
    /**
     * This is the main method, it is used to test the DogHouse class.
     * 
     * @param args String
     */
    public static void main( String[] args )
    { 
        new Frame();
        
        Rectangle r = new Rectangle();
        r.setColor( Color.GRAY );
        r.setSize( 1000, 1000 );
        r.setLocation( 0, 0 );
        
        DogHouse d = new DogHouse( 200, 200 );
        Utilities.sleep( 3000 );
        d.cold();
        Utilities.sleep( 10000 );
        d.warm();
        d.setLocation( 400, 200 );
    }    
}