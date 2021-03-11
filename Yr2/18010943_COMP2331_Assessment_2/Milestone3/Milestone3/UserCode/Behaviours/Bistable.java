package UserCode.Behaviours;

import Framework.Interfaces.*;
import Framework.Implementations.*;
import UserCode.EventHandling.IEventListener;

/**
 * Bistable: a two-state variable; essentially a bi-stable 'flip-flop'.
 * Uses events to trigger a state change.
 *
 * @author Marc Price
 * @version 0.1
 */
public class Bistable extends Variable implements IBistable, IEventListener, IUpdatable
{
    // instance variables:
    // DECLARE a two-cell array of doubles (initialised to 0.0,0.0), to store the two states, call it _states:
    private double[] _states = {0.0,0.0};
    
    // DECLARE an integer (initialised to 0) to point to the current state (ie the current valid cell of _states), call it _state:
    private int _state = 0;
    
    // DECLARE an integer (initialised to 0) to store the requested new state via an event, call it _newState:
    private int _newState = 0;
    
    // DECLARE a boolean that is normally false, and true when a new event has been published, call it _eventFlag:
    private boolean _eventFlag = false;    

    
    /**
     * Constructor for objects of class Bistable
     */
    public Bistable()
    {

    }
    
    // -------------------------- Implementation of IBistable --------------------------------------
    /**
     * METHOD: initialise bistable behaviour according to needs.
     * Initially, the bistable is set to the initialStateValue.  An external mechanism triggers a state change.
     * 
     * 
     * @param  defaultStateValue    the default state value.
     * @param  otherStateValue      the other state value.
     */
    public void initialise(double initialStateValue, double otherStateValue)
    {
        // SET _state :
        _states[0] = initialStateValue;
        _states[1] = otherStateValue;
        
        // SET _variable to the value of the current state:
        _variable = initialStateValue;
        
    }
    

    // -------------------------- Implementation of IEventListener --------------------------------------
    /**
     * Method to handle an event - this is what triggers a state change.
     * 
     * @param data an array of integers containing the event data - we expect data[0] to signal the rqd state (0 or 1).
     * 
     */
    public void onEvent(int ...data)
    {
        // SET _eventFlag to flag that the state needs to be flipped:
        _eventFlag = true;
        
        // SET _newState to data[0]:
        if (data[0]>0)      // Anything above 0 signifies state 1:
            _newState = 1;
        else                // Everything else signifies state 0:
            _newState = 0;
            
    }
    
    
    // -------------------------- Implementation of IUpdatable --------------------------------------
    /**
     * METHOD: apply changes to variable for next frame - ie flip states if triggered.
     * 
     */
    public void update()
    {       
        // CHECK if _eventFlag has been set, and _newState is not the current state:
        // (this means that a state change has been successfully requested)
        if ((_eventFlag)&&(_newState!=_state))
        {
            // FLIP _state:
            _state = _newState;
            
            // SET _variable to the value of the new state:
            _variable = _states[_state];
        }
        
    }
}
