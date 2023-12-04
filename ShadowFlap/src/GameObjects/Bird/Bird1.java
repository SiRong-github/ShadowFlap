/**
 * Bird1 Class
 * Bird for Level1
 */
package GameObjects.Bird;

import bagel.Input;
import bagel.Keys;
import bagel.util.Point;

public class Bird1 extends Bird {

    private static final String PATH_UP = "ShadowFlap/res/level-1/birdWingUp.png";
    private static final String PATH_DOWN = "ShadowFlap/res/level-1/birdWingDown.png";
    private boolean hasShot;

    public Bird1() {
        super(PATH_UP, PATH_DOWN);
        hasShot = false;
    }

    @Override
    public void update(Input input) {
        super.update(input);
        hasShot = input.wasPressed(Keys.S);
    }

    /**
     * Indicates whether the player has pressed the S key
     * @return true if player has pressed the S key, false otherwise
     */
    public boolean hasShot() {
        return hasShot;
    }

    /**
     * Gets the position of the beak
     * @return Point beak position
     */
    public Point getBeakPos() {
        return new Point(getBoundingBox().right(), y);
    }

}
