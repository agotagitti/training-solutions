package primitivetypes;

public class PrimitiveTypesMain {

    public static void main(String[] args) {
        PrimitiveTypes primitiveTypes = new PrimitiveTypes();

        System.out.println(primitiveTypes.toBinaryString(-5));
        System.out.println(Integer.toBinaryString(-5));

        System.out.println(new Integer(1) + new Integer(2));
    }
}
