package UserCode.pets;


/**
 * IBehaviourMgr: A manager of a set of IBehaviours
 * 
 * @author Marc Price 
 * @version 0.4
 */
public interface IBehaviourMgr
{
    /**
     * Update all IBehaviours being managed, call on each pass through the update loop
     * 
     */
    void update();
    
    public void AddBehaviour(IBehaviour behaviour);
}

