package UserCode.pets;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class RenderableTest, for testing Renderable.
 *
 * @author  Marc Price
 * @version 04012016
 * 
 * Test conditions:
 * 1: position(): values of coords[] get stored into relevant fields.
 * 2: position(): throws an exception when values of coords[] are out of range.
 * 3: position(): ignores coords if null.
 * 4: orientation(): values of coords[] get stored into relevant fields.
 * 5: orientation(): ignores coords if null.
 * 6: Construction: all fields are initialised as expected.
 * 7: Construction: throws exception when size parameter is out of range.
 */
public class RenderableTest
{
    // DECLARE a Renderable instance variable, call it _renderable
    private Renderable _renderable;
    
    /**
     * Default constructor for test class RenderableTest
     */
    public RenderableTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        _renderable = new Renderable();
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    // ------------------------------------------------------------------------------------------- //

    
    /**
     * METHOD: Test condition 1:
     * position(): values of coords[] get stored into relevant fields.
     *
     */
    @Test
    public void testCondition1() throws ArgumentOutOfBoundsException
    {
        // Check that position is changed as expected:
        Double[] expected = {5.0, 5.0, 1.0};
        _renderable.position(expected);
        Double actual[] = _renderable.position();
        assertEquals("x coordinate did not get set,", expected[0], actual[0], 0.01);
        assertEquals("y coordinate did not get set,", expected[1], actual[1], 0.01);
        assertEquals("z coordinate did not get set,", expected[2], actual[2], 0.01);
    }
    // ------------------------------------------------------------------------------------------- //

    
    /**
     * METHOD: Test condition 2:
     * position(): throws an exception when values of coords[] are out of range.
     *
     */
    @Test
    public void testCondition2()
    {
        Double[] coordinates = {5.0, -5.0, 1.0};
        boolean pass = false;
        
        // TEST if an ArgumentOutOfBoundsException is thrown when a value < 0.0:
        try
        {
            _renderable.position(coordinates);
        }
        catch(ArgumentOutOfBoundsException e)
        {
            pass = true;
        }
        
        // TEST if an ArgumentOutOfBoundsException is thrown when a value > 10.0:
        if (pass)
        {
            pass = false;
            coordinates[1] = 10.1;
            try
            {
                _renderable.position(coordinates);
            }
            catch(ArgumentOutOfBoundsException e)
            {
                pass = true;
            }
        }
        
        if (!pass)
            fail("ArgumentOutOfBoundsException was not thrown");
    }
    // ------------------------------------------------------------------------------------------- //

    
    /**
     * METHOD: Test condition 3:
     * position(): coords is ignored if null.
     *
     */
    @Test
    public void testCondition3() throws ArgumentOutOfBoundsException
    {
        Double[] coordinates = null;
        Double before[] = _renderable.position();
        _renderable.position(coordinates);
        Double after[] = _renderable.position();
        assertEquals("position array changed", before[0], after[0], 0.01);
        assertEquals("position array changed", before[1], after[1], 0.01);
        assertEquals("position array changed", before[2], after[2], 0.01);
    }
    // ------------------------------------------------------------------------------------------- //

    /**
     * METHOD: Test condition 4:
     * orientation(): values of coords[] get stored into relevant fields.
     *
     */
    @Test
    public void testCondition4()
    {
        Double[] angles = {75.0, 75.0, 71.0};
        _renderable.orientation(angles);
        Double testVal[] = _renderable.orientation();
        assertEquals("x angle did not get set,", angles[0], testVal[0], 2);
        assertEquals("y angle did not get set,", angles[1], testVal[1], 2);
        assertEquals("z angle did not get set,", angles[2], testVal[2], 2);
    }
    // ------------------------------------------------------------------------------------------- //

        /**
     * METHOD: Test condition 5:
     * orientation(): coords is ignored if null.
     *
     */
    @Test
    public void testCondition5()
    {
        Double[] coordinates = null;
        Double before[] = _renderable.orientation();
        _renderable.orientation(coordinates);
        Double after[] = _renderable.orientation();
        assertEquals("orientation array changed", before[0], after[0], 0.01);
        assertEquals("orientation array changed", before[1], after[1], 0.01);
        assertEquals("orientation array changed", before[2], after[2], 0.01);
    }
    // ------------------------------------------------------------------------------------------- //

    
}

