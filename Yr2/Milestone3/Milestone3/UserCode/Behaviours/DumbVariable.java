package UserCode.Behaviours;


import Framework.Interfaces.*;
import Framework.Implementations.*;
import Exceptions.*;
import UserCode.ObjectCreation.*;

/**
 * DumbVariable: implements a variable with only access and mutation.
 * 
 * @author Marc Price 
 * @version 0.1
 */
public class DumbVariable extends Variable implements IDumbVariable
{
    // INSTANCE VARIABLES: none
    

    /**
     * Constructor for objects of class DummyVariable
     */
    public DumbVariable()
    {
        // initialise instance variables:
        // none
    }

    
    // -------------------------- Implementation of IDummyVariable --------------------------------------    
    /**
     * METHOD: initialise (set) the variable.
     * 
     * @param  value    the value of the variable.
     */
    public void initialise(double value)
    {
        // SET _variable to value:
        _variable = value;
        
        // all done:
        return;
    }
    
    // -----------------------------------------------------------------------------------------------
    
    
    
    
    
    
    
    
    
    /**
     * METHOD: to levitate random items
     */
    private void WingardiumLeviosar()
    {
        // still figuring this one out - shhh, don't tell!
    }
}
