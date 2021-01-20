package UserCode.EventHandling;


/**
 * IEventPublisher: publishes input events to all listeners.
 *
 * @author Marc Price
 * @version 0.7
 */
public interface IEventPublisher
{
    /**
     * METHOD: Subscribe a new listener for events
     *
     * @param  l   a reference to the listener that is being subscribed
     */
    void subscribe(IEventListener l);

    /**
     * METHOD: Unsubscribe a listener
     *
     * @param  l   a reference to the listener that is being unsubscribed
     */
    void unsubscribe(IEventListener l);
}
