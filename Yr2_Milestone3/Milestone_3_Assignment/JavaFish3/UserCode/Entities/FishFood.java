package UserCode.Entities;
import Framework.Interfaces.*;
import UserCode.Vector3;
import Exceptions.*;
/**
 * Write a description of class FishFood here.
 * 
 * @author (Ryan Coles) 
 * @version (1.0)
 */
public class FishFood implements IUpdatable,ISpawnable
{
    //DECLARE an IDisplayObject for holding a reference to the displayobject that is associated with this FishFood class
    private IDisplayObject fishFood;
    //DECLARE 3 doubles for storing the x,y and z coordinates of the fish food, call them x,y and z
    private double x,y,z;
    //DECLARE a double for storing the speed of the fish food, call it speed
    private double speed =0.005f;
    //DECLARE a boolean for checking if the fish food has reached the bottom of the screen, call it hitBottom
    private boolean hitBottom=false;
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
        fishFood=displayObject;
        // SET the Vector3 for position inside the DisplayObject class to the passed Position
        fishFood.position(Position);
        // SET the Vector3 for orientation inside the DisplayObject class to the passed Orientation
        fishFood.orientation(Orientation);
        //Set x,y and z to the passed values
        x=Position.getX();
        y=Position.getY();
        z=Position.getZ();
        // ADD to 3D world:
        world.addDisplayObject(fishFood);
    }
    /**
     * Method Sink
     *Behaviour for fish food where Fish Food Object floats towards bottom of the screen and stops
     */
    private void Sink()
    {
         //if fishFood has reached the bottom of the screen
        if(y<=0.5)
        //set the hitBottom to true
            hitBottom=true;
        //if the Fish Food hasn't hit the bottom of the screen
        if(!hitBottom)
        //sink to the bottom of the screen
            y+=-speed;
    }
    /**
     * Method update
     *
     */
    public void update()
    {
        //Enact sink behaviour
        Sink();
        //Passes the x,y and z values to the display object class
        fishFood.position(new Vector3(x,y,z));
    }
}
