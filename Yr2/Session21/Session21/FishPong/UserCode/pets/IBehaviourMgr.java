package UserCode.pets;


/**
 * IBehaviourMgr: A manager of a set of IBehaviours
 * 
 * @author Marc Price 
 * @version 0.4
 */
public interface IBehaviourMgr
{
    /**
     * Update all IBehaviours being managed, call on each pass through the update loop
     * 
     */
    void update() throws ArgumentOutOfBoundsException;
    
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
    public <T extends IBehaviour> IBehaviour createBehaviour(Class<T> rqdClass, IToken token, Double[] posn, Double[] angle) throws Exception;
}

