package Framework;

import env3d.Env;

/**
 * ICore implementations provide the core functionality for the top-level aquarium simulation class.
 * 
 * @author Marc Price 
 * @version 0.4
 */
public interface ICoreMgr
{
    /**
     * METHOD: create and initialise the environment (aka 'world')
     *
     */
    void createWorld();
    
    /**
     * METHOD: destroy the 3D world.
     * Although there is a garbage-collector in Java, the world has to be destroyed with 'destroyWorld'
     * in order to close-down your simulation-loop cleanly.
     *
     */
    void destroyWorld();
    
        
    /**
     * Apply all updates to the environment.
     * This must be called at the end of each pass through the simulation loop.
     *
     */
    void updateWorld();
    
    /**
     * Add a renderable object to the world.
     * 
     * @param   token   an object of type Renderable that is to be displayed in the virtual world.
     */
    void addRenderable(IRenderable token);
    
    /**
     * Remove a renderable object from the world.
     * 
     * @param   token   an object of type Renderable that is to be removed from the virtual world.
     */
    void removeRenderable(IRenderable token);
    
    /**
     * Accessor for the Env3D world object
     * 
     * @return  the Env3D world object
     */
    Env world();
}
