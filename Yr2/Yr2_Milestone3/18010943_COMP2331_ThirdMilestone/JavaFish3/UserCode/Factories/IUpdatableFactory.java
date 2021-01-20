package UserCode.Factories;
import Framework.Interfaces.IUpdatable;
/**
 * Interface for the abstract factory that creates new IUpdatable objects.
 * 
 * @author (Marc Price) 
 * @version (1.0)
 */
public interface IUpdatableFactory
{
    /**
     * Create a new IUpdatable instance and return it.
     * 
     * @param rqdClass the implementation type of IUpdatable to be instantiated
     * @return the new IUpdatable instance
     */
    <T extends IUpdatable> IUpdatable create(Class<T> rqdClass) throws Exception;
}
