package GameObjects;

import bagel.util.Rectangle;

public interface GameObject {

    /**
     * Updates the game object based on each frame
     */
    void update(double speed);

    /**
     * Renders the game object on the screen
     */
    void render();

    /**
     * Gets the bounding box of the game object
     * @return bounding box
     */
    Rectangle getBoundingBox();

    boolean outOfBounds();

}
