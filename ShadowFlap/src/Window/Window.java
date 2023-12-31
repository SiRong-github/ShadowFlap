/**
 * Window Enum
 * Positions in the screen
 */
package Window;
public enum Window {

    TOP(0),
    BOTTOM(bagel.Window.getHeight()),
    LEFT(0),
    RIGHT(bagel.Window.getWidth()),
    MID_X((double) bagel.Window.getWidth()/2),
    MID_Y((double) bagel.Window.getHeight()/2);

    private final double value;

    Window(double value) {
        this.value = value;
    }

    /**
     * Returns the point of the given window corner
     * @return point of window corner
     */
    public double getValue() {
        return value;
    }

}
