package UserCode.Behaviours;


import Framework.Interfaces.IUpdatable;
import UserCode.EventHandling.IEventListener;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class BistableTest.
 *
 * @author  Marc Price
 * @version 0.1
 * 
 * Test conditions:
 * 1) Check that update() does nothing when no event has occurred.
 * 2) Check that update() responds to event accordingly.
 */
public class BistableTest
{
    /**
     * Default constructor for test class BistableTest
     */
    public BistableTest()
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
     * Test condition 1: Check normal functioning: does nothing when update() called if no event has occurred.
     * 
     * Setting state0 = 0.0, State1 = 1.0.
     *
     */
    @Test
    public void testCondOne()
    {
        // Instantiate Bistable, store it in move:
        IBistable move = new Bistable();
        
        // CAST move to an IUpdatable and store it in update:
        IUpdatable update = (IUpdatable) move;
        
        // CAST move to an IVariable and store it in value:
        IVariable value = (IVariable) move;
        
        // Initialise move:
        move.initialise(0.0, 1.0);
        
        // Update:
        update.update();
        
        // STORE result in testVar:
        double testVar = value.value();
    
        // Check value of testVar (it should be 0.0):
        assertEquals("incorrect state (State0)", 0.0, testVar, 0.05);
        
        // all done for now
        return;
    }
    
    
    /**
     * Test condition 2: Check that update() responds to an event.
     * We're going to try setting an initialCounterValue to -1 - it should be ignored and default to zero.
     *
     */
    @Test
    public void testCondTwo()
    {
       // Instantiate Bistable, store it in move:
        IBistable move = new Bistable();
        
        // CAST move to an IUpdatable and store it in update:
        IUpdatable update = (IUpdatable) move;
        
        // CAST move to an IVariable and store it in value:
        IVariable value = (IVariable) move;
        
        // CAST move to an IEventListener and store it in event:
        IEventListener event = (IEventListener) move;
        
        // Initialise move:
        move.initialise(0.0, 1.0);
        
        // Fire an event changing state to 1:
        int data = 1;
        event.onEvent(data);
        
        // Update:
        update.update();
        
        // STORE result in testVar:
        double testVar = value.value();
    
        // Check value of testVar (it should be 1.0):
        assertEquals("incorrect state (State1)", 1.0, testVar, 0.05);
        
        // Check for a state transition back...
        // Fire an event changing state to 0:
        data = 0;
        event.onEvent(data);
        update.update();
        testVar = value.value();
        assertEquals("incorrect state (State1)", 0.0, testVar, 0.05);
        
        // all done for now
        return;
    }
}
