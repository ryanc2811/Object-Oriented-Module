package UserCode.BubbleBlowing;
import UserCode.Vector3;
/**
 * Listens of OnBubbleBlow event
 * 
 * @author (Ryan Coles) 
 * @version (1.0)
 */
public interface IBubbleBlowListener
{
    /**
     * Method OnBubbleBlow
     * Event for the Bubble being blown
     * @param Position Vector3 position of the bubble
     */
    void OnBubbleBlow(Vector3 Position);
}
