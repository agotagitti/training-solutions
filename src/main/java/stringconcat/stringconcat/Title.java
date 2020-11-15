package stringconcat.stringconcat;

public enum Title {

    MR("Mr."), MS("Ms."), DR("Dr.");

    private String titleDesc;

    Title(String titleDesc) {
        this.titleDesc = titleDesc;
    }

    public String getTitleDesc() {
        return titleDesc;
    }
}
