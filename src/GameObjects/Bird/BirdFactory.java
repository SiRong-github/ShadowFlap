/**
 * BirdFactory Class
 * Creates the Bird for each level
 */
package GameObjects.Bird;

public class BirdFactory {

    private static final BirdFactory _instance = new BirdFactory();

    private BirdFactory() {

    }

    /**
     * Gets the instance of the bird factory
     * @return bird factory instance
     */
    public static BirdFactory getInstance() {
        return _instance;
    }

    /**
     * Creates the bird type based on level
     * @param level level number
     * @return bird type
     * @throws IllegalArgumentException provided level number is out of the scope
     */
    public Bird getBird(int level) throws IllegalArgumentException {
        if (level == 0) {
            return new Bird0();
        } else {
            return new Bird1();
        }
    }

}
