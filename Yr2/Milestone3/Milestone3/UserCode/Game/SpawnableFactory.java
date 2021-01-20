package UserCode.Game;
import Framework.Interfaces.IUpdatable;

/**
 * Write a description of class SpawnableFactory here.
 * 
 * @author (Ryan Coles) 
 * @version (04/05/2020)
 */
public class SpawnableFactory implements ISpawnableFactory
{
    public <T extends ISpawnableFacade> IUpdatable create(String rqdClass)
    {
        // CREATE required ISpawnableFacade, call it newSpawnableFacade:
            IUpdatable newSpawnableFacade=null;
        try
        {
            
            
            if(rqdClass=="JavaFish")
            {
                newSpawnableFacade=new JavaFish();
            }
            if(rqdClass=="OrangeFish")
            {
                newSpawnableFacade=new OrangeFish();
            }
            if(rqdClass=="SeaHorse")
            {
                newSpawnableFacade=new SeaHorse();
            }
            if(rqdClass=="Urchin")
            {
                newSpawnableFacade=new Urchin();
            }           
            if(rqdClass=="Feeder")
            {
                newSpawnableFacade=new Feeder();
            }  
            
        }
        catch (Exception e)
        {
        }
        return newSpawnableFacade;
    }}
