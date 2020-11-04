package week02;

public class Product {

    private String name;
    private String code;

    public Product(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public boolean areTheyEqual(Product p) {
        return name.equals(p.getName());
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public static void main(String[] args) {
        Product product1 = new Product("name1", "code1");
        Product product2 = new Product("name1", "code2");
        Product product3 = new Product("name2", "code3");

        System.out.println(product1.areTheyEqual(product2));
        System.out.println(product1.areTheyEqual(product3));

    }

}
