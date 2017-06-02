import wheelsunh.users.*;
import java.awt.Color;
/** 
 * Puts a Creature's through its paces. 
 * @author Travis Calley
 */
public class Program4
{ 
    //---------------- instance variables -----------------------------
    private TextBox positionLabel;
    
    // -----------------------------------------------------------------
    /**
     * Constructor for Program4 class.
     */
    public Program4()
    {
        positionLabel = new TextBox( 270, 240 );
        positionLabel.setSize( 250, 250 );  
        
        Creature fish = new Creature ( Color.GREEN );
        
        positionLabel.setText( "Creatures y-coordinate: " + 
                                fish.getYLocation() );
        
        Utilities.sleep( 2000 );
        
        fish.setLocation( 100, 400 );
        
        positionLabel.setText( "Creatures y-coordinate: " + 
                                   fish.getYLocation() );
        
        Utilities.sleep( 1000 );
        
        while( fish.getYLocation() != 0 )
        {
            fish.moveUp( 5 );
            positionLabel.setText( "Creatures y-coordinate: " + 
                                   fish.getYLocation() );
            Utilities.sleep( 17 );
        }
    }
    
    //-------------------- main ----------------------------------------
    /**
     * Just create a Program4r object.
     * @param args String
     */
    public static void main( String[] args )
    {
        Frame f = new Frame();
        Program4 test = new Program4();
    }
}