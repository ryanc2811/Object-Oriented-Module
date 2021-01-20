package UserCode.pets;


/**
 * IBehaviour: the interface for any behaviour.
 * 
 * @author Marc Price 
 * @version 27012016
 */
public interface IBehaviour
{
    /**
     * METHOD: Initialise fields of the IBehaviour
     * 
     * @param token a reference to the associated Token instance
     * @param posn a Double[3] that gives the x,y,z position coordinates of the associated Token instance
     * @param angle a Double[3] that gives the orientation about x,y,z axes of the associated Token instance
     */
    void Initialise(IToken token, Double[] posn, Double[] angle) throws ArgumentOutOfBoundsException, NullPointerException;
    
    
    /**
     * METHOD: update behaviour simulation for next frame.
     * 
     */
    void update() throws ArgumentOutOfBoundsException;
}
