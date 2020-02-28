package Framework.Implementations;

import Framework.Interfaces.*;
import UserCode.Behaviours.*;
import UserCode.*;
import com.jme3.system.SystemListener;

/**
 * The DisplayObject contains all the data for displaying something by a Core instance.
 * 
 * @author (Marc Price) 
 * @version 0.6
 */
public class DisplayObject implements IDisplayObject, IUpdatable
{
    // Env3d-defined object-specific fields:
    // Reference to the 3D model, called 'model':
    protected String model;
    
    // Reference to texture-map, called 'texture':
    protected String texture;
    
    // Scale factor applied to model:
    private double scale=1.0;
    
    // Position in 3D world (x,y,z coordinates):
    private double x=0, y=0, z=0.1;
    
    // Ori (about x,y,z):
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
    
    public Vector3 orientation()
    {
        Vector3 Orientation=new Vector3(rotateX, rotateY, rotateZ);
        return Orientation;
    }
    public Vector3 position()
    {
        Vector3 Position=new Vector3(x,y,z);
        return Position;
    }
    // ------------------ IMPLEMENTATION OF IDisplayObject --------------------//
        /**
     * METHOD: set the IDisplayObject position along x,y,z axes
     * @param x double giving the new position along x axis.
     * @param y double giving the new position along y axis.
     * @param z double giving the new position along z axis.
     */
    public void position(Vector3 Position)
    {
        this.x = Position.getX();
        this.y = Position.getY();
        this.z = Position.getZ();
    }
    
    /**
     * METHOD: rotate the IDisplayObject about x,y,z axes
     * @param xOrientation double giving the new orientation about x axis.
     * @param yOrientation double giving the new orientation about y axis.
     * @param zOrientation double giving the new orientation about z axis.
     */
    public void orientation(Vector3 Orientation)
    {
        this.rotateX = Orientation.getX();
        this.rotateY = Orientation.getY();
        this.rotateZ = Orientation.getZ();
    }
   
    // -------------------------- IMPLEMENTATION OF IUpdatable ----------------------
    /**
     * METHOD: change to DisplayObject for next frame, called by Core class on each update
     * 
     */
    public void update()
    {
        // do nothing
       
        ISound.PlaySound("sounds/bubble.wav");
    }
}
