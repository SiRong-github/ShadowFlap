package GameObjects.PipeSet.FlameSet;

import GameObjects.PipeSet.PipeType.PipeSet;
import bagel.util.Point;

public class FlameSetFactory {
    private static final FlameSetFactory _instance = new FlameSetFactory();
    private static final String PATH = "ShadowFlap/res/level-1/flame.png";
    private static final int FLAME_DIST = 10; // distance of flames from pipes

    FlameSetFactory() {

    }

    public static FlameSetFactory getInstance() {
        return _instance;
    }

    public FlameSet getFlameSet(double x, double gapPos) {
        double yTop = gapPos + FLAME_DIST;
        double yBot = gapPos + PipeSet.GAP - FLAME_DIST;
        return new FlameSet(PATH, x, yTop, yBot);
    }


}
