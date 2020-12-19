package interfacedefaultmethods.print;

public class ColoredPage {

    private final String content;
    private final String color;

    public ColoredPage(String content, String color) {
        this.content = content;
        this.color = color;
    }

    public String getContent() {
        return content;
    }

    public String getColor() {
        return color;
    }

}
