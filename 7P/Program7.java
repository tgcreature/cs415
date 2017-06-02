// imports ----------------------------------------------------------------
import wheelsunh.users.*;
import java.awt.Color;
import java.awt.event.*;
import java.awt.Point;

/**
 * This is the Program7 class.
 * 
 * @author Travis Calley
 */
public class Program7
{

    private TravelingCreature _tc;

    
    /**
     * Default constructor for Program7.
     */
    public Program7()
    {   
        _tc = new TravelingCreature( 200, 200 );
    }
    
    /**
     * This is the main method that makes a Program7 and Frame.
     * 
     * @param args String
     */
    public static void main( String[] args )
    {
        new Frame();
        new Program7();
    }
}