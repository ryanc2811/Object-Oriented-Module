package UserCode.Factories;
import Framework.Interfaces.IDisplayObject;
/**
 * Interface for factory that creates a new IDisplayObject and returns it back
 * 
 * @author (Ryan Coles) 
 * @version (1.0)
 */
public interface IDisplayableFactory
{
    /**
     * Method createDisplayObject
     *
     * @param model location of the model
     * @param tex location of the texture
     * @param scale scale if the display object
     * @return IDisplayObject
     */
    IDisplayObject createDisplayObject(String model, String tex, double scale);
}
