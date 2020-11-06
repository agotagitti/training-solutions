package finalmodifier;

public class TaxCalculator {

    final static double VAT_PERCENT = 0.27;


    public double tax(double price) {
        return price * VAT_PERCENT;
    }

    public double priceWithTax(double price) {
        return price + (price * VAT_PERCENT);
    }

}
