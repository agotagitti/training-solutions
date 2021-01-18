package week12d01;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GradeRounderTest {

    @Test
    void roundGrades() {
        GradeRounder gradeRounder = new GradeRounder();
        int[] numbers = {1, 25, 40, 75, 80, 81, 82, 83, 84, 89};

        assertEquals("[1, 25, 40, 75, 80, 81, 82, 85, 85, 90]", Arrays.toString(gradeRounder.roundGrades(numbers)));
    }
}