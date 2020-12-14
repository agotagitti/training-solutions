package week08d01;

public class Robot2 {
    private int x;
    private int y;

    public Robot2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Robot2 move(String directions) {
        for (int i = 0; i < directions.length(); i++) {
            if (directions.toUpperCase().charAt(i) == 'F') {
                movingUp();
            } else if (directions.toUpperCase().charAt(i) == 'L') {
                movingDown();
            } else if (directions.toUpperCase().charAt(i) == 'J') {
                movingRight();
            } else if (directions.toUpperCase().charAt(i) == 'B') {
                movingLeft();
            } else {
                throw new IllegalArgumentException("Invalid direction!");
            }
        }
        return this;
    }

    private void movingUp() {
        y += 1;
    }

    private void movingDown() {
        y -= 1;
    }

    private void movingRight() {
        x += 1;
    }

    private void movingLeft() {
        x -= 1;
    }

    @Override
    public String toString() {
        return "New position: " +
                x + ", " + y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
