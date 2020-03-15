package UserCode.BubbleBlowing;
import UserCode.Vector3;

/**
 * Write a description of class BubbleBlower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BubbleBlower
{
    // instance variables - replace the example below with your own
    private IBubbleHandler bubbleHandler;
    public void Initialize(IBubbleHandler BH)
    {
        bubbleHandler=BH;
    }
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void BlowBubble(Vector3 Position)
    {
        bubbleHandler.BubbleBlown(Position);
    }
}
