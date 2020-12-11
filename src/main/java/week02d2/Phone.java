package week02d2;

import java.util.Scanner;

public class Phone {

    private String type;
    private int mem;

    public Phone(String type, int mem) {
        this.type = type;
        this.mem = mem;

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMem() {
        return mem;
    }

    public void setMem(int mem) {
        this.mem = mem;
    }

    public static void main(String[] args) {
        Scanner scanner1 = new Scanner(System.in);

        System.out.println("Phone 1 type: ");
        String type1 = scanner1.nextLine();
        System.out.println("Phone 1 memory: ");
        int mem1 = scanner1.nextInt();

        Phone phone1 = new Phone(type1, mem1);

        Scanner scanner2 = new Scanner(System.in);

        System.out.println("Phone 2 type: ");
        String type2 = scanner2.nextLine();
        System.out.println("Phone 2 memory: ");
        int mem2 = scanner2.nextInt();

        Phone phone2 = new Phone(type2, mem2);

        System.out.println("Phone 1: " + phone1.getType() + " " + phone1.getMem());
        System.out.println("Phone 2: " + phone2.getType() + " " + phone2.getMem());

    }
}
