package week15d03;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PostFinder {

    private List<Post> posts;

    public PostFinder(List<Post> posts) {
        this.posts = posts;
    }

    public List<Post> findPostsFor(String user) {
        List<Post> foundPosts = new ArrayList<>();
        for (Post actual : posts) {
            if (actual.getOwner().equals(user) && isBefore(actual.getPublishedAt())
            && isNotEmpty(actual.getTitle()) && isNotEmpty(actual.getContent())) {
                foundPosts.add(actual);
            }
        }
        return foundPosts;
    }

    private boolean isBefore(LocalDate published) {
        return published.isBefore(LocalDate.now());
    }

    private boolean isNotEmpty(String string) {
        return string != null && !string.isEmpty();
    }

}
