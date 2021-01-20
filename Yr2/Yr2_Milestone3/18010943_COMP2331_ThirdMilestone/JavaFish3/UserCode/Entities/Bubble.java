package UserCode.Entities;
import Framework.Interfaces.*;
import UserCode.Vector3;
import Exceptions.*;
/**
 * Class for the ISpawnable Bubble object.
 * 
 * @author (Ryan Coles) 
 * @version (1.0)
 */
public class Bubble implements ISpawnable, IUpdatable
{
    //DECLARE an IDisplayObject for holding a reference to the displayobject that is associated with this Bubble class
    private IDisplayObject bubble;
    //DECLARE 3 doubles for storing the x,y and z coordinates of the fish food, call them x,y and z
    private double x,y,z;
    //DECLARE a double for storing the speed of the bubble, call it speed
    private double speed =0.015f;
    //DECLARE a reference to the IWorld class
    private IWorld _world;
    //DECLARE a boolean for checking if the object wants to be destroyed, call it destroy
    private boolean destroy=false;
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
        //store referenec to IWorld in a local variable
        _world=world;
        // ADD to 3D world:
        _world.addDisplayObject(bubble);
    }
    /**
     * Method Destroy
     *
     * @return destroy boolean
     */
    public boolean Destroy()
    {
        return destroy;
    }
    /**
     * Method DestroyBubble
     * Destroy the Bubble
     */
    private void DestroyBubble()throws WorldDoesNotExistException
    {
        //remove the displayobject from the game world
        _world.removeDisplayObject(bubble);
        //tell simulation that this object wants to be removed from the _updatables list
        destroy=true;
    }
    /**
     * Method CheckTopHit
     *
     * @return true if bubble has hit the top of the screen
     */
    private boolean CheckTopHit()
    {
        if(y>=7)
        {
            return true;
        }
        return false;
    }
     /**
     * Method update
     *
     */
    public void update()
    {
       //float to the top of the screen
       y+=speed;
       // if the bubble reaches the top of the screen
       if(CheckTopHit())
       {
           System.out.println("Pop");
           try
           {
               //Destroy the bubble
               DestroyBubble();
           }
           catch(Exception e)
            {
            }
       }
       //Passes the x,y and z values to the display object class
       bubble.position(new Vector3(x,y,z));
}
}
