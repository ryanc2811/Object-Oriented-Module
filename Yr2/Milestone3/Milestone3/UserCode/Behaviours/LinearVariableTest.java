package UserCode.Behaviours;


import Framework.Interfaces.IUpdatable;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class LinearVariableTest.
 *
 * @author  Marc Price
 * @version 0.1
 * 
 * Test conditions:
 * 1) Check that update() increments the variable provided.
 * 2) Check that update() adheres to boundaries.
 */
public class LinearVariableTest
{
    /**
     * Default constructor for test class LinearVariableTest
     */
    public LinearVariableTest()
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
    
    /**
     * Test condition 1: Check normal functioning: that update() actually updates the variable provided.
     * We're going to try moving our variable between 0.0 and 10.0, with a speed of 1.0 and initial value of 5.0.
     *
     */
    @Test
    public void testCondOne()
    {
        // Instantiate LinearMovement, store it in move:
        ILinearVariable move = new LinearVariable();
        
        // CAST move to an IUpdatable and store it in update:
        IUpdatable update = (IUpdatable) move;
        
        // CAST move to an IVariable and store it in value:
        IVariable value = (IVariable) move;
        
        // Initialise move:
        move.initialise(5.0, 1.0, 0.0, 10.0);
        
        // Update:
        update.update();
        
        // GET the new value of move and store it in testVar:
        double testVar = value.value();
        
        // Check value of testVar (it should be 6.0):
        assertEquals("variable was not the correct value", 6.0, testVar, 0.05);
        
        // all done for now
        return;
    }
    
    /**
     * Test condition 2: Check normal functioning: that update() adheres to boundaries.  Upper boundary.
     * We're going to try different values for our variable with boundaries set to 0.0 and 10.0, with a speed of 1.0.
     *
     */
    @Test
    public void testCondTwo()
    {
        // Instantiate LinearMovement, store it in move:
        ILinearVariable move = new LinearVariable();
        
        // CAST move to an IUpdatable and store it in update:
        IUpdatable update = (IUpdatable) move;
        
        // CAST move to an IVariable and store it in value:
        IVariable value = (IVariable) move;
        
        // Initialise move, variable set to 1.0, step size set to 1.0, lower set to 0.0, upper set to 2.0:
        move.initialise(1.0, 1.0, 0.0, 2.0);
        
        // UPPER BOUNDARY:
        double testVar = 0.0;
        
        // Update twice to push variable over upper limit:
        update.update();
        update.update();
        
        // STORE new value in testVar:
        testVar = value.value();
    
        // Check value of testVar (it should be 1.0):
        assertEquals("test2 upper", 1.0, testVar, 0.05);

        // LOWER BOUNDARY:
        // Update twice again:
        update.update();
        update.update();
        
        // STORE new value in testVar:
        testVar = value.value();
        
        // Check value of testVar (it should now be 1.0):
        assertEquals("test2 lower", 1.0, testVar, 0.05);
        
        // all done for now
        return;
    }
}
