/**
 * Gap Enum
 * Indicates where the gap of the pipe set is located
 */
package GameObjects.PipeSet.PipeType;

public enum Gap {

    LOW_GAP(500),
    MID_GAP(300),
    HIGH_GAP(100);

    public static final int NUM = 3;
    public static final Gap[] TYPES = Gap.values();
    private final double position;

    Gap(double position) {
        this.position = position;
    }

    /**
     * Gets the position of the gap
     * @return position of the gap
     */
    public double getPosition() {
        return position;
    }
}
