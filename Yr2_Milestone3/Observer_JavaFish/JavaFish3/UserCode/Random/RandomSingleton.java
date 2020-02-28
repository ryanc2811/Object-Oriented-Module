package UserCode.Random;
import java.util.Random;
public class RandomSingleton {
    private static RandomSingleton instance;
    private Random rnd;

    /**
     * RandomSingleton Constructor
     *
     */
    private RandomSingleton() {
        rnd = new Random();
    }

    /**
     * Method getInstance
     *
     * @return The return value
     */
    public static RandomSingleton getInstance() {
        if(instance == null) {
            instance = new RandomSingleton();
        }
        return instance;
    }

    /**
     * Method nextDouble
     *
     * @return The return value
     */
    public double nextDouble() {
         return rnd.nextDouble();
    }
}
