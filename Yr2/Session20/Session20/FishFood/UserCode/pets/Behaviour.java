package UserCode.pets;


/**
 * Abstract class Behaviour - all common code required for implementing behaviours.
 * 
 * @author Marc Price
 * @version 27012016
 */
public abstract class Behaviour implements IBehaviour
{
    // instance variables:
    // DECLARE a 3 element array of Doubles to store position (x,y,z) coordinates, call it _position,
    // and initialise it to 1,1,1:
    protected Double[] _position = {1.0,1.0,1.0};
    
    // DECLARE a 3 element array of Doubles to store orientation (x,y,z) angles (in degrees),
    // call it _orientation, and initialise it to 0,0,0:
    protected Double[] _orientation = {0.0,0.0,0.0};

    // DECLARE reference to the associated IRenderable, call it '_renderable':
    protected IRenderable _renderable;

    // METHOD: Return the position coordinates:
    public Double[] position()
    {
        return _position;
    }
   
    // METHOD: Return the orientation coordinates:
    public Double[] orientation()
    {
        return _orientation;        
    }
   

    /**
     * Default constructor for objects of class Behaviour (only ever called from subclass).
     * 
     */
    public Behaviour()
    {
        // initialise instance variables
        // (all done in field declarations)
    }

    /**
     * METHOD: Initialise fields of the IBehaviour
     * 
     * @param renderable a reference to the associated Renderable instance
     * @param posn a Double[3] that gives the x,y,z position coordinates of the associated Renderable instance
     * @param angle a Double[3] that gives the orientation about x,y,z axes of the associated Renderable instance
     */
    public void Initialise(IRenderable renderable, Double[] posn, Double[] angle) throws ArgumentOutOfBoundsException, NullPointerException
    {    
        // VALIDATE posn:
        if ((posn[0] < 0.0)||(posn[0] > 10.0)||
            (posn[1] < 0.0)||(posn[1] > 10.0)||
            (posn[2] < 0.0)||(posn[2] > 10.0))
            throw new ArgumentOutOfBoundsException("posn[] values must be within range: 0.0 < value < 10.0");
        else
        {
            // SET the new position:
            _position = posn;
        
            // SET the new orientation:
            _orientation = angle;
        
            // SET reference to associated renderable:
            _renderable = renderable;
         
        }
    }

    /**
     * METHOD: update behaviour simulation for next frame.
     * 
     */
    public abstract void update();

}
