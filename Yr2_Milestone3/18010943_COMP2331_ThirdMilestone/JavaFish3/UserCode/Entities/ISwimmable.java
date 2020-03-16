package UserCode.Entities;
import UserCode.Behaviours.*;
/**
 * Class for all entities that can swim
 * 
 * @author (Ryan Coles) 
 * @version (1.0)
 */
public interface ISwimmable
{
     /**
     * Method receiveJob
     *
     * @param behaviour receive the behaviour related to this object
     */
    void receiveJob(IFishBehaviour behaviour);
}
