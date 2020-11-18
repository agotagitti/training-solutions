package stringbuilder;

public enum Title {

    MR("Mr."), MS("Ms."), DR("Dr."), PROF("Prof.");

    private String titleDesc;

    Title(String titleDesc) {
        this.titleDesc = titleDesc;
    }

    public String getTitleDesc() {
        return titleDesc;
    }
}