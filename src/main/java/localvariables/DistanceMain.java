package localvariables;

public class DistanceMain {

    public static void main(String[] args) {
        Distance distance = new Distance(15.3, true);

        System.out.println(distance.getDistanceInKm());
        System.out.println(distance.isExact());

        int lengthInt = (int) distance.getDistanceInKm();

        System.out.println(lengthInt);



    }

}
