package UserCode.pets;

import java.util.List;
import java.util.ArrayList;
import com.jme3.math.Vector3f;

import UserCode.input.*;


/**
 * PaddleBehaviour - implements movement behaviour for pong paddle.
 * 
 * @author Marc Price 
 * @version 0.6
 */
public class PaddleBehaviour extends Behaviour implements IInputListener, ICollider
{
    
    // instance constants:
    //DECLARE a double constant to hold the speed of movement, call it speed:
    private static double _speed = 0.05;
    
    // instance variables:
    //DECLARE a boolean to flag a change in position, call it '_move', set it false:
    private boolean _move = false;
    
    //DECLARE a double to hold the next step change in vertical position:
    private double _changePosn = 0.0;
        

    /**
     * Constructor for objects of class PaddleBehaviour
     * 
     * @param rhs  a boolean that is true if paddle is to be on the right side of display
     */
    public PaddleBehaviour()
    {
        // CALL super:
        super();
        
    }

    /**
     * METHOD: update behaviour simulation for next frame.
     * Paddle just moves upwards and downwards, as per keyboard request...
     * 
     */
    public void update() throws ArgumentOutOfBoundsException
    {
        // MOVE paddle if requested to:
        if (_move)
        {
            //CHANGE y position:
            _position[1] += _changePosn;
            _token.position(_position);
            
            //RESET _changePosn[1] to zero:
            _changePosn = 0.0;
            
            //RESET _move to false:
            _move = false;
        }
    }
    
    /**
     * Method to handle a keyboard input (IInputListener)
     * 
     */
    public void onInput(int... inputVal)
    {
                //System.out.println("Key: " + inputVal[0]);
        // up = 200, down=208
        switch (inputVal[0])
        {
            case 200:   _changePosn += _speed;
                        _move = true;
                        break;
            case 208:    _changePosn -= _speed;
                         _move = true;
                         break;
            default:
                break;
        }

    }

    
    /**
     * Method to return the position as a jme3 Vector3f
     * 
     * @return the position as a Vector3f
     */
    public Vector3f position()
    {
        Vector3f rtnVal = new Vector3f(_position[0].floatValue(), _position[1].floatValue(), _position[2].floatValue());
        return rtnVal;
    }
}
