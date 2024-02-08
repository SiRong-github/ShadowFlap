/**
 * Weapon Abstract Class
 */
package GameObjects.Weapon;

import Window.Window;
import GameObjects.GameObject;
import GameObjects.PipeSet.PipeType.PipeSetType;
import bagel.Image;
import bagel.util.Point;
import bagel.util.Rectangle;

public abstract class Weapon implements GameObject {
    public static final int SPAWN_FRAME = 125;
    protected static final double SHOOTING_SPEED = 5;
    protected Image image;
    protected double shootingRange;
    protected PipeSetType[] target;
    protected double x;
    protected double y;
    protected double shootingX;
    protected boolean isShot;
    protected int shootingFrame;

    Weapon(String imagePath, double shootingRange, PipeSetType[] target, Point initPos) {
        this.image = new Image(imagePath);
        this.shootingRange = shootingRange;
        this.target = target;
        this.x = initPos.x;
        this.y = initPos.y;
        isShot = false;
        shootingFrame = 0;
    }

    @Override
    public void update(double speed) {
        x -= speed;
        render();
    }

    /**
     * Updates the position of the weapon based on shooting speed
     */
    public void updateShot() {
        x += SHOOTING_SPEED;
        render();
        shootingFrame++;
    }

    /**
     * Updates the position based on the bird (player) position
     * @param bird Position of the bird
     */
    public void update(Point bird) {
        this.x = bird.x;
        this.y = bird.y;
        render();
    }

    @Override
    public void render() {
        image.draw(x, y);
    }

    @Override
    public Rectangle getBoundingBox() {
        return image.getBoundingBoxAt(new Point(x,y));
    }

    @Override
    public boolean outOfBounds() {
        if (isShot) {
            return shootingFrame == shootingRange;
        } else {
            return x < Window.LEFT.getValue();
        }

    }

    /**
     * Instantiates the shooting position and marks the weapon as shot
     * @param x Position the bird (player) has shot the weapon
     */
    public void isShot(double x) {
        this.shootingX = x;
        isShot = true;
    }

    /**
     * Gets the target type of the weapon
     * @return Array of pipe set type/s
     */
    public PipeSetType[] getTarget() {
        return target;
    }
}
