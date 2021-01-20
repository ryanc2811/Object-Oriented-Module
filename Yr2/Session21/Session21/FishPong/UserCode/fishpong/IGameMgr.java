package UserCode.fishpong;

import env3d.Env;

/**
 * IGameMgr: a class that takes care of running the game.
 * 
 * @author Marc Price 
 * @version 0.6
 */
public interface IGameMgr
{
    /**
     * Update the IGameMgr - must be called on each pass thru update loop
     */
    void update(Env world) throws Exception;

}