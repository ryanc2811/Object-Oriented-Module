package UserCode.BubbleBlowing;
import java.util.List;
import java.util.ArrayList;
import UserCode.Vector3;
import Framework.Interfaces.IUpdatable;
/**
 * Handles Bubble blow Event
 * 
 * @author (Ryan Coles) 
 * @version (1.0)
 */
public class BubbleHandler implements IBubbleBlowPublisher,IBubbleHandler
{
    // DECLARE a list of IIBubbleBlowListeners to store the event listener methods, call it _listeners:
    private List<IBubbleBlowListener> _listeners;
    /**
     * Constructor for objects of class BubbleHandler
     */
    public BubbleHandler()
    {
        // INSTANTIATE _listeners lists
       _listeners=new ArrayList<IBubbleBlowListener>();
    }
    public void BubbleBlown(Vector3 Position)
    {
        // RAISE event for each listener:
        for (IBubbleBlowListener BL : _listeners)
        {
            BL.OnBubbleBlow(Position);
        }
    }
    /**
     * METHOD: Subscribe a new listener for bubble events
     *
     * @param  BL  a reference to the listener that is being subscribed
     */
    public void Subscribe(IBubbleBlowListener BL)
    {
        // ADD new listener to the listeners list:
        _listeners.add(BL);
    }
    /**
     * METHOD: Unsubscribe a new listener for bubble events
     *
     * @param  BL  a reference to the listener that is being unsubscribed
     */
    public void Unsubscribe(IBubbleBlowListener BL)
    {
         // REMOVE new listener to the listeners list:
        _listeners.remove(BL);
    }
}
