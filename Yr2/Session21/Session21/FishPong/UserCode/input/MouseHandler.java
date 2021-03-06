package UserCode.input;

import java.util.List;
import java.util.ArrayList;
import env3d.Env;

/**
 * Handles Mouse Events specifically for the Session 15 exercise.
 * 
 * @author Marc Price 
 * @version 0.5
 */
public class MouseHandler implements IInputPublisher
{
    // instance variables:
    // DECLARE a list of IInputListener to store the event listener methods, call it _listeners:
    private List<IInputListener> _listeners;    

    /**
     * Constructor for objects of class MouseHandler
     */
    public MouseHandler()
    {
        // initialise instance variables:
        //INSTANTIATE listeners list:
        _listeners = new ArrayList<IInputListener>();
        
    }
    
    /**
     * METHOD: Subscribe a new listener for mouse events
     *
     * @param  l   a reference to the listener that is being subscribed
     */
    public void subscribe(IInputListener l)
    {
        // ADD new listener to the listeners list:
        _listeners.add(l);
    }

    /**
     * METHOD: Unsubscribe a listener
     *
     * @param  l   a reference to the listener that is being unsubscribed
     */
    public void unsubscribe(IInputListener l)
    {
        // ADD new listener to the listeners list:
        _listeners.remove(l);
    }

    /**
     * METHOD: Update the Mouse state
     *
     */
    public void update(Env world)
    {
        // local variables:
        // DECLARE an int[] array for the method return value
        // INITIALISE: to return -1,-1
        int[] rtnVal={-1,-1};
        
        // IF: the left mouse button has been clicked
        if (world.getMouseButtonClicked() == 0)
        {
            // SET rtnVal to x,y coordinates of mouse pointer:
            rtnVal[0] = world.getMouseX();
            rtnVal[1] = world.getMouseY();
            
            // RAISE event for each listener:
            for (IInputListener l : _listeners)
                l.onInput(rtnVal);
        }

    }

}
