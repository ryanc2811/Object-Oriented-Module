package UserCode.pets;


/**
 * The Renderable class provides all properties/behaviour to display a renderable in an Env3D simulation.
 * 
 * @author Marc Price 
 * @version 04012016
 */
public class Renderable implements IRenderable
{
    // Instance variables (fields):
    
    // --- DECLARE instance variables rqd by Env3D:
    // reference to the 3D model:
    private String model = "models/billboard/billboard.obj";
    
    // scale factor to be applied to model:
    private double scale=0.4;
    
    // reference to the image to be used as the texture-map (initialise to something sensible):
    private String texture = "textures/javaFish/JavaFish.png";

    // transparency flag - set to true:
    private boolean transparent=true;
    
    // position in to be placed at in 3D world (x,y,z coordinates):
    private double x=1.0, y=1.0, z=1.0;
    
    // orientation to be placed at in 3D world (about x,y,z):
    private double rotateX=90, rotateY=0, rotateZ=0;
    // --------------------------------------------- //
    
    // --- Public properties rqd for testing. NOT included in IRenderable, and minimalist javadoc:
    // METHOD: Return the position coordinates in an array of Doubles
    public Double[] position()
    {
        Double rtnVal[] = {x, y, z};
        return rtnVal;
    }
   
    // METHOD: Return the orientation coordinates in an array of Doubles
    public Double[] orientation()
    {
        Double rtnVal[] = {rotateX, rotateY, rotateZ};
        return rtnVal;        
    }
   

    /**
     * Default constructor for objects of class Token
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
    public Renderable(String mod, String tex, double size) throws ArgumentOutOfBoundsException
    {
        // initialise instance variables
        // model:
        model = mod;
        
        // texture:
        texture = tex;
        
        // size:
        if ((scale > 0.0)&&(scale <= 1.0))
            scale = size;
        else
        {
            throw new ArgumentOutOfBoundsException("size parameter must be within range: 0.0 < size < 1.0");
        }
        
    }

    /**
     * METHOD: Place the renderable at the given position within the aquarium
     *
     * @param  coords   the new position of the renderable as an array of three Doubles.  The element values must be 0.0 &lt value &lt 10.0.
     */
    public void position(Double ...coords) throws ArgumentOutOfBoundsException
    {
        // VALIDATE coords:
        // IF not null:
        if (coords != null)
        {
            // IF out of range:
            if ((coords[0] < 0.0)||(coords[0] > 10.0)||
                (coords[1] < 0.0)||(coords[1] > 10.0)||
                (coords[2] < 0.0)||(coords[2] > 10.0))
                throw new ArgumentOutOfBoundsException("coords[] values must be within range: 0.0 < value < 10.0");
            else
            {
                // SET the new position:
                x = coords[0];
                y = coords[1];
                z = coords[2];
            }
        }
    }
    
    /**
     * METHOD: Place the renderable at the given orientation within the aquarium
     *
     * @param  coords   the new orientation (x,y,z) of the renderable as an array of three Doubles
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


}
