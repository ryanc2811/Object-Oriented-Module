package UserCode.pets;


/**
 * ICollidable: something that can collide with an ICollider.
 * 
 * @author Marc Price 
 * @version 0.6
 */
public interface ICollidable
{
    /**
     * Method to assign an ICollider
     * 
     */
    void addICollider(ICollider collider);
}
