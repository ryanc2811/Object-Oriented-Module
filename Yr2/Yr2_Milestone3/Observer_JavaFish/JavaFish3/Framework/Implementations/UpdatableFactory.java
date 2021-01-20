package Framework.Implementations;
import Framework.Interfaces.*;

/**
 * Write a description of class UpdatableFactory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
