package week12d01;

public class GradeRounder {

    public int[] roundGrades(int[] grades) {
        int[] rounded = new int[grades.length];
        for(int i = 0; i < grades.length; i++) {
            if (grades[i] >= 40 && grades[i] % 5 >= 3) {
                rounded [i] = grades[i] + (5 - (grades[i] % 5));
            } else {
                rounded[i] = grades[i];
            }
        }
        return rounded;
    }

}
