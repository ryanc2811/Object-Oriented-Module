package UserCode.fishpong;
import env3d.Env;
import UserCode.pets.*;
/**
 * Write a description of interface IGameInitialiser here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface IGameInitialiser
{
    void Initialise(Env World)throws Exception;
    IBehaviour GetPaddle();
}
