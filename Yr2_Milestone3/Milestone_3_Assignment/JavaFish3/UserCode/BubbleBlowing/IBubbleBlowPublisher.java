package UserCode.BubbleBlowing;


/**
 * Write a description of interface IBubbleBlowPublisher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface IBubbleBlowPublisher
{
    /**
     * An example of a method header - replace this comment with your own
     * 
     * @param  y    a sample parameter for a method
     * @return        the result produced by sampleMethod 
     */
    void Subscribe(IBubbleBlowListener BL);
    void Unsubscribe(IBubbleBlowListener BL);
}
