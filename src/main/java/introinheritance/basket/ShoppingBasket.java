package introinheritance.basket;

public class ShoppingBasket {

    private Basket basket;

    public ShoppingBasket() {
        this.basket = new Basket();
    }

    public void addItem(Item item) {
        basket.addItem(item);
    }

    public void removeItem(String barcode) {
        basket.removeItem(barcode);
    }

    public double sumNettoPrice() {
        double sum = 0.0;
        for (Item actual: basket.getItems()) {
            sum += actual.getNettoPrice();
        }
        return sum;
    }

    public double sumTaxValue() {
        double sum = 0.0;
        for (Item actual: basket.getItems()) {
            sum += actual.getTaxAmount();
        }
        return sum;
    }

    public double sumBruttoPrice() {
        return sumNettoPrice() + sumTaxValue();
    }

    public void checkout(){
        basket.clearBasket();
    }

    public void removeMostExpensiveItem() {

        double mostExp = 0.0;
        String toRemove = "";
        for(Item actual: basket.getItems()) {
            if (actual.getNettoPrice() > mostExp) {
                toRemove = actual.getBarcode();
            }
        }
        basket.removeItem(toRemove);
    }

}
