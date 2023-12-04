package GameObjects.PipeSet.PipeType;

import GameObjects.PipeSet.FlameSet.FlameSet;
import GameObjects.PipeSet.FlameSet.FlameSetFactory;
import bagel.util.Rectangle;

public class SteelPipeSet extends PipeSet {

    private static final String PATH = "ShadowFlap/res/level-1/steelPipe.png";
    private final FlameSet flameSet;

    public SteelPipeSet(double gapPos) {
        super(PipeSetType.STEEL, PATH, gapPos);
        flameSet = FlameSetFactory.getInstance().getFlameSet(x, gapPos);
    }

    @Override
    public void update(double speed) {
        super.update(speed);
        flameSet.update(speed);
    }

    public Rectangle[] getBoundingBoxes() {
        if (flameSet.isRendered()) {
            return new Rectangle[] {getNoFlames()[0], getNoFlames()[1],
                    flameSet.getBoundingBoxes()[0], flameSet.getBoundingBoxes()[1]};
        } else {
            return getNoFlames();
        }
    }

    public Rectangle[] getNoFlames() {
        return new Rectangle[] {super.getBoundingBoxes()[0], super.getBoundingBoxes()[1]};
    }

}
