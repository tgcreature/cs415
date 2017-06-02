// imports ----------------------------------------------------------------
import wheelsunh.users.*;
import java.awt.Color;

/**
 * Program9 is the main program that initialize all other objects.
 * 
 * @author Travis Calley
 */
public class Program9
{
    // instance variables -------------------------------------------------
    Building _b1, _b2, _b3, _b4, _b5, _b6, _b7, _b8, _b9, _b10;
    Slingshot slingshot;
    
    /**
     * Default constructor.
     */
    public Program9()
    {
        _b1 = new Building( 150 );
        _b2 = new Building( 150 + _b1.getWidth() );
        _b3 = new Building( _b2.getXLocation() + _b2.getWidth() );
        _b4 = new Building( _b3.getXLocation() + _b3.getWidth() );
        _b5 = new Building( _b4.getXLocation() + _b4.getWidth() );
        _b6 = new Building( _b5.getXLocation() + _b5.getWidth() );
        _b7 = new Building( _b6.getXLocation() + _b6.getWidth() );
        _b8 = new Building( _b7.getXLocation() + _b7.getWidth() );
        _b9 = new Building( _b8.getXLocation() + _b8.getWidth() );
        _b10 = new Building( _b9.getXLocation() + _b9.getWidth() );
        slingshot = new Slingshot( 50, 400 );
    }
    
    /**
     * Main method used to make a Frame and a Program9.
     * 
     * @param args String[]
     */
    public static void main( String[] args )
    {
        new Frame();
        new Program9();
    }
}