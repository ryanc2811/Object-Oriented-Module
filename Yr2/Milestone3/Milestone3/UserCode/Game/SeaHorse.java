package UserCode.Game;

import Framework.Interfaces.IUpdatable;
import Framework.Interfaces.IDisplayObject;
import Framework.Interfaces.IWorld;
import Framework.Implementations.DisplayObject;
import Exceptions.WorldDoesNotExistException;
import UserCode.ObjectCreation.IUpdatableFactory;
import UserCode.EventHandling.*;
import UserCode.Spawnables.ISpawnable;
import UserCode.Spawnables.Spawnable;
import UserCode.Behaviours.*;


/**
 * SeaHorse initialises and spawns an SeaHorse type pet in the game - it is a Facade. Use one for each pet.
 *
 * @author Marc Price
 * @version 0.1
 */
public class SeaHorse implements ISpawnableFacade
{
    // instance constants
    // DECLARE a String to point to the billboard model file, call it _model:
    private static final String _model = "models/billboard/billboard.obj";
    
    // DECLARE a String to point to the SeaHorse texture file, call it _texture:
    private static final String _texture = "textures/javaFish/Seahorse.png";
    
    // DECLARE a double to represent the scale of the SeaHorse model, call it _scale, set it to 0.25:
    private static final double _scale = 0.25;
    
    // DECLARE a double to represent the positional value of the rhs of window, call it _rhs, set it to 9.3:
    private static final double _rhs = 9.3;
    
    // DECLARE a double to represent the positional value of the lhs of window, call it _lhs, set it to 0.7:
    private static final double _lhs = 0.7;
    
    // DECLARE a double to represent the positional value of the top of window, call it _top, set it to 6.9:
    private static final double _top = 6.9;
    
    // DECLARE a double to represent the positional value of the bottom of window, call it _bottom, set it to 2.0:
    private static final double _bottom = 2.0;
    
    
    // instance variables:
    // DECLARE an ISpawnable to store a reference to the ISpawnable this controls, call it _spawnable
    ISpawnable _spawnable;
    
    // DECLARE a double to represent the speed of the SeaHorse, call it _speed, set it to 0.01:
    private double _speed = 0.01;
    
    

    /**
     * Constructor for objects of class SeaHorse
     */
    public SeaHorse()
    {
        // initialise instance variables
        // none
    }
    
    
    // ---------------------- IMPLEMENTATION OF ISpawnableFacade --------------------------- //    
    /**
     * METHOD: build and spawn an ISpawnable at the given position/orientation, of the given IWorld.
     * 
     * @param  factory      IUpdatableFactory for object creation.
     * @param  world        the IWorld.
     * @param  speed        the initial speed of the spawnable when spawned.
     * @param  xPosn        double giving the initial position along the x axis.
     * @param  yPosn        double giving the initial position along the y axis.
     * @param  zPosn        double giving the initial position along the z axis.
     * @param  xOrientation double giving the initial orientation about x axis.
     * @param  yOrientation double giving the initial orientation about y axis.
     * @param  zOrientation double giving the initial orientation about z axis.
     */
    public void spawn(IUpdatableFactory factory, IWorld world, double speed, double xPosn, double yPosn, double zPosn,
                            double xOrientation, double yOrientation, double zOrientation) throws Exception
    {
        // CREATE _spawnable:
        _spawnable = ((ISpawnable) factory.create(Spawnable.class));
        
        // SET _speed to speed:
        _speed = speed;
        
        // CREATE new displayObject:
        IDisplayObject displayObject = new DisplayObject(_model, _texture, _scale);
        
        // SET position of _displayObject:
        displayObject.position(xPosn, yPosn, zPosn);
        
        // SET orientation of _displayObject:
        displayObject.orientation(xOrientation, yOrientation, zOrientation);
        
        // ADD to 3D world:
        world.addDisplayObject(displayObject);
        
        // INITIALISE movements...
        // X:
        IVariable X = new LinearEventVariable();
        ((ILinearVariable) X).initialise(xPosn, _speed, _lhs, _rhs);
        
        // Y:
        IVariable Y = new LinearVariable();
        ((ILinearVariable) Y).initialise(yPosn, _speed, _bottom, _top);
        
        // Z:
        IVariable Z = new DumbVariable();
        ((IDumbVariable) Z).initialise(zPosn);
        
        // Xo:
        IVariable Xo = new DumbVariable();
        ((IDumbVariable) Xo).initialise(xOrientation);
        
        // Yo (needs to flip at boundaries):
        IVariable Yo = new Bistable();
        ((IBistable) Yo).initialise(yOrientation, -yOrientation);
        
        // Subscribe Yo to X:
        ((IEventPublisher) X).subscribe((IEventListener) Yo);

        // Zo:
        IVariable Zo = new DumbVariable();
        ((IDumbVariable) Zo).initialise(zOrientation);

        // Spawn spawnable:
        _spawnable.spawn(displayObject, X, Y, Z, Xo, Yo, Zo);
        
        // all done
        return;
    }
    
    // ---------------------- IMPLEMENTATION OF IUpdatable (which ISpawnableFacade inherits) --------------------------- //
    /**
     * METHOD: change to Spawnable for next frame
     */
    public void update()
    {
        // Update all axes of _displayObject:
        ((IUpdatable) _spawnable).update();
    }
}
