package activity;

public enum ActivityType {

    BIKING(true),
    HIKING(true),
    RUNNING(true),
    BASKETBALL(false);

    private boolean tracked;

    ActivityType(boolean tracked) {
        this.tracked = tracked;
    }

    public boolean isTracked() {
        return tracked;
    }
}
