package introdate;

import java.time.LocalDate;
import java.time.LocalTime;

public class PerformanceTest {

    public static void main(String[] args) {

        Performance performance = new Performance("PMJ", LocalDate.of(2010,5,5), LocalTime.of(19,0), LocalTime.of(21,0));
        System.out.println(performance.getInfo());

    }
}
