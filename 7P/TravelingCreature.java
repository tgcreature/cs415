// imports ----------------------------------------------------------------
import wheelsunh.users.*;
import java.awt.Color;
import java.awt.event.*;
import java.awt.Point;
import java.util.Random;

/**
 * TravelingCreature is a creature that draws a line when moves. It also
 * makes a solid line that connects from its current location to its starting
 * location.
 * 
 * @author Travis Calley
 */
public class TravelingCreature extends Creature
{
    // instance variables -------------------------------------------------
    private Crosshair _creatureCrosshair;
    private Random _rand = new Random();
    private Line _conLine;
    private Point _startingPoint;
    private TextBox _labelBox;
    private int _numLegs;
    private double _curLengthLegs;
    private double _totLengthLegs;
    private double _avgLengthLegs;
    
    /**
     * Default Constructor for TravleingCreature makes it at point 0, 0.
     */
    public TravelingCreature()
    { 
        super();
        makeTravelingCreature( 0, 0 );
        _labelBox = new TextBox();
        _labelBox.setLocation( 20, 20 );
        _labelBox.setSize( 300, 200 );
        _numLegs = 1;
        _totLengthLegs = 0;
        _curLengthLegs = 0;
        _avgLengthLegs = 0;
        this.updateInfo();
    }
    
    /**
     * Constructor that makes a TravelingCreature at point x, y.
     * 
     * @param x x-location
     * @param y y-location
     */
    public TravelingCreature( int x, int y )
    {
        super( x, y );
        makeTravelingCreature( x, y );
        _labelBox = new TextBox();
        _labelBox.setLocation( 20, 20 );
        _labelBox.setSize( 300, 200 );
        _numLegs = 1;
        _totLengthLegs = 0;
        _curLengthLegs = 0;
        _avgLengthLegs = 0;
        this.updateInfo();
    }
    
    /**
     * Makes a TravelingCreature at location x, y.
     * 
     * @param x x-location
     * @param y y-location
     */
    private void makeTravelingCreature( int x, int y )
    {
        int r = _rand.nextInt( 256 );
        int g = _rand.nextInt( 256 );
        int b = _rand.nextInt( 256 );
        _fishBodyColor = new Color( r, g, b );
        this.setColor( _fishBodyColor );
        _creatureCrosshair = new Crosshair( x - 25, y + this.getHeight() / 2 );
        add( _creatureCrosshair );
        
        _startingPoint = _creatureCrosshair.getPoint();
        _conLine = new Line();
        _conLine.setP1( _startingPoint );
        _conLine.setP2( _startingPoint );
        _conLine.setColor( Color.BLACK );
    }
    
    
    /** 
     * Sets the TravelingCreature color to random when clicked.
     * 
     * @param e MouseEvent
     */
    public void mouseClicked( MouseEvent e )
    {
        int r = _rand.nextInt( 256 );
        int g = _rand.nextInt( 256 );
        int b = _rand.nextInt( 256 );
        _fishBodyColor = new Color( r, g, b );
        this.setColor( _fishBodyColor );
        _startingPoint = _creatureCrosshair.getPoint();
        _conLine.setP1( _startingPoint );
        _numLegs++;
        _curLengthLegs = 0;
        this.updateInfo();
    }
    
    /**
     * Moves the TravelingCreature and paints a line, also connects a line
     * to starting point.
     * 
     * @param e MouseEvent
     */
    public void mouseDragged( MouseEvent e )
    {
        Point currentPoint = e.getPoint();
        
        _conLine.setP1( _startingPoint );
        _creatureCrosshair.mouseDragged( e );
        
        Line drawLine = new Line();
        drawLine.setThickness( 2 );
        drawLine.setColor( _fishBodyColor );
        drawLine.setP1( _creatureCrosshair.getPoint() );
        
        int diffX = currentPoint.x - _lastMousePosition.x;
        int diffY = currentPoint.y - _lastMousePosition.y;
        this.setLocation( this.getLocation().x + diffX,
                         this.getLocation().y + diffY );
        
        int x2 = _creatureCrosshair.getPoint().x + diffX;
        int y2 = _creatureCrosshair.getPoint().y + diffY;
        
        _conLine.setP2( new Point( x2, y2 ) );
        drawLine.setP2( x2, y2 );
        _curLengthLegs += Math.sqrt( ( ( diffX ) * ( diffX ) ) + 
                                    ( ( diffY ) * ( diffY ) ) );
        _totLengthLegs += Math.sqrt( ( ( diffX ) * ( diffX ) ) + 
                                    ( ( diffY ) * ( diffY ) ) );
        this.updateInfo();
        _lastMousePosition = currentPoint;
    }
    
    /**
     * This method updates all the information in the label box.
     */
    public void updateInfo()
    {
        int x2 = _creatureCrosshair.getPoint().x;
        int x1 = _startingPoint.x;
        int y2 = _creatureCrosshair.getPoint().y;
        int y1 = _startingPoint.y;
        Double distance = Math.sqrt( ( ( x2 - x1 ) * ( x2 - x1 ) ) + 
                                    ( ( y2 - y1 ) * ( y2 - y1 ) ) );
        _avgLengthLegs = _totLengthLegs / _numLegs;
        
        String s1 = "Current Leg Start" + "(" + x1 + ", " + y1 + ")" + "\n";
        String s2 = "Current Leg End: " + "(" + x2 + ", " + y2 + ")" + "\n";
        String s3 = "Distance to Start: " + distance + "\n";
        String s4 = "Length of Current Leg: " + _curLengthLegs + "\n";
        String s5 = "Number of Legs: " + _numLegs + "\n";
        String s6 = "Total Length of all legs: " + _totLengthLegs + "\n";
        String s7 = "Average leg length: " + _avgLengthLegs + "\n";
        String labelString = s1 + s2 + s3 + s4 + s5 + s6 + s7;
        
        _labelBox.setText( labelString );
    }
    
    /**
     * Main method for testing TravelingCreature.
     * 
     * @param args String
     */
    public static void main( String[] args )
    { 
        new Frame();
        new TravelingCreature( 200, 200 );
    }
}