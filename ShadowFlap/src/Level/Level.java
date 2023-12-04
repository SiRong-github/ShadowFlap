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
        bg.draw(Window.MID_X.getValue(), Window.MID_Y.getValue());
        if (!hasStarted) {
            if (input.wasPressed(Keys.SPACE)) {
                hasStarted = true;
            } else {
                renderStartScreen();
            }
        } else {
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

    protected void updateLife() {
        for (HashMap.Entry<PipeSet, String> entry : pipeSets.entrySet()) {
            if (entry.getValue().equals("new")) {
                if (CollisionDetector.hasHit(bird.getBoundingBox(), entry.getKey().getBoundingBoxes())) {
                    entry.setValue("hit");
                    life--;
                    break;
                }
            }
        }

        if (bird.outOfBounds()) {
            life--;
            bird.reset();
        }

        if (life == 0) {
            hasLost = true;
        }

        LifeFactory.renderLife(life, maxLife);
    }

    protected void updateScore() {

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

        if (score == maxScore) {
            hasWon = true;
        }

        Message.printScore(score);
    }

    public boolean hasCompleted() {
        return hasCompleted;
    }

    protected void createGameObjects() {
        if (frame % PipeSet.SPAWN_FRAME == 0) {
            PipeSet pipe = PipeSetFactory.getInstance().getPipe(level);
            pipeSets.put(pipe, "new");
            newPipeSets.add(pipe);
        }
    }

    protected void updateGameObjects(Input input) {
        speed = Timescale.getSpeed(input);
        bird.update(input);
        itrP = pipeSets.entrySet().iterator();
        while (itrP.hasNext()) {
            HashMap.Entry<PipeSet, String> entry = itrP.next();
            if (entry.getValue().equals("hit")) {
                newPipeSets.remove(entry.getKey());
                itrP.remove();
            } else {
                entry.getKey().update(speed);
            }
        }
    }

    protected void renderStartScreen() {
        Message.printMsgCentre(Message.START);
    }

    protected void renderWinScreen() {
        Message.printMsgCentre(Message.LEVEL_UP);
        if (winFrame == WIN_FRAME) {
            hasCompleted = true;
        }
        winFrame++;
    }

    protected void renderGameOverScreen() {
        Message.printMsgCentre(Message.GAME_OVER);
        Message.printFinalScore(score);
    }

    public int getScore() {
        return score;
    }

}
