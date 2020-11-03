package introcontrol;

public class IntroControl {

    public int subtractTenIfGreaterThanTen(int number) {
        if (number > 10) {
            number -= 10;
        }
        return number;
    }

    public String describeNumber(int number) {
        String result;
        if (number == 0) {
            result = "zero";
        } else {
            result = "not zero";
        }
        return result;
    }

    public String greetingToJoe(String name) {
        String greeting="";
        if (name.equals("Joe")) {
            greeting = "Hello Joe";
        }
        return greeting;
    }

    public int calculateBonus(int sale){
        int bonus = 0;
        if (sale >= 1000000) {
            bonus = (int) (sale * 0.1);
        }
        return bonus;
    }

    public int calculateConsumption(int prev, int next) {
        int consumption;
        if (prev < next) {
            consumption = next - prev;
        } else { consumption = prev - next;
        }
        return consumption;
    }

    public void printNumbers(int max) {
        for (int i = 0; i <= max; i++) {
            System.out.println(i);
        }
    }

    public void printNumbersBetween(int min, int max) {
        for (int i = min + 1; i < max; i++) {
            System.out.println(i);
        }
    }

    public void printNumbersBetweenAnyDirection(int a, int b) {
        if (a > b) {
            for (int i = a - 1; i > b; i--) {
                System.out.println(i);
            }
        } else {
            for (int i = a + 1; i < b; i++) {
                System.out.println(i);
            }
        }
    }

    public void printOddNumbers(int max) {
        for (int i = 1; i <= max; i += 2) {
            System.out.println(i);
        }
    }

}
