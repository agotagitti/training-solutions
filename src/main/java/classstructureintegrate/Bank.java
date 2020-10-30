package classstructureintegrate;

public class Bank {

    public static void main(String[] args) {
        BankAccount accountOne = new BankAccount("1111-2222-3333", "Jane Doe", 100000);
        BankAccount accountTwo = new BankAccount("2222-3333-4444", "John Doe", 150000);
        int amountToTransfer = 3500;

        System.out.println(accountOne.getInfo());
        System.out.println(accountTwo.getInfo());


        System.out.println("Transfer initiated: " + amountToTransfer + " Ft");

        accountOne.transfer(accountTwo, amountToTransfer);

        System.out.println(accountOne.getInfo());
        System.out.println(accountTwo.getInfo());

    }

}
