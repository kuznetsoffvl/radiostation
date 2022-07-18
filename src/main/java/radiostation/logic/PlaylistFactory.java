package radiostation.logic;

public class PlaylistFactory implements PlaylistFactoryDefault{

    private final BroadcastCollection broadcastCollection;

    private final int maxDurationSec;
    private Playlist playlist;


    public PlaylistFactory(BroadcastCollection broadcastCollection, int maxDurationSec) {
        this.broadcastCollection = broadcastCollection;
        this.maxDurationSec = maxDurationSec;
    }

    @Override
    public void createPlaylist() {
        playlist = new Playlist(broadcastCollection, maxDurationSec);
        playlist.createPlaylist();
    }

    public Playlist getPlaylist() {
        return playlist;
    }

}
