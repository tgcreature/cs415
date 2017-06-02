// imports ----------------------------------------------------------------
import wheelsunh.users.*;
import java.awt.Color;
import java.util.*;
import java.awt.event.MouseEvent;
import java.awt.Point;

/**
 * Creates a projectile that launches from a point.
 * 
 * @author Travis Calley
 */
public class Projectile extends Ellipse implements Animator
{
    // instance variables -------------------------------------------------
    private int _time;
    private int _startX, _startY;
    private int _dX, _dY;
    private AnimationTimer _timer;
    private Vector<Ellipse> trail;
    
    /**
     * Default constructor.
     */
    public Projectile( int x, int y, int diffX, int diffY )
    {
        super( x, y );
        this.setSize( 10, 10 );
        this.setColor( Color.RED.darker() );
        
        _startX = x;
        _startY = y;
        _dX = diffX;
        _dY = diffY;
        _time = 0;
        trail = new Vector<Ellipse>();
        
        _timer = new AnimationTimer( 10, this );
        _timer.start();
    }
    
    public void setLocation( int x, int y )
    {
        super.setLocation( x, y );
        _startX = x;
        _startY = y;
    }
    
    /**
     * Method to animate the movement of the projectile.
     */
    public void animate()
    {
        this.move();
    }
    
    /**
     * Calculates the location of the ball every second depending
     * on the initial dx and dy.
     */
    public void move()
    {
        double nX = _startX + _time * -0.015 * _dX;
        double g = 0.15;
        double gravity = 0.5 * g * _time * _time;
        double nY = _startY + _time * -0.015 * _dY + gravity;
        this.setLocation( (int)nX, (int)nY );
        _time++;
        Ellipse e = new Ellipse( );
        e.setSize( 2, 2 );
        e.setLocation( this.getXLocation(), this.getYLocation() );
        trail.add( e );
    }
    
    /**
     * Main method used to make a Frame and a Program9.
     * 
     * @param args String[]
     */
    public static void main( String[] args )
    {
        new Frame();
        //Projectile p = new Projectile( 100, 100, 20, 30 );
        Slingshot s = new Slingshot( 100, 400 );
    }
}