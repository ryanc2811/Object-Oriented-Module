package UserCode.BubbleBlowing;
import java.util.List;
import java.util.ArrayList;
import UserCode.Vector3;
import Framework.Interfaces.IUpdatable;
/**
 * Write a description of class BubbleHandler here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BubbleHandler implements IBubbleBlowPublisher,IBubbleHandler
{
    // instance variables - replace the example below with your own
    private List<IBubbleBlowListener> _listeners;
    /**
     * Constructor for objects of class BubbleHandler
     */
    public BubbleHandler()
    {
        // initialise instance variables
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
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void Subscribe(IBubbleBlowListener BL)
    {
        // ADD new listener to the listeners list:
        _listeners.add(BL);
    }
    public void Unsubscribe(IBubbleBlowListener BL)
    {
         // REMOVE new listener to the listeners list:
        
        _listeners.remove(BL);
    }
}
