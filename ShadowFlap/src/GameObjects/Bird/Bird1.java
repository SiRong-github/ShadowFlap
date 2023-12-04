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

    public boolean hasShot() {
        return hasShot;
    }

    public Point getBeakPos() {
        return new Point(getBoundingBox().right(), y);
    }

}
