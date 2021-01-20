package UserCode;

///////////////////////////////////////////////////////////////////////////////////////////////////
// Notes:
// * Add code to this as necessary to produce your simulation.
// * Use comments to clearly highlight your code that has been added.
// * Acknowledge/cite appropriately any added code that is not your own.
///////////////////////////////////////////////////////////////////////////////////////////////////
import env3d.Env;
import Framework.ICore;
import Framework.Core;
import UserCode.fishpong.*;
import UserCode.input.*;
import UserCode.pets.*;
/**
 * Simulation is the entry-point for the FishPong game.
 * 
 * @author Marc Price
 * @version 0.5
 */
public class Simulation
{
    // instance variables:
    // none

    
    /**
     * METHOD: Static Main method used for entry-point
     *
     */
    public static void main(String[] args) throws Exception
    {
        // INSTANTIATE an ICore, a mouse IInputPublisher, a keyboard IInputPublisher, and an IGameMgr:
        ICore core = new Core();
        IInputPublisher mouse = new MouseHandler();
        IInputPublisher keys = new KeybHandler();
        IBehaviourMgr BM = new BehaviourMgr();
        INewBallListener _newBallListener=new NewBallListener();
        // SUBSCRIBE _food as a _mouse listener:
        mouse.subscribe((IInputListener)_newBallListener);
        IGameInitialiser GI=new GameInitialiser(keys,BM);
        IGameMgr game = new GameMgr(BM,_newBallListener,GI);
        // INSTANTIATE the FishPong top-level class, and pass it the above instances:
        FishPong sim = new FishPong(core, mouse, keys, game,GI);
        
        // ENTER the real-time loop:
        sim.run();
    }
    
    
    /**
     * Constructor for objects of class Simulation
     */
    public Simulation()
    {
    }

}
