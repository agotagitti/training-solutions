package week05d05.senior;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayListTest {

    @Test
    void findByLengthGreaterThan() {

        List<Song> songList = List.of(
                new Song("A", 1230, "aa"),
                new Song("B", 7634, "bb"),
                new Song("C", 60, "cc")
        );
        PlayList playList = new PlayList(songList);
        assertEquals("Song: A, 1230, aa, Song: B, 7634, bb", playList.toString(playList.findByLengthGreaterThan(15)));
        assertEquals(2, playList.findByLengthGreaterThan(1).size());

    }
}