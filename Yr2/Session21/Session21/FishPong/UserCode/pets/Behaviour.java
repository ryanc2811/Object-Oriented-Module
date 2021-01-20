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

    // DECLARE reference to the associated IToken, call it '_token':
    protected IToken _token;

    // METHOD: Return the position coordinates:
    //public Double[] position()
    //{
    //    return _position;
    //}
   
    // METHOD: Return the orientation coordinates:
    //public Double[] orientation()
    //{
    //    return _orientation;        
    //}
   

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
     * @param token a reference to the associated Token instance
     * @param posn a Double[3] that gives the x,y,z position coordinates of the associated Token instance
     * @param angle a Double[3] that gives the orientation about x,y,z axes of the associated Token instance
     */
    public void Initialise(IToken token, Double[] posn, Double[] angle) throws ArgumentOutOfBoundsException, NullPointerException
    {
            // SET the new position:
            _position = posn;
        
            // SET the new orientation:
            _orientation = angle;
        
            // SET reference to associated token:
            _token = token;
    }

    /**
     * METHOD: update behaviour simulation for next frame.
     * 
     */
    public abstract void update() throws ArgumentOutOfBoundsException;

}
