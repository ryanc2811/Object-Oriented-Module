package UserCode.Spawnables;

import java.util.List;
import java.util.ListIterator;
import java.util.ArrayList;
import Framework.Interfaces.IUpdatable;
import Framework.Interfaces.IDisplayObject;
import Framework.Interfaces.IWorld;
import Framework.Implementations.DisplayObject;
import UserCode.Behaviours.IVariable;



/**
 * Spawnable - implements the main code for any spawnable.
 * 
 * @author Marc Price
 * @version 0.1
 */
public class Spawnable implements ISpawnable, IUpdatable
{
    // instance variables:
    // DECLARE an IDisplayObject to represent this Spawnable on the display, call it _displayObject:
    protected IDisplayObject _displayObject;

    // DECLARE an IVariable to represent the value along the X axis, call it X:
    protected IVariable _X;
    
    // DECLARE an IVariable to represent the value along the Y axis, call it Y:
    protected IVariable _Y;
    
    // DECLARE an IVariable to represent the value along the Z axis, call it Z:
    protected IVariable _Z;

    // DECLARE an IVariable to represent the angle about the X axis, call it Xo:
    protected IVariable _Xo;
    
    // DECLARE an IVariable to represent the angle about the Y axis, call it Yo:
    protected IVariable _Yo;
    
    // DECLARE an IVariable to represent the value angle about Z axis, call it Zo:
    protected IVariable _Zo;

    // DECLARE a List of IUpdatables to contain any behaviours, call it _behaviours:
    protected List<IUpdatable> _behaviours;

    
    // ---------------------- IMPLEMENTATION OF ISpawnable --------------------------- //
    /**
     * METHOD: spawn at the given position/orientation
     * @param displayObject the IDisplayObject to represent the spawnable.
     * @param xPosn IVariable controlling the position along y axis.
     * @param yPosn IVariable controlling the position along y axis.
     * @param zPosn IVariable controlling position along z axis.
     * @param xOrientation IVariable controlling the orientation about x axis.
     * @param yOrientation IVariable controlling the orientation about y axis.
     * @param zOrientation IVariable controlling orientation about z axis.
     */
    public void spawn(IDisplayObject displayObject, IVariable xPosn, IVariable yPosn, IVariable zPosn,
            IVariable xOrientation, IVariable yOrientation, IVariable zOrientation)
    {
        // INSTANTIATE _behaviours:
        _behaviours = new ArrayList<IUpdatable>();

        // ASSIGN _displayObject to displayObject:
        _displayObject = displayObject;
        
        // INITIALISE movements...
        // X:
        _X = assign(xPosn);
        
        // Y:
        _Y = assign(yPosn);
        
        // Z:
        _Z = assign(zPosn);
        
        // Xo:
        _Xo = assign(xOrientation);
        
        // Yo:
        _Yo = assign(yOrientation);

        // Zo:
        _Zo = assign(zOrientation);
        
        // all done
        return;
    }
    
    /**
     * METHOD: add a behaviour (as an IUpdatable)
     * 
     * @param behaviour the behaviour to be added (as an IUpdatabale)
     */
    public void addBehaviour(IUpdatable behaviour)
    {
        _behaviours.add(behaviour);
    }
    
    /**
     * METHOD: return a reference to the IDisplayObject
     * 
     */
    public IDisplayObject getDisplayObject()
    {
        return _displayObject;
    }
    // ----------------------------------------------------------------------------------- //
    
    // ------------------------- IMPLEMENTATION OF IUpdatable ---------------------------- //
    /**
     * METHOD: change to Spawnable for next frame
     */
    public void update()
    {
        // CREATE an Iterator for _behaviours, call it _updateIterator:
        ListIterator<IUpdatable> _updateIterator = _behaviours.listIterator(0);
        
        // UPDATE _behaviours:
        while (_updateIterator.hasNext())
        {
            _updateIterator.next().update();
        }
            
        // Update all axes of _displayObject:
        _displayObject.position(_X.value(), _Y.value(), _Z.value());
        _displayObject.orientation(_Xo.value(), _Yo.value(), _Zo.value());
    }
    
    //------------------------------------------------------------------------------------ //
    
    
    // -------------------------------- Private Methods -------------------------------- //
    private IVariable assign(IVariable v)
    {
        // ADD v to _behaviours if it implements IUpdatable:
        if (IUpdatable.class.isInstance(v))
        {
            _behaviours.add((IUpdatable)v);
        }
        
        // return v:
        return v;
    }

}

