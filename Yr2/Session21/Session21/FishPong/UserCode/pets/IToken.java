package UserCode.pets;


/**
 * IToken defines the interface for all tokens within a JFF simulation.
 * 
 * @author Marc Price 
 * @version 23122015
 */
public interface IToken
{
    /**
     * METHOD: Place the token at the given position within the aquarium
     *
     * @param  coords   the new position (x,y,z) of the token as an array of three Doubles.  The element values must be 0.0 &lt value &lt 10.0.
     */
    public void position(Double ...coords) throws ArgumentOutOfBoundsException;
    
    /**
     * METHOD: Place the token at the given orientation within the aquarium
     *
     * @param  coords   the new orientation (x,y,z) of the token as an array of three Doubles
     */
    public void orientation(Double ...coords);
}

