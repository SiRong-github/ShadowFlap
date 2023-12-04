/**
 * FlameSet Class
 */
package GameObjects.PipeSet.FlameSet;

import GameObjects.GameObject;
import GameObjects.PipeSet.PipeType.PipeSet;
import bagel.Image;
import bagel.util.Point;
import bagel.util.Rectangle;

public class FlameSet implements GameObject {
    private static final int START_FRAME = 20;
    private static final int END_FRAME = 30;
    private int frame;
    private int flameRender;
    private int flameRendered;
    private final Image flame;
    private double x;
    private final double YTop;
    private final double YBot;
    private boolean isRendered;
    private Rectangle[] boundingBoxes;

    public FlameSet(String path, double x, double yTop, double yBot) {
        flame = new Image(path);
        this.x = x;
        this.YTop = yTop;
        this.YBot = yBot;
        frame = 0;
        flameRender = 0;
        flameRendered = 0;
        isRendered = false;
        boundingBoxes = null;
    }

    @Override
    public void update(double speed) {
        x -= speed;
        if (frame == flameRendered) {
            render();
            flameRender = 0;
            flameRendered += START_FRAME + END_FRAME;
        } else {
            if (flameRender <= END_FRAME) {
                render();
                flameRender++;
            } else {
                isRendered = false;
            }
        }
        frame++;
    }

    @Override
    public void render() {
        flame.draw(x, YTop);
        flame.draw(x, YBot, PipeSet.ROTATE);
        isRendered = true;
    }

    @Override
    public Rectangle getBoundingBox() {
        return null;
    }

    @Override
    public boolean outOfBounds() {
        return false;
    }

    /**
     * Gets the top and bottom bounding boxes of the flame set
     * @return Array of the bounding boxes
     */
    public Rectangle[] getBoundingBoxes() {
        boundingBoxes = new Rectangle[] {flame.getBoundingBoxAt(new Point(x, YTop)),
                flame.getBoundingBoxAt(new Point(x, YBot))};
        return boundingBoxes;
    }

    /**
     * Indicates whether the flame set is rendered
     * @return true if rendered, false otherwise
     */
    public boolean isRendered() {
        return isRendered;
    }
}
