package UserCode.pets;


/**
 * FoodBehaviour - implements movement behaviour for fish food.
 * 
 * @author Marc Price 
 * @version 27012016
 */
public class FoodBehaviour extends Behaviour
{
    // instance variables - none

    /**
     * Constructor for objects of class FoodBehaviour
     */
    public FoodBehaviour()
    {
        // CALL super:
        super();
    }
    
    /**
     * METHOD: update behaviour simulation for next frame.
     * Food just moves downwards...
     * 
     */
    public void update()
    {
        _position[1] -= 0.04;
        
        try
        {
            _renderable.position(_position);
        }
        catch (ArgumentOutOfBoundsException e)
        {
            //System.out.println(e.getMessage());
        }
    }
}
