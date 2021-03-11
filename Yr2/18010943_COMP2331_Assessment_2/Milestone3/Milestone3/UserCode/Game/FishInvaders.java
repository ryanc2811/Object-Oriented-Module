package UserCode.Game;


import java.util.List;
import java.util.ListIterator;
import java.util.ArrayList;
import java.util.Random;

import UserCode.IGameMgr;
import UserCode.ObjectCreation.IUpdatableFactory;
import UserCode.EventHandling.*;
import UserCode.InputHandling.IInputHandler;
import UserCode.Spawnables.*;
import UserCode.Behaviours.ISpawnablePool;
import UserCode.Behaviours.IVariable;
import UserCode.Behaviours.IDumbVariable;
import UserCode.Behaviours.DumbVariable;
import Framework.Interfaces.IUpdatable;
import Framework.Interfaces.IWorld;
import Framework.Interfaces.IDisplayObject;
import Framework.Implementations.DisplayObject;

/**
 * Write a description of class FishInvaders here.
 *
 * @author Marc Price
 * @version 0.1
 */
public class FishInvaders implements IGameMgr, IUpdatable
{
    // instance variables:
    // DECLARE a reference to the IWorld, call it '_world':
    private IWorld _world;
    
    // DECLARE a reference to an IUpdatableFactory, call it '_factory':
    private IUpdatableFactory _factory;
    
    // DECLARE a reference to an IInputHandler to store the MouseHandler, call it _mouseEvents:
    private IInputHandler _mouseEvents;
    
    // DECLARE a Random which will be used for placement and speed caluclations, call it _random:
    private Random _random;
    
    // DECLARE a list for the Spawnables, call it '_spawnables':
    private List<IUpdatable> _spawnables;
    private ISpawnableFactory spawnableFactory;
    

    /**
     * Constructor for objects of class FishInvaders
     */
    public FishInvaders()
    {
        // INSTANTIATE _spawnables:
        _spawnables = new ArrayList<IUpdatable>();
        // INSTANTIATE _random:
        _random = new Random();
    }

    // --------------------------- Implementation of IGame -----------------------------//
    /**
     * METHOD: Create the game scene.
     * 
     * @param factory an IUpdatableFactory, needed for creating ISpawnables as IUpdatables.
     * @param world an IWorld, needed to spawn ISpawnables.
     */
    public void create(IUpdatableFactory factory, IWorld world, IInputHandler input,ISpawnableFactory spawnFactory)
    {
        // ASSIGN factory to _factory:
        _factory = factory;
        spawnableFactory=spawnFactory;
        // ASSIGN world to _world:
        _world = world;
        
        // INSTANTIATE _mouseEvents:
        _mouseEvents = input;

        // BUILD and SPAWN ten new JavaFish:
        for (int i=0; i<10; i++)
        {
            IUpdatable fish=spawnFactory.create("JavaFish");
            double x;
            double y;
            double speed;
            speed=0.045 * _random.nextDouble() + 0.005;
            x=7.0 * _random.nextDouble() + 1.0; // random x
            y=5.0 * _random.nextDouble() + 1.0; // random y
            // ADD it to the _spawnables list:
            _spawnables.add(fish);
            try
            {
            ((ISpawnableFacade) fish).spawn(_factory, _world, speed, x, y, 1.0, 0.0, -90.0 ,0.0); 
        }
        catch(Exception e){
        }
        }
            
        // BUILD and SPAWN a few OrangeFish:
        for (int i=0; i<3; i++)
        {
             IUpdatable fish=spawnFactory.create("OrangeFish");
            double x;
            double y;
            double speed;
            speed=0.045 * _random.nextDouble() + 0.005;
            x=7.0 * _random.nextDouble() + 1.0; // random x
            y=5.0 * _random.nextDouble() + 1.0; // random y
             _spawnables.add(fish);
             try
            {
            ((ISpawnableFacade) fish).spawn(_factory, _world, speed, x, y, 1.0, 0.0, -90.0 ,0.0); 
        }
        catch(Exception e){
        }
        }
        
        // BUILD and SPAWN a few SeaHorses:
        for (int i=0; i<3; i++)
        {
            IUpdatable fish=spawnFactory.create("SeaHorse");
            double x;
            double y;
            double speed;
            speed=0.045 * _random.nextDouble() + 0.005;
            x=7.0 * _random.nextDouble() + 1.0; // random x
            y=3.5 * _random.nextDouble() + 2.5; // random y
             _spawnables.add(fish);
             try
            {
            ((ISpawnableFacade) fish).spawn(_factory, _world, speed, x, y, 1.0, 0.0, -90.0 ,0.0); 
        }
        catch(Exception e){
        }
        }
            
        // BUILD and SPAWN a few Urchins:
        for (int i=0; i<3; i++)
        {
             IUpdatable fish=spawnFactory.create("Urchin");
            double x;
            double y=0.9;
            double speed;
            speed=0.045 * _random.nextDouble() + 0.005;
            x=7.0 * _random.nextDouble() + 1.0; // random x
             _spawnables.add(fish);
             try
            {
            ((ISpawnableFacade) fish).spawn(_factory, _world, speed, x, y, 1.0, 0.0, -90.0 ,0.0); 
        }
        catch(Exception e){
        }
        }

        // Give the user a Feeder behaviour:
        try
        {
            // Create:
            IUpdatable feeder = spawnableFactory.create("Feeder");
        
            // Initialise:
            IVariable X = (IVariable) new DumbVariable();
            IVariable Y = (IVariable) new DumbVariable();
            ((ISpawnablePool)feeder).initialise(factory, world, X, Y);
            
            // Subscribe it to _mouseEvents:
            ((IEventPublisher) _mouseEvents).subscribe((IEventListener)feeder);
        
            // Add it to _spawnables:
            _spawnables.add(feeder);
        }
        catch (Exception e)
        {
        }
    }
    // ---------------------------------------------------------------------------------------------//

    // --------------------------- Implementation of IUpdatable ------------------------------------//
    /**
     * METHOD: change to IUpdatable for next frame
     */
    public void update()
    {
        // UPDATE spawnables...
        // (Iterate through _spawnables)
        // CREATE an Iterator for _spawnables, call it _updateIterator:
        ListIterator<IUpdatable> _updateIterator = _spawnables.listIterator(0);
        
        // UPDATE _spawnables:
        while (_updateIterator.hasNext())
        {
            _updateIterator.next().update();
        }        
    }
 
}
