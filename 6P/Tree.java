// imports ----------------------------------------------------------------
import java.awt.Color;
import wheelsunh.users.*;
import java.awt.event.MouseEvent;
import java.awt.Point;

/**
 * This class makes a Tree object. The tree is green with a brown trunk.
 * 
 * @author Travis Calley
 */
public class Tree extends ShapeGroup implements TemperatureSensitive
{
    // instance variables -------------------------------------------------
    private Rectangle _trunk, _leftBranch, _rightBranch; 
    private Rectangle _miniBranch1, _miniBranch2, _miniBranch3, _miniBranch4;
    private Ellipse _bottomLeaves, _topLeaves;
    private Color _tempColor;
    private Point _lastMousePosition;
    private Color _treeColor = Color.GREEN.darker();
    private Color _trunkColor = new Color( 139, 87, 66 ); // brown
    
    // constructors -------------------------------------------------------
    /**
     * Default constructor that takes no parameters and makes a tree at 0,0.
     */
    public Tree() 
    { 
        makeTree( 0, 0 );
    }
    
    /**
     * Constructor to make a Tree at x, y.
     * 
     * @param x x-location
     * @param y y-location
     */
    public Tree( int x, int y )
    {
        makeTree( x, y );
    }
    
    /**
     * This is a makeTree method that creates a tree at x, y.
     * 
     * @param x x-location
     * @param y y-location
     */
    private void makeTree( int x, int y )
    {
        _trunk = new Rectangle();
        _trunk.setSize( 60, 170 );
        _trunk.setColor( _trunkColor );
        _trunk.setLocation( x, y );
        add( _trunk );
        
        _leftBranch = new Rectangle();
        _leftBranch.setSize( 10, 130 );
        _leftBranch.setColor( _trunkColor );
        _leftBranch.setLocation( x - 10, y - 100 );
        _leftBranch.setRotation( -20 );
        add( _leftBranch );
        
        _rightBranch = new Rectangle();
        _rightBranch.setSize( 10, 130 );
        _rightBranch.setColor( _trunkColor );
        _rightBranch.setLocation( x + 50, y - 100 );
        _rightBranch.setRotation( 25 );
        add( _rightBranch );
        
        _miniBranch1 = new Rectangle();
        _miniBranch1.setSize( 5, 40 );
        _miniBranch1.setColor( _trunkColor );
        _miniBranch1.setLocation( x - 30, y - 80 );
        _miniBranch1.setRotation( -45 );
        add( _miniBranch1 );
        
        _miniBranch2 = new Rectangle();
        _miniBranch2.setSize( 5, 40 );
        _miniBranch2.setColor( _trunkColor );
        _miniBranch2.setLocation( x + 2, y - 90 );
        _miniBranch2.setRotation( 40 );
        add( _miniBranch2 );
        
        _miniBranch3 = new Rectangle();
        _miniBranch3.setSize( 5, 50 );
        _miniBranch3.setColor( _trunkColor );
        _miniBranch3.setLocation( x + 30, y - 60 );
        _miniBranch3.setRotation( -45 );
        add( _miniBranch3 );
        
        _miniBranch4 = new Rectangle();
        _miniBranch4.setSize( 5, 60 );
        _miniBranch4.setColor( _trunkColor );
        _miniBranch4.setLocation( x + 70, y - 80 );
        _miniBranch4.setRotation( 50 );
        add( _miniBranch4 );
        
        _bottomLeaves = new Ellipse();
        _bottomLeaves.setSize( 250, 100 );
        _bottomLeaves.setColor( _treeColor );
        _bottomLeaves.setLocation( x - 100, y - 50 );
        add( _bottomLeaves );
        
        _topLeaves = new Ellipse();
        _topLeaves.setSize( 200, 150 );
        _topLeaves.setColor( _treeColor );
        _topLeaves.setLocation( x - 75, y - 125 );
        add( _topLeaves );
    }
    
    /**
     * Sets the color of all wooden parts of the Tree.
     * 
     * @param c trunk color
     */
    public void setColor( Color c )
    {
        _trunkColor = c;
        _trunk.setColor( _trunkColor );
        _leftBranch.setColor( _trunkColor );
        _rightBranch.setColor( _trunkColor );
        _miniBranch1.setColor( _trunkColor );
        _miniBranch2.setColor( _trunkColor );
        _miniBranch3.setColor( _trunkColor );
        _miniBranch4.setColor( _trunkColor );
    }
    
    /**
     * Gets the color of all the wooden parts of the Tree.
     * 
     * @return tree color
     */
    public Color getColor()
    {
        return _trunkColor;
    }
    
    // MouseClick methods -------------------------------------------------
    /**
     * This changes the _trunkColor to a darker color.
     * 
     * @param e MouseEvent
     */
    public void mousePressed( MouseEvent e )
    {
        _lastMousePosition = e.getPoint();
        _tempColor = _trunkColor;
        _trunkColor = _trunkColor.darker();
        this.setColor( _trunkColor );
    }
    
    /**
     * This changes the _trunkColor back to normal.
     * 
     * @param e MouseEvent
     */
    public void mouseReleased( MouseEvent e )
    {
        _trunkColor = _tempColor;
        this.setColor( _trunkColor );
    }
    
    /**
     * This moves the Tree when it is clicked on and dragged.
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
     * This changes the Tree object to a cold state.
     */
    public void cold()
    {
        _bottomLeaves.hide();
        _topLeaves.hide();
    }
    
    /**
     * This changes the Tree object to a warm state.
     */
    public void warm()
    {
        _bottomLeaves.show();
        _topLeaves.show();
    }
    
    // main ---------------------------------------------------------------
    /**
     * This is the main method, it is used to test the Tree class.
     * 
     * @param args String
     */
    public static void main( String[] args )
    { 
        new Frame();
        Tree t = new Tree( 200, 200 );
        Utilities.sleep( 3000 );
        t.cold();
        Utilities.sleep( 1000 );
        t.warm();
        t.setLocation( 400, 200 );
    }    
}