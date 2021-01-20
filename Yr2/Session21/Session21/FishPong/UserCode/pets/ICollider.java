package UserCode.pets;

import com.jme3.math.Vector3f;

/**
 * ICollider: something that can be collided with.
 * 
 * @author Marc Price 
 * @version 0.6
 */
public interface ICollider
{
    /**
     * Method to return ICollider position as a jme3 Vector3f
     * 
     * @return        the ICollider's position 
     */
    Vector3f position();
}

