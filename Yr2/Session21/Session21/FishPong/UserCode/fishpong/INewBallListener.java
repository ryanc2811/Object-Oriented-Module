package UserCode.fishpong;


/**
 * Write a description of interface INewBallListener here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface INewBallListener
{
   boolean GetNewBall();
   void ResetNewBall(boolean newBall);
   int[] GetBallPos();
}
