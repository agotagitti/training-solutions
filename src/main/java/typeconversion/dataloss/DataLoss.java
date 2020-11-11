package typeconversion.dataloss;

public class DataLoss {

    public static void dataLoss() {
        int count = 0;
        for (long i = 1; count < 3; i++) {
            float float1 = i;
            long long2 = (long) float1;
            if (i != long2) {
                System.out.println(i+ " : " + long2 + " : " + (i - long2));
                System.out.println(Long.toBinaryString(i));
                System.out.println(Long.toBinaryString(long2));
                count++;
            }
        }
    }

    public static void main(String[] args) {

        dataLoss();
    }
}
