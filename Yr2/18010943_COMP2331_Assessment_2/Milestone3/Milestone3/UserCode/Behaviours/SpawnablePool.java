package UserCode.Behaviours;

import java.util.List;
import java.util.ArrayList;

import Framework.Interfaces.IUpdatable;
import Framework.Interfaces.IDisplayObject;
import Framework.Interfaces.IWorld;
import Framework.Implementations.DisplayObject;
import Exceptions.WorldDoesNotExistException;
import UserCode.Spawnables.ISpawnable;
import UserCode.Spawnables.Spawnable;
import UserCode.ObjectCreation.IUpdatableFactory;

/**
 * Abstract class SpawnablePool - common code to implement an 'object pool' of specific ISpawnables.
 * NOTE: this does not implement the Object Pool design pattern.
 *
 * @author Marc Price
 * @version 0.1
 */
public abstract class SpawnablePool implements ISpawnablePool
{
    // instance variables - replace the example below with your own
    // DECLARE a reference to the IWorld, call it '_world':
    protected IWorld _world;
    
    // DECLARE an IUpdatableFactory, call it '_factory':
    protected IUpdatableFactory _factory;
    
    // DECLARE an IVariable to store a reference to the owner's X variable, call it _X:
    protected IVariable _X;
    
    // DECLARE an IVariable to store a reference to the owner's Y variable, call it _Y:
    protected IVariable _Y;
    
    // DECLARE a List of IUpdatables to store the pool of ISpawnables, call it _spawnables
    protected List<IUpdatable> _spawnables;
      
    

    // ---------------------- IMPLEMENTATION OF ISpawnablePool --------------------------- //    
    /**
     * METHOD: initialise the ISpawnablePool.
     * 
     * @param  factory      the IUpdatableFactory.
     * @param  world        the IWorld.
     * @param  X            an IVariable that will represent the spawn point along x axis, when it is time to spawn.
     * @param  Y            an IVariable that will represent the spawn point along y axis, when it is time to spawn.
     */
    public void initialise(IUpdatableFactory factory, IWorld world, IVariable X, IVariable Y)
    {
        // ASSIGN _factory, _world, _X, and _Y:
        _factory = factory;
        _world = world;
        _X = X;
        _Y = Y;
        
        // INSTANTIATE _spawnables:
        _spawnables = new ArrayList<IUpdatable>();
        
    }
    
    
    // -------------------------------- Protected Methods ---------------------------------- //

}
