package UserCode.BubbleBlowing;
import UserCode.Vector3;

/**
 * Interface for the bubble Handler
 * 
 * @author (Ryan Coles) 
 * @version (1.0)
 */
public interface IBubbleHandler
{
    /**
     * Method BubbleBlown
     * event for the bubble being blown
     * @param Position Position of the bubble
     */
    public void BubbleBlown(Vector3 Position);
}
