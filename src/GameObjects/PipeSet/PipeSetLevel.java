package GameObjects.PipeSet;

import GameObjects.PipeSet.PipeType.Gap;
import GameObjects.PipeSet.PipeType.PipeSetType;
import Randomiser.Randomiser;

import static GameObjects.PipeSet.PipeType.Gap.*;
import static GameObjects.PipeSet.PipeType.Gap.HIGH_GAP;
import static GameObjects.PipeSet.PipeType.PipeSetType.NUM;

public class PipeSetLevel {

    public static double getPipeGap(int level) throws IllegalArgumentException {
        if (level == 0) {
            return TYPES[Randomiser.getRandomInt(1, Gap.NUM)-1].getPosition();
        } else {
            return Randomiser.getRandomDouble(HIGH_GAP.getPosition(), LOW_GAP.getPosition());
        }
    }

    public static PipeSetType getPipeType(int level) throws IllegalArgumentException {
        if (level == 0) {
            return PipeSetType.PLASTIC;
        } else {
            return PipeSetType.TYPES[Randomiser.getRandomInt(1, NUM)-1];
        }
    }

}
