package Framework.Implementations;
import Framework.Interfaces.*;
import UserCode.Behaviours.*;
import UserCode.*;
import Exceptions.*;
/**
 * Write a description of class Swimmable here.
 * 
 * @author (Ryan Coles) 
 * @version (1.0)
 */
public class Swimmable implements ISwimmable,IUpdatable,ISpawnable
{
    // instance variables - replace the example below with your own
    private IFishBehaviour _fishBehaviour;
    private IDisplayObject fish;
    private Vector3 _Position;
    private Vector3 _Orientation;
    /**
     * Constructor for objects of class Swimmable
     */
    public Swimmable()
    {
        
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
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void update()
    {
        // put your code here
       if(_fishBehaviour!=null){
       _fishBehaviour.Behaviour();
       _Position=_fishBehaviour.getPosition();
       _Orientation=_fishBehaviour.getOrientation();
       fish.position(_Position);
       fish.orientation(_Orientation);
    }
    }
}
