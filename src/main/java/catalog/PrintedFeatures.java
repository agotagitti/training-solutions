package catalog;

import java.util.List;

public class PrintedFeatures implements Feature {

    private List<String> authors;
    private int numberOfPages;
    private String title;


    public PrintedFeatures(String title, int numberOfPages, List<String> authors) {
        if (Validators.isBlank(title)) {
            throw new IllegalArgumentException("Empty title");
        } else if (numberOfPages < 1) {
            throw new IllegalArgumentException("Invalid number of pages!");
        } else if (Validators.isEmpty(authors)) {
            throw new IllegalArgumentException("Invalid list of authors!");
        }
        this.authors = authors;
        this.numberOfPages = numberOfPages;
        this.title = title;
    }

    @Override
    public List<String> getContributors() {
        return authors;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    @Override
    public String getTitle() {
        return title;
    }
}
