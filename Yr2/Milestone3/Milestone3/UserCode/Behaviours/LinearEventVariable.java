package UserCode.Behaviours;


import java.util.List;
import java.util.ArrayList;

import UserCode.EventHandling.IEventPublisher;
import UserCode.EventHandling.IEventListener;

/**
 * LinearEventVariable inherits LinearVariable.  This version publishes an event when the variable reaches either of its bounds.
 *
 * @author Marc Price
 * @version 0.1
 */
public class LinearEventVariable extends LinearVariable implements IEventPublisher
{
    // instance variables:
    // DECLARE a list of IEventListener to store the event listener methods, call it _listeners:
    private List<IEventListener> _listeners;


    /**
     * Constructor for objects of class LinearEventVariable
     */
    public LinearEventVariable()
    {
        //INSTANTIATE _listeners:
        _listeners = new ArrayList<IEventListener>();
    }

    
    // ------------------------- Implementation of IEventPublisher -------------------------------//
    /**
     * METHOD: Subscribe a new listener for direction-change events
     *
     * @param  l   a reference to the listener that is being subscribed
     */
    public void subscribe(IEventListener l)
    {
        // ADD new listener to the listeners list:
        _listeners.add(l);
    }

    /**
     * METHOD: Unsubscribe a listener
     *
     * @param  l   a reference to the listener that is being unsubscribed
     */
    public void unsubscribe(IEventListener l)
    {
        // ADD new listener to the listeners list:
        _listeners.remove(l);
    }

    
    // --------------------------------- Implementation of IUpdatable ------------------------------ //
    /**
     * METHOD: change to variable for next frame - calls parent update method and fires an event if a direction-change occurs.
     * 
     */
    public void update()
    {
        // STORE current _direction to local variable, call it prevDirection:
        double prevDirection = _direction;
        
        super.update();
        
        // CHECK if a direction-change has occurred:
        //IF _direction = -1, new state = 1
        if (prevDirection > _direction)
        {
            // RAISE event for each listener, requesting state 1:
            for (IEventListener l : _listeners)
                l.onEvent(1);
        }
        
        //IF _direction = 1, new state = 0
        else if (prevDirection < _direction)
        {
            // RAISE event for each listener, requesting state 0:
            for (IEventListener l : _listeners)
                l.onEvent(0);            
        }
    }
}
