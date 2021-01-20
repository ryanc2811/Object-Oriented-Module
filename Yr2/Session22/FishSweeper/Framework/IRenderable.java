package Framework;


/**
 * Write a description of interface IRenderable here.
 * 
 * @author (Ryan Coles) 
 * @version (03/04/2020)
 */
public interface IRenderable
{
    /**
     * METHOD: Place the token at the given position within the aquarium
     *
     * @param  coords   the new position of the token as an array of three Doubles.  
     */
    void position(Double ...coords);
    /**
     * METHOD: Return the token's position within the aquarium
     *
     * @return   the position of the token as an array of three Doubles.
     */
    Double[] position();
     /**
     * METHOD: Place the token at the given orientation within the aquarium
     *
     * @param  coords   the new orientation (x,y,z) of the token as an array of three Doubles
     */
    void orientation(Double ...coords);
    /**
     * METHOD: Scale the token by the given multiplier
     *
     * @param  scale   the new scale of the token as a Double
     */
    void scale(Double scale);
}
