package methodpass.troopers;

import java.util.ArrayList;
import java.util.List;

public class HeadQuarter {

    private List<Trooper> troopers = new ArrayList<>();

    public void addTrooper(Trooper trooper) {
        if (isEmpty(trooper)) {
            throw new IllegalArgumentException("Argument cannot be null or empty");
        }
        troopers.add(trooper);
    }

    public void moveTrooperByName(String name, Position target) {
        if (isEmpty(name) || isEmpty(target)) {
            throw new IllegalArgumentException("Argument cannot be null or empty");
        }
        findTrooperByName(name).changePosition(target);
    }

    public void moveClosestTrooper(Position target) {
        if (isEmpty(target)) {
            throw new IllegalArgumentException("Argument cannot be null or empty");
        }
        findClosestTrooper(target).changePosition(target);
    }

    private Trooper findTrooperByName(String name) {
        Trooper foundTrooper = null;
        for (Trooper actual: troopers) {
            if (actual.getName().equals(name)) {
                foundTrooper = actual;
                break;
            }
        }
        return foundTrooper;
    }

    private Trooper findClosestTrooper(Position target) {
        Trooper closestTrooper = null;
        for (Trooper actual: troopers) {
            if (closestTrooper == null || actual.distanceFrom(target) < closestTrooper.distanceFrom(target)) {
                closestTrooper = actual;
            }
        }
        return closestTrooper;
    }

    private void moveTrooper(Trooper trooper, Position target) {
        trooper.changePosition(target);
    }

    public List<Trooper> getTroopers() {
        return troopers;
    }

    private boolean isEmpty(Trooper trooper) {
        if (trooper == null) {
            return true;
        }
        return false;
    }

    private boolean isEmpty(Position position) {
        if (position == null) {
            return true;
        }
        return false;
    }

    private boolean isEmpty(String string) {
        if (string == null || string.equals("")) {
            return true;
        }
        return false;
    }

}
