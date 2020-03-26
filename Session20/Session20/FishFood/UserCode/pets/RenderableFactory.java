package UserCode.pets;


/**
 * RenderableFactory: a helper class to create displayable renderable.
 * 
 * @author Marc Price 
 * @version 0.5
 */
public class RenderableFactory implements IRenderableFactory
{
    // instance variables - none

    /**
     * Constructor for objects of class RenderableFactory
     */
    public RenderableFactory()
    {
        // do nothing
    }

    /**
     * Create and return new IRenderable instance.
     * 
     * @param   model    specifies the 3D model to be used
     * @param   texture  specifies the texture to be used
     * @param   posn    a Double[3] that gives the x,y,z location coords
     * @param   angle   a Double[3] that gives the orietnation about the x,y,z axes
     * @param   scale   a Double between 0.0 and 1.0 that specifies the size of the token
     * 
     * @return  the new IRenderable
     */
    public IRenderable create(String model, String texture, Double[] posn, Double[] angle, Double scale)
    throws Exception
    {
        // CHECK parameters:
        
        // CREATE and INITIALISE the renderable:
        IRenderable renderable = new Renderable(model, texture, scale);
        renderable.position(posn);
        renderable.orientation(angle);
            
        // RETURN the token
        return renderable;
    }
}

