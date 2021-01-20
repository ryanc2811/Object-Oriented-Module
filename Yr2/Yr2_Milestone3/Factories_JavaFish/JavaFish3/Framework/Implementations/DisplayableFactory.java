package Framework.Implementations;
import Framework.Interfaces.*;

/**
 * Write a description of class EntityManager here.
 * 
 * @author (Ryan Coles) 
 * @version (1.0)
 */
public class DisplayableFactory implements IDisplayableFactory
{    

    /**
     * Constructor for objects of class EntityManager
     */
    public DisplayableFactory()
    {
        // initialise instance variables
        
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public IDisplayObject createDisplayObject(String model, String tex, double scale)
    {
        // put your code here
        IDisplayObject Entity=new DisplayObject(model,tex,scale);
        return Entity;
    }
}
