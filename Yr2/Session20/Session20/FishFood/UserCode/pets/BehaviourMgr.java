package UserCode.pets;

import java.util.List;
import java.util.ArrayList;
/**
 * BehaviourMgr: implementation of IBehaviour - a manager of a set of IBehaviours.
 * 
 * @author Marc Price 
 * @version 0.4
 */
public class BehaviourMgr implements IBehaviourMgr
{
    // instance variables:
    // DECLARE a list that holds the behaviours, call it _behaviours:
    List<IBehaviour> _behaviours;

    /**
     * Constructor for objects of class BehaviourMgr
     */
    public BehaviourMgr()
    {
        // initialise instance variables
        _behaviours = new ArrayList<IBehaviour>();
    }

    /**
     * Update all IBehaviours being managed, call on each pass through the update loop
     * 
     */
    public void update()
    {
        
        // Update all behaviours:
        for (IBehaviour b : _behaviours)
            b.update();

    }

   public void AddBehaviour(IBehaviour behaviour)
   {
       _behaviours.add(behaviour);
   }
}
