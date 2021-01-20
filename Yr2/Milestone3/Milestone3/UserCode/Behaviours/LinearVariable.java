package UserCode.Behaviours;

import Framework.Interfaces.*;
import Framework.Implementations.*;


/**
 * LinearVariable: implementation of ILinearVariable - a 'smart' variable with a linear change, which changes direction when it reaches the upper or lower limit.
 * 
 * @author Marc Price 
 * @version 0.1
 */
public class LinearVariable extends Variable implements ILinearVariable, IUpdatable
{
    // INSTANCE VARIABLES:
    // DECLARE a double to store the direction (as either -1 or +1), call it _direction, set it to 1.0:
    protected double _direction = 1.0;
    
    // DECLARE a double to store the step-size (ie speed), call it _speed, default to 1.0:
    private double _speed = 0.0;
    
    // DECLARE a double to store the lower boundary, call it _min, default to 0.0:
    private double _min = 0.0;
    
    // DECLARE a double to store the upper boundary, call it _max, default to 1.0:
    private double _max = 1.0;
    

    /**
     * Constructor for objects of class LinearVariable
     */
    public LinearVariable()
    {
        // initialise instance variables:
        // none
    }



    // -------------------------- Implementation of ILinearVariable --------------------------------------
    /**
     * METHOD: initialise movement behaviour according to needs.
     * 
     * @param  value    the initial value of the variable.
     * @param  speed    the step size that the variable should be incremented/decremented by.
     * @param  minimum  the lower boundary value for the variable.
     * @param  maximum  the upper boundary value for the variable.
     */
    public void initialise(double value, double speed, double minimum, double maximum)
    {
        // SET _variable to value:
        _variable = value;
        
        // SET _speed to speed:
        _speed = speed;
        
        // SET _min to minimum:
        _min = minimum;
        
        // SET _max to maximum:
        _max = maximum;
        
        // all done:
        return;
    }
    
    
    // -------------------------- Implementation of IUpdatable --------------------------------------
    /**
     * METHOD: change to variable for next frame
     * 
     */
    public void update()
    {
        // COMPUTE next step: _speed * _direction:
        double step = _speed*_direction;
        
        // CHECK if _variable will go outside bounds:
        if ((_min > _variable+step)||(_max < _variable+step))
        {
            // Invert _direction:
            _direction *=-1.0;
            
            // RE-COMPUTE next step:
            step = _speed*_direction;
        }
        
        // APPLY step to )variable:
        _variable += step;
        
        return;
    }
}
