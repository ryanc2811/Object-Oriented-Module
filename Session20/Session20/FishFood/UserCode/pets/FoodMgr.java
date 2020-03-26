package UserCode.pets;

import UserCode.input.*;

import java.util.List;
import java.util.ArrayList;
import env3d.Env;

/**
 * FoodMgr: a thing that takes care of foods and their behaviours.
 * 
 * @author Marc Price 
 * @version 0.6
 */
public class FoodMgr implements IFoodMgr, IMouseListener
{
    // instance constants:
    //DECLARE the model name of all food renderables:
    private static String model = "sphere";
    
    //DECLARE the texture of all food renderables:
    private static String texture = "textures/javaFish/FishFood.png";
    
    // instance variables:
    //DECLARE the reference to the RenderableCreator, call it _foodMaker:
    private IRenderableFactory _foodMaker;
    
    // DECLARE a reference to the instance of the IBehaviourMgr, call it _behaviour:
    private IBehaviourMgr _foodBehaviour;
    private IBehaviourFactory _behaviourFactory;
    //DECLARE a boolean to flag a request for a new food
    public boolean _newFood = false;
    
    //DECLARE an int[2] to store x,y coordinates of last mouse pointer posn
    private int[] _mousePosn = {-1,-1};
    

    /*******************************************************************************************
     *                          DEPRECATED: newFood is for testing only
     *******************************************************************************************/
    public boolean newFood()
    {
        return _newFood;
    }
    /*******************************************************************************************/
    

    /**
     * Constructor for objects of class FoodMgr
     */
    public FoodMgr()
    {
        // initialise instance variables
        // _foodMaker:
        _foodMaker = new RenderableFactory();
        
        // _foodBehaviour:
        _foodBehaviour = new BehaviourMgr();
        _behaviourFactory=new BehaviourFactory();
    }

    /**
     * Update the FoodMgr - must be called on each pass thru update loop
     */
    public void update(Env world) throws Exception
    {
        // CHECK if a new food has been requested:
        if (_newFood)
        {
            // RESET _newFood for next update:
            _newFood = false;
            
            // CREATE new food renderable:
            Double[] _newFoodLocn = {(_mousePosn[0]*0.0077), (_mousePosn[1]*0.0077), 1.0};

            // CREATE new food renderable:
            Double[] angle = {0.0,90.0,0.0};
            IRenderable food = _foodMaker.create(model, texture, _newFoodLocn, angle, 0.07);
            
            // ADD it to the scene:
            world.addObject(food);
            
            // CREATE associated behaviour:
            IBehaviour behaviour=_behaviourFactory.create(FoodBehaviour.class, food, _newFoodLocn, angle);
            _foodBehaviour.AddBehaviour(behaviour);
        }
        
        // UPDATE behaviour manager:
        _foodBehaviour.update();
    }
    
    /**
     * Method to handle a mouse input
     * 
     */
    public void onMouse(int[] mouseVal)
    {
        // IF elements of mouseVal are positive:
        if ((mouseVal[0]>=0.0)&&(mouseVal[1]>=0.0))
        {
            // SET _newFood=TRUE to flag a new mouse input:
            _newFood = true;
            
            // STORE mouseVal in _mousePosn:
            _mousePosn = mouseVal;
        }
    }
    
}

