package UserCode.pets;


/**
 * Write a description of interface IBehaviourFactory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface IBehaviourFactory
{
    /**
     * Create a new behaviour, add it to the managed list, and return a reference to it.
     *
     * @param  rqdClass the implementation type of IBehaviour to be instantiated
     * @param  renderable   a reference to the renderable that the behaviour is for
     * @param  posn     a Double[3] that gives x,y,z coords of renderable
     * @param  angle    a Double[3] that gives orientation of renderable about x,y,z
     * 
     * @return true when new behaviour is successfully created.
     */
    public <T extends IBehaviour> IBehaviour create(Class<T> rqdClass, IRenderable renderable, Double[] posn, Double[] angle) throws Exception;
    
}
