package Framework;


/**
 * This is an aquarium-style 3D 'world'.
 * 
 * @author Marc Price 
 * @version 0.1
 */
class Aquarium
{
    private String textureTop;
    private String textureBottom; // = "textures/orangeFish/AquariumBackground.png";
    private String textureNorth = "textures/javaFish/AquariumBackground.png";
    private String textureSouth;
    private String textureEast; // = "textures/orangeFish/AquariumBackground.png";
    private String textureWest; // = "textures/orangeFish/AquariumBackground.png";
    
    private double width;
    private double height;
    private double depth;
    
    private double bgRed;
    private double bgGreen;
    private double bgBlue;
    
    /**
     * Constructor
     *
     * @param  x   width of type double
     * @param  y   height of type double
     * @param  z   depth of type double
     */
    public Aquarium(double x, double y, double z)
    {
        width = x;
        height = y;
        depth = z;
    }

}
