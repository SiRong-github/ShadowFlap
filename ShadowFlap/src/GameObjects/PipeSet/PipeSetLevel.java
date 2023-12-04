package GameObjects.PipeSet;

import GameObjects.PipeSet.PipeType.Gap;
import GameObjects.PipeSet.PipeType.PipeSetType;
import Randomiser.Randomiser;

import static GameObjects.PipeSet.PipeType.Gap.*;
import static GameObjects.PipeSet.PipeType.Gap.HIGH_GAP;
import static GameObjects.PipeSet.PipeType.PipeSetType.NUM;

public class PipeSetLevel {

    public static double getPipeGap(int level) throws IllegalArgumentException {
        return switch (level) {
          case 0 -> TYPES[Randomiser.getRandomInt(1, Gap.NUM)-1].getValue();
          case 1 -> Randomiser.getRandomDouble(HIGH_GAP.getValue(), LOW_GAP.getValue());
          default -> throw new IllegalArgumentException();
        };
    }

    public static PipeSetType getPipeType(int level) throws IllegalArgumentException {
        return switch (level) {
            case 0 -> PipeSetType.PLASTIC;
            case 1 -> PipeSetType.TYPES[Randomiser.getRandomInt(1, NUM)-1];
            default -> throw new IllegalArgumentException();
        };
    }

}
