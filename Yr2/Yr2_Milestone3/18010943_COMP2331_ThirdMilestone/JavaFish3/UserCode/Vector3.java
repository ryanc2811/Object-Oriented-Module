 package UserCode;
/**
 * holds vectors such as position and orientation.
 * 
 * @author (Ryan Coles) 
 * @version (1.0)
 */
public class Vector3
{              
    // Members
    // Position in 3D world (x,y,z coordinates):
    private double x=0, y=0, z=0.1;
    // Constructors
    /**
     * Vector3 Constructor
     *
     */
    public Vector3() 
    {
        this.x = 0.0;
        this.y = 0.0;
        this.z = 0.1;
    } 
    /**
     * Vector3 Constructor
     *
     * @param x x value
     * @param y value
     * @param z value
     */
    public Vector3(double x, double y,double z) 
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    /**
     * Method setValue
     *
     * @param x value
     * @param y value
     * @param z value
     */
    public void setValue(double x,double y,double z)
    {
        this.x=x;
        this.y=y;
        this.z=z;
    }
    /**
     * Method getX
     *
     * @return x value
     */
    public double getX()
    {
        return x;
    }
    /**
     * Method getY
     *
     * @return y value
     */
    public double getY()
    {
       return y; 
    }
    /**
     * Method getZ
     *
     * @return z value
     */
    public double getZ()
    {
        return z;
    }
}