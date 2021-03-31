package week05d05.senior;

import java.util.ArrayList;
import java.util.List;

public class PlayList {

    List<Song> songs;

    public PlayList(List<Song> songs) {
        this.songs = songs;
    }

    public List<Song> findByLengthGreaterThan(int mins) {
        List<Song> longSongs = new ArrayList<>();
        for(Song actualSong : songs) {
            if (actualSong.getLengthInSeconds() / 60 > mins) {
                longSongs.add(actualSong);
            }
        }
        return longSongs;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public String toString(List<Song> songList) {
        StringBuilder sb  = new StringBuilder();
        for (Song actualSong : songList) {
            if (sb.isEmpty()) {
                sb. append(actualSong);
            } else {
                sb.append(", ").append(actualSong);
            }

        }
        return sb.toString();
    }

}
