package GameObjects.PipeSet.PipeType;

import Window.Window;
import GameObjects.GameObject;
import bagel.DrawOptions;
import bagel.Image;
import bagel.util.Point;
import bagel.util.Rectangle;

public abstract class PipeSet implements GameObject {

    public static final int SPAWN_FRAME = 100;
    public static final int GAP = 168;
    public static final DrawOptions ROTATE = new DrawOptions().setRotation(Math.toRadians(180));
    protected Image image;
    protected double x;
    protected final double YTop;
    protected final double YBot;
    protected int frame;
    protected PipeSetType type;

    public PipeSet(PipeSetType type, String imagePath, double gapPos) {
        this.type = type;
        this.image = new Image(imagePath);
        x = Window.RIGHT.getValue() + image.getWidth()/2;
        YTop = gapPos - image.getHeight()/2;
        YBot = gapPos + GAP + image.getHeight()/2;
        frame = 0;
    }

    @Override
    public void update(double speed) {
        x -= speed;
        render();
    }

    @Override
    public void render() {
        image.draw(x, YTop);
        image.draw(x, YBot, ROTATE);
    }

    @Override
    public Rectangle getBoundingBox() {
        return image.getBoundingBoxAt(new Point(x, YTop));
    }

    public Rectangle[] getBoundingBoxes() {
        return new Rectangle[] {getBoundingBox(), image.getBoundingBoxAt(new Point(x, YBot))};
    }

    @Override
    public boolean outOfBounds() {
        return x <= Window.LEFT.getValue();
    }

    public int getSpawnFrame() {
        return SPAWN_FRAME;
    }

    public PipeSetType getType() {
        return type;
    }

}
