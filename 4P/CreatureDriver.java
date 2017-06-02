import wheelsunh.users.*;
import java.awt.Color;
/** 
 * Puts  an Creature's through its paces. 
 * @author CS415  
 */
public class CreatureDriver
{ 
    //---------------- instance variables ------------------------------
    private Creature     myCreature;          
    private TextBox label,  colorLabel, locStartLabel, locEndLabel;   
    
    //--------------- constructor --------------------------------------
    /**
     * 
     *  Construct a Creature and then test it.
     *  TextBox objects are displayed  to show results.
     */
    public CreatureDriver()
    {
        label = new TextBox( 270, 40 );
        label.setSize( 290, 100 );
        label.setText( "No parameter Constructor" );
        
        myCreature = new Creature();
        
        Utilities.sleep( 2000 );
        
        label.setText( "Two parameter Constructor\n ( 20,200 )" );
        Utilities.sleep( 1000 );
        myCreature = new Creature( 20, 200 );
        
        Utilities.sleep( 2000 );
        
        label.setText( "One parameter Constructor\n (ORANGE)" );
        Utilities.sleep( 1000 );
        myCreature = new Creature( Color.ORANGE );
        
        Utilities.sleep( 2000 );
        
        label.setText( "SetLocation ( 40, 350 ) " );
        Utilities.sleep( 1000 );
        myCreature.setLocation( 40, 350 );
        
        Utilities.sleep( 2000 );
        label.setText( "SetColor (PINK) " );
        Utilities.sleep( 1000 );
        myCreature.setColor( Color.pink );
        
        
        Utilities.sleep( 2000 );
        colorLabel = new TextBox( 270, 140 );
        colorLabel.setSize( 290, 100 );
        
        colorLabel.setText( "getColor =  " + myCreature.getColor() +
                           "\n ( 225, 175, 175 )" );
        
        Utilities.sleep( 2000 );
        
        locStartLabel = new TextBox( 270, 240 );
        locStartLabel.setSize( 290, 100 );      
        locStartLabel.setText( "Start Location" +
                              "\ngetXlocation =  " +
                              myCreature.getXLocation() +
                              "\ngetYLocation = " + 
                              myCreature.getYLocation() +
                              "\n (40, 350)\n" );     
        Utilities.sleep( 1000 );
        
        label.setText( "moveUp " );
        Utilities.sleep( 1000 );
        
        for( int i = 0; i < 60; i++ )
        {
            myCreature.moveUp( 5 );
            Utilities.sleep( 20 );
        }
        
        locEndLabel = new TextBox( 270, 340 );
        locEndLabel.setSize( 290, 100 ); 
        locEndLabel.setText( "End Location" +
                            "\ngetXlocation = " +
                            myCreature.getXLocation() +
                            "\ngetYLocation = " + 
                            myCreature.getYLocation() +
                            "\n (40, 50)\n" );
    }
    
    //-------------------- main ----------------------------------------
    /**
     * Just create a CreatureDriver object.
     * @param args String
     */
    public static void main( String[] args )
    {
        new Frame();
        new CreatureDriver();
    }
}