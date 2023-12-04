package GameObjects.Weapon;

import Window.Window;
import GameObjects.GameObject;
import GameObjects.PipeSet.PipeType.PipeSetType;
import bagel.Image;
import bagel.util.Point;
import bagel.util.Rectangle;

public abstract class Weapon implements GameObject {
    public static final int SPAWN_FRAME = 125;
    private static final double SHOOTING_SPEED = 5;
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

    public void updateShot() {
        x += SHOOTING_SPEED;
        render();
        shootingFrame++;
    }

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

    public void isShot(double x) {
        this.shootingX = x;
        isShot = true;
    }

    public PipeSetType[] getTarget() {
        return target;
    }
}
