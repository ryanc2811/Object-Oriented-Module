package UserCode.Sound;
import env3d.EnvBasic;

/**
 * Write a description of class PlaySound here.
 *
 * @author (Ryan Coles)
 * @version (1.0)
 */
public class PlaySound implements ISound
{
    // instance variables - replace the example below with your ow
    /**
     * Constructor for objects of class PlaySound
     */
    public static void PlaySound(String sound)
    {
        EnvBasic soundPlayer=new EnvBasic();
        soundPlayer.soundLoad(sound);
        soundPlayer.soundPlay(sound);
        //soundPlayer.soundStop(sound);
    }

    
}
