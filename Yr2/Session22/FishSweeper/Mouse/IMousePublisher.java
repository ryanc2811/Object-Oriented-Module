package Mouse;


/**
 * IMousePublisher: publishes mouse events to all listeners.
 * 
 * @author Marc Price 
 * @version 0.5
 */
public interface IMousePublisher
{
    /**
     * METHOD: Subscribe a new listener for mouse events
     *
     * @param  l   a reference to the listener that is being subscribed
     */
    void subscribe(IMouseListener l);

    /**
     * METHOD: Unsubscribe a listener
     *
     * @param  l   a reference to the listener that is being unsubscribed
     */
    void unsubscribe(IMouseListener l);

}
