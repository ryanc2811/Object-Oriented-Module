package Mouse;


import java.util.List;
import java.util.ArrayList;
import env3d.Env;

import Framework.ICoreMgr;

/**
 * Handles Mouse Events specifically for the Session 15 exercise.
 * 
 * @author Marc Price 
 * @version 0.5
 */
public class MouseHandler implements IInputHandler, IMousePublisher
{
    // instance variables:
    // DECLARE a list of IMouseListener to store the event listener methods, call it _listeners:
    private List<IMouseListener> _listeners;
    
    // DECLARE a reference to the ICoreMgr, call it _core:
    ICoreMgr _core;

    /**
     * Constructor for objects of class MouseHandler
     */
    public MouseHandler(ICoreMgr core)
    {
        // initialise instance variables:
        // ASSIGN core to _core:
        _core = core;
        
        //INSTANTIATE listeners list:
        _listeners = new ArrayList<IMouseListener>();
        
    }
    
    /**
     * METHOD: Subscribe a new listener for mouse events
     *
     * @param  l   a reference to the listener that is being subscribed
     */
    public void subscribe(IMouseListener l)
    {
        // ADD new listener to the listeners list:
        _listeners.add(l);
    }

    /**
     * METHOD: Unsubscribe a listener
     *
     * @param  l   a reference to the listener that is being unsubscribed
     */
    public void unsubscribe(IMouseListener l)
    {
        // ADD new listener to the listeners list:
        _listeners.remove(l);
    }

    /**
     * METHOD: Update the Mouse state
     *
     */
    public void update()
    {
        // local variables:
        // DECLARE an int[] array for the method return value
        // INITIALISE: to return -1,-1
        int[] rtnVal={-1,-1};
        
        // IF: the left mouse button has been clicked
        if (_core.world().getMouseButtonClicked() == 0)
        {
            // SET rtnVal to x,y coordinates of mouse pointer:
            rtnVal[0] = _core.world().getMouseX();
            rtnVal[1] = _core.world().getMouseY();
            
            // RAISE event for each listener:
            for (IMouseListener l : _listeners)
                l.onMouse(rtnVal);
        }

    }

}
