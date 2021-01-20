package UserCode.fishpong;
import UserCode.input.*;
import UserCode.pets.*;
import env3d.Env;
/**
 * Write a description of class GameInitialiser here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameInitialiser implements IGameInitialiser
{
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
    /**
     * Constructor for objects of class GameInitialiser
     */
    public GameInitialiser(IInputPublisher keys,IBehaviourMgr thingBehaviour)
    {
       _keyInput=keys;
       // _ballMaker:
        _thingMaker = new TokenFactory();
        // _ballBehaviour:
        _thingBehaviour = thingBehaviour;
    }

    public void Initialise(Env world) throws Exception
    {
         // CREATE paddle...
        // CREATE new paddle token:
        Double[] paddleLocn = {1.0, 4.0, 1.0};
        Double[] angle = {0.0,-90.0,180.0};
        IToken paddleToken = _thingMaker.createToken(_paddleModel, _paddleTexture, paddleLocn, angle, 0.5);
        
        // ADD it to the scene:
        world.addObject(paddleToken);
        
        // CREATE associated behaviour:
        _paddle = _thingBehaviour.createBehaviour(PaddleBehaviour.class, paddleToken, paddleLocn, angle);
        
        // SUBSCRIBE paddle to keyboard handler:
        _keyInput.subscribe((IInputListener) _paddle);
    }
    public IBehaviour GetPaddle()
    {
        if(_paddle!=null)
            return _paddle;
        return null;
    }
}
