package week08d03;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class StringListTest {

    @Test
    public void testStringListUnion() {
        List<String> list1 = Arrays.asList("a", "b", "c");
        List<String> list2 = Arrays.asList("a", "d", "e");

        StringList stringList = new StringList();

        System.out.println(stringList.stringListsUnion(list1, list2));
        System.out.println(stringList.stringListsUnion2(list1, list2));

    }

}
