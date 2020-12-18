package abstractclass.gamecharacter;

public class Point {

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public long distance(Point anotherPoint) {
        return (long) Math.sqrt(Math.pow(anotherPoint.getX() - (double) x, 2) +
                Math.pow(anotherPoint.getY() - (double) y, 2));
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
