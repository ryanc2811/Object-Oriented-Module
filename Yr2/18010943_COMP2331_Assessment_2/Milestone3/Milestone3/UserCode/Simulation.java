package UserCode;

///////////////////////////////////////////////////////////////////////////////////////////////////
// Notes:
// * Add code to this as necessary to produce your simulation.
// * Use comments to clearly highlight your code that has been added.
// * Acknowledge/cite appropriately any added code that is not your own.
///////////////////////////////////////////////////////////////////////////////////////////////////
import java.util.List;
import java.util.ListIterator;
import java.util.ArrayList;
import env3d.Env;
import Framework.Interfaces.*;
import Framework.Implementations.*;
import Exceptions.*;
import UserCode.Game.*;
import UserCode.ObjectCreation.*;
import UserCode.InputHandling.*;
import UserCode.Spawnables.*;


/**
 * Simulation is the top-level class for the Aquarium simulation.
 * 
 * @author Marc Price
 * @version 0.6
 */
public class Simulation
{
    // instance variables:
    // DECLARE a reference to the IWorld, call it '_world':
    private IWorld _world;
    
    // DECLARE a reference to the IInput, call it '_input':
    private IInput _input;
    
    // DECLARE a reference to the IGameMgr, call it '_game':
    private IGameMgr _game;
        
    // DECLARE a boolean that signals when the simulation loop should be exited:
    private boolean endSim = false;
    
    // DECLARE a reference to the IInputHandler, call it '_inputHandler':
    private IInputHandler _inputHandler;
    
    // DECLARE a list for updatables, call it '_updatables':
    private List<IUpdatable> _updatables;
       
    // DECLARE a reference to an IUpdatableFactory, call it '_factory':
    private IUpdatableFactory _factory;
    private ISpawnableFactory _spawnableFactory;    

    /**
     * METHOD: Static Main method used for creating standalone apps
     *
     */
    public static void main(String[] args) throws Exception
    {
        // CREATE an IUpdatableFactory, call it updatableFactory:
        IUpdatableFactory updatableFactory = new UpdatableFactory();
        ISpawnableFactory spawnableFactory = new SpawnableFactory();
        // CREATE an IGame using updatableFactory, call it game:
        IGameMgr game = new FishInvaders();
        
        // INSTANTIATE Simulation, call it sim:
        Simulation sim = new Simulation(updatableFactory, game,spawnableFactory);
        
        // RUN sim:
        sim.run();
    }
    
    
    /**
     * Constructor for objects of class Simulation
     */
    public Simulation(IUpdatableFactory factory, IGameMgr game,ISpawnableFactory spawnFactory)
    {
        // INITIALISE instance variables:
        // _updatables:
        _updatables = new ArrayList<IUpdatable>();
        _spawnableFactory=spawnFactory;
        // _factory:
        _factory = factory;
        
        // _game:
        _game = game;
        
        try
        {
            // _world:
            _world = ((IWorld) _factory.create(Core.class));
            
            // ADD _world implementation to _updatables:
            _updatables.add((IUpdatable) _world);
           
            // _input:
            _input = (IInput) _world;
            
            // ADD _game implementation to _updatables:
            _updatables.add((IUpdatable) game);
            
            // _inputHandler:
            _inputHandler = ((IInputHandler) _factory.create(MouseHandler.class));
            _inputHandler.initialise(_input);
            
            // ADD _inputHandler to _updatables:
            _updatables.add((IUpdatable) _inputHandler);
            
        }
        catch(Exception e)
        {
            // do nothing here because I can't be bothered!
        }
    }


    /**
     * METHOD: Run the simulation loop.  User presses escape to exit.
     *
     */
    public void run()
    {
        // Create the 3D world:
        _world.create();
        _game.create(_factory, _world, _inputHandler,_spawnableFactory);
        
        // Use try - catch to ensure 3D world was successfully created:
        try
        {
        
            // Start simulation loop:
            while (!endSim)
            {
                // UPDATE STAGE:
                // IF: user has requested simulation loop exit (ie escape pressed):
                if (_input.getKey() == 1)
                {
                    // SET: render loop exit condition
                    endSim = true;
                }
                        
                // UPDATE everything...
                // (Iterate through _updatables in reverse because we want to update _world last)
                // CREATE an Iterator for _updatables, pointing at end of list, call it _updateIterator:
                ListIterator<IUpdatable> _updateIterator = _updatables.listIterator(_updatables.size());
                
                // UPDATE _updatables in reverse order (so that 3D world is updated last):
                while (_updateIterator.hasPrevious())
                {
                    _updateIterator.previous().update();
                }
            }
        
            // EXIT: cleanly by closing-down the environment:
            _world.destroy();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }

}
