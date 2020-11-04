package array;

public class ArrayHandler {

    public boolean contains(int[] source, int itemToFind) {
        boolean answer = false;

        for (int item: source) {
            if (item == itemToFind) {
                answer = true;
            }
        } return answer;
    }

    public int find(int[] source, int itemToFind) {
        int number = -1;

        for (int i = 0; i < source.length; i++) {
            if (source[i] == itemToFind) {
                number = i;
            }
        } return number;
    }

    public static void main(String[] args) {
        ArrayHandler arrayHandler = new ArrayHandler();

        int[] test = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.println(arrayHandler.contains(test, 5));
        System.out.println(arrayHandler.contains(test, 12));

        System.out.println(arrayHandler.find(test, 6));
        System.out.println(arrayHandler.find(test, 13));

    }
}
