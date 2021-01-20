package UserCode.Factories;
import Framework.Interfaces.IDisplayObject;
import Framework.Implementations.DisplayObject;
/**
 *  A factory that creates a new IDisplayObject and returns it back
 * 
 * @author (Ryan Coles) 
 * @version (1.0)
 */
public class DisplayableFactory implements IDisplayableFactory
{    
     /**
     * Method createDisplayObject
     *
     * @param model location of the model
     * @param tex location of the texture
     * @param scale scale if the display object
     * @return IDisplayObject
     */
    public IDisplayObject createDisplayObject(String model, String tex, double scale)
    {
        //INSTANTIATE a new IDisplayObject and pass the model, texture and scale to the DisplayObject class
        IDisplayObject Entity=new DisplayObject(model,tex,scale);
        //Return the new IDisplayObject
        return Entity;
    }
}
