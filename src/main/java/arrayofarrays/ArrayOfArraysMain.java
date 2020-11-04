package arrayofarrays;

public class ArrayOfArraysMain {

    public int[][] multiplicationTable(int size) {

        int[][] table = new int[size][size];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    table[i][j] = (i + 1) * (j + 1);
                }
            }
        return table;
    }


    public void printArrayOfArrays(int[][] a)  {

        for (int[] i : a) {
            for (int j: i) {
                if (j < 10) {
                    System.out.print("  ");
                }
                if (j < 100 && j > 9){
                    System.out.print(" ");
                }
                System.out.print(" " + j);
            }
            System.out.println();
        }

    }


    public int[][] triangularMatrix(int size) {

        int[][] table = new int[size][];
            for (int i = 0; i < size; i++) {
                table[i] = new int[i+1];
                for (int j = 0; j < i +1 ; j++) {
                    table[i][j] = i;
                }
            }
        return table;
    }

    public int[][] getValues() {

        int[][] months = new int[12][];
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int i = 0; i < months.length; i++) {
            months[i] = new int [daysInMonth[i]];
        }
        return months;
    }

    public static void main(String[] args) {
        ArrayOfArraysMain test = new ArrayOfArraysMain();

        int[][] numbers = {{1, 2}, {1, 2, 3, 4}, {1, 2, 3}, {1, 2, 3, 4, 5, 6}};
        int[][] numbers2 = {{1, 2, 3}, {10, 20, 30, 40}, {100, 200, 300, 400}};

        test.printArrayOfArrays(numbers);
        test.printArrayOfArrays(numbers2);

//        test.printArrayOfArrays(test.multiplicationTable(4));
//        test.printArrayOfArrays(test.triangularMatrix(4));
//        test.printArrayOfArrays(test.getValues());

    }

}
