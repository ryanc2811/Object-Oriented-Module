package Framework.Interfaces;
import UserCode.Vector3;
import Exceptions.*;
/**
 * Any animal that can be spawned must implement ISpawnable.
 * 
 * @author Ryan Coles
 * @version 0.1
 */
public interface ISpawnable
{
    /**
     * METHOD: spawn the ISpawnable at the given position/orientation
     * @param world IWorld representing the 3D world.
     * @param Position Vector3 giving the position of the entity
     * @param Orientation Vector3 giving the orientation of the entity
     */
    void spawn(IWorld world,IDisplayObject displayObject,Vector3 Position, Vector3 Orientation)
    throws WorldDoesNotExistException;
}
