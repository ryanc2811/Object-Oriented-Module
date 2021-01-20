package UserCode.Game;

import java.util.List;
import java.util.ListIterator;
import java.util.ArrayList;
import java.util.Random;

import UserCode.ObjectCreation.IUpdatableFactory;
import UserCode.Spawnables.ISpawnable;
import UserCode.Spawnables.Spawnable;
import Framework.Interfaces.IUpdatable;
import Framework.Interfaces.IDisplayObject;
import Framework.Interfaces.IWorld;
import Framework.Implementations.DisplayObject;
import Exceptions.WorldDoesNotExistException;
import UserCode.Behaviours.*;

/**
 * Bubbles extends SpawnablePool, to provide a 'bubbler' behaviour.  It is ok for there to be many instances of it.
 * Use a separate instance for each behaviour.
 *
 * @author Marc Price
 * @version 0.1
 */
public class Bubbles extends SpawnablePool
{
    // instance constants
    // DECLARE a String to point to the billboard model file, call it _model:
    private static final String _model = "sphere";
    
    // DECLARE a String to point to the Bubble texture file, call it :
    private static final String _texture = "textures/javaFish/Bubble.png";
    
    // DECLARE a double to represent the scale of the Bubble model, call it _scale, set it to 0.05:
    private static final double _scale = 0.05;
    
    // DECLARE a double to represent the positional value of the top of window, call it _top, set it to 7.0:
    private static final double _top = 7.0;
    
    // DECLARE a double to represent the speed of each Bubble, call it _speed:
    private static final double _speed = 0.01;
    
    // DECLARE an integer to represent the interval between bubbles, call it _interval:
    private static final int _interval = 200;
    
    
    // instance variables:
    // DECLARE a List of IVariables to store the Y values of _spawnables, call it _Ys:
    private List<IVariable> _Ys;
    
    // DECLARE a Random, call it _random:
    private Random _random;
    
    // DECLARE an integer to store a count-down for randomised interval timing of spawns, call it _countdown:
    private int _countdown = 0;
    

    /**
     * Constructor for objects of class Bubbles
     */
    public Bubbles()
    {
        // INSTANTIATE _Ys:
        _Ys = new ArrayList<IVariable>();
        
        // INSTANTIATE _random:
        _random = new Random();
        
    }
    
    // ---------------------- IMPLEMENTATION OF IUpdatable (which ISpawnablePool inherits) --------------------------- //
    /**
     * METHOD: changes to Bubbles for next frame
     */
    public void update()
    {
        try
        {
            // Bubble-spawning functionality...
            // Decrement _countdown and check if it's reached zero:
            if (--_countdown < 1)    // this is the signal to spawn a new bubble...
            {
                // COMPUTE next countdown:
                _countdown = 10 + _random.nextInt(90);
                
                // SPAWN new bubble:
                this.spawn(_speed, _X.value(), _Y.value(), 1.0, 0.0, 0.0, 0.0);
            }
            
            // Updates to current bubbles...
            // CREATE an Iterator for _spawnables, call it _updateIterator:
            ListIterator<IUpdatable> _spawnableIterator = _spawnables.listIterator(0);
            
            // CREATE an Iterator for _Ys, call it _YIterator:
            ListIterator<IVariable> _YIterator = _Ys.listIterator(0);
            
            // ITERATE through _spawnables:
            while (_spawnableIterator.hasNext())
            {
                // GET spawnable / Y pair:
                IUpdatable spawnable = _spawnableIterator.next();
                IVariable Y = _YIterator.next();
                
                // UPDATE spawnable:
                spawnable.update();
                
                // REMOVE it if it has gone off screen:
                if (Y.value() > _top)
                {
                    // REMOVE display object from world:
                    _world.removeDisplayObject(((ISpawnable)spawnable).getDisplayObject());
                
                    // REMOVE spawnable from _spawnables:
                    _spawnableIterator.remove();
                    
                    // REMOVE Y from _Ys:
                    _YIterator.remove();
                }
            }
        }
        catch(Exception e)
        {
            // do nothing because we're in the real-time loop
        }

        // all done
        return;
    }
    
    //------------------------------------------------------------------------------------------------------------
    
    
    
    /**
     * METHOD: spawn an ISpawnable at the given position/orientation.
     * 
     * @param  speed        the initial speed of the spawnable when spawned.
     * @param  xPosn        double giving the initial position along the x axis.
     * @param  yPosn        double giving the initial position along the y axis.
     * @param  zPosn        double giving the initial position along the z axis.
     * @param  xOrientation double giving the initial orientation about x axis.
     * @param  yOrientation double giving the initial orientation about y axis.
     * @param  zOrientation double giving the initial orientation about z axis.
     */
    private void spawn(double speed, double xPosn, double yPosn, double zPosn,
                            double xOrientation, double yOrientation, double zOrientation) throws Exception
    {
        // CREATE new IDisplayObject, call it displayObject:
        IDisplayObject displayObject = new DisplayObject(_model, _texture, _scale);
        
        // CREATE a Spawnable, call it spawnable:
        ISpawnable spawnable = ((ISpawnable) _factory.create(Spawnable.class));
    
        // SET position of _displayObject:
        displayObject.position(xPosn, yPosn, zPosn);
    
        // SET orientation of _displayObject:
        displayObject.orientation(xOrientation, yOrientation, zOrientation);
    
        // ADD to 3D world:
        _world.addDisplayObject(displayObject);
    
        // INITIALISE movements...
        // X:
        IVariable X = new DumbVariable();
        ((IDumbVariable) X).initialise(xPosn);
    
        // Y:
        IVariable Y = new LinearVariable(); 
        ((ILinearVariable) Y).initialise(yPosn, speed, 0.0, _top+1.0);
        
        // Add to _Ys:
        _Ys.add(Y);
    
        // Z:
        IVariable Z = new DumbVariable();
        ((IDumbVariable) Z).initialise(zPosn);
    
        // Xo:
        IVariable Xo = new DumbVariable();
        ((IDumbVariable) Xo).initialise(xOrientation);
    
        // Yo:
        IVariable Yo = new DumbVariable();
        ((IDumbVariable) Yo).initialise(yOrientation);

        // Zo:
        IVariable Zo = new DumbVariable();
        ((IDumbVariable) Zo).initialise(zOrientation);

        // Spawn spawnable:
        spawnable.spawn(displayObject, X, Y, Z, Xo, Yo, Zo);
        
        // Add spawnable to _spawnables:
        _spawnables.add((IUpdatable)spawnable);
        
        // all done
        return;
    }
    

}
