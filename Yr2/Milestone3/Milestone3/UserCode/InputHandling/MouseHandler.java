package UserCode.InputHandling;

import java.util.List;
import java.util.ArrayList;

import Framework.Interfaces.IInput;
import Framework.Interfaces.IUpdatable;
import UserCode.EventHandling.*;

/**
 * Handles Mouse Events specifically for the Session 15 exercise.
 * 
 * @author Marc Price 
 * @version 0.1
 */
public class MouseHandler implements IInputHandler, IEventPublisher, IUpdatable
{
    // instance variables:
    // DECLARE a list of IEventListener to store the event listener methods, call it _listeners:
    private List<IEventListener> _listeners;
    
    // DECLARE an IInput to hold a reference to our input capture implementation, call it _inputCapture:
    private IInput _inputCapture;

    /**
     * Constructor for objects of class MouseHandler
     */
    public MouseHandler()
    {
        //INSTANTIATE listeners list:
        _listeners = new ArrayList<IEventListener>();
    }
    

    // -------------------------- Implementation of IInputHandler --------------------------------//
    /**
     * METHOD: Initialise the handler by giving it a reference to the input capture source.
     * 
     * @param inputCapture the input capture source (normally via Env3D)
     */
    public void initialise(IInput inputCapture)
    {
        //ASSIGN inputCapture to _inputCapture:
        _inputCapture = inputCapture;
    }
    
    
    // ------------------------- Implementation of IEventPublisher -------------------------------//
    /**
     * METHOD: Subscribe a new listener for mouse events
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
     * METHOD: Update the Mouse state
     *
     */
    public void update()
    {
        // DECLARE an int array, to store any mouse input to, call it mouseVal:
        int[] mouseVal;
                
        // Check if left button has been clicked:
        try
        {
            if (0 == _inputCapture.getMouseClicked())
            {
                // STORE mouse pointer position into mouseVal:
                mouseVal = _inputCapture.getMousePointer();
                
                // RAISE event for each listener:
                for (IEventListener l : _listeners)
                    l.onEvent(mouseVal);
            }
        }
        catch (Exception e)
        {
            // do nothing as this would occur in the real-time loop
        }
    }

}
