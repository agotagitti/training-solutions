package abstractclass.gamecharacter;

public class BattleField {

    private int round;

    private boolean oneHit(Character attacker, Character defender) {
        if (attacker.isAlive() && defender.isAlive()) {
            attacker.primaryAttack(defender);
        }
        if (attacker.isAlive() && defender.isAlive()) {
            attacker.secondaryAttack(defender);
        }
        return attacker.isAlive() && defender.isAlive();
    }

    public Character fight(Character one, Character other) {
        while (one.isAlive() && other.isAlive()) {
            round++;
            if (oneHit(one, other)) {
                oneHit(other, one);
            }
        }
        return one.isAlive() ? one : other;
    }

    public int getRound() {
        return round;
    }
}
