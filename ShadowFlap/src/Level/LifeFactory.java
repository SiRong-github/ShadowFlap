package Level;

import bagel.Image;
import bagel.util.Point;

public class LifeFactory {
    private static final Image FULL_LIFE = new Image("ShadowFlap/res/level/fullLife.png");
    private static final Image NO_LIFE = new Image("ShadowFlap/res/level/noLife.png");
    private static final Point LIFE_BAR = new Point(100, 15);
    private static final int LIFE_SPACE = 50;

    LifeFactory() {

    }

    public static void renderLife(int currLife, int maxLife) {

        for (int i = 0; i < currLife; i++) {
            FULL_LIFE.drawFromTopLeft(LIFE_BAR.x + i * LIFE_SPACE, LIFE_BAR.y);
        }

        for (int i = currLife; i < maxLife; i++) {
            NO_LIFE.drawFromTopLeft(LIFE_BAR.x + i * LIFE_SPACE, LIFE_BAR.y);
        }

    }

}
