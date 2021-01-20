package Game;

import java.util.List;
import java.util.ArrayList;
import env3d.Env;
import Framework.ICoreMgr;
import Framework.IRenderable;
import Framework.Renderable;
import Mouse.*;

/**
 * FishSweeper is the top-level class for the Aquarium simulation.
 * 
 * @author Marc Price
 * @version 0.5
 */
public class FishSweeper implements IGame, IMouseListener
{
    // instance variables:    
    // DECLARE a reference to the ICoreMgr, call it '_core':
    private ICoreMgr _core;
    
    // DECLARE a reference to an IInputHandler, call it _mouse:
    private IInputHandler _mouse;
    
    // DECLARE a boolean that signals when a new mouse input is received, call it '_clicked':
    private boolean _clicked = false;
    
    // DECLARE an int[2] to hold the coords of the mouse pointer on last click, call it '_mousePosn':
    private int[] _mousePosn = {-1,-1};
    
    // DECLARE a List that stores the target tokens, call it _targets:
    private List<IRenderable> _targets;
            
    // DECLARE a boolean that signals when the simulation loop should be exited:
    private boolean endSim = false;
    
    
    /**
     * Constructor for objects of class FishSweeper
     */
    public FishSweeper(ICoreMgr core, IInputHandler input)
    {
        // INITIALISE instance variables:
        // _core, _mouse, _targets:
        _core = core;
        _mouse = input;
        _targets = new ArrayList<IRenderable>();
        
    }      
    
    /**
     * Method to handle a mouse input (IMouseListener)
     * 
     */
    public void onMouse(int... mouseVal)
    {
        _clicked = true;
        _mousePosn = mouseVal;
    }

    /**
     * METHOD: Populate the scene with eight targets.
     * The eight targets are all located at y=5, and from x=1.5 to x=8.5.
     *
     */
    private void populate()
    {
        // INSTANTIATE: the 10 targets and...
        // SET: the targets as tokens in the environment
        double offset = 0.5;
        String texture = "textures/javaFish/Target.png";
        Double[] angle = {0.0,90.0,0.0};
        Double scale = 0.4;
        for (int i=1; i<9; i++)
        {
            for (int j=1; j<9; j++)
            {
                Double[] posn = {(double)(j+offset),(double)i,1.0};
                IRenderable target = new Renderable(texture);
                target.position(posn);
                target.orientation(angle);
                target.scale(scale);
                _core.addRenderable(target);
                _targets.add(target);
            }
        }

    }
    
    /**
     * METHOD: Run the simulation loop.  User presses escape to exit.
     *
     */
    public void run() throws Exception
    {
        // CREATE the environment:
        _core.createWorld();
        
        // Populate the environment with things:
        this.populate();
                
        // Start simulation loop:
        while (!endSim)
        {
            // UPDATE STAGE:
            // IF: user has requested simulation loop exit (ie escape pressed):
            if (_core.world().getKey() == 1)
            {
                // SET: render loop exit condition
                endSim = true;
            }
            
            // IF mouse has been clicked:
            if (_clicked)
            {
                // AD-HOC DIAGNOSTICS:
                System.out.println("clicked at:" + _mousePosn[0] + "," + _mousePosn[1]);
                
                // RESET _clicked to false:
                _clicked = false;
                
                // REMOVE underlying target:
                Double[] _estTargetLocn = {(_mousePosn[0]*0.00725), (_mousePosn[1]*0.00725)};
                for (IRenderable target : _targets)
                {
                    Double[] checkPosn = {0.0,0.0};
                    checkPosn[0] = Math.abs(target.position()[0] - _estTargetLocn[0]);
                    checkPosn[1] = Math.abs(target.position()[1] - _estTargetLocn[1]);
                    if ((checkPosn[0]<0.4)&&(checkPosn[1]<0.4))
                    {
                        // REMOVE target from environment and _targets:
                        _core.removeRenderable(target);
                         _targets.remove(target);
                    }
                }
                
                // CHECK if it is a 'hit':
                
                // UPDATE score accordingly:
            }
            
            // UPDATE mouse handler:
            _mouse.update();
                       
            // RENDER STAGE
            // UPDATE: the environment
            _core.updateWorld();
        }
        
        // EXIT: cleanly by closing-down the environment:
        _core.destroyWorld();

    }

}
