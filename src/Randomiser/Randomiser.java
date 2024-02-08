/**
 * Randomiser Class
 */
package Randomiser;
import java.util.concurrent.ThreadLocalRandom;

public class Randomiser {

    public Randomiser() {

    }

    /**
     * Gets random int from given min and max
     * @param min int
     * @param max int
     * @return random int
     */
    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    /**
     * Gets random double from given min and max
     * @param min int
     * @param max int
     * @return random double
     */
    public static double getRandomDouble(double min, double max) {
        return ThreadLocalRandom.current().nextDouble(min, max + 1);
    }
}
