package UserCode.Game;

import Framework.Interfaces.IUpdatable;
import Framework.Interfaces.IWorld;
import UserCode.ObjectCreation.IUpdatableFactory;

/**
 * ISpawnableFacade - a facade to any ISpawnable used in the game.  It is used to initialise and set-up a spawnable.
 *
 * @author Marc Price
 * @version 0.1
 */
public interface ISpawnableFacade extends IUpdatable
{
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
    void spawn(IUpdatableFactory factory, IWorld world, double speed, double xPosn, double yPosn, double zPosn,
                            double xOrientation, double yOrientation, double zOrientation) throws Exception;
}
