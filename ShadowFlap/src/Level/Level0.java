package Level;

public class Level0 extends Level {

    protected static final String BG_PATH = "ShadowFlap/res/level-0/background.png";
    protected static final int MAX_LIFE = 3;
    protected static final int MAX_SCORE = 10;

    public Level0() {
        super(0, BG_PATH, MAX_LIFE, MAX_SCORE);
    }

}
