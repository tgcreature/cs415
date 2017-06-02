import wheelsunh.users.*;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;

/** 
 * Program6.java: Puts some TemperatureSensitive objects 
 * through a temperature cycle.
 * 
 *  @author cs415 
 */
public class Program6  extends ShapeGroup
{  
    //---------------- instance variables -------------------------------------
    private Rectangle _background;   // the sky
    private Color _warmBackgroundColor;
    private Color _coldBackgroundColor;
    private int _season = 0;
    private TextBox _text;
    
    // Three TemperatureSensitive objects 
    private TemperatureSensitive _sensitive1;  
    private TemperatureSensitive _sensitive2;
    private TemperatureSensitive _sensitive3;
    
    
    
    
    /**
     *  Create a background and three draggable TemperatureSensitives and
     *  run them through a daily cycle.
     */
    public Program6(  )
    {
        
        // create the background
        _warmBackgroundColor = new Color( 200, 200, 255 ); // summery blue
        _coldBackgroundColor = new Color( 200, 200, 200 ); // wintery gray
        _background = new Rectangle( 0, 0 );
        _background.setSize( 700, 500 );
        
        _text = new TextBox( 270, 10 );
        _text.setWidth ( 230 );
        _text.setColor( new Color( 255, 255, 255, 1 ) );
        
        add( _background );
        add( _text );
        
        
        ////////////////////////////////////////////
        // Change the code below:
        // replace the nulls with your objects:
        // Construct your three TemperatureSensitive objects
        // and assign them to these instance variables
        ////////////////////////////////////////////
        
        _sensitive1 = new Creature( 400, 200 );  
        _sensitive2 = new Tree( 100, 350 );
        _sensitive3 = new DogHouse( 200, 50 );
        
        ////////////////////////////////////////////
        // Do not change any other code in 
        // Program6
        ////////////////////////////////////////////
        changeTemperature(  );
        
    }
    
    //--------------------------------------------------------------------
    /**
     *   Change the temperature.
     * 
     */ 
    public void  changeTemperature(  )
    {
        _season++;
        if( _season % 2 == 0 )  // it's cold
        {
            _background.setColor( _coldBackgroundColor );
            _text.setText( "Cold Temperature" );
            _text.setColor( _coldBackgroundColor );
            _text.setWidth ( 230 );
            if( _sensitive1 != null )
                _sensitive1.cold( );  
            if( _sensitive2 != null )
                _sensitive2.cold( ); 
            if( _sensitive3 != null )
                _sensitive3.cold( );
        }          
        else // now it's warm
        {
            _text.setText( "Warm Temperature  " );
            _text.setWidth ( 280 );
            _background.setColor( _warmBackgroundColor );
            _text.setColor( _warmBackgroundColor );
            if( _sensitive1 != null )  
                _sensitive1.warm( );
            if( _sensitive2 != null )
                _sensitive2.warm( );   
            if( _sensitive3 != null )
                _sensitive3.warm( );
        }               
    }
    
    
    /**
     * Change the temperature.
     * 
     * @param me MouseEvent
     */
    public void mouseClicked( MouseEvent me )
    {
        changeTemperature(  );   
    }
    
    
    
    /** 
     * Start the program.
     * 
     * @param args String[]
     */
    public static void main( String[ ] args )
    {      
        new Frame( );
        new Program6(  ); 
    }  
    
} //End of Class Program6


