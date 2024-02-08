import Level.Level;
import Level.LevelFactory;
import bagel.*;

import java.util.ArrayList;

public class ShadowFlap extends AbstractGame {
    private final int maxLevel;
    private final ArrayList<Level> levels;
    private Level currLevel;
    private int currLevelIndex;

    public ShadowFlap() {
        maxLevel = LevelFactory.MAX_LEVEL;
        levels = new ArrayList<>();
        addLevels();
    }

    /**
     * Adds the levels to the level array list
     */
    private void addLevels() {
        for (int i = 0; i < maxLevel + 1; i++) {
            levels.add(LevelFactory.getInstance().getLevel(i));
        }
        currLevel = levels.get(0);
        currLevelIndex = 0;
    }

    /**
     * The entry point for the program.
     */
    public static void main(String[] args) {
        ShadowFlap game = new ShadowFlap();
        game.run();
    }

    /**
     * Performs a state update and allows the game to exit when the escape key is pressed.
     * @param input Input
     */
    @Override
    public void update(Input input) {
        /* Runs each level of the game */
        if (currLevel.hasCompleted() && currLevelIndex != maxLevel) {
            currLevelIndex++;
            currLevel = levels.get(currLevelIndex);
        } else {
            currLevel.update(input);
        }
    }

}
