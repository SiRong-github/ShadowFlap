/**
 * Collision Detector Class
 * Used to detect whether a game object has collided with another game object
 */
package Level;
import bagel.util.Rectangle;

public class CollisionDetector {

    CollisionDetector() {

    }

    /**
     * Checks whether a given game object has collided with another game object
     * @param b1 Bounding box of the first game object
     * @param b2 Bounding box of the second game object
     * @return true if b1 has collided with b2, false otherwise
     */
    public static boolean hasCollided(Rectangle b1, Rectangle b2) {
        return b1.intersects(b2);
    }

    /**
     * Checks whether a given game object has collided with a set of game objects
     * @param b1 Bounding box of the first game object
     * @param bs Bounding boxes of the second game object (specifically the pipe set)
     * @return true if b1 has collided with any element of bs, false otherwise
     */
    public static boolean hasCollided(Rectangle b1, Rectangle[] bs) {
        for (Rectangle b2 : bs) {
            if (hasCollided(b1, b2)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks whether a weapon has collided with a pipe set
     * @param b1 Bounding box of the weapon
     * @param bs Bounding boxes of the pipe set
     * @return true if b1 has collided with any of the pipe sets (not the flame set, if it exists),
     *          false otherwise
     */
    public static boolean weaponHitPipe(Rectangle b1, Rectangle[] bs) {
        Rectangle[] pipe = new Rectangle[] {bs[0], bs[1]};
        return hasCollided(b1, pipe);
    }

    /**
     * Checks whether a game object (particularly the bird) has passed another game object (particularly the pipe set)
     * @param b1 Bounding box of the weapon
     * @param b2 Top bounding box of the pipe set (this is sufficient as both pipes in the set have the same x position)
     * @return true if b1 has passed b2, false otherwise
     */
    public static boolean hasPassed(Rectangle b1, Rectangle b2) {
        return b1.topLeft().x > b2.bottomRight().x;
    }
}
