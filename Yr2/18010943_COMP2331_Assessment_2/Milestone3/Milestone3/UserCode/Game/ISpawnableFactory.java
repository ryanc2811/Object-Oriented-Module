package UserCode.Game;
import Framework.Interfaces.IUpdatable;

/**
 * Write a description of interface ISpawnableFactory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface ISpawnableFactory
{
     <T extends ISpawnableFacade> IUpdatable create(String rqdClass);
}
