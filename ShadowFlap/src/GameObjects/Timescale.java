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

    public static Timescale getInstance() {
        return _instance;
    }

    public static double getSpeed(Input k) {
        if (k.wasPressed(Keys.L) && timescale > minTimescale) {
            timescale--;
        }

        if (k.wasPressed(Keys.R) && timescale < maxTimescale) {
            timescale++;
        }

        return defaultSpeed + (timescale - 1) * speedChange;
    }

    public static double getDefaultSpeed() {
        return defaultSpeed;
    }

}
