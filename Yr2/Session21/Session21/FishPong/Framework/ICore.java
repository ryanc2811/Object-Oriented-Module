package Framework;


import env3d.Env;

/**
 * ICore implementations provide the core functionality for the top-level aquarium simulation class.
 * Note that the top-level simulation class must implement the simulation loop.
 * 
 * @author Marc Price 
 * @version 0.4
 */

public interface ICore
{
    /**
     * METHOD: create and initialise the environment (aka 'world')
     *
     * @return      the 'world', once it has been created.
     */

    Env createWorld();
    
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
}
