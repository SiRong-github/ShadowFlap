/**
 * FlameSetFactory Class
 * Creates the flame set for each pipe set
 */
package GameObjects.PipeSet.FlameSet;

import GameObjects.PipeSet.PipeType.PipeSet;

public class FlameSetFactory {
    private static final FlameSetFactory _instance = new FlameSetFactory();
    private static final String PATH = "ShadowFlap/res/level-1/flame.png";
    private static final int FLAME_DIST = 10;

    FlameSetFactory() {

    }

    public static FlameSetFactory getInstance() {
        return _instance;
    }

    /**
     * Creates the flame set for a given pipe set
     * @param x x-position of the pipe set
     * @param gapPos gap position of the pipe set
     * @return created flame set
     */
    public FlameSet getFlameSet(double x, double gapPos) {
        double yTop = gapPos + FLAME_DIST;
        double yBot = gapPos + PipeSet.GAP - FLAME_DIST;
        return new FlameSet(PATH, x, yTop, yBot);
    }


}
