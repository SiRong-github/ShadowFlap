/**
 * Bird Abstract Class
 */
package GameObjects.Bird;

import Window.Window;
import GameObjects.GameObject;
import bagel.Image;
import bagel.Input;
import bagel.Keys;
import bagel.util.Point;
import bagel.util.Rectangle;

public abstract class Bird implements GameObject {

    protected final Point INIT_POS = new Point(200, 350);
    protected final int INIT_SPEED = 0;
    protected final double FLY = 6; // acceleration due to gravity
    protected final double G = 0.4; // acceleration due to gravity
    protected final int MAX_FALL = 10;
    protected Image birdUp;
    protected Image birdDown;
    protected int frame;
    protected final double X;
    protected double y;
    protected double yVelocity;

    public Bird(String imagePathUp, String imagePathDown) {
        this.birdUp = new Image(imagePathUp);
        this.birdDown = new Image(imagePathDown);
        frame = 0;
        X = INIT_POS.x;
        y = INIT_POS.y;
        yVelocity = INIT_SPEED;
    }

    /**
     * Updates the bird (player) state
     * @param input
     */
    public void update(Input input) {
        if (input.wasPressed(Keys.SPACE)) {
            yVelocity = -FLY;
            birdDown.draw(X, y);
        } else {
            yVelocity = Math.min(yVelocity + G, MAX_FALL);
            render();
        }
        y += yVelocity;
        frame++;
    }

    @Override
    public void update(double speed) {

    }

    /**
     * Resets the position of the bird
     */
    public void reset() {
        y = INIT_POS.y;
    }

    @Override
    public void render() {
        if (frame % 10 == 0) {
            birdUp.draw(X, y);
        } else {
            birdDown.draw(X, y);
        }
    }

    @Override
    public Rectangle getBoundingBox() {
        return birdUp.getBoundingBoxAt(new Point(X, y));
    }

    @Override
    public boolean outOfBounds() {
        return y <= Window.TOP.getValue() || y >= Window.BOTTOM.getValue();
    }

}
