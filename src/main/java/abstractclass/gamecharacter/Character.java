package abstractclass.gamecharacter;

import java.util.Random;

public abstract class Character {

    private Point position;
    private int hitPoint = 100;
    private Random random;

    public Character(Point position, Random random) {
        this.position = position;
        this.random = random;
    }

    protected int getActualPrimaryDamage() {
        return getRandom().nextInt(10) + 1;
    }

    private int getActualDefence() {
        return getRandom().nextInt(5) + 1;
    }

    protected void hit(Character enemy, int damage) {
        if (enemy.getActualDefence() < damage) {
            enemy.decreaseHitPoint(damage);
        }
    }

    public void primaryAttack(Character enemy) {
        hit(enemy, getActualPrimaryDamage());
    }

    abstract public void secondaryAttack(Character enemy);

    private void decreaseHitPoint(int diff) {
        hitPoint -= diff;
    }

    public boolean isAlive() {
        return hitPoint > 0;
    }

    public Point getPosition() {
        return position;
    }

    public int getHitPoint() {
        return hitPoint;
    }

    public Random getRandom() {
        return random;
    }
}
