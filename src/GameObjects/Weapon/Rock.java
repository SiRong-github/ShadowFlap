/**
 * Rock Class
 */
package GameObjects.Weapon;

import GameObjects.PipeSet.PipeType.PipeSetType;
import bagel.util.Point;

public class Rock extends Weapon {

    private static final String PATH = "res/Level-1/rock.png";
    private static final int SHOOTING_RANGE = 25;

    public Rock(Point initPos) {
        super(PATH, SHOOTING_RANGE, new PipeSetType[] {PipeSetType.values()[0]}, initPos);
    }

}
