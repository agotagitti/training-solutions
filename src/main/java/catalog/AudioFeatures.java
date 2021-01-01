package catalog;

import java.util.ArrayList;
import java.util.List;

public class AudioFeatures implements Feature {

    private final List<String> composer;
    private final int length;
    private final List<String> performers;
    private final String title;

    public AudioFeatures(String title, int length, List<String> performers) {
        if (Validators.isBlank(title)) {
            throw new IllegalArgumentException("Empty title");
        } else if (length < 1) {
            throw new IllegalArgumentException("Invalid length!");
        }
        this.title = title;
        this.length = length;
        this.performers = performers;
        this.composer = new ArrayList<>();
    }

    public AudioFeatures(String title, int length, List<String> performers, List<String> composer) {
        if (Validators.isBlank(title)) {
            throw new IllegalArgumentException("Empty title");
        } else if (length < 1) {
            throw new IllegalArgumentException("Invalid length!");
        }
        this.title = title;
        this.length = length;
        this.performers = performers;
        this.composer = composer;
    }

    @Override
    public List<String> getContributors() {
        List<String> sumList = new ArrayList<>();
        sumList.addAll(composer);
        sumList.addAll(performers);
        return sumList;
    }

    public int getLength() {
        return length;
    }

    @Override
    public String getTitle() {
        return title;
    }
}
