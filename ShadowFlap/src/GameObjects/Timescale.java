/**
 * Timescale Class
 * Allows the player to control the speed of all game objects except for bird
 */
package GameObjects;

import bagel.Input;
import bagel.Keys;

public class Timescale {
    private static final Timescale _instance = new Timescale();
    private static final int minTimescale = 1;
    private static final int maxTimescale = 10;
    private static final double defaultSpeed = 5;
    private static final double speedChange = 0.5;
    private static int timescale;

    Timescale() {
        timescale = minTimescale;
    }

    /**
     * Gets the instance of the Timescale class
     * @return instance
     */
    public static Timescale getInstance() {
        return _instance;
    }

    /**
     * Gets the speed based on player input
     * @param k Player input
     * @return speed
     */
    public double getSpeed(Input k) {
        if (k.wasPressed(Keys.L) && timescale > minTimescale) {
            timescale--;
        }

        if (k.wasPressed(Keys.R) && timescale < maxTimescale) {
            timescale++;
        }

        return defaultSpeed + (timescale - 1) * speedChange;
    }

    /**
     * Gets the default speed
     * @return double Default speed
     */
    public static double getDefaultSpeed() {
        return defaultSpeed;
    }

}
