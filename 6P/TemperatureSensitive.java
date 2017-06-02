/** 
 * A TemperatureSensiive object can respond to
 * warm and cold.
 * 
 *  @author mlb
 */
public interface TemperatureSensitive
{
    /**
     * The weather is warm.
     */
    public void warm( );
    
    /**
     * The weather is cold.
     */
    public void cold( );
}