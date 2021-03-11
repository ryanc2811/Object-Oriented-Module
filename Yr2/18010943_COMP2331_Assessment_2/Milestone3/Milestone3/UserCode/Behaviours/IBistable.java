package UserCode.Behaviours;


/**
 * IBistable: a two-state variable; essentially a bi-stable 'flip-flop' (or two-element state machine).
 * Requires an external mechanism to trigger a state change.
 *
 * @author Marc Price
 * @version 0.1
 */
public interface IBistable
{
    /**
     * METHOD: initialise bistable behaviour according to needs.
     * Initially, the bistable is set to the initialStateValue.  An external mechanism triggers a state change.
     * 
     * 
     * @param  defaultStateValue    the default state value.
     * @param  otherStateValue      the other state value.
     */
    public void initialise(double initialStateValue, double otherStateValue);
}
