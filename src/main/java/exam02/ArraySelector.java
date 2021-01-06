package exam02;

public class ArraySelector {

    public String selectEvens(int[] elements) {
        StringBuilder result = new StringBuilder("");
        for (int i = 0; i < elements.length; i += 2) {
            if (!result.isEmpty()) {
                result.append(", ");
            }
            result.append(elements[i]);
        }
        return elements.length == 0 ? "" : "[" + result.toString() + "]";
    }

}
