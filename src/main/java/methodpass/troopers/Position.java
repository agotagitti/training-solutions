package methodpass.troopers;

public class Position {

    private final double posX;
    private final  double posY;

    public Position(double posX, double posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public double distanceFrom(Position position) {
        if (position == null) {
            throw new IllegalArgumentException("Position cannot be null");
        }
        return Math.sqrt(Math.pow(this.posX - position.posX, 2) + Math.pow(this.posY - position.posY, 2));
    }

    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }

}
