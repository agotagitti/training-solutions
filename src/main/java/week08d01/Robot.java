package week08d01;

public class Robot {

    private int x;
    private int y;

    public Robot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Robot move(String directions) {
        for (int i = 0; i < directions.length(); i++) {
           switch (directions.toUpperCase().charAt(i)) {
               case 'F':
                   y += 1;
                   break;
               case 'L':
                   y -= 1;
                   break;
               case 'J':
                   x += 1;
                   break;
               case 'B':
                   x -= 1;
                   break;
               default:
                   throw new IllegalArgumentException("Invalid direction!");
           }
        }
        return this;
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
