package classstructureintegrate;

import java.util.Scanner;

public class ProductMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Name of Product?");
        String name = scanner.nextLine();

        System.out.println("Price of Product?");
        int price = scanner.nextInt();

        System.out.println();

        Product product = new Product(name, price);

        System.out.println("Product: " + product.getName() + ", Price: " + product.getPrice());

        product.increasePrice(3);
        System.out.println("Product: " + product.getName() + ", New price: " + product.getPrice());

        product.decreasePrice(4);
        System.out.println("Product: " + product.getName() + ", Sale price: " + product.getPrice());
    }


}
