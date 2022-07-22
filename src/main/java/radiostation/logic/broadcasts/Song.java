package radiostation.logic.broadcasts;

public class Song extends Broadcast {

    private final String artist;
    private final String title;

    public Song(String artist, String title, int durationSec) {
        super(durationSec);
        this.artist = artist;
        this.title = title;
    }

    @Override
    public int getCost() {
        return 0;
    }

    @Override
    public String toString() {
        return "Song{" +
                "artist='" + artist + '\'' +
                ", title='" + title + '\'' +
                ", durationSec=" + durationSec +
                '}';
    }

    @Override
    public boolean isPaid() {
        return false;
    }
}
