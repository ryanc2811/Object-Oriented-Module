package UserCode.BubbleBlowing;
import UserCode.Vector3;

/**
 * Tells handler when a bubble event should be fired.
 * 
 * @author (Ryan Coles) 
 * @version (1.0)
 */
public class BubbleBlower
{
    //DECLARE a reference to the IBubbleHandler object
    private IBubbleHandler bubbleHandler;
    //DECLARE a float for counting how long it has been since the last bubble was created, call it counter
    private float counter;
    //DECLARE a double for the rate at which the bubble should be created, call it bubbleRate
    private double bubbleRate;
    /**
     * BubbleBlower Constructor
     *
     */
    public BubbleBlower()
    {
       double max = 6.0; 
       double min = 2.0; 
       // define the range 
       double range = max - min;
       //set the bubbleRate to a random number within a certain range
       bubbleRate =(Math.random() * range) + min; 
    }
    /**
     * Method Initialize
     *initalise the BubbleBlower by passing the referece of IBubbleHandler from simulation
     * @param BH IBubbleHandler reference to the BubbleHandler class
     */
    public void Initialize(IBubbleHandler BH)
    {
        //set the passed value to local reference of IBubbleHandler
        bubbleHandler=BH;
    }
    /**
     * Method BlowBubble
     *
     * @param Position the position of the bubble
     */
    public void BlowBubble(Vector3 Position)
    {
        //count up
        counter++;
        //if the counter has reached the value of bubbleRate
        if(counter/60f>bubbleRate)
        {
            //pass the position of where the bubble should be created at
            bubbleHandler.BubbleBlown(Position);
            //reset counter
            counter=0;
        }
    }
}
