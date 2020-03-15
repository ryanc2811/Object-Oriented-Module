package UserCode.Factories;
import Framework.Interfaces.IUpdatable;
/**
 * Write a description of class UpdatableFactory here.
 * 
 * @author (Marc Price) 
 * @version (1.0)
 */
public class UpdatableFactory implements IUpdatableFactory
{
   public <T extends IUpdatable> IUpdatable create(Class<T> rqdClass) throws Exception
    {
        // INSTANTIATE new IUpdatable, call it 'newObject':
        IUpdatable newUpdatable = rqdClass.newInstance();
        
        // RETURN new IUpdatable:
        return newUpdatable;
    }
}
