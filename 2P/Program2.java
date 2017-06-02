import wheelsunh.users.*;
import java.awt.Color;

/** 
 * Program2.java:
 * Draws two pads for drawing creepy sea creatures. 
 * Then relatively positions two identical sea creatures within two pads.
 *
 * @author Travis Calley
 * @assignment: 2P
 * 
 */
public class Program2 
{
    //---------------- instance variables ------------------------------
    
    private Rectangle _pad1, _pad2;
    private int _x1 = 200, _y1 = 200, _x2 = 400, _y2 = 200;
    private int _padX = 130, _padY = 110;
    
    private RoundedRectangle _topFin; // creates top fin behind fish's body
    private Ellipse _rightFin, _leftFin; // creates right and left fin 
    private Rectangle _backFin; // creates the fish's back fin
    private RoundedRectangle _fishBody; // creates the fish's body
    private Ellipse _eyeWhite; // creates the eye white
    private Ellipse _pupil; // creates the _pupil in the eye white
    private Rectangle _stripe1, _stripe2, _stripe3; // creates 3 stripes
    private Line _mouth;
    
    //------------------ magic numbers --------------------------------
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
    /** Constructor for the Program2 class.
      */
    public Program2( )
    {
        _pad1 = new Rectangle( _x1, _y1 );
        _pad1.setFillColor( Color.WHITE );
        _pad1.setFrameColor( Color.BLACK );
        _pad1.setSize( _padX, _padY );
        
        _pad2 = new Rectangle( _x2, _y2 );
        _pad2.setFillColor( Color.WHITE );
        _pad2.setFrameColor( Color.BLACK );
        _pad2.setSize( _padX, _padY );
        //--------------------------------------------------------------------
        // code for fish one
        _topFin = new RoundedRectangle( Color.CYAN );
        _topFin.setSize( _topFinWidth, _topFinHeight );
        _topFin.setLocation( _x1 + _topFinWidth / 2, _y1 + _topFinHeight / 2 );
        
        _rightFin = new Ellipse( Color.CYAN );
        _rightFin.setSize( _finWidth, _finHeight );
        _rightFin.setRotation( _rightFinRotation );
        _rightFin.setLocation( _x1 + _fishBodyWidth / 3, 
                              _y1 + _fishBodyHeight + _finHeight );
        
        _fishBody = new RoundedRectangle();
        _fishBody.setSize( _fishBodyWidth, _fishBodyHeight );
        _fishBody.setColor( Color.YELLOW );
        _fishBody.setLocation( _x1 + xOffset - _fishBody.getWidth()
                                  / 2, _y1 + _fishBodyHeight / 4 );
        
        _eyeWhite = new Ellipse( Color.WHITE );
        _eyeWhite.setSize( _eyeWhiteRadius, _eyeWhiteRadius );
        _eyeWhite.setLocation( _x1 + xOffset - _fishBody.getWidth() / 2 + 
                              _eyeWhiteRadius, _y1 + _fishBodyHeight / 4 + 
                              _eyeWhiteRadius );
        
        _pupil = new Ellipse( Color.BLACK );
        _pupil.setSize( _pupilRadius, _pupilRadius );
        _pupil.setLocation( _x1 + xOffset - _fishBody.getWidth() / 2 + 
                           _eyeWhiteRadius, _y1 + _fishBodyHeight / 4 + 
                           _eyeWhiteRadius + _eyeWhite.getHeight( ) / 2 );
        
        _backFin = new Rectangle( Color.BLUE );
        _backFin.setSize( _backFinWidth, _backFinHeight );
        _backFin.setLocation( _x1 + xOffset - _fishBody.getWidth() / 2 + 
                             _fishBodyWidth / 2 + _backFinWidth * 3,
                             _y1 + _backFinHeight / 2 );

        _stripe1 = new Rectangle( Color.BLUE );
        _stripe1.setSize( _stripeWidth, _fishBody.getHeight() );
        _stripe1.setLocation( _x1 + xOffset - _stripeOffset, _y1 + 
                             _fishBody.getHeight() / 4 );

        _stripe2 = new Rectangle( Color.BLUE );
        _stripe2.setSize( _stripeWidth, _fishBody.getHeight() );
        _stripe2.setLocation( _x1 + xOffset, _y1 + _fishBody.getHeight() / 4 );

        _stripe3 = new Rectangle( Color.BLUE );
        _stripe3.setSize( _stripeWidth, _fishBody.getHeight() );
        _stripe3.setLocation( _x1 + xOffset + _stripeOffset, _y1 + 
                             _fishBody.getHeight() / 4 );

        _leftFin = new Ellipse();
        _leftFin.setSize( _finWidth, _finHeight );
        _leftFin.setColor( ( Color.CYAN ).darker() );
        _leftFin.setRotation( _leftFinRotation );
        _leftFin.setLocation( _x1 + xOffset - _fishBody.getWidth() / 6, 
                             _y1 + _fishBody.getHeight() + _finHeight );

        _mouth = new Line();
        _mouth.setSize( _mouthWidth, _mouthHeight );
        _mouth.setColor( Color.BLACK );
        _mouth.setLocation( _x1 + 20, _y1 + yOffset );
        //--------------------------------------------------------------------
        // code for fish two
        _topFin = new RoundedRectangle( Color.CYAN );
        _topFin.setSize( _topFinWidth, _topFinHeight );
        _topFin.setLocation( _x2 + _topFinWidth / 2, _y2 + _topFinHeight / 2 );
        
        _rightFin = new Ellipse( Color.CYAN );
        _rightFin.setSize( _finWidth, _finHeight );
        _rightFin.setRotation( _rightFinRotation );
        _rightFin.setLocation( _x2 + _fishBodyWidth / 3, 
                              _y2 + _fishBodyHeight + _finHeight );
        
        _fishBody = new RoundedRectangle();
        _fishBody.setSize( _fishBodyWidth, _fishBodyHeight );
        _fishBody.setColor( Color.YELLOW );
        _fishBody.setLocation( _x2 + xOffset - _fishBody.getWidth()
                                  / 2, _y2 + _fishBodyHeight / 4 );
        
        _eyeWhite = new Ellipse( Color.WHITE );
        _eyeWhite.setSize( _eyeWhiteRadius, _eyeWhiteRadius );
        _eyeWhite.setLocation( _x2 + xOffset - _fishBody.getWidth() / 2 + 
                              _eyeWhiteRadius, _y2 + _fishBodyHeight / 4 + 
                              _eyeWhiteRadius );
        
        _pupil = new Ellipse( Color.BLACK );
        _pupil.setSize( _pupilRadius, _pupilRadius );
        _pupil.setLocation( _x2 + xOffset - _fishBody.getWidth() / 2 + 
                           _eyeWhiteRadius, _y2 + _fishBodyHeight / 4 + 
                           _eyeWhiteRadius + _eyeWhite.getHeight( ) / 2 );
        
        _backFin = new Rectangle( Color.BLUE );
        _backFin.setSize( _backFinWidth, _backFinHeight );
        _backFin.setLocation( _x2 + xOffset - _fishBody.getWidth() / 2 + 
                             _fishBodyWidth / 2 + _backFinWidth * 3,
                             _y2 + _backFinHeight / 2 );

        _stripe1 = new Rectangle( Color.BLUE );
        _stripe1.setSize( _stripeWidth, _fishBody.getHeight() );
        _stripe1.setLocation( _x2 + xOffset - _stripeOffset, _y2 + 
                             _fishBody.getHeight() / 4 );

        _stripe2 = new Rectangle( Color.BLUE );
        _stripe2.setSize( _stripeWidth, _fishBody.getHeight() );
        _stripe2.setLocation( _x2 + xOffset, _y2 + _fishBody.getHeight() / 4 );

        _stripe3 = new Rectangle( Color.BLUE );
        _stripe3.setSize( _stripeWidth, _fishBody.getHeight() );
        _stripe3.setLocation( _x2 + xOffset + _stripeOffset, _y2 + 
                             _fishBody.getHeight() / 4 );

        _leftFin = new Ellipse();
        _leftFin.setSize( _finWidth, _finHeight );
        _leftFin.setColor( ( Color.CYAN ).darker() );
        _leftFin.setRotation( _leftFinRotation );
        _leftFin.setLocation( _x2 + xOffset - _fishBody.getWidth() / 6, 
                             _y2 + _fishBody.getHeight() + _finHeight );

        _mouth = new Line();
        _mouth.setSize( _mouthWidth, _mouthHeight );
        _mouth.setColor( Color.BLACK );
        _mouth.setLocation( _x2 + 20, _y2 + yOffset );
    } 
    
    // -----------------------------------------------------------------
    /** main program creates a frame and invokes the class constructor.
      * 
      * @param args String[]
      */
    public static void main( String[] args )
    {
        new Frame();
        Program2 app = new Program2();
    }
} //End of Class Program2