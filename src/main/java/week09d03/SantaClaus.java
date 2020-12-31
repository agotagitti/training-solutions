package week09d03;

import java.util.ArrayList;
import java.util.List;

public class SantaClaus {

    private List<Person> personList = new ArrayList<>();

    public SantaClaus(List<Person> personList) {
        this.personList = personList;
    }

    public void getThroughChimneys() {
        for (Person actual: personList) {
            actual.setPresent();
        }
    }

}
