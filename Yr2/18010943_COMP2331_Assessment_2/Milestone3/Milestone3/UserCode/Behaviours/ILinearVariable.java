package UserCode.Behaviours;


/**
 * ILinearVariable: a 'smart' variable with a linear change, which changes direction when it reaches the upper or lower limit.
 * Essentially a counter, that counts upwards by default, until it reaches the upper limit.
 * Then it begins counting back down until it reaches the lower limit, when it begins counting up again... and so on, ad infinitum..
 * 
 * @author Marc Price 
 * @version 0.1
 */
public interface ILinearVariable
{
    /**
     * METHOD: initialise movement behaviour according to needs.
     * 
     * @param  value    the initial value of the variable.
     * @param  speed    the step size that the variable should be incremented/decremented by.
     * @param  minimum  the lower boundary value for the variable.
     * @param  maximum  the upper boundary value for the variable.
     */
    public void initialise(double value, double speed, double minimum, double maximum);

}
