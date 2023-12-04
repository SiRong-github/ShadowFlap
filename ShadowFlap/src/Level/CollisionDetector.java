package Level;

import bagel.util.Rectangle;

public class CollisionDetector {

    CollisionDetector() {

    }

    public static boolean hasHit(Rectangle b1, Rectangle b2) {
        return b1.intersects(b2);
    }

    public static boolean hasHit(Rectangle b1, Rectangle[] bs) {
        for (Rectangle b2 : bs) {
            if (hasHit(b1, b2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean weaponHitPipe(Rectangle b1, Rectangle[] bs) {
        Rectangle[] pipe = new Rectangle[] {bs[0], bs[1]};
        return hasHit(b1, pipe);
    }

    public static boolean hasPassed(Rectangle b1, Rectangle b2) {
        return b1.topLeft().x > b2.bottomRight().x;
    }
}
