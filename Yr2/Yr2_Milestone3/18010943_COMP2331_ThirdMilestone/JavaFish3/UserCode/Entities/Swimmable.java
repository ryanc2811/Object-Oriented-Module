package UserCode.Entities;
import Framework.Interfaces.*;
import UserCode.Behaviours.*;
import UserCode.*;
import Exceptions.*;
import UserCode.BubbleBlowing.BubbleBlower;
import java.lang.Math;
/**
 * Generic class for Swimmable objects with a mouth
 * 
 * @author (Ryan Coles) 
 * @version (1.0)
 */
public class Swimmable implements ISwimmable,IUpdatable,ISpawnable,IMouth
{
     // DECLARE a reference to the IFishBehaviour class
    private IFishBehaviour _fishBehaviour;
    //DECLARE a reference to the IDisplayObject that relates to this object
    private IDisplayObject fish;
    //DELCARE a Vector3 for storing the position of the swimmable object
    private Vector3 _Position;
     //DELCARE a Vector3 for storing the orientation of the swimmable object
    private Vector3 _Orientation;
    //DECLARE a boolean for checking if the object wants to be destroyed
    private boolean destroy=false;
    //DECLARE a refernce to the bubbleBlower object
    private BubbleBlower bubbleBlower;
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
        fish=displayObject;
        // SET position of fish by translating fish
        fish.position(Position);
        // SET orientation of fish by rotating fish
        fish.orientation(Orientation);
        _fishBehaviour.setVectors(fish.position(),fish.orientation()); 
        // ADD to 3D world:
        world.addDisplayObject(fish);
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
     * Method receiveJob
     *
     * @param behaviour receive the behaviour related to this object
     */
    public void receiveJob(IFishBehaviour behaviour)
    {
        _fishBehaviour=behaviour;
    }
    /**
     * Method receiveBubbleBlower
     *
     * @param BB receive the BubbleBlower object so the fish can blow bubbles
     */
    public void receiveBubbleBlower(BubbleBlower BB)
    {
        bubbleBlower=BB;
    }
    /**
     * Method Behaviour
     * Behaviour of the Swimmable object
     */
    private void Behaviour()
    {
        //Enact the fish behaviour
        _fishBehaviour.Behaviour();
        //get the position from the behaviour class
        _Position=_fishBehaviour.getPosition();
        //get the orientation from the fish behaviour class
        _Orientation=_fishBehaviour.getOrientation();
        //pass the position to the IDisplayObject
        fish.position(_Position);
        //pass the orientation to the IDisplayObject
        fish.orientation(_Orientation);
    }
    /**
     * Method update
     *
     */
    public void update()
    {
        // if there is a fish behaviour
        if(_fishBehaviour!=null)
        {
           //Enact behaviour
           Behaviour();
           //Blow bubbles
           bubbleBlower.BlowBubble(_Position);
        }
    }
}
