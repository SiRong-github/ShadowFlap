package GameObjects.Weapon;

import GameObjects.PipeSet.PipeType.Gap;
import Level.CollisionDetector;
import Randomiser.Randomiser;
import Window.Window;
import bagel.util.Point;
import bagel.util.Rectangle;

public class WeaponFactory {

    private static final WeaponFactory _instance = new WeaponFactory();

    private WeaponFactory() {

    }

    /**
     * Gets the instance of the weapon factory
     * @return weapon factory instance
     */
    public static WeaponFactory getInstance() {
        return _instance;
    }

    public Weapon getWeapon(Rectangle[] p) {
        String weapon = WeaponType.TYPES[Randomiser.getRandomInt(1, WeaponType.NUM)-1].toString();
        Point initPos = new Point (Window.RIGHT.getValue(),
                Randomiser.getRandomDouble(Gap.HIGH_GAP.getPosition(), Gap.LOW_GAP.getPosition()));
        if (weapon.equals("BOMB")) {
            return updatePos(new Bomb(initPos), p);
        } else {
            return updatePos(new Rock(initPos), p);
        }
    }

    public Weapon updatePos(Weapon w, Rectangle[] p) {
        if (p != null) {
            while (CollisionDetector.weaponHitPipe(w.getBoundingBox(), p)) {
                w.y = Randomiser.getRandomDouble(Gap.HIGH_GAP.getPosition(), Gap.LOW_GAP.getPosition());
            }
        }
        return w;
    }

}
