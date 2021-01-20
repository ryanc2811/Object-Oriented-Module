package UserCode.BubbleBlowing;


/**
 * Publisher of Bubble blow event.
 * 
 * @author (Ryan Coles) 
 * @version (1.0)
 */
public interface IBubbleBlowPublisher
{
    
    /**
     * METHOD: Subscribe a new listener for bubble events
     *
     * @param  BL  a reference to the listener that is being subscribed
     */
    void Subscribe(IBubbleBlowListener BL);
    /**
     * METHOD: Unsubscribe a new listener for bubble events
     *
     * @param  BL  a reference to the listener that is being unsubscribed
     */
    void Unsubscribe(IBubbleBlowListener BL);
}
