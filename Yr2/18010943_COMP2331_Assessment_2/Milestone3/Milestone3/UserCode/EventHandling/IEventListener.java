package UserCode.EventHandling;


/**
 * IInputListener: all listeners for input must implement this interface.
 * 
 * @author Marc Price 
 * @version 0.1
 */
public interface IEventListener
{
    /**
     * Method to handle an event
     * 
     * @param data an array of integers containing the event data
     * 
     */
    void onEvent(int ...data);
}
