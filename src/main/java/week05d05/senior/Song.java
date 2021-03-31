package week05d05.senior;

public class Song {

    private String name;
    private long lengthInSeconds;
    private String artist;

    public Song(String name, long lengthInSeconds, String artist) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Invalid name");
        }
        if (artist == null || artist.isBlank()) {
            throw new IllegalArgumentException("Invalid artist");
        }
        if (lengthInSeconds <= 0) {
            throw new IllegalArgumentException("Invalid length");
        }
        this.name = name;
        this.lengthInSeconds = lengthInSeconds;
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "Song: " + name + ", " + lengthInSeconds +
                ", " + artist;
    }

    public String getName() {
        return name;
    }

    public long getLengthInSeconds() {
        return lengthInSeconds;
    }

    public String getArtist() {
        return artist;
    }
}
