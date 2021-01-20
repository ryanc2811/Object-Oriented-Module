package UserCode.pets;

import java.util.List;
import java.util.ArrayList;
/**
 * BehaviourMgr: implementation of IBehaviour - a manager of a set of IBehaviours.
 * 
 * @author Marc Price 
 * @version 0.6
 */
public class BehaviourMgr implements IBehaviourMgr
{
    // instance variables:
    // DECLARE a list that holds the behaviours, call it _behaviours:
    List<IBehaviour> _behaviours;

    /**
     * Constructor for objects of class BehaviourMgr
     */
    public BehaviourMgr()
    {
        // initialise instance variables
        _behaviours = new ArrayList<IBehaviour>();
    }

    /**
     * Update all IBehaviours being managed, call on each pass through the update loop
     * 
     */
    public void update() throws ArgumentOutOfBoundsException
    {
        
        // Update all behaviours:
        for (IBehaviour b : _behaviours)
            b.update();

    }

    /**
     * Create a new behaviour, add it to the managed list, and return a reference to it.
     *
     * @param  rqdClass the implementation type of IBehaviour to be instantiated
     * @param  token   a reference to the token that the behaviour is for
     * @param  posn     a Double[3] that gives x,y,z coords of token
     * @param  angle    a Double[3] that gives orientation of token about x,y,z
     * 
     * @return true when new behaviour is successfully created.
     */
    public <T extends IBehaviour> IBehaviour createBehaviour(Class<T> rqdClass, IToken token, Double[] posn, Double[] angle) throws Exception
    {
        // CHECK parameters:
        if (token == null || posn == null || angle == null)
        {
            Exception e = new Exception();
            throw e;
        }
            
        // INSTANTIATE new Behaviour, call it 'newBehaviour':
        T newBehaviour = rqdClass.newInstance();
        
        // INITIALISE newBehaviour:
        newBehaviour.Initialise(token, posn, angle);
        
        // STORE newBehaviour in _behaviours:
        _behaviours.add(newBehaviour);
        
        // RETURN newBehaviour:
        return newBehaviour;
    }


}
