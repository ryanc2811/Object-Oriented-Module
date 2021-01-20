package UserCode.pets;

import java.util.List;
import java.util.ArrayList;

import com.jme3.math.Vector3f;

/**
 * BallBehaviour - implements behaviour of fish (as a ball).
 * 
 * @author Marc Price 
 * @version 0.6
 */
public class BallBehaviour extends Behaviour implements ICollidable
{
    // instance constants:
    //DECLARE a double constant to hold the speed of movement, call it _speed:
    private static double _speed = 0.05;
    
    // instance variables:
    //DECLARE an ICollider that stores a reference to the paddle, call it _collider:
    private ICollider _collider;
    
    //DECLARE a double to hold direction (along x axis), call it _direction:
    private double _direction = -1.0;
    
    /**
     * Constructor for objects of class BallBehaviour
     */
    public BallBehaviour()
    {
        // INITIALISE base object:
        super();
        
    }

    /**
     * METHOD: update behaviour simulation for next frame.
     * Food just moves downwards and settles at bottom...
     * 
     */
    public void update() throws ArgumentOutOfBoundsException
    {
        // UPDATE the position:
        _position[0] += (_speed * _direction);
        _token.position(_position);
        
        // CHECK if it is colliding with the paddle:
        if (_collider != null)
        {
            Vector3f posn = new Vector3f(_position[0].floatValue(), _position[1].floatValue(), _position[2].floatValue());
            this.collide(posn, _collider.position());
        }
    }

    /**
     * Method to assign an ICollider
     * 
     */
    public void addICollider(ICollider collider)
    {
        // ASSIGN collider to _collider:
        _collider = collider;
    }

    /**
     * Method to check for and react to a collision.
     * Collision occurs when other object is within 0.1 units of this object.
     * 
     */
    private void collide(Vector3f thisPosn, Vector3f otherPosn)
    {
        // IF distance between thisPosn and otherPosn is less than 0.1:
        if (0.1 > thisPosn.distance(otherPosn))
        {
            // REACT to collision by multiplying _speed by -1.0:
            _direction*=-1;
        }
    }
}
