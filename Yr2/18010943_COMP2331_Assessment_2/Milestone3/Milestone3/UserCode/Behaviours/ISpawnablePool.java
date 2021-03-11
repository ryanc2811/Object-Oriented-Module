package UserCode.Behaviours;

import Framework.Interfaces.IUpdatable;
import Framework.Interfaces.IDisplayObject;
import Framework.Interfaces.IWorld;
import Exceptions.WorldDoesNotExistException;
import UserCode.Spawnables.ISpawnable;
import UserCode.ObjectCreation.IUpdatableFactory;

/**
 * ISpawnablePool - an object pool of specific ISpawnables having the same parameters, used to implement a particle system.
 *
 * @author Marc Price
 * @version 0.1
 */
public interface ISpawnablePool extends IUpdatable
{
    /**
     * METHOD: initialise the ISpawnablePool.
     * 
     * @param  factory      the IUpdatableFactory.
     * @param  world        the IWorld.
     * @param  X            an IVariable that will represent the spawn point along x axis, when it is time to spawn.
     * @param  Y            an IVariable that will represent the spawn point along y axis, when it is time to spawn.
     */
    void initialise(IUpdatableFactory factory, IWorld world, IVariable X, IVariable Y);
}
