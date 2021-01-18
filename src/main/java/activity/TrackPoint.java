package activity;

public class TrackPoint {

    private Coordinate coordinate;
    private double elevation;

    public TrackPoint(Coordinate coordinate, double elevation) {
        this.coordinate = coordinate;
        this.elevation = elevation;
    }

    public double getDistanceFrom(TrackPoint trackPoint) {
        final int radEarth = 6371;
        final double firstLatitude = coordinate.getLatitude();
        final double firstLongitude = coordinate.getLongitude();
        final double otherLatitude = trackPoint.coordinate.getLatitude();
        final double otherLongitude = trackPoint.coordinate.getLongitude();

        double latitudeDist = Math.toRadians(otherLatitude - firstLatitude);
        double longitudeDist = Math.toRadians(otherLongitude - firstLongitude);
        double a = Math.sin(latitudeDist / 2) * Math.sin(latitudeDist / 2)
                + Math.cos(Math.toRadians(firstLatitude)) * Math.cos(Math.toRadians(otherLatitude))
                * Math.sin(longitudeDist / 2) * Math.sin(longitudeDist / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = radEarth * c * 1000;

        double height = this.getElevation() - trackPoint.getElevation();
        distance = Math.pow(distance, 2) + Math.pow(height, 2);

        return  Math.sqrt(distance);
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public double getElevation() {
        return elevation;
    }
}
