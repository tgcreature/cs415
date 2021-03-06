// imports ----------------------------------------------------------------
import wheelsunh.users.*;
import java.awt.Color;
import java.awt.event.*;
import java.awt.Point;

/**
 * This a class that creatures a sea creature object.
 * 
 * @author Travis Calley
 */
public class Creature extends ShapeGroup implements TemperatureSensitive
{
    // instance variables -------------------------------------------------
    
    private RoundedRectangle _topFin; // creates top fin behind fish's body
    private Ellipse _rightFin, _leftFin; // creates right and left fin 
    private Rectangle _backFin; // creates the fish's back fin
    private RoundedRectangle _fishBody; // creates the fish's body
    private Ellipse _eyeWhite; // creates the eye white
    private Ellipse _pupil; // creates the _pupil in the eye white
    private Rectangle _stripe1, _stripe2, _stripe3; // creates 3 stripes
    private Line _mouth;
    private Color _fishBodyColor = Color.YELLOW;
    private Color _stripeColor = Color.BLUE;
    private Line _eyeLine1, _eyeLine2;  // creates dead fish eye lines
    
    private Point _lastMousePosition;
    private Color _tempCol, _tempCol2;
    
    // magic numbers ------------------------------------------------------
    private int _x1 = 50, _y1 = 50, _x2 = 200, _y2 = 100;
    private int _x3 = 350, _y3 = 150, _x4 = 500, _y4 = 200;
    private int _stripeOffset = 15;
    private int _stripeWidth = 8;
    private int _fishBodyWidth = 95;
    private int _fishBodyHeight = 75;
    private int _topFinWidth = 55;
    private int _topFinHeight = 15;
    private int _finWidth = 50;
    private int _finHeight = 15;
    private int _rightFinRotation = 15;
    private int _leftFinRotation = 10;
    private int _backFinWidth = 15;
    private int _backFinHeight = _fishBodyHeight - 20;
    private int _pupilRadius = 5;
    private int _mouthWidth = 15;
    private int _mouthHeight = 1;
    private int _eyeWhiteRadius = 15;
    private int xOffset = 65;
    private int yOffset = 50;
    
    
    // --------------------------------------------------------------------
    /**
     * Default constructor for the Creature class.
     *
     */
    public Creature()
    {
        makeCreature( 0, 0, _fishBodyColor );
    }

    // --------------------------------------------------------------------
    /**
     * Constructor for the Creature class.
     * 
     * @param x takes an initial x coordinate
     * @param y takes an initial y coordinate
     */
    public Creature( int x, int y )
    {
        makeCreature( x, y, _fishBodyColor );
    }
    
    // --------------------------------------------------------------------
    /**
     * Constructor for the Creature class.
     * 
     * @param c takes a _fishBody color
     */
    public Creature( Color c )
    {
        makeCreature( 0, 0, c );
    }
    
    // --------------------------------------------------------------------
    /**
     * Makes the fish creature.
     * 
     * @param x takes an initial x coordinate
     * @param y takes an initial y coordinate
     * @param c takes a _fishBody color
     */
    public void makeCreature( int x, int y, Color c )
    {
        _topFin = new RoundedRectangle( Color.CYAN );
        _topFin.setSize( _topFinWidth, _topFinHeight );
        _topFin.setLocation( x + _topFinWidth / 2, y );
        add( _topFin );
        
        _rightFin = new Ellipse( Color.CYAN );
        _rightFin.setSize( _finWidth, _finHeight );
        _rightFin.setRotation( _rightFinRotation );
        _rightFin.setLocation( x + _fishBodyWidth / 3, 
                               y + _fishBodyHeight + _topFinHeight / 2 );
        add( _rightFin );
        
        _fishBodyColor = c;
        
        _fishBody = new RoundedRectangle();
        _fishBody.setSize( _fishBodyWidth, _fishBodyHeight );
        _fishBody.setColor( _fishBodyColor );
        _fishBody.setLocation( x , y + _topFinHeight / 2 );
        add( _fishBody );
        
        _eyeWhite = new Ellipse( Color.WHITE );
        _eyeWhite.setSize( _eyeWhiteRadius, _eyeWhiteRadius );
        _eyeWhite.setLocation( x + _eyeWhiteRadius, 
                               y + _eyeWhiteRadius + _topFinHeight / 2 );
        add( _eyeWhite );
        
        _pupil = new Ellipse( Color.BLACK );
        _pupil.setSize( _pupilRadius, _pupilRadius );
        _pupil.setLocation( x + _eyeWhiteRadius, 
                            y + _eyeWhiteRadius + _pupilRadius + 
                            _topFinHeight / 2 );
        add( _pupil );
        
        _backFin = new Rectangle( Color.BLUE );
        _backFin.setSize( _backFinWidth, _backFinHeight );
        _backFin.setLocation( x + _fishBodyWidth, 
                              y + _backFinHeight / 6 + _topFinHeight / 2 );
        add( _backFin );
        
        _stripe1 = new Rectangle( _stripeColor );
        _stripe1.setSize( _stripeWidth, _fishBodyHeight );
        _stripe1.setLocation( x + xOffset - _stripeOffset * 2, 
                              y + _topFinHeight / 2 );
        add( _stripe1 );
        
        _stripe2 = new Rectangle( _stripeColor );
        _stripe2.setSize( _stripeWidth, _fishBodyHeight );
        _stripe2.setLocation( x + ( _fishBodyWidth / 2 ) + _stripeOffset / 2, 
                              y + _topFinHeight / 2 );
        add( _stripe2 );
        
        _stripe3 = new Rectangle( _stripeColor );
        _stripe3.setSize( _stripeWidth, _fishBodyHeight );
        _stripe3.setLocation( x + xOffset + _stripeOffset / 2, 
                              y + _topFinHeight / 2 );
        add( _stripe3 );
        
        _leftFin = new Ellipse();
        _leftFin.setSize( _finWidth, _finHeight );
        _leftFin.setColor( ( Color.CYAN ).darker() );
        _leftFin.setRotation( _leftFinRotation );
        _leftFin.setLocation( x + xOffset - _fishBodyWidth / 6, 
                              y + _fishBodyHeight + _topFinHeight / 2 );
        add( _leftFin );
        
        _mouth = new Line();
        _mouth.setSize( _mouthWidth, _mouthHeight );
        _mouth.setColor( Color.BLACK );
        _mouth.setLocation( x, y + yOffset + _topFinHeight / 2 );
        add( _mouth );
        
        _eyeLine1 = new Line();
        _eyeLine1.setLocation( _eyeWhite.getLocation() );
        _eyeLine1.setRotation( 45 );
        _eyeLine1.setColor( Color.BLACK );
        _eyeLine1.setSize( 15, 15 );
        add( _eyeLine1 );
        
        _eyeLine2 = new Line();
        _eyeLine2.setLocation( _eyeWhite.getLocation() );
        _eyeLine2.setRotation( 135 );
        _eyeLine2.setColor( Color.BLACK );
        _eyeLine2.setSize( 15, 15 );
        add( _eyeLine2 );
        
        _eyeLine1.hide();
        _eyeLine2.hide();
    }
    
    // --------------------------------------------------------------------
    /**
     * Mutator to change the color of the Creature.
     * 
     * @param c changes the color of the _fishBody to Color c
     */
    public void setColor( Color c )
    {
        _fishBodyColor = c;
        _fishBody.setColor( _fishBodyColor );
    }
    
    // --------------------------------------------------------------------
    /**
     * Moves the Creature up by dy.
     * 
     * @param dy moves the creature up by the value of dy
     */
    public void moveUp( int dy )
    {
        int xLocation = this.getXLocation();
        int yLocation = this.getYLocation();
        this.setLocation( xLocation, yLocation - dy );
    }
    
    // --------------------------------------------------------------------
    /**
     * Gets the color of the Creature object.
     * 
     * @return The color of the Creature object
     */
    public Color getColor()
    {
        Color color = _fishBodyColor;
        return color;
    }
    
    //-------------------------- mouse events -----------------------------
    /**
     * Changes the color of the fishBody.
     * 
     * @param e MouseEvent
     */
    public void mousePressed( MouseEvent e )
    {
        _lastMousePosition = e.getPoint();
        _tempCol2 = _fishBodyColor;
        _fishBodyColor = _fishBodyColor.darker();
        this.setColor( _fishBodyColor );
    }
    
    /**
     * Drags the Creature to the mouse's current location.
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
    
    /**
     * Changes the color of the fishBody back to normal.
     * 
     * @param e MouseEvent
     */
    public void mouseReleased( MouseEvent e )
    {
        _fishBodyColor = _tempCol2;
        this.setColor( _fishBodyColor );
    }
    
    // --------------------------------------------------------------------
    /**
     * Sets the Creature to a warm state.
     */
    public void warm()
    {
        _eyeLine1.hide();
        _eyeLine2.hide();
        _eyeWhite.show();
        _pupil.show();
        if( _tempCol != null )
        {
            _fishBodyColor = _tempCol;
            this.setColor( _fishBodyColor );
        }
    }
    
    // --------------------------------------------------------------------
    /**
     * Sets the Creature to a cold state.
     */
    public void cold()
    {
        _pupil.hide();
        _eyeWhite.hide();
        _eyeLine1.show();
        _eyeLine2.show();
        _tempCol = _fishBodyColor;
        _fishBodyColor = Color.GRAY;
        this.setColor( _fishBodyColor );
    }
    
    // main ---------------------------------------------------------------
    /**
     * Creates a Frame and tests multiple Creature objects.
     * 
     * @param args String
     */
    public static void main( String[] args )
    {
        Frame f = new Frame();
        
        Creature fish = new Creature ( 100, 200 );
        fish.cold();
        
        Creature fish2 = new Creature( 300, 100 );
        fish2.warm();
    }
    
}