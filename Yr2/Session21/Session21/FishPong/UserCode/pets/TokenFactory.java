package UserCode.pets;


/**
 * TokenFactory: a helper class to create displayable tokens.
 * 
 * @author Marc Price 
 * @version 0.5
 */
public class TokenFactory implements ITokenFactory
{
    // instance variables - none

    /**
     * Constructor for objects of class TokenFactory
     */
    public TokenFactory()
    {
        // do nothing
    }

    /**
     * Create and return new IToken instance.
     * 
     * @param   model    specifies the 3D model to be used
     * @param   texture  specifies the texture to be used
     * @param   posn    a Double[3] that gives the x,y,z location coords
     * @param   angle   a Double[3] that gives the orietnation about the x,y,z axes
     * @param   scale   a Double between 0.0 and 1.0 that specifies the size of the token
     * 
     * @return  the new IToken
     */
    public IToken createToken(String model, String texture, Double[] posn, Double[] angle, Double scale)
    throws Exception
    {
        // CHECK parameters:
        
        // CREATE and INITIALISE the token:
        IToken token = new Token(model, texture, scale);
        token.position(posn);
        token.orientation(angle);
            
        // RETURN the token
        return token;
    }
}

