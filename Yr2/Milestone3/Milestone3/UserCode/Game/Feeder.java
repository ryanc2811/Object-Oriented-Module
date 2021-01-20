package UserCode.Game;


import java.util.List;
import java.util.ListIterator;
import java.util.ArrayList;

import UserCode.ObjectCreation.IUpdatableFactory;
import UserCode.Spawnables.ISpawnable;
import UserCode.Spawnables.Spawnable;
import Framework.Interfaces.IUpdatable;
import Framework.Interfaces.IDisplayObject;
import Framework.Interfaces.IWorld;
import Framework.Implementations.DisplayObject;
import Exceptions.WorldDoesNotExistException;
import UserCode.EventHandling.IEventListener;
import UserCode.Behaviours.*;

/**
 * Feeder implements ISpawnablePool & IEventListener, to provide a mouse-based 'feeder' behaviour.
 *
 * @author Marc Price
 * @version 0.1
 */
public class Feeder extends SpawnablePool implements IEventListener
{
    // instance constants
    // DECLARE a String to point to the billboard model file, call it _model:
    private static final String _model = "sphere";
    
    // DECLARE a String to point to the FishFood texture file, call it _texture:
    private static final String _texture = "textures/javaFish/FishFood.png";
    
    // DECLARE a double to represent the scale of the FishFood model, call it _scale, set it to 0.05:
    private static final double _scale = 0.05;
    
    // DECLARE a double to represent the positional value of the top of window, call it _top, set it to 7.0:
    private static final double _top = 7.0;
    
    // DECLARE a double to represent the positional value of the bottom of window, call it _bottom, set it to 0.5:
    private static final double _bottom = 0.5;
    
    // DECLARE a double to represent the speed of each FishFood, call it _speed, set it to -0.02 (so that it falls rather than rises):
    private static final double _speed = -0.02;
    
        
    
    // instance variables:
    // DECLARE a List of IVariables to store the Y values of _spawnables, call it _Ys:
    private List<IVariable> _Ys;
    
    // DECLARE a boolean that is normally false, and true when a new input event has been published, call it _eventFlag:
    private boolean _eventFlag = false;
    


    /**
     * Constructor for objects of class Feeder
     */
    public Feeder()
    {        
        // INSTANTIATE _Ys:
        _Ys = new ArrayList<IVariable>();
    }
    
    // -------------------------------------- IMPLEMENTATION OF IEventListener -------------------------------------- //
    /**
     * Method to handle an event
     * 
     * @param data an array of integers containing the event data
     * 
     */
    public void onEvent(int ...data)
    {
        // SET _eventFlag to flag that a new fishfood needs to be spawned:
        _eventFlag = true;
         
        // COMPUTE the position for the new food and store in _X and _Y:
        ((IDumbVariable)_X).initialise(data[0]*0.0077);
        ((IDumbVariable)_Y).initialise(data[1]*0.0077);
            
    }
    
    // ---------------------- IMPLEMENTATION OF IUpdatable (which ISpawnablePool inherits) --------------------------- //
    /**
     * METHOD: changes to Feeder for next frame
     */
    public void update()
    {
        
        try
        {
            // Fishfood-spawning functionality...
            // Check if an input event has been published:
            if (_eventFlag)    // this is the signal to spawn a new fishfood...
            {
                // RESET _eventFlag:
                _eventFlag = false;
                
            // SPAWN new fishfood:
                this.spawn(_speed, _X.value(), _Y.value(), 1.0, 0.0, 0.0, 0.0);
                System.out.println(_Ys);
            }
            
            // Updates to current fishfood...
            // CREATE an Iterator for _spawnables, call it _updateIterator:
            ListIterator<IUpdatable> _spawnableIterator = _spawnables.listIterator(0);
            
            
            // ITERATE through _spawnables:
            while (_spawnableIterator.hasNext())
            {
                // GET spawnable / Y pair:
                IVariable Y = _Ys.get(_spawnableIterator.nextIndex());
                IUpdatable spawnable = _spawnableIterator.next();
                
                // UPDATE spawnable:
                spawnable.update();
                
                // REMOVE the spawnable if it has reached the bottom:
                if (Y.value() <= _bottom)
                {
                    // REMOVE display object from world:
                   
                    _world.removeDisplayObject(((ISpawnable)spawnable).getDisplayObject());
                
                    // REMOVE spawnable from _spawnables:
                    _spawnableIterator.remove();
                    _Ys.remove(Y);
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
