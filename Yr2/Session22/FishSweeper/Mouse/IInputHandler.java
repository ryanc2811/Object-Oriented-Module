package Mouse;


/**
 * IInputHandler: handles user input.
 * 
 * @author Marc Price 
 * @version 0.5
 */
public interface IInputHandler
{

    /**
     * METHOD: Update the Input state - must be called on each pass through main control loop
     */
    void update();
}
