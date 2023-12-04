/**
 * Message Enum
 */
package Message;

import bagel.Font;
import bagel.Window;
import bagel.util.Point;

public enum Message {

    START("PRESS SPACE TO START"),
    LEVEL_UP("LEVEL-UP!"),
    SCORE("SCORE: "),
    GAME_OVER("GAME OVER"),
    FINAL_SCORE("FINAL SCORE: "),
    SHOOT("PRESS 'S' TO SHOOT"),
    CONGRATS("CONGRATULATIONS");

    private static final Point SCORE_POS = new Point(100,100);
    private static final Font FONT = new Font("ShadowFlap/res/font/slkscr.ttf", 48);
    private static final Point CENTRE = new Point(Window.getWidth(), Window.getHeight());
    private static final double SHOOT_SPACE = 68;
    private static final double FINAL_SCORE_SPACE = 75;
    private final String message;

    Message(final String message) {
        this.message = message;
    }

    /**
     * Prints message at centre of screen
     * @param message Message
     */
    public static void printMsgCentre(Message message) {
        FONT.drawString(message.toString(), (CENTRE.x - FONT.getWidth(message.toString()))/2, CENTRE.y/2);
    }

    /**
     * Prints message below the centre of the screen based on the given spacing
     * @param message Message
     * @param spacing double
     */
    public static void printMsgBelowCentre(Message message, double spacing) {
        FONT.drawString(message.toString(), (CENTRE.x - FONT.getWidth(message.toString()))/2, CENTRE.y/2 + spacing);
    }

    /**
     * Prints the current score
     * @param score double
     */
    public static void printScore(int score) {
        FONT.drawString(SCORE.toString() + score,
                SCORE_POS.x,
                SCORE_POS.y);
    }

    /**
     * Prints final score
     * @param score final score
     */
    public static void printFinalScore(int score) {
        FONT.drawString(FINAL_SCORE.toString() + score,
                (CENTRE.x - FONT.getWidth(FINAL_SCORE.toString() + score))/2,
                CENTRE.y/2 + FINAL_SCORE_SPACE);
    }

    /**
     * Converts the message into string
     * @return String type of the message
     */
    public String toString() {
        return message;
    }

    /**
     * Gets the line spacing for the shoot message
     * @return double Line spacing
     */
    public static double getShootSpace() {
        return SHOOT_SPACE;
    }

}
