package classsctructuremethods;

public class ClientMain {

    public static void main(String[] args) {
        Client client = new Client();
        client.setName("Jane Doe");
        client.setYear(1970);
        client.setAddress("1001 Budapest Huba utca 1.");
        System.out.println("Name: " + client.getName());
        System.out.println("Year of Birth: " + client.getYear());
        System.out.println("Address: " + client.getAddress());

        client.migrate("1001 Budapest Huba utca 33.");
        System.out.println("New Address: " + client.getAddress());
    }

}
