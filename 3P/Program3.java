import wheelsunh.users.*;
import java.awt.Color;

/** 
 * Program3.java:
 * This program creates a method called makeCreature, this method creates a fish
 * at point xx, yy, and has Color color.
 *
 * @author Travis Calley
 * @assignment: 3P
 * 
 */
public class Program3 
{
    //---------------- instance variables ------------------------------
    
    private RoundedRectangle _topFin; // creates top fin behind fish's body
    private Ellipse _rightFin, _leftFin; // creates right and left fin 
    private Rectangle _backFin; // creates the fish's back fin
    private RoundedRectangle _fishBody; // creates the fish's body
    private Ellipse _eyeWhite; // creates the eye white
    private Ellipse _pupil; // creates the _pupil in the eye white
    private Rectangle _stripe1, _stripe2, _stripe3; // creates 3 stripes
    private Line _mouth;
    
    //------------------ magic numbers --------------------------------
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
    private int _mouthWidth = 10;
    private int _mouthHeight = 1;
    private int _eyeWhiteRadius = 15;
    private int xOffset = 65;
    private int yOffset = 50;
    // -----------------------------------------------------------------
    
    /** Constructor for the Program3 class.
      */
    public Program3( )
    {
        // code for fish one
        makeCreature( _x1, _y1, Color.YELLOW );
        // code for fish two
        makeCreature( _x2, _y2, Color.GREEN );
        // code for fish three
        makeCreature( _x3, _y3, Color.ORANGE );
        // code for fish four
        makeCreature( _x4, _y4, Color.RED );
    } 
    
    /** Creates a fish at given points x, y with Color color.
      * 
      * @param xx takes an initial x coordinate
      * @param yy takes an initial y coordinate
      * @param color takes a fishBody color
      */
    private void makeCreature( int xx, int yy, Color color )
    {
        _topFin = new RoundedRectangle( Color.CYAN );
        _topFin.setSize( _topFinWidth, _topFinHeight );
        _topFin.setLocation( xx + _topFinWidth / 2, yy + _topFinHeight / 2 );
        
        _rightFin = new Ellipse( Color.CYAN );
        _rightFin.setSize( _finWidth, _finHeight );
        _rightFin.setRotation( _rightFinRotation );
        _rightFin.setLocation( xx + _fishBodyWidth / 3, 
                              yy + _fishBodyHeight + _finHeight );
        
        _fishBody = new RoundedRectangle();
        _fishBody.setSize( _fishBodyWidth, _fishBodyHeight );
        _fishBody.setColor( color );
        _fishBody.setLocation( xx + xOffset - _fishBody.getWidth()
                                  / 2, yy + _fishBodyHeight / 4 );
        
        _eyeWhite = new Ellipse( Color.WHITE );
        _eyeWhite.setSize( _eyeWhiteRadius, _eyeWhiteRadius );
        _eyeWhite.setLocation( xx + xOffset - _fishBody.getWidth() / 2 + 
                              _eyeWhiteRadius, yy + _fishBodyHeight / 4 + 
                              _eyeWhiteRadius );
        
        _pupil = new Ellipse( Color.BLACK );
        _pupil.setSize( _pupilRadius, _pupilRadius );
        _pupil.setLocation( xx + xOffset - _fishBody.getWidth() / 2 + 
                           _eyeWhiteRadius, yy + _fishBodyHeight / 4 + 
                           _eyeWhiteRadius + _eyeWhite.getHeight( ) / 2 );
        
        _backFin = new Rectangle( Color.BLUE );
        _backFin.setSize( _backFinWidth, _backFinHeight );
        _backFin.setLocation( xx + xOffset - _fishBody.getWidth() / 2 + 
                             _fishBodyWidth / 2 + _backFinWidth * 3,
                             yy + _backFinHeight / 2 );

        _stripe1 = new Rectangle( Color.BLUE );
        _stripe1.setSize( _stripeWidth, _fishBody.getHeight() );
        _stripe1.setLocation( xx + xOffset - _stripeOffset, 
                             yy + _fishBody.getHeight() / 4 );

        _stripe2 = new Rectangle( Color.BLUE );
        _stripe2.setSize( _stripeWidth, _fishBody.getHeight() );
        _stripe2.setLocation( xx + xOffset, yy + _fishBody.getHeight() / 4 );

        _stripe3 = new Rectangle( Color.BLUE );
        _stripe3.setSize( _stripeWidth, _fishBody.getHeight() );
        _stripe3.setLocation( xx + xOffset + _stripeOffset, 
                             yy + _fishBody.getHeight() / 4 );

        _leftFin = new Ellipse();
        _leftFin.setSize( _finWidth, _finHeight );
        _leftFin.setColor( ( Color.CYAN ).darker() );
        _leftFin.setRotation( _leftFinRotation );
        _leftFin.setLocation( xx + xOffset - _fishBody.getWidth() / 6, 
                             yy + _fishBody.getHeight() + _finHeight );

        _mouth = new Line();
        _mouth.setSize( _mouthWidth, _mouthHeight );
        _mouth.setColor( Color.BLACK );
        _mouth.setLocation( xx + 20, yy + yOffset );
    }
    
    // -----------------------------------------------------------------
    /** main program creates a frame and invokes the class constructor.
      * 
      * @param args String[]
      */
    public static void main( String[] args )
    {
        new Frame();
        Program3 app = new Program3();
    }
} //End of Class Program3