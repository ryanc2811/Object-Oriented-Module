package UserCode.Entities;
import Framework.Interfaces.*;
import UserCode.Vector3;
import Exceptions.*;
/**
 * Write a description of class FishFood here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FishFood implements IUpdatable,ISpawnable
{
    // instance variables - replace the example below with your own
    private IDisplayObject fishFood;
    private double x;
    private double y;
    private double speed =0.005f;
    /**
     * Constructor for objects of class FishFood
     */
    public FishFood()
    {
        // initialise instance variables
       
    }
    public void spawn(IWorld world,IDisplayObject displayObject, Vector3 Position, Vector3 Orientation)
    throws WorldDoesNotExistException    
    {
        
        fishFood=displayObject;
        // SET position of fish by translating fish
        fishFood.position(Position);
        
        // SET orientation of fish by rotating fish
        fishFood.orientation(Orientation);
        x=Position.getX();
        y=Position.getY();
        //_fishBehaviour.setVectors(fishFood.position(),fishFood.orientation());
        
        // ADD to 3D world:
        world.addDisplayObject(fishFood);
       
    }
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void update()
    {
        y+=-speed;
        fishFood.position(new Vector3(x,y,1));
    }
}
