package statements;

import java.util.Scanner;

public class InvestmentMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Invested amount?");
        int amount = scanner.nextInt();
        System.out.println("Interest rate?");
        int intRate = scanner.nextInt();

        Investment investment = new Investment(amount, intRate);

        System.out.println("Invested amount: " + amount);
        System.out.println("Interest rate: " + intRate);
        System.out.println("Yield for 50 days: " + investment.getYield(50));
        System.out.println("Total amount withdrawn after 80 days: " + investment.close(80));
        System.out.println("Total amount withdrawn after 81 days: " + investment.close(81));

    }

}
