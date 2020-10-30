package classstructureconstructors;

public class StoreMain {

    public static void main(String[] args) {
        Store bookStore = new Store("Books");
        Store mobileStore = new Store("Mobiles");

        bookStore.store(15);
        System.out.println(bookStore.getProduct() + ": " + bookStore.getStock());

        bookStore.dispatch(7);
        System.out.println(bookStore.getProduct() + ": " + bookStore.getStock());

        bookStore.store(3);
        bookStore.dispatch(40);

        System.out.println(bookStore.getProduct() + ": " + bookStore.getStock());

        mobileStore.store(3);
        System.out.println(mobileStore.getProduct() + ": " + mobileStore.getStock());

        mobileStore.store(4);
        mobileStore.dispatch(2);
        mobileStore.store(29);

        System.out.println(mobileStore.getProduct() + ": " + mobileStore.getStock());


    }

}
