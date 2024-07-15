/**
 * LifeFactory Class
 */
package Level;

import bagel.Image;
import bagel.util.Point;

public class LifeFactory {
    private static final Image FULL_LIFE = new Image("res/level/fullLife.png");
    private static final Image NO_LIFE = new Image("res/level/noLife.png");
    private static final Point LIFE_BAR = new Point(100, 15);
    private static final int LIFE_SPACE = 50;

    LifeFactory() {

    }

    /**
     * Renders the number of hearts in a given level
     * @param currLife Current life of the player
     * @param maxLife Maximum life of the level
     */
    public static void renderLife(int currLife, int maxLife) {

        for (int i = 0; i < currLife; i++) {
            FULL_LIFE.drawFromTopLeft(LIFE_BAR.x + i * LIFE_SPACE, LIFE_BAR.y);
        }

        for (int i = currLife; i < maxLife; i++) {
            NO_LIFE.drawFromTopLeft(LIFE_BAR.x + i * LIFE_SPACE, LIFE_BAR.y);
        }

    }

}
