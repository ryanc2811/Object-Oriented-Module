package UserCode;

///////////////////////////////////////////////////////////////////////////////////////////////////
// Notes:
// * Add code to this as necessary to produce your simulation.
// * Use comments to clearly highlight your code that has been added.
// * Acknowledge/cite appropriately any added code that is not your own.
///////////////////////////////////////////////////////////////////////////////////////////////////
import env3d.Env;
import Framework.*;
import Mouse.*;
import Game.*;

/**
 * Simulation is the top-level class for the Aquarium simulation.
 * 
 * @author Marc Price
 * @version 0.5
 */
public class Simulation
{
    /**
     * METHOD: Static Main method used for creating standalone apps
     *
     */
    public static void main(String[] args) throws Exception
    {
        // Instantiate CoreMgr as an ICoreMgr, call it core:
        ICoreMgr core = new CoreMgr();
        
        // Instantiate MouseHandler as an IMousePublisher, call it mouse:
        IMousePublisher mouse = new MouseHandler(core);
        
        // CAST mouse to an IInputHandler, call it mouseMgr:
        IInputHandler mouseMgr = (IInputHandler) mouse;
        
        // Instantiate FishSweeper as an IMouseListener, call it listener:
        IMouseListener listener = new FishSweeper(core, mouseMgr);
        
        // Subscribe listener to mouse:
        mouse.subscribe(listener);
        
        // CAST listener to an IGame, call it game:
        IGame game = (IGame) listener;
        
        // Run game:
        game.run();
    }
    
}
