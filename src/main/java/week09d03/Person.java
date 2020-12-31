package week09d03;

import java.util.Random;

public class Person {

    private String name;
    private int age;
    private Present present;
    private Random random = new Random();

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setPresent() {
        Present present = null;
        do {
            int rndNumber = random.nextInt(Present.values().length);
            if (Present.values()[rndNumber].getMaxGiftableAge() >= this.age) {
                present = Present.values()[rndNumber];
            }
        } while(present == null);
        this.present = present;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", present=" + present +
                '}';
    }

}