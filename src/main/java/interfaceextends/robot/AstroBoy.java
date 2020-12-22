package interfaceextends.robot;

import java.util.ArrayList;
import java.util.List;

public class AstroBoy implements FlyableRobot {

    private Point position;
    private int angle;
    private List<Point> path = new ArrayList<>();
    public final static long ALTITUDE = 5;

    public AstroBoy(Point position) {
        this.position = position;
    }

    public void walkTo(Point position) {
        moveTo(new Point(position.getX(), position.getY(), 0));
    }

    public void flyTo(Point position) {
        moveTo(new Point(position.getX(), position.getY(), getAltitude()));
    }

    @Override
    public void liftTo(long altitude) {
        position = new Point(position.getX(), position.getY(), altitude);
        path.add(position);
    }

    @Override
    public void moveTo(Point position) {
        path.add(position);
        this.position = position;
    }

    @Override
    public void fastMoveTo(Point position) {
        liftTo(ALTITUDE);
        flyTo(position);
        liftTo(0);
    }

    @Override
    public void rotate(int angle) {
        this.angle = angle;
    }

    @Override
    public List<Point> getPath() {
        return path;
    }

    public Point getPosition() {
        return position;
    }

    public int getAngle() {
        return angle;
    }

    public long getAltitude() {
        return position.getZ();
    }
}
