package Level;

public class LevelFactory {

    private static final LevelFactory _instance = new LevelFactory();
    public static final int MAX_LEVEL = 1;

    private LevelFactory() {

    }

    /**
     * Gets the instance of level factory
     * @return level factory instance
     */
    public static LevelFactory getInstance() {
        return _instance;
    }

    /**
     * Gets the level based on the level number
     * @param level level number
     * @return level
     * @throws IllegalArgumentException outside number of levels
     */
    public Level getLevel(int level) throws IllegalArgumentException {
        return switch (level) {
            case 0 -> new Level0();
            case 1 -> new Level1();
            default -> throw new IllegalArgumentException();
        };
    }

}
