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
     * @param renderabl,e a reference to the associated Renderable instance
     * @param posn a Double[3] that gives the x,y,z position coordinates of the associated Renderable instance
     * @param angle a Double[3] that gives the orientation about x,y,z axes of the associated Renderable instance
     */
    void Initialise(IRenderable renderable, Double[] posn, Double[] angle) throws ArgumentOutOfBoundsException, NullPointerException;
    
    
    /**
     * METHOD: update behaviour simulation for next frame.
     * 
     */
    void update();
}
