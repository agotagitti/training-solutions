package math;

import java.util.Random;

public class Warrior {

    private String name;
    private int stamina;
    private double skill;

    private Point position;

    private Random rnd = new Random();

    public Warrior(String name, Point position) {
        this.name = name;
        this.position = position;
        stamina = rnd.nextInt(80) + 20;
        skill = rnd.nextDouble();
    }

    public Point getPosition() {
        return position;
    }

    public void move(Warrior gamer) {
        int x = position.getX();
        int y = position.getY();;
        if (position.getX() != gamer.getPosition().getX()) {
            if (position.getX() < gamer.getPosition().getX()) {
                x += 1;
            } else {
                x -= 1;
            }
        }
        if (position.getY() != gamer.getPosition().getY()) {
            if (position.getY() < gamer.getPosition().getY()) {
                y += 1;
            } else {
                y -= 1;
            }
        }
        if (position.getX() != x || position.getY() != y) {
            position = new Point(x, y);
        }
    }

    public void attack(Warrior enemy) {
        if (rnd.nextDouble() < skill) {
            enemy.stamina -= rnd.nextInt(3) + 1;
        }
    }

    public double distance(Warrior otherGamer) {
        return position.distance(otherGamer.position);
    }

    public boolean isAlive() {
        return stamina > 0;
    }

    public String toString() {
        return name + ": (" + position.getX() + ", " + position.getY() + ") " + stamina;
    }

}
