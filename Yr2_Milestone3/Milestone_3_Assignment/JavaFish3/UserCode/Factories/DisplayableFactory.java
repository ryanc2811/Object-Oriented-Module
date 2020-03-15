package UserCode.Factories;
import Framework.Interfaces.IDisplayObject;
import Framework.Implementations.DisplayObject;
/**
 * Write a description of class EntityManager here.
 * 
 * @author (Ryan Coles) 
 * @version (1.0)
 */
public class DisplayableFactory implements IDisplayableFactory
{    
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
