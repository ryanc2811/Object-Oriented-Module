package UserCode.Behaviours;
import UserCode.Vector3;

/**
 * Interface for all fish behaviours. Enacts a behaviour for a fish
 *
 * @author (Ryan Coles)
 * @version (1.0)
 */
public interface IFishBehaviour
{
    
    /**
     * Method Behaviour
     * enacts the fishes behaviour
     */
    void Behaviour();
    /**
     * Method getPosition
     *
     * @return Position of fish
     */
    Vector3 getPosition();
    /**
     * Method getOrientation
     *
     * @return Orientation of fish
     */
    Vector3 getOrientation();
    /**
     * Method setVectors
     *
     * @param Position of fish
     * @param Orientation of fish
     */
    void setVectors(Vector3 position, Vector3 orientation);
}
