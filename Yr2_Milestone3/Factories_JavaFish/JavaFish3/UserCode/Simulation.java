package UserCode;

///////////////////////////////////////////////////////////////////////////////////////////////////
// Notes:
// * Add code to this as necessary to produce your simulation.
// * Use comments to clearly highlight your code that has been added.
// * Acknowledge/cite appropriately any added code that is not your own.
///////////////////////////////////////////////////////////////////////////////////////////////////
import env3d.Env;
import Framework.Interfaces.*;
import Framework.Implementations.*;
import UserCode.Behaviours.*;
import Exceptions.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
/**
 * Simulation is the top-level class for the Aquarium simulation.
 * 
 * @author (Ryan Coles) and Marc Price
 * @version 0.6
 */
public class Simulation
{
    // instance variables:
    // DECLARE a reference to the IWorld, call it '_world':
    private IWorld _world;
    
    // DECLARE a reference to the IInput, call it '_input':
    private IInput _input;
        
    // DECLARE a boolean that signals when the simulation loop should be exited:
    private boolean endSim = false;
    //DECLARE a ArrayList that stores the display objects within the simulation, call it _displayObjects
    private List<IUpdatable> _Updatables;
    private IDisplayableFactory displayableFactory;
    private final String textureJavaFish="textures/javaFish/JavaFish.png";
    private final String model="models/billboard/billboard.obj";
    private IFishBehaviour horizontalBehaviour;
    private IDisplayObject javaFishDisplay;
    private IUpdatableFactory _factory;
    
    public static void main()
    {
        Simulation sim=new Simulation();
        sim.run();
    }
    
    /**
     * Constructor for objects of class Simulation
     */
    public Simulation()
    {
        // INITIALISE instance variables:
        _factory =new UpdatableFactory();
        _Updatables=new ArrayList<IUpdatable>();
        horizontalBehaviour=new horizontalMovement();
        displayableFactory=new DisplayableFactory();
        
    try
    {
        // _world:
        _world = ((IWorld)_factory.create(Core.class));
        

    }
    catch(Exception e)
    {
        
    }
        
        // _input:
        _input = (IInput) _world;
        // ADD _world implementation to _updatables:
        addEntity((IUpdatable) _world);
        
    }

    public void addEntity(IUpdatable entity)
    {
        _Updatables.add(entity);
    }
    public void Populate()
    {
         try
    {
       
        IUpdatable javaFish = _factory.create(Swimmable.class);
        addEntity(javaFish);   
        javaFishDisplay=displayableFactory.createDisplayObject(model,textureJavaFish,0.4);
        ((ISwimmable)javaFish).receiveJob(horizontalBehaviour);
        ((ISpawnable)javaFish).spawn(_world, javaFishDisplay, new Vector3(2.0,2.0,1.0), new Vector3(0,-90,0));

    }
    catch(Exception e)
    {
        
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
        
        // User try - catch to ensure 3D world was successfully created:
        try
        {
            // ADD Objects to 3D world?:
            Populate();
            
        
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
                      
                // UPDATE 3D objects and world...
                 for (IUpdatable u : _Updatables)
                    u.update();
                
                
                // UPDATE 3D World:
                // Apply all updates to the environment.
                // This must be called at the end of each pass through the simulation loop.
                // Cast to IUpdatable interface
                //((IUpdatable)_world).update();
            }
        
            // EXIT: cleanly by closing-down the environment:
            _world.destroy();
        }
        catch (WorldDoesNotExistException e)
        {
            System.out.println(e.getMessage());
        }

    }

}
