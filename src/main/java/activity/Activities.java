package activity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Activities {

    private List<Activity> activities;

    public Activities(List<Activity> activities) {
        this.activities = activities;
    }

    public void addActivities(Activity activity) {
        activities.add(activity);
    }

    public List<Report> distancesByTypes() {
        List<Report> reports = new ArrayList<>();

        double[] sum = new double[ActivityType.values().length];
        for (Activity actual: activities) {
            sum[actual.getType().ordinal()] += actual.getDistance();
        }
        for (ActivityType actual: ActivityType.values()) {
            reports.add(new Report(actual, sum[actual.ordinal()]));
        }
        return  reports;
    }

    public int numberOfTrackActivities() {
        int counter = 0;
        for (Activity actual: activities) {
            if (actual.getType().isTracked()) {
                counter++;
            }
        }
        return counter;
    }

    public int numberOfWithoutTrackActivities() {
        int counter = 0;
        for (Activity actual: activities) {
            if (!actual.getType().isTracked()) {
                counter++;
            }
        }
        return counter;
    }

}
