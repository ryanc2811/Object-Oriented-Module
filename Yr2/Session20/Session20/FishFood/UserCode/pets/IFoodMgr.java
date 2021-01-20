package UserCode.pets;

import env3d.Env;

/**
 * IFoodMgr: a thing that takes care of creating food tokens and their behaviours.
 * 
 * @author Marc Price 
 * @version 0.6
 */
public interface IFoodMgr
{
    /**
     * Update the IBubbleMgr - must be called on each pass thru update loop
     */
    void update(Env world) throws Exception;

}
