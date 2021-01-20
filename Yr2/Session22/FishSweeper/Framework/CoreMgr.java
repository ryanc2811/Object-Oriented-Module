package Framework;

import env3d.Env;

/**
 * Core is intended to provide the core functionality for the top-level aquarium simulation class.
 * Note that the top-level simulation class must implement the simulation loop.
 * 
 * @author Marc Price 
 * @version 0.4
 */
public class CoreMgr implements ICoreMgr
{
    // instance variables (fields):
    // DECLARE the reference to the 3D world:
    private Env _world;
    
    // DEFINE a private inner class that creates the Env3D 'room', call it 'Aquarium':
    private class Aquarium
    {
        private String textureTop;
        private String textureBottom; // = "textures/orangeFish/AquariumBackground.png";
        private String textureNorth = "textures/javaFish/AquariumBackground.png";
        private String textureSouth;
        private String textureEast; // = "textures/orangeFish/AquariumBackground.png";
        private String textureWest; // = "textures/orangeFish/AquariumBackground.png";
        
        private double width;
        private double height;
        private double depth;
        
        private double bgRed;
        private double bgGreen;
        private double bgBlue;
        
        /**
         * Constructor
         *
         * @param  x   width of type double
         * @param  y   height of type double
         * @param  z   depth of type double
         */
        public Aquarium(double x, double y, double z)
        {
            width = x;
            height = y;
            depth = z;
        }
    
    }
    
    
    
    /**
     * Constructor for objects of class Core
     */
    public CoreMgr()
    {
    }

    /**
     * METHOD: create and initialise the environment (aka 'world')
     *
     */
    public void createWorld()
    {
        // Instantiate an environment:
        _world = new Env();
        
        // Get rid of the awful mouse control:
        _world.setDefaultControl(false);
        
        // Set the window resolution:
        _world.setResolution(1280,960,24);
        
        // Instantiate Aquarium and assign it to the environment as the scene:
        _world.setRoom(new Aquarium(10, 8, 1));
        
        // Set the camera to a fixed position so that scene looks flat:
        _world.setCameraXYZ((_world.getCameraX()),3.9,9.1);
    }

    /**
     * METHOD: destroy the 3D world.
     * Although there is a garbage-collector in Java, the world has to be destroyed with 'destroyWorld'
     * in order to close-down your simulation-loop cleanly.
     *
     */
    public void destroyWorld()
    {
        // Close down the environment:
        _world.exit();
    }
    
    /**
     * Apply all updates to the environment.
     * This must be called at the end of each pass through the simulation loop.
     *
     */
    public void updateWorld()
    {
        // Update the environment
        _world.advanceOneFrame();
    }
    
    /**
     * Add a renderable object to the world.
     * 
     * @param   token   an object of type Renderable that is to be displayed in the virtual world.
     */
    public void addRenderable(IRenderable token)
    {
        _world.addObject(token);
    }
        
    /**
     * Remove a renderable object from the world.
     * 
     * @param   token   an object of type Renderable that is to be removed from the virtual world.
     */
    public void removeRenderable(IRenderable token)
    {
        _world.removeObject(token);
    }
    
    /**
     * Accessor for the Env3D world object
     * 
     * @return  the Env3D world object
     */
    public Env world()
    {
        // RETURN a reference to _env:
        return _world;
    }    
}
