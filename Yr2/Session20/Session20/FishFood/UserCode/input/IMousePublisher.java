package UserCode.input;

import env3d.Env;

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
    public void subscribe(IMouseListener l);

    /**
     * METHOD: Unsubscribe a listener
     *
     * @param  l   a reference to the listener that is being unsubscribed
     */
    public void unsubscribe(IMouseListener l);

    /**
     * METHOD: Update the Mouse state - must be called on each pass through main control loop
     */
    public void update(Env world);
}
