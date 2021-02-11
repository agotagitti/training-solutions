package week15d03;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PostFinderTest {

    @Test
    void findPostsFor() {
        List<Post> posts = new ArrayList<>();
        posts.add(new Post("Title1", LocalDate.of(2020, 01, 01), LocalDate.now(), "Content1", "Owner1"));
        posts.add(new Post("Title2", LocalDate.of(2020, 01, 01), LocalDate.now(), "Content2", "Owner2"));
        posts.add(new Post("Title3", LocalDate.of(2020, 01, 01), LocalDate.now(), "Content3", "Owner2"));
        posts.add(new Post("Title4", LocalDate.of(2020, 01, 01), LocalDate.now(), "Content4", "Owner3"));
        PostFinder postFinder = new PostFinder(posts);
        assertEquals(2, postFinder.findPostsFor("Owner2").size());
    }
}