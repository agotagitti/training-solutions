package week03d02;

import java.util.ArrayList;
import java.util.List;

public class Position {

    private String name;
    private int bonus;

    public Position(String name, int bonus) {
        this.name = name;
        this.bonus = bonus;
    }

    public String getName() {
        return name;
    }

    public int getBonus() {
        return bonus;
    }

    @Override
    public String toString() {
        return "Position{" +
                "name='" + name + '\'' +
                ", bonus=" + bonus +
                '}';
    }



    public static void main(String[] args) {

        List<Position> positionList = new ArrayList<>();

        positionList.add(new Position("CEO", 160_000));
        positionList.add(new Position("CTO", 150_000));
        positionList.add(new Position("CO", 200_000));

        for (Position pos: positionList) {
            if (pos.getBonus() > 150_000) {
                System.out.println(pos);
            }
        }
    }

}
