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
     * An example of a method header - replace this comment with your own
     *
     * @param  y a sample parameter for a method
     * @return   the result produced by sampleMethod
     */
    void Behaviour();
    Vector3 getPosition();
    Vector3 getOrientation();
    void setVectors(Vector3 position, Vector3 orientation);
}
