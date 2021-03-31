package week05d04.senior;

public class Product {

    private long price;
    private String currency;

    public Product(long price, String currency) {
        this.price = price;
        if (currency.equalsIgnoreCase("HUF") || currency.equalsIgnoreCase("USD")) {
            this.currency = currency;
        } else {
            throw new IllegalArgumentException("Invalid currency");
        }

    }

    public double convertPrice(String currency) {
        double convertedPrice = 0.0;
        if (this.currency.equalsIgnoreCase(currency)) {
            return price;
        } else if (currency.equalsIgnoreCase("HUF")) {
            convertedPrice = price * 300.0;
        } else if (currency.equalsIgnoreCase("USD")) {
            convertedPrice = price / 300.0;
        }
        return convertedPrice;
    }

    public long getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

}
