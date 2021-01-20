package Framework.Interfaces;


/**
 * The IDisplayObject instance contains all the data for displaying something by an IWorld instance.
 * 
 * @author (Marc Price) 
 * @version 0.500
 */
public interface IDisplayObject
{
    /**
     * METHOD: set the position of the IDisplayObject along x,y,z axes
     * @param x double giving the new position along x axis.
     * @param y double giving the new position along y axis.
     * @param z double giving the new position along z axis.
     */
    void position(double x, double y, double z);
    
    /**
     * METHOD: set the orientation of the IDisplayObject about x,y,z axes
     * @param xo double giving the new orientation about x axis.
     * @param yo double giving the new orientation about y axis.
     * @param zo double giving the new orientation about z axis.
     */
    void orientation(double xo, double yo, double zo);

}
