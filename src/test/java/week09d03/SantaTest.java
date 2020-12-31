package week09d03;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SantaTest {

    @Test
    public void testGetThroughChimneys() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Jane", 39));
        personList.add(new Person("John", 11));
        personList.add(new Person("Jill", 14));
        personList.add(new Person("Jill", 50));

        SantaClaus santaClaus = new SantaClaus(personList);

        santaClaus.getThroughChimneys();

        System.out.println(personList);


    }


}
