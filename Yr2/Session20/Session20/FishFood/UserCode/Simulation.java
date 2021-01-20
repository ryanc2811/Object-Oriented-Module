package UserCode;

import java.util.List;
import java.util.ArrayList;
import env3d.Env;
import Framework.Core;
import UserCode.pets.*;
import UserCode.input.*;

/**
 * Simulation is the top-level class for the Aquarium simulation.
 * 
 * @author (your name here!) & Marc Price
 * @version 0.5
 */
public class Simulation
{
    // instance variables:
    // DECLARE a reference to the instance of the Core class, call it '_core':
    private Core _core;
    
    // DECLARE a reference to the instance of the 'Env' (environment) class, call it '_world':
    private Env _world;
        
    // DECLARE a reference to the instance of the 'IMousePublisher' class, call it '_mouse':
    private IMousePublisher _mouse;
    
    // DECLARE a reference to the instance of the IFoodMgr, call it _food:
    private IFoodMgr _food;
            
    // DECLARE a boolean that signals when the simulation loop should be exited:
    private boolean endSim = false;

    
    /**
     * METHOD: Static Main method used for creating standalone apps
     *
     */
    public static void main(String[] args) throws Exception
    {
        Simulation sim = new Simulation();
        sim.run();
    }
    
    
    /**
     * Constructor for objects of class Simulation
     */
    public Simulation()
    {
        // INITIALISE instance variables:
        // _core, _mouse, _tokenMaker, _behaviour
        _core = new Core();
        _mouse = new MouseHandler();
        _food = new FoodMgr();

        // SUBSCRIBE _food as a _mouse listener:
        _mouse.subscribe((IMouseListener)_food);
    }


    /**
     * METHOD: Run the simulation loop.  User presses escape to exit.
     *
     */
    public void run() throws Exception
    {
        // CREATE the environment:
        _world = _core.createWorld();
        
        // ADD Tokens to 3D world:
        
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
             
            // UPDATE Objects in 3D world:
            _food.update(_world);
            
            // RENDER STAGE
            // UPDATE: the environment
            _core.updateWorld();
        }
        
        // EXIT: cleanly by closing-down the environment:
        _core.destroyWorld();

    }

}
