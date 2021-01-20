package UserCode;


/**
 * Write a description of class Vector3 here.
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
    public Vector3() {
        this.x = 0.0;
        this.y = 0.0;
        this.z = 0.0;
    }
       
    public Vector3(double x, double y,double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public void setValue(double x,double y,double z){
        this.x=x;
        this.y=y;
        this.z=z;
    }
    public double getX()
    {
        return x;
    }
    public double getY()
    {
       return y; 
    }
    public double getZ()
    {
        return z;
    }
        
    
}