package UserCode.Entities;
import UserCode.BubbleBlowing.BubbleBlower;

/**
 * Interface for all fish that can emit bubbles.
 * 
 * @author (Ryan Coles) 
 * @version (1.0)
 */
public interface IMouth
{
    /**
     * Method receiveBubbleBlower
     * pass BubbleBlower
     * @param BB bubbleBlower
     */
    void receiveBubbleBlower(BubbleBlower BB);
}
