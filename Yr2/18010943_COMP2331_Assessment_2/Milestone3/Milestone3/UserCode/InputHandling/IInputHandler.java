package UserCode.InputHandling;

import Framework.Interfaces.IInput;


/**
 * IInputPublisher: publishes input events to all listeners.
 * 
 * @author Marc Price 
 * @version 0.1
 */
public interface IInputHandler
{
    /**
     * METHOD: Initialise.
     * 
     * @param inputCapture the input capture source (normally via Env3D)
     */
    void initialise(IInput inputCapture);
    
}
