package UserCode.Entities;
import Framework.Interfaces.*;
import UserCode.Vector3;
import Exceptions.*;
/**
 * Write a description of class Bubble here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bubble implements ISpawnable, IUpdatable
{
    //DECLARE an IDisplayObject for holding a reference to the displayobject that is associated with this FishFood class
    private IDisplayObject bubble;
    //DECLARE 3 doubles for storing the x,y and z coordinates of the fish food, call them x,y and z
    private double x,y,z;
    //DECLARE a double for storing the speed of the fish food, call it speed
    private double speed =0.015f;
    //DECLARE a boolean for checking if the fish food has reached the bottom of the screen, call it hitBottom
    private boolean hitTop=false;
    /**
     * Constructor for objects of class Bubble
     */
    public Bubble()
    {
        
    }

    /**
     * Method spawn
     * Implementation of ISpawnable-Spawns the ISpawnable Object into the 3D world
     * @param world For spawning the Entity into the 3D world
     * @param displayObject for storing the associated DisplayObject
     * @param Position for storing objects initial Position
     * @param Orientation Vector3 for storing objects initial Orientation
     */
    public void spawn(IWorld world,IDisplayObject displayObject, Vector3 Position, Vector3 Orientation)
    throws WorldDoesNotExistException    
    {
        //SET local IDisplayObject to the passed IDisplayObject
        bubble=displayObject;
        // SET the Vector3 for position inside the DisplayObject class to the passed Position
        bubble.position(Position);
        // SET the Vector3 for orientation inside the DisplayObject class to the passed Orientation
        bubble.orientation(Orientation);
        //Set x,y and z to the passed values
        x=Position.getX();
        y=Position.getY();
        z=Position.getZ();
        // ADD to 3D world:
        world.addDisplayObject(bubble);
    }
     /**
     * Method update
     *
     */
    public void update()
    {
       //float to the top of the screen
            y+=speed;
       //Passes the x,y and z values to the display object class
         bubble.position(new Vector3(x,y,z));
    }
}
