package introconstructors;

public class RestaurantMain {

    public static void main(String[] args) {

        Restaurant restaurant = new Restaurant("Food&Wine", 10);

        System.out.println("Restaurant: " + restaurant.getName());
        System.out.println("Capacity: " + restaurant.getCapacity());
        System.out.println("Menu: " + restaurant.getMenu());
    }
}
