package week03d05;

import operators.Operators;

public class Operation {

    private int leftValue;
    private int rightValue;

    public Operation(String toConvert) {
        //161+18
        leftValue = Integer.parseInt(toConvert.substring(0, toConvert.indexOf("+")).trim());
        rightValue = Integer.parseInt(toConvert.substring(toConvert.indexOf("+") + 1, toConvert.length()).trim());
    }

    public int getResult() {
        return getLeftValue() + getRightValue();
    }

    public int getLeftValue() {
        return leftValue;
    }

    public int getRightValue() {
        return rightValue;
    }
}
