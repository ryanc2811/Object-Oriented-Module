package UserCode;

import Framework.Interfaces.IWorld;
import UserCode.ObjectCreation.IUpdatableFactory;
import UserCode.InputHandling.IInputHandler;
import UserCode.Game.ISpawnableFactory;
/**
 * All top-level game classes must implement IGameMgr.
 *
 * @author Marc Price
 * @version 0.1
 */
public interface IGameMgr
{
    /**
     * METHOD: Create the game scene.
     * 
     * @param factory an IUpdatableFactory, needed to create ISpawnables as IUpdatables.
     * @param world an IWorld, needed to spawn ISpawnables.
     */
    void create(IUpdatableFactory factory, IWorld world, IInputHandler input,ISpawnableFactory spawnFactory);
    
}
