package UserCode.Spawnables;

import Framework.Interfaces.IDisplayObject;
import Framework.Interfaces.IUpdatable;
import UserCode.Behaviours.IVariable;
import Exceptions.*;

/**
 * Any object that can be spawned must implement ISpawnable.
 * 
 * @author Marc Price 
 * @version 0.1
 */
public interface ISpawnable
{
    /**
     * METHOD: spawn at the given position/orientation
     * @param displayObject the IDisplayObject to represent the spawnable.
     * @param xPosn IVariable controlling the position along x axis.
     * @param yPosn IVariable controlling the position along y axis.
     * @param zPosn IVariable controlling position along z axis.
     * @param xOrientation IVariable controlling the orientation about x axis.
     * @param yOrientation IVariable controlling the orientation about y axis.
     * @param zOrientation IVariable controlling orientation about z axis.
     */
    void spawn(IDisplayObject displayObject, IVariable xPosn, IVariable yPosn, IVariable zPosn,
            IVariable xOrientation, IVariable yOrientation, IVariable zOrientation);
            
    /**
     * METHOD: add a behaviour (as an IUpdatable)
     * 
     * @param behaviour the behaviour to be added (as an IUpdatabale)
     */
    void addBehaviour(IUpdatable behaviour);
    
    /**
     * METHOD: return a reference to the IDisplayObject
     * 
     */
    IDisplayObject getDisplayObject();
}
