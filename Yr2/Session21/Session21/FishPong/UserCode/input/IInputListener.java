package UserCode.input;


/**
 * IInputListener: all listeners for input must implement this interface.
 * 
 * @author Marc Price 
 * @version 0.6
 */
public interface IInputListener
{
    /**
     * Method to handle an input event
     * 
     */
    void onInput(int... inputVal);
}
