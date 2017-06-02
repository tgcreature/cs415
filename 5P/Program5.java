// ---------------       imports          ------------------------------
import wheelsunh.users.*;
import java.awt.Color;
import java.awt.event.MouseEvent;

/**
 * This is Program5. Program5 Tests all the different Creautres and buttons.
 * 
 * @author Travis Calley
 */
public class Program5
{
    /**
     * This constructor creates all of the creatures and buttons.
     */
    public Program5()
    {
        Creature topCre = new Creature();
        topCre.setLocation( Frame.getWidth() / 2 - topCre.getWidth() / 2, 
                       Frame.getHeight() / 2 - topCre.getHeight() - 75 );
        
        CreatureButton cb = new CreatureButton( Frame.getWidth() / 2 - 
                                                topCre.getWidth() / 2, 
                       Frame.getHeight() / 2 - topCre.getHeight() / 2, topCre );
        
        FlashlightCreature leftCre = new FlashlightCreature();
        leftCre.setLocation( Frame.getWidth() / 2 - leftCre.getWidth() * 2, 
                       Frame.getHeight() / 2 );
        leftCre.setColor( Color.GREEN );
        
        FlashlightCreatureButton fcb = new FlashlightCreatureButton( 0, 0, 
                                                                     leftCre );
        fcb.setLocation( Frame.getWidth() / 2 - leftCre.getWidth() * 2, 
                         Frame.getHeight() / 2 + leftCre.getHeight() + 20 );
        
        FireCreature rightCre = new FireCreature();
        rightCre.setLocation( Frame.getWidth() / 2 + rightCre.getWidth(),
                              Frame.getHeight() / 2 );
        
        FireCreatureButton scb = new FireCreatureButton( 0, 0, rightCre );
        scb.setLocation( rightCre.getXLocation(),
                         rightCre.getYLocation() + rightCre.getHeight() + 20 );
        
    }

    /**
     * Main constructor. Initializes a frame and an instance of Program5.
     * 
     * @param args String
     */
    public static void main( String[] args )
    {
        Frame f = new Frame();
        Program5 p = new Program5();
    }
}