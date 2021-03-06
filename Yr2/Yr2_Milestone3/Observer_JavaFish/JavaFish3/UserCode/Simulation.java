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
import UserCode.Entities.*;
import Exceptions.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import UserCode.InputHandling.*;
import UserCode.Random.RandomSingleton;
import java.util.Random;
/**
 * Simulation is the top-level class for the Aquarium simulation.
 * 
 * @author (Ryan Coles) and Marc Price
 * @version 0.6
 */
public class Simulation implements IInputListener
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
    private final String textureFishFood="textures/javaFish/FishFood.png";
    private final String model="models/billboard/billboard.obj";
    private IUpdatableFactory _factory;
    // DECLARE a boolean that signals when a new lion is rqd, call it _newLion:
    private boolean _clicked = false;
    // DECLARE a reference to the IInputPublisher, call it '_inputPublisher':
    private IInputPublisher _inputPublisher;
    // DECLARE an int array, to store any mouse input to, initialise it to {-1,-1}, call it _mouseVal:
    private int[] _mouseVal = {-1,-1};
    private Random rnd;
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
        displayableFactory=new DisplayableFactory();
        rnd = new Random();
    try
    {
        // _world:
        _world = ((IWorld)_factory.create(Core.class));
        // _input:
        _input = (IInput) _world;
        
        // _inputPublisher:
       // (INSTANTIATE):
       _inputPublisher = ((IInputPublisher) _factory.create(MouseHandler.class));
            
       // (INITIALISE):
       _inputPublisher.Initialise(_input);
    }
    catch(Exception e)
    {
        
    }
 
        // ADD _world implementation to _updatables:
        addEntity((IUpdatable) _world);
        addEntity((IUpdatable)_inputPublisher);
        _inputPublisher.subscribe(this);
    }

    public void addEntity(IUpdatable entity)
    {
        _Updatables.add(entity);
    }
    /**
     * METHOD: handle an input event
     * 
     * @param data an array of integers containing the input data
     * 
     */
    public void onInput(int ...data)
    {
        // SET _newLion to flag that a new lion needs to be spawned:
        _clicked = true;
        
        // SET _mouseVal to data:
        _mouseVal = data;
    }
    private double nextDouble(double minNum, double maxNum)
    {
         double randomDouble= minNum + rnd.nextDouble() * (maxNum - minNum);
         return randomDouble;
    }
    public void Populate()
    {
        try
        {
       
        IFishBehaviour horizontalBehaviour;
        horizontalBehaviour=new horizontalMovement();
        IUpdatable javaFish = _factory.create(Swimmable.class);
        addEntity(javaFish);   
        IDisplayObject javaFishDisplay=displayableFactory.createDisplayObject(model,textureJavaFish,0.15);
        ((ISwimmable)javaFish).receiveJob(horizontalBehaviour);
        ((ISpawnable)javaFish).spawn(_world, javaFishDisplay, new Vector3(nextDouble(2.0,8.0),nextDouble(2.0,7.0),1.0), new Vector3(0, -90, 0));
    
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
            // ADD lions when requested via mouse input...                
                // CHECK if a new lion has been requested:
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
                    
                    if (_clicked)
                    {
               // RESET _newLion to false:
               _clicked = false;
                    
                // COMPUTE the position/orientation for the new lion from mouseVal:
                Double posn[] = {_mouseVal[0]*0.0077, _mouseVal[1]*0.0077, 1.0};
                Double angle[]= {0.0,90.0,0.0};
                try
                {
        
            // RESET _newLion to false:
        
                IUpdatable fishFood = _factory.create(FishFood.class);
                addEntity(fishFood); 
                IDisplayObject fishFoodDisplay=displayableFactory.createDisplayObject("sphere",textureFishFood,0.1);
                ((ISpawnable)fishFood).spawn(_world, fishFoodDisplay, new Vector3(posn[0], posn[1], posn[2]), new Vector3(angle[0], -90, angle[2]));
            }
            catch(Exception e)
            {
        
            }
        }
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
