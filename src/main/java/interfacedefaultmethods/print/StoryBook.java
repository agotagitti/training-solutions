package interfacedefaultmethods.print;

import java.util.ArrayList;
import java.util.List;

public class StoryBook implements Printable {

    private List<ColoredPage> coloredPageList = new ArrayList<>();


    @Override
    public int getLength() {
        return coloredPageList.size();
    }

    @Override
    public String getPage(int pageNumber) {
        return coloredPageList.get(pageNumber).getContent();
    }

    @Override
    public String getColor(int pageNumber) {
        return coloredPageList.get(pageNumber).getColor();
    }

    public void addPage(String content, String color) {
        coloredPageList.add(new ColoredPage(content, color));
    }

}
