package UserCode.fishpong;
import UserCode.input.*;

/**
 * Write a description of class NewBallListener here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NewBallListener implements INewBallListener,IInputListener
{
   //DECLARE a boolean to flag a request for a new bubble
    boolean _newBall = false;
    //DECLARE an int[2] to store x,y coordinates of last mouse pointer posn
    int[] _mousePosn = {-1,-1};
    /**
     * Constructor for objects of class NewBallListener
     */
    public NewBallListener()
    {
       
    }

     /**
     * Method to handle a mouse input
     * 
     */
    public void onInput(int... inputVal)
    {
        _newBall = true;
        _mousePosn = inputVal;
    }
    public boolean GetNewBall()
    {
        return _newBall;
    }
    public void ResetNewBall(boolean newBall)
    {
        _newBall=newBall;
    }
    
    public int[] GetBallPos()
    {
        return _mousePosn;
    }
}
