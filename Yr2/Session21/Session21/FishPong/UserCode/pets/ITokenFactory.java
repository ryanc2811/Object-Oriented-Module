package UserCode.pets;


/**
 * ITokenFactory: specifically to create Tokens.
 * 
 * @author Marc Price 
 * @version 0.5
 */
public interface ITokenFactory
{
    /**
     * Create and return new IToken instance.
     * 
     * @param   model    specifies the 3D model to be used
     * @param   texture  specifies the texture to be used
     * @param   posn    a Double[3] that gives the x,y,z location coords
     * @param   angle   a Double[3] that gives the orietnation about the x,y,z axes
     */
    IToken createToken(String model, String texture, Double[] posn, Double[] angle, Double scale)
    throws Exception;
}
