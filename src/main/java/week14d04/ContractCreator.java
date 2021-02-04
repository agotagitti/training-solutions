package week14d04;

import java.util.ArrayList;
import java.util.List;

public class ContractCreator {

    private Contract templateContract;

    public ContractCreator(String client, List<Integer> monthlyPrices) {
        templateContract = new Contract(client, monthlyPrices);
    }

    public Contract create(String name) {
        return new Contract(name, new ArrayList<>(templateContract.getMonthlyPrices()));
    }

    public static void main(String[] args) {
        ContractCreator contractCreator = new ContractCreator("John Doe", new ArrayList<>(List.of(1, 2, 3)));
        Contract contract1 = contractCreator.create("Jane Doe");
        Contract contract2 = contractCreator.create("Jill Doe");
        System.out.println(contract1);
        System.out.println(contract2);

        contract1.getMonthlyPrices().set(0, 4);
        System.out.println(contract1);
        System.out.println(contract2);

    }

}
