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
import UserCode.Factories.IDisplayableFactory;
import UserCode.Factories.IUpdatableFactory;
import UserCode.Factories.DisplayableFactory;
import UserCode.Factories.UpdatableFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import UserCode.InputHandling.*;
import java.util.Random;
import UserCode.BubbleBlowing.*;
/**
 * Simulation is the top-level class for the Aquarium simulation.
 * 
 * @author (Ryan Coles) and Marc Price
 * @version 0.6
 */
public class Simulation implements IInputListener,IBubbleBlowListener
{
    // instance variables:
    // DECLARE a reference to the IWorld, call it '_world':
    private IWorld _world;
    // DECLARE a reference to the IInput, call it '_input':
    private IInput _input;     
    // DECLARE a boolean that signals when the simulation loop should be exited:
    private boolean endSim = false;
    //DECLARE a ArrayList that stores the IUpdatable Objects within the simulation, call it _Updatables
    private List<IUpdatable> _Updatables;
    //DECLARE an IDisplayableFactory used for creating new IDisplayable Objects, call it displayableFactory
    private IDisplayableFactory displayableFactory;
    //DECLARE a final String for storing the location of the JavaFish texture, call it textureJavaFish
    private final String textureJavaFish="textures/javaFish/JavaFish.png";
    //DECLARE a final String for storing the location of the FishFood texture, call it textureFishFood
    private final String textureFishFood="textures/javaFish/FishFood.png";
    //DECLARE a final String for storing the location of the FishFood texture, call it textureFishFood
    private final String textureBubble="textures/javaFish/Bubble.png";
    //DECLARE a final String for storing the location of billboard model, call it model
    private final String model="models/billboard/billboard.obj";
    //DECLARE an IUpdatableFactory for creating new IUpdatable Objects, call it _factory
    private IUpdatableFactory _factory;
    //DECLARE a boolean that signals when mouse is clicked:
    private boolean _clicked = false;
    //DECLARE a boolean that signals when a new bubble is rqd, call it _newBubble:
    private boolean _newBubble = false;
    //DECLARE a reference to the IInputPublisher, call it '_inputPublisher':
    private IInputPublisher _inputPublisher;
    //DECLARE a reference to the IBubbleBlowPublisher, call it '_bubblePublisher':
    private IBubbleBlowPublisher _bubblePublisher;
    private List <Vector3> bubblePos;
    //DECLARE an int array, to store any mouse input to, initialise it to {-1,-1}, call it _mouseVal:
    private int[] _mouseVal = {-1,-1};
    //DECLARE a reference to the Random class, call it rnd
    private Random rnd;
    /**
     * Method main
     * INSTANTIATES a new Simulation
     */
    public static void main()
    {
        //INSTANTIATE a new Simulation
        Simulation sim=new Simulation();
        //Run the simulation
        sim.run();
    }
    /**
     * Constructor for objects of class Simulation
     */
    public Simulation()
    {
        // INSTANTIATE instance variables:
        _factory =new UpdatableFactory();
        _Updatables=new ArrayList<IUpdatable>();
        displayableFactory=new DisplayableFactory();
        rnd = new Random();
        bubblePos =new ArrayList<Vector3>();
        try
        {
            // STORE an IWorld object into _world
            _world = ((IWorld)_factory.create(Core.class));
            // STORE an IInput object into _input
            _input = (IInput) _world;
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
        //Subscribe simulation as an input listener
        _inputPublisher.subscribe(this);
        _bubblePublisher=new BubbleHandler();
        _bubblePublisher.Subscribe(this);
    }
    /**
     * Method addEntity
     *
     * @param entity IUpdatable entity
     */
    public void addEntity(IUpdatable entity)
    {
        //Add the IUpdatable object to the _Updatables list
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
        // SET _clicked to flag that mouse has been clicked:
        _clicked = true;
        // SET _mouseVal to data:
        _mouseVal = data;
    }
    public void OnBubbleBlow(Vector3 Position)
    {
        // SET _clicked to flag that mouse has been clicked:
        if(!_newBubble)
            bubblePos =new ArrayList<Vector3>();
        bubblePos.add(Position);
        _newBubble = true;
    }
    /**
     * Method nextDouble
     *
     * @param minNum minmum number that can be return
     * @param maxNum maximum number that can be return
     * @return randomly generated double
     */
    private double nextDouble(double minNum, double maxNum)
    {
        //generate a random double number between minNum and maxNum
        double randomDouble= minNum + rnd.nextDouble() * (maxNum - minNum);
        //return randomly generated double
        return randomDouble;
    }
    /**
     * Method horizontalBehaviour
     *
     * @return IFishBehavour horizontalBehaviour
     */
    private IFishBehaviour horizontalBehaviour()
    {
        //INSTANTIATE a new horizontalMovement and store it in an IFishBehaviour object
        IFishBehaviour horizontalBehaviour=new horizontalMovement();
        //Return the horizontal behaviour
        return horizontalBehaviour;
    }
     private BubbleBlower bubbleBlower()
     {
        //INSTANTIATE a new horizontalMovement and store it in an IFishBehaviour object
        BubbleBlower bb=new BubbleBlower();
        bb.Initialize(((IBubbleHandler)_bubblePublisher));
        //Return the horizontal behaviour
        return bb;
    }
    /**
     * Method Populate
     * Populates the aqaurium with the initial display objects
     */
    private void Populate()
    {
        try
        {
            //Spawn 10 JavaFish
            for(int i=0;i<10;i++)
            {
                //Create a swimmable object and store it into an IUpdatable object called javaFish
                IUpdatable javaFish = _factory.create(Swimmable.class);
                //add the IUpdatable object to _Updatables
                addEntity(javaFish); 
                //Create a IDisplayObject and store it in an object called javaFishDisplay
                IDisplayObject javaFishDisplay=displayableFactory.createDisplayObject(model,textureJavaFish,0.15);
                //Pass the behaviour object to the Swimmable javaFish Object
                ((IMouth)javaFish).receiveBubbleBlower(bubbleBlower());
                ((ISwimmable)javaFish).receiveJob(horizontalBehaviour());
                
                //Spawn the javaFish object into the 3D world
                ((ISpawnable)javaFish).spawn(_world, javaFishDisplay, new Vector3(nextDouble(2.0,8.0),nextDouble(2.0,7.0),0.15), new Vector3(0, -90, 0));
            }
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
            // ADD Objects to 3D world:
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
                {
                    u.update(); 
                }
                if (_newBubble)
                {
                   // RESET _newLion to false:
                   _newBubble = false; 
                   // COMPUTE the position/orientation from mouseVal:
                   
                   try
                   {
                        for(int i=0;i<bubblePos.size();i++){
                        //CREATE a new FishFood class and store it in an IUpdatable Object called fishFood
                        IUpdatable bubble = _factory.create(Bubble.class);
                        //ADD fishFood to _Updatables
                        addEntity(bubble);
                        //CREATE an IDisplayObject and store a new IDisplayObject inside it
                        IDisplayObject bubbleDisplay=displayableFactory.createDisplayObject("sphere",textureBubble,0.1);
                        Vector3 Position =bubblePos.get(i);
                        //Spawn the FishFood into the 3D world
                        ((ISpawnable)bubble).spawn(_world, bubbleDisplay, Position, new Vector3(0,-90,0));
                    }}
                    catch(Exception e)
                    {
                        
                    }
                }
                if (_clicked)
                {
                   // RESET _newLion to false:
                   _clicked = false; 
                   // COMPUTE the position/orientation from mouseVal:
                   Double posn[] = {_mouseVal[0]*0.0077, _mouseVal[1]*0.0077, 0.1};
                   Double angle[]= {0.0,90.0,0.0};
                   try
                   {
                       //CREATE a new FishFood class and store it in an IUpdatable Object called fishFood
                       IUpdatable fishFood = _factory.create(FishFood.class);
                       //ADD fishFood to _Updatables
                       addEntity(fishFood);
                       //CREATE an IDisplayObject and store a new IDisplayObject inside it
                       IDisplayObject fishFoodDisplay=displayableFactory.createDisplayObject("sphere",textureFishFood,0.1);
                       //Spawn the FishFood into the 3D world
                       ((ISpawnable)fishFood).spawn(_world, fishFoodDisplay, new Vector3(posn[0], posn[1], posn[2]), new Vector3(angle[0], -90, angle[2]));
                   }
                   catch(Exception e)
                   {
            
                   }
                }
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
