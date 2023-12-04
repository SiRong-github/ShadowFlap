package GameObjects.Weapon;

import GameObjects.PipeSet.PipeType.PipeSetType;
import bagel.util.Point;

public class Bomb extends Weapon {

    private static final String PATH = "ShadowFlap/res/Level-1/bomb.png";
    private static final int SHOOTING_RANGE = 50;

    public Bomb(Point initPos) {
        super(PATH, SHOOTING_RANGE, PipeSetType.values(), initPos);
    }

}
