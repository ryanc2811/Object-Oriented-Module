package UserCode.Behaviours;
import UserCode.Vector3;

/**
 * Write a description of class horizontalMovement here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class horizontalMovement implements IFishBehaviour
{
    private Vector3 Position;
    private Vector3 Orientation;
    private double Speed=0.05;
    private int facingDirection=1;
  // Orientation (about x,y,z):
    private double rotateX=0, rotateY=0, rotateZ=0;
    private double x=0, y=0, z=1;
    /**
     * Constructor for objects of class horizontalMovement
     */
    public horizontalMovement()
    {
       
    }
    public void setVectors(Vector3 pPosition, Vector3 pOrientation)
    {
       Position=pPosition;
       Orientation=pOrientation;
       x=Position.getX();
       y=Position.getY();
       rotateX=Orientation.getX();
       rotateY=Orientation.getY();
    }
    public Vector3 getPosition()
    {
        return Position;
    }
    public Vector3 getOrientation()
    {
        return Orientation;
    }
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void Behaviour()
    {
        //move the fish along the x axis depending on the direction they are facing
       x+=Speed*facingDirection;
       Position.setValue(x,y,z);
       Orientation.setValue(rotateX, rotateY, rotateZ);
       System.out.println(x);
        //if x is greater than 9 then turn around and swim to the left
        //else if x is less than or equal to 1 then turn around and swim to the right
       if(x>=9)
       {
           //has hit the right side of the screen
           facingDirection=-1;
           rotateY=90;
       }
       else if(x<=1)
       {
           //has hit the left side of the screen
           facingDirection=1;
           rotateY=-90;
       }
    }

}
