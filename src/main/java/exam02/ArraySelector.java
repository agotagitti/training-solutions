package exam02;

public class ArraySelector {

    public String selectEvens(int[] elements) {
        StringBuilder result = new StringBuilder("");
        if (elements.length != 0) {
            result.append("[");
        }
        for (int i = 0; i < elements.length; i += 2) {
            if (!result.toString().equals("[")) {
                result.append(", ");
            }
            result.append(elements[i]);
        }
        if (elements.length != 0) {
            result.append("]");
        }
        return result.toString();
    }

}
