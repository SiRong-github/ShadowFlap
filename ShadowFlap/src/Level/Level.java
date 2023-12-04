/**
 * Level Abstract Class
 */
package Level;

import GameObjects.Bird.Bird;
import GameObjects.Bird.BirdFactory;
import GameObjects.PipeSet.PipeSetFactory;
import GameObjects.PipeSet.PipeType.PipeSet;
import GameObjects.Timescale;
import Message.Message;
import bagel.*;
import Window.Window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class Level {
    protected static final int WIN_FRAME = 150;
    protected int level;
    protected Image bg;
    protected Bird bird;
    protected int maxScore;
    protected int score;
    protected int maxLife;
    protected int life;
    protected int frame;
    protected int winFrame;
    protected boolean hasStarted;
    protected boolean hasWon;
    protected boolean hasLost;
    protected boolean hasCompleted;
    protected HashMap<PipeSet, String> pipeSets;
    protected List<PipeSet> newPipeSets;
    protected Iterator<HashMap.Entry<PipeSet, String>> itrP;
    protected Iterator<PipeSet> itrNP;
    protected double speed;

    Level(int level, String bgPath, int maxLife, int maxScore) {
        this.level = level;
        this.bg = new Image(bgPath);
        this.maxLife = maxLife;
        this.maxScore = maxScore;
        bird = BirdFactory.getInstance().getBird(level);
        hasStarted = false;
        hasWon = false;
        hasLost = false;
        hasCompleted = false;
        score = 0;
        life = maxLife;
        winFrame = 0;
        frame = 0;
        pipeSets = new HashMap<>();
        newPipeSets = new ArrayList<>();
        speed = Timescale.getDefaultSpeed();
    }

    /**
     * Updates each frame given player input
     * @param input player input
     */
    public void update(Input input) {
        /* Draws the background of the level */
        bg.draw(Window.MID_X.getValue(), Window.MID_Y.getValue());
        /* Checks whether the level has started */
        if (!hasStarted) {
            if (input.wasPressed(Keys.SPACE)) {
                hasStarted = true;
            } else {
                renderStartScreen();
            }
        } else {
            /* Checks level completion */
            if (hasWon) {
                renderWinScreen();
            } else if (hasLost) {
                renderGameOverScreen();
            } else {
                createGameObjects();
                updateGameObjects(input);
                updateLife();
                updateScore();
                frame++;
            }
        }
    }

    /**
     * Updates the player life
     */
    protected void updateLife() {

        /* Update based on whether player has collided with pipe set */
        for (HashMap.Entry<PipeSet, String> entry : pipeSets.entrySet()) {
            if (entry.getValue().equals("new")) {
                if (CollisionDetector.hasCollided(bird.getBoundingBox(), entry.getKey().getBoundingBoxes())) {
                    entry.setValue("hit");
                    life--;
                    break;
                }
            }
        }

        /* Update based on whether player is out of bounds */
        if (bird.outOfBounds()) {
            life--;
            bird.reset();
        }

        /* Update based on whether player has lost */
        if (life == 0) {
            hasLost = true;
        }

        LifeFactory.renderLife(life, maxLife);
    }

    /**
     * Updates player score
     */
    protected void updateScore() {

        /* Update based on whether player has passed a pipe set */
        itrNP = newPipeSets.iterator();
        while (itrNP.hasNext()) {
            PipeSet p = itrNP.next();
            if (CollisionDetector.hasPassed(bird.getBoundingBox(), p.getBoundingBox())) {
                pipeSets.replace(p, "passed");
                itrNP.remove();
                score++;
                break;
            }
        }

        /* Update based on whether player has won */
        if (score == maxScore) {
            hasWon = true;
        }

        Message.printScore(score);
    }

    /**
     * Indicates whether player has completed the level
     * @return true if player has completed the level, false otherwise
     */
    public boolean hasCompleted() {
        return hasCompleted;
    }

    /**
     * Creates game objects (specifically the pipe sets)
     */
    protected void createGameObjects() {
        if (frame % PipeSet.SPAWN_FRAME == 0) {
            PipeSet pipe = PipeSetFactory.getInstance().getPipe(level);
            pipeSets.put(pipe, "new");
            newPipeSets.add(pipe);
        }
    }

    /**
     * Updates the game objects
     * @param input Player input
     */
    protected void updateGameObjects(Input input) {
        /* Gets the speed of the game objects (pipe sets) based on player timescale control */
        speed = Timescale.getInstance().getSpeed(input);
        /* Updates bird */
        bird.update(input);
        itrP = pipeSets.entrySet().iterator();
        /* Updates each pipe set */
        while (itrP.hasNext()) {
            HashMap.Entry<PipeSet, String> entry = itrP.next();
            /* Removes pipe set if the player has collided with it, update otherwise */
            if (entry.getValue().equals("hit")) {
                newPipeSets.remove(entry.getKey());
                itrP.remove();
            } else {
                entry.getKey().update(speed);
            }
        }
    }

    /**
     * Renders start screen
     */
    protected void renderStartScreen() {
        Message.printMsgCentre(Message.START);
    }

    /**
     * Renders win screen
     */
    protected void renderWinScreen() {
        Message.printMsgCentre(Message.LEVEL_UP);
        if (winFrame == WIN_FRAME) {
            hasCompleted = true;
        }
        winFrame++;
    }

    /**
     * Renders game over screen
     */
    protected void renderGameOverScreen() {
        Message.printMsgCentre(Message.GAME_OVER);
        Message.printFinalScore(score);
    }

}
