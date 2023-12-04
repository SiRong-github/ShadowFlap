package GameObjects.PipeSet.PipeType;

public enum Gap {

    LOW_GAP(500),
    MID_GAP(300),
    HIGH_GAP(100);

    public static final int NUM = 3;
    public static final Gap[] TYPES = Gap.values();
    private final double value;

    Gap(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
