package UserCode.Behaviours;


import Framework.Interfaces.*;
import Framework.Implementations.*;


/**
 * Abstract class Variable - implements the common functionality for any smart variable.
 *
 * @author Marc Price
 * @version 0.1
 */
public abstract class Variable implements IVariable
{
    // INSTANCE VARIABLES:
    // DECLARE a double to store the variable in question, call it _variable:
    protected double _variable;
    

    // -------------------------- Implementation of IVariable --------------------------------------
    /**
     * METHOD: return value of variable
     * 
     * @return double the value of the smart variable.
     */
    public double value()
    {
        return _variable;
    }

}
