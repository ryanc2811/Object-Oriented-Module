package UserCode.Behaviours;
import UserCode.Vector3;
/**
 * This is the Behaviour for the horizontal movement of a fish
 *
 * @author (Ryan Coles)
 * @version (1.0)
 */
public class horizontalMovement implements IFishBehaviour
{
    //DECLARE a Vector3 for storing the fish's position, call it Position
    private Vector3 Position;
    //DECLARE a Vector3 for storing the fish's orientation, call it Orientation
    private Vector3 Orientation;
    //DECLARE a double for storing the movement speed of the fish, call it Speed
    private double Speed=0.05;
    //DECLARE an int for the facing direction of a fish
    private int facingDirection=1;
    //DECLARE a double for each orientation angle
    private double rotateX=0, rotateY=0, rotateZ=0;
    //DECLARE a double for each position coordinate
    private double x=0, y=0, z=0.15;
    /**
     * horizontalMovement Constructor
     *
     */
    public horizontalMovement()
    {
       // define the maximum required number 
       double max = 0.05;
       // define the minumun required number
       double min = 0.005;
       // define the range 
       double range = max - min;
       //set speed to a random number within the range
       Speed =(Math.random() * range) + min;
    }
    /**
     * Method setVectors
     *
     * @param pPosition Position of the fish
     * @param pOrientation Orientation of the fish
     */
    public void setVectors(Vector3 pPosition, Vector3 pOrientation)
    {
       //set Vectors to passed value
       Position=pPosition;
       Orientation=pOrientation;
       //set x to positions x value
       x=Position.getX();
       //set y to positions y value
       y=Position.getY();
       //set rotateX to Orientations x value
       rotateX=Orientation.getX();
       //set rotateY to Orientations y value
       rotateY=Orientation.getY();
    }
    /**
     * Method getPosition
     *
     * @return Position if the fish
     */
    public Vector3 getPosition()
    {
        return Position;
    }
    /**
     * Method getOrientation
     *
     * @return Orientation of the fish
     */
    public Vector3 getOrientation()
    {
        return Orientation;
    }
    /**
     * Method Behaviour
     * Enacts the horizontal movement behaviour
     */
    public void Behaviour()
    {
        //move the fish along the x axis depending on the direction they are facing
       x+=Speed*facingDirection;
       //Pass the x,y and z coordinates into the Vector3 position object
       Position.setValue(x,y,z);
       //Pass the rotateX, rotateY and rotateZ angles into the Vector3 orientation object
       Orientation.setValue(rotateX, rotateY, rotateZ);
        //if x is greater than 9 then turn around and swim to the left
        //else if x is less than or equal to 1 then turn around and swim to the right
       if(x>=9.75)
       {
           //has hit the right side of the screen
           facingDirection=-1;
           //flip fish token
           rotateY=90;
       }
       else if(x<=0.25)
       {
           //has hit the left side of the screen
           facingDirection=1;
           //flip fish token
           rotateY=-90;
       }
    }
}
