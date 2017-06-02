import wheelsunh.users.*;
import java.awt.Color;

/** 
 * Program1.java:
 * Displays a pad for building a sea creature.
 *
 * @author Travis Calley
 * @assignment: 1P
 * 
 * mb 8/12
 * 
 */
public class Program1 
{
    
    //---------------- instance variables ------------------------------
    
    private Rectangle _pad;
    private RoundedRectangle _topFin; // creates top fin behind fish's body
    private Ellipse _rightFin, _leftFin; // creates right and left fin 
    private Rectangle _backFin; // creates the fish's back fin
    private RoundedRectangle _fishBody; // creates the fish's body
    private Ellipse _eyeWhite; // creates the eye white
    private Ellipse _pupil; // creates the _pupil in the eye white
    private Rectangle _stripe1, _stripe2, _stripe3; // creates 3 stripes
    private Line _mouth; // creates the mouth
    
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
    private int _mouthWidth = 10;
    private int _mouthHeight = 1;
    private int _eyeWhiteRadius = 15;
    
    // -----------------------------------------------------------------
    /** Constructor.
      */
    public Program1( )
    {
        _pad = new Rectangle( 200, 200 );
        _pad.setFillColor( Color.WHITE );
        _pad.setFrameColor( Color.BLACK );
        _pad.setSize( 130, 110 );
        //-------------------------------------------------------------
        
        // add your code here
        _topFin = new RoundedRectangle();
        _topFin.setSize( _topFinWidth, _topFinHeight );
        _topFin.setLocation( _pad.getXLocation() + _topFinWidth / 2,
                            _pad.getYLocation() + _topFinHeight / 2 );
        _topFin.setFillColor( Color.CYAN );
        _topFin.setFrameColor( Color.CYAN );
        
        _rightFin = new Ellipse();
        _rightFin.setSize( _finWidth, _finHeight );
        _rightFin.setColor( Color.CYAN );
        _rightFin.setRotation( _rightFinRotation );
        _rightFin.setLocation( _pad.getXLocation() + _finWidth, 
                              _pad.getYLocation() + _fishBodyHeight + 
                              _finHeight );
        
        _fishBody = new RoundedRectangle();
        _fishBody.setSize( _fishBodyWidth, _fishBodyHeight );
        _fishBody.setColor( Color.YELLOW );
        _fishBody.setLocation( _pad.getXLocation() + _pad.getWidth() / 2 - 
                              _fishBody.getWidth() / 2, _pad.getYLocation() + 
                              _fishBodyHeight / 4 );
        
        _eyeWhite = new Ellipse();
        _eyeWhite.setSize( _eyeWhiteRadius, _eyeWhiteRadius );
        _eyeWhite.setColor( Color.WHITE );
        _eyeWhite.setLocation( _fishBody.getXLocation() + _eyeWhiteRadius,
                              _fishBody.getYLocation() + _eyeWhiteRadius );
        
        _pupil = new Ellipse();
        _pupil.setSize( _pupilRadius, _pupilRadius );
        _pupil.setColor( Color.BLACK );
        _pupil.setLocation( _eyeWhite.getXLocation(), _eyeWhite.getYLocation()
                               + _eyeWhite.getHeight( ) / 2 );
        
        _backFin = new Rectangle();
        _backFin.setSize( _backFinWidth, _backFinHeight );
        _backFin.setColor( Color.BLUE );
        _backFin.setLocation( _fishBody.getCenterX() + _backFinWidth * 3,
                             _fishBody.getCenterY() - _backFinHeight / 2 );
    
        _stripe1 = new Rectangle();
        _stripe1.setSize( _stripeWidth, _fishBody.getHeight() );
        _stripe1.setColor( Color.BLUE );
        _stripe1.setLocation( _fishBody.getCenterX() - _stripeOffset,
                           _fishBody.getCenterY() - _fishBodyHeight / 2 );
        
        _stripe2 = new Rectangle();
        _stripe2.setSize( _stripeWidth, _fishBody.getHeight() );
        _stripe2.setColor( Color.BLUE );
        _stripe2.setLocation( _fishBody.getCenterX(),
                           _fishBody.getCenterY() - _fishBodyHeight / 2 );
        
        _stripe3 = new Rectangle();
        _stripe3.setSize( _stripeWidth, _fishBody.getHeight() );
        _stripe3.setColor( Color.BLUE );
        _stripe3.setLocation( _fishBody.getCenterX() + _stripeOffset,
                             _fishBody.getCenterY() - _fishBodyHeight / 2 );
        
        _leftFin = new Ellipse();
        _leftFin.setSize( _finWidth, _finHeight );
        _leftFin.setColor( ( Color.CYAN ).darker() );
        _leftFin.setRotation( _leftFinRotation );
        _leftFin.setLocation( _fishBody.getCenterX() - _fishBody.getWidth() / 6,
                             _fishBody.getYLocation() +
                             _fishBody.getHeight() - 10 );
        
        _mouth = new Line();
        _mouth.setSize( _mouthWidth, _mouthHeight );
        _mouth.setColor( Color.BLACK );
        _mouth.setLocation( _fishBody.getXLocation(), _fishBody.getCenterY() );
    } 
    
    // -----------------------------------------------------------------
    /** main program just invokes the class constructor.
      * 
      * @param args String array
      * 
      */
    public static void main( String[] args )
    {
        new Frame( );
        Program1 app = new Program1();
    }
} //End of Class Program1