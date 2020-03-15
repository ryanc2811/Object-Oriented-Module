package UserCode.Entities;
import Framework.Interfaces.*;
import UserCode.Behaviours.*;
import UserCode.*;
import Exceptions.*;
import UserCode.BubbleBlowing.BubbleBlower;
import java.lang.Math;
/**
 * Write a description of class Swimmable here.
 * 
 * @author (Ryan Coles) 
 * @version (1.0)
 */
public class Swimmable implements ISwimmable,IUpdatable,ISpawnable,IMouth
{
    // instance variables - replace the example below with your own
    private IFishBehaviour _fishBehaviour;
    private IDisplayObject fish;
    private Vector3 _Position;
    private Vector3 _Orientation;
    private BubbleBlower bb;
    private boolean blow=false;
    private float counter;
    private double bubbleRate;

    public Swimmable()
    {
       // define the range 
       double max = 6; 
       double min = 2; 
       double range = max - min + 1; 
       bubbleRate =(Math.random() * range) + min; 
    }
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
    public void receiveJob(IFishBehaviour behaviour)
    {
        _fishBehaviour=behaviour;
    }
    public void receiveBubbleBlower(BubbleBlower BB)
    {
        bb=BB;
    }
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void update()
    {
        // put your code here
        if(_fishBehaviour!=null)
        {
           _fishBehaviour.Behaviour();
           _Position=_fishBehaviour.getPosition();
           _Orientation=_fishBehaviour.getOrientation();
           fish.position(_Position);
           fish.orientation(_Orientation);
           counter++;
           System.out.println(counter/60f);
           if(counter/60f>bubbleRate)
           {
               bb.BlowBubble(_Position);
               // Get elapsed time in seconds
               counter=0;
            }
        }}
}
