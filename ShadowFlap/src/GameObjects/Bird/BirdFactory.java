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
     * Gets the bird type based on level
     * @param level level number
     * @return bird type
     * @throws IllegalArgumentException provided level number is out of the scope
     */
    public Bird getBird(int level) throws IllegalArgumentException {
        return switch (level) {
            case 0 -> new Bird0();
            case 1 -> new Bird1();
            default -> throw new IllegalArgumentException();
        };
    }

}
