package arraylist;

import java.util.ArrayList;
import java.util.List;

public class Books {

    private List<String> titleList = new ArrayList<>();

    public void addString(String book) {
        titleList.add(book);
    }

    public List<String> findAllByPrefix(String prefix) {
        List<String> sameTitle = new ArrayList<>();
        for (String title: titleList) {
            if (title.startsWith(prefix)) {
                sameTitle.add(title);
            }
        }
        return sameTitle;
    }

    public void removeByPrefix(String prefix) {
        List<String> removeTitle = new ArrayList<>();
        for(String title: titleList) {
            if (title.startsWith(prefix)) {
                removeTitle.add(title);
            }
        }
        titleList.removeAll(removeTitle);
    }

    public List<String > getTitles() {
        return titleList;
    }

    public static void main(String[] args) {
        Books test = new Books();

        test.addString("The Hobbit");
        test.addString("It");
        test.addString("Pride and Prejudice");
        test.addString("The Martian");

        System.out.println(test.getTitles());

        System.out.println(test.findAllByPrefix("The"));

        System.out.println(test.getTitles());

        test.removeByPrefix("The");
        System.out.println(test.getTitles());

    }

}