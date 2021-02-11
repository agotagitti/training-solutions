package week15d03;

import java.util.ArrayList;
import java.util.List;

public class PostFinder {

    private List<Post> posts;

    public PostFinder(List<Post> posts) {
        this.posts = posts;
    }

    public List<Post> findPostsFor(String user) {
        List<Post> foundPosts = new ArrayList<>();
        for (Post actual: posts) {
            if (actual.getOwner().equals(user)) {
                foundPosts.add(actual);
            }
        }
        return foundPosts;
    }
}
