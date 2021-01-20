package UserCode.fishpong;

import java.util.List;
import java.util.ArrayList;
import env3d.Env;

import UserCode.input.*;
import UserCode.pets.*;

/**
 * GameMgr: a thing that takes care of bubbles and their behaviours.
 * 
 * @author Marc Price 
 * @version 0.6
 */
public class GameMgr implements IGameMgr
{
    // instance constants:
    //DECLARE the model name of all food tokens:
    private static String _ballModel = "sphere";
    
    //DECLARE the texture of all food tokens:
    private static String _ballTexture = "textures/javaFish/FishFood.png";
    
    //DECLARE the model name of paddle token:
    private static String _paddleModel = "models/billboard/billboard.obj";
    
    //DECLARE the texture of the paddle token:
    private static String _paddleTexture = "textures/javaFish/PiranhaRed.png";
        
    // instance variables:
    // DECLARE a reference to the keyboard handler, call it _keyinput:
    IInputPublisher _keyInput;
    
    //DECLARE the reference to the TokenCreator, call it _ballMaker:
    private ITokenFactory _thingMaker;
    
    // DECLARE a reference to the instance of the IBehaviourMgr, call it _behaviour:
    private IBehaviourMgr _thingBehaviour;
    
    // DECLARE a reference to the paddle, call it _paddle:
    private IBehaviour _paddle;

    //DECLARE a boolean to flag a request for a new bubble
    boolean _newBall = false;
    
    //DECLARE an int[2] to store x,y coordinates of last mouse pointer posn
    int[] _mousePosn = {-1,-1};
    private INewBallListener _ballListener;
    private IGameInitialiser _gameInitialiser;
    /**
     * Constructor for objects of class GameMgr
     */
    public GameMgr(IBehaviourMgr thingBehaviour, INewBallListener ballListener,IGameInitialiser GI)
    {
       
        // _ballMaker:
        _thingMaker = new TokenFactory();
        _ballListener=ballListener;
        _gameInitialiser=GI;
        // _ballBehaviour:
        _thingBehaviour = thingBehaviour;
    }
    /**
     * Update the GameMgr - must be called on each pass thru update loop
     */
    public void update(Env world) throws Exception
    {
        // CHECK if a new bubble has been requested:
        _newBall=_ballListener.GetNewBall();
        if (_newBall)
        {
            // RESET _newBall for next update:
            _ballListener.ResetNewBall(false);
            _mousePosn= _ballListener.GetBallPos();
            // CREATE new bubble token:
            Double[] newBallLocn = {(_mousePosn[0]*0.0077), (_mousePosn[1]*0.0077), 1.0};
            Double[] angle = {0.0,90.0,0.0};
            IToken ball = _thingMaker.createToken(_ballModel, _ballTexture, newBallLocn, angle, 0.1);
            
            // ADD it to the scene:
            world.addObject(ball);
            _paddle=_gameInitialiser.GetPaddle();
            // CREATE associated behaviour and pass it _paddle as an ICollider:
            ICollidable ballBehaviour = (ICollidable) _thingBehaviour.createBehaviour(BallBehaviour.class, ball, newBallLocn, angle);
            ballBehaviour.addICollider((ICollider) _paddle);
        }
        
        // UPDATE behaviour manager:
        _thingBehaviour.update();
    }
    
}

