package Framework;




/**
 * The Renderable class provides all properties/behaviour to display a token in an Env3D simulation.
 * 
 * @author Marc Price 
 * @version 0.5
 */
public class Renderable implements IRenderable
{
    // Instance variables (fields):
    
    // --- DECLARE instance variables rqd by Env3D:
    // reference to the 3D model:
    private String model = "models/billboard/billboard.obj";
    
    // scale factor to be applied to model:
    private double scale=1.0;
    
    // reference to the image to be used as the texture-map (initialise to something sensible):
    private String texture = "textures/javaFish/JavaFish.png";

    // transparency flag - set to true:
    private boolean transparent=true;
    
    // position in to be placed at in 3D world (x,y,z coordinates):
    private double x=1.0, y=1.0, z=1.0;
    
    // orientation to be placed at in 3D world (about x,y,z):
    private double rotateX=90, rotateY=0, rotateZ=0;
    // --------------------------------------------- //
   

    /**
     * Default constructor for objects of class Renderable
     * 
     * All fields take on default values: token depicts a 'JavaFish', located at 1,1,1, facing left.
     */
    public Renderable()
    {
        // initialise instance variables
        // (all done in field declarations)
    }

    /**
     * Constructor for objects of class Renderable
     * 
     * User defines the image texture.  All other fields are set to default.
     * 
     * @param  tex   a String holding the path to the texture image file.
     */
    public Renderable(String tex)
    {
        // initialise instance variables
        // texture:
        texture = tex;        
    }

    /**
     * Constructor for objects of class Renderable
     * 
     * User defines the image texture and size.  All other fields are set to default.
     * 
     * @param  mod   a String holding the path to the texture image file.
     * @param  tex   a String holding the path to the texture image file.
     * @param  size  a double holding the scale of the object as a fraction (0.0 - 1.0).
     */
    public Renderable(String mod, String tex, double size)
    {
        // initialise instance variables
        // model:
        model = mod;
        
        // texture:
        texture = tex;
        
        // size:
        if ((scale > 0.0)&&(scale <= 1.0))
            scale = size;
        
    }

    /**
     * METHOD: Place the token at the given position within the aquarium
     *
     * @param  coords   the new position of the token as an array of three Doubles.  
     */
    public void position(Double ...coords)
    {
        // VALIDATE coords:
        // IF not null:
        if (coords != null)
        {
            // SET the new position:
            x = coords[0];
            y = coords[1];
            z = coords[2];
        }
    }
    
    /**
     * METHOD: Return the token's position within the aquarium
     *
     * @return   the position of the token as an array of three Doubles.
     */
    public Double[] position()
    {
        // LOAD return variable with position coords:
        Double[] coords = {x, y, z};
        return coords;
    }
    
    /**
     * METHOD: Place the token at the given orientation within the aquarium
     *
     * @param  coords   the new orientation (x,y,z) of the token as an array of three Doubles
     */
    public void orientation(Double ...coords)
    {
        // VALIDATE coords:
        // IF not null:
        if (coords != null)
        {
            // SET the new orientation:
            rotateX = coords[0];
            rotateY = coords[1];
            rotateZ = coords[2];
        }
    }
    
    /**
     * METHOD: Scale the token by the given multiplier
     *
     * @param  scale   the new scale of the token as a Double
     */
    public void scale(Double scale)
    {
        // SET the new scale:
        this.scale = scale;
    }


}
