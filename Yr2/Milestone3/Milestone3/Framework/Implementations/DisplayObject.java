package Framework.Implementations;

import Framework.Interfaces.*;


/**
 * The DisplayObject contains all the data for displaying something by a Core instance.
 * 
 * @author (Marc Price) 
 * @version 0.6
 */
public class DisplayObject implements IDisplayObject
{
    // Env3d-defined object-specific fields:
    // Reference to the 3D model, called 'model':
    protected String model;
    
    // Reference to texture-map, called 'texture':
    protected String texture;
    
    // Scale factor applied to model:
    private double scale=1.0;
    
    // Position in 3D world (x,y,z coordinates):
    private double x=0, y=0, z=0;
    
    // Orientation (about x,y,z):
    private double rotateX=0, rotateY=0, rotateZ=0;
    
    // Set transparency to true:
    private boolean transparent=true;

    /**
     * Constructor for objects of class DisplayObject
     * 
     * @param  model    the path to the file for the model
     * @param  tex      the path to the file for the texture
     * @param  scale    the amount to scale the model by to produce the rqd size object
     */
    public DisplayObject(String model, String tex, double scale)
    {
        // initialise instance variables
        this.scale = scale;
        this.model = model;
        this.texture = tex;
    }
    
    
    // ------------------ IMPLEMENTATION OF IDisplayObject --------------------//
    /**
     * METHOD: set the position of the IDisplayObject along x,y,z axes
     * @param x double giving the new position along x axis.
     * @param y double giving the new position along y axis.
     * @param z double giving the new position along z axis.
     */
    public void position(double x, double y, double z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    /**
     * METHOD: set the orientation of the IDisplayObject about x,y,z axes
     * @param xo double giving the new orientation about x axis.
     * @param yo double giving the new orientation about y axis.
     * @param zo double giving the new orientation about z axis.
     */
    public void orientation(double xo, double yo, double zo)
    {
        this.rotateX = xo;
        this.rotateY = yo;
        this.rotateZ = zo;
    }
    
}
