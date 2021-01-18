package activity;

import java.util.ArrayList;
import java.util.List;

public class Track {

    private List<TrackPoint> trackPoints = new ArrayList<>();

    public void addTrackPoint(TrackPoint trackPoint) {
        trackPoints.add(trackPoint);
    }

    public Coordinate findMaximumCoordinate() {
        double maxLong = trackPoints.get(0).getCoordinate().getLongitude();
        double maxLat = trackPoints.get(0).getCoordinate().getLatitude();
        for (TrackPoint actual: trackPoints) {
            if (actual.getCoordinate().getLatitude() > maxLat) {
                maxLat = actual.getCoordinate().getLatitude();
            }
            if (actual.getCoordinate().getLongitude() > maxLong) {
                maxLong = actual.getCoordinate().getLongitude();
            }

        }
        return new Coordinate(maxLat, maxLong);
    }

    public Coordinate findMinimumCoordinate() {
        double minLong = trackPoints.get(0).getCoordinate().getLongitude();
        double minLat = trackPoints.get(0).getCoordinate().getLatitude();
        for (TrackPoint actual: trackPoints) {
            if (actual.getCoordinate().getLatitude() < minLat) {
                minLat = actual.getCoordinate().getLatitude();
            }
            if (actual.getCoordinate().getLongitude() < minLong) {
                minLong = actual.getCoordinate().getLongitude();
            }
        }
        return new Coordinate(minLat, minLong);
    }

    public double getDistance() {
        double sum = 0.0;
        for (int i = 0; i < trackPoints.size() - 1; i++) {
            sum += Math.abs(trackPoints.get(i).getDistanceFrom(trackPoints.get(i + 1)));
        }
        return sum;
    }

    public double getFullDecrease() {
        double sumDecrease = 0.0;
        for (int i = 0; i < trackPoints.size() - 1; i++) {
            if (trackPoints.get(i).getElevation() > trackPoints.get(i + 1).getElevation()) {
                sumDecrease += trackPoints.get(i).getElevation() - trackPoints.get(i + 1).getElevation();
            }
        }
        return  sumDecrease;
    }

    public double getFullElevation() {
        double sumElevation = 0.0;
        for (int i = 0; i < trackPoints.size() - 1; i++) {
            if (trackPoints.get(i).getElevation() < trackPoints.get(i + 1).getElevation()) {
                sumElevation += trackPoints.get(i + 1).getElevation() - trackPoints.get(i).getElevation();
            }
        }
        return sumElevation;
    }

    public double getRectangleArea() {
        return ((findMaximumCoordinate().getLatitude() - findMinimumCoordinate().getLatitude())
                * (findMaximumCoordinate().getLongitude() - findMinimumCoordinate().getLongitude()));
    }

    public List<TrackPoint> getTrackPoints() {
        return trackPoints;
    }
}
