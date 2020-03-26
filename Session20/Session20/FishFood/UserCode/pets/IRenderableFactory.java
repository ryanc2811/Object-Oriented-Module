package UserCode.pets;


/**
 * IRenderableFactory: specifically to create Tokens.
 * 
 * @author Marc Price 
 * @version 0.5
 */
public interface IRenderableFactory
{
    /**
     * Create and return new IRenderable instance.
     * 
     * @param   model    specifies the 3D model to be used
     * @param   texture  specifies the texture to be used
     * @param   posn    a Double[3] that gives the x,y,z location coords
     * @param   angle   a Double[3] that gives the orietnation about the x,y,z axes
     */
    IRenderable create(String model, String texture, Double[] posn, Double[] angle, Double scale)
    throws Exception;
}
