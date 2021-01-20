package UserCode.fishpong;

import env3d.Env;
import Framework.ICore;
import UserCode.pets.*;
import UserCode.input.*;

/**
 * FishPong is the top-level class for the FishPong game.
 * 
 * @author Marc Price
 * @version 0.6
 */
public class FishPong
{
    // instance variables:
    // DECLARE a reference to the instance of the Core class, call it '_core':
    private ICore _core;
    
    // DECLARE a reference to the instance of the 'Env' (environment) class, call it '_world':
    private Env _world;
    
    // DECLARE a reference to the instance of the 'MouseHandler' class, call it '_mouse':
    private IInputPublisher _mouse;
    
    // DECLARE a reference to the instance of the 'KeyboardHandler' class, call it '_keyb':
    private IInputPublisher _keyb;
    
    // DECLARE a reference to the instance of the IGameMgr, call it _game:
    private IGameMgr _game;
    private IGameInitialiser _gameInitialiser;
            
    // DECLARE a boolean that signals when the simulation loop should be exited:
    private boolean endSim = false;
    /**
     * Constructor for objects of class FishPong
     */
    public FishPong(ICore core, IInputPublisher mouse, IInputPublisher keys, IGameMgr game,IGameInitialiser GI)
    {
        // INITIALISE instance variables:
        // _core, _mouse, _keyb, _food
        _core = core;
        _mouse = mouse;
        _keyb = keys;
        _game = game;
        _gameInitialiser=GI;
    }      
    

    /**
     * METHOD: Run the simulation loop.  User presses escape to exit.
     *
     */
    public void run() throws Exception
    {
        // CREATE the environment:
        _world = _core.createWorld();
        
        // INITIALISE the game:
       _gameInitialiser.Initialise(_world);
                
        // Start simulation loop:
        while (!endSim)
        {
            // UPDATE STAGE:
            // IF: user has requested simulation loop exit (ie escape pressed):
            if (_world.getKey() == 1)
            {
                // SET: render loop exit condition
                endSim = true;
            }
            
            // UPDATE mouse handler:
            _mouse.update(_world);
            
            // UPDATE keyboard handler:
            _keyb.update(_world);
            
            // UPDATE Objects in 3D world:
            _game.update(_world);
            
            // RENDER STAGE
            // UPDATE: the environment
            _core.updateWorld();
        }
        
        // EXIT: cleanly by closing-down the environment:
        _core.destroyWorld();

    }

}
