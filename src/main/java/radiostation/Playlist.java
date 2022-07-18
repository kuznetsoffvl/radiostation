package radiostation;

import java.util.ArrayList;
import java.util.List;

public class Playlist implements PlaylistFactoryDefault{
    private List<Broadcast> playList;

    private BroadcastCollection broadcastCollection;

    private int maxDurationSec = 0;
    private int totalDurationSec = 0;
    private int maxPaidDurationSec = 0;
    private int totalPaidDurationSec = 0;
    //private int cost;

    private static final double PAID_PROPORTION = 0.5;

    public Playlist(BroadcastCollection broadcastCollection, int maxDurationSec) {
        this.broadcastCollection = broadcastCollection;
        this.maxDurationSec = maxDurationSec;
        this.maxPaidDurationSec = (int) Math.floor(maxDurationSec * PAID_PROPORTION);
        System.out.println("this.maxDurationSec = " + this.maxDurationSec);
        System.out.println("this.maxPaidDurationSec = " + this.maxPaidDurationSec);
    }

    @Override
    public void createPlaylist() {

        playList = new BroadcastList<>(new ArrayList<>());

        while (totalDurationSec <= maxDurationSec) {

            Broadcast broadcast = broadcastCollection.nextBroadcast();
            boolean willAdd = false;
            int currDuration = (int) broadcast.getDurationSec();

            if (currDuration == 0)  {continue; }
            if (broadcast.isPaid()) {
                if (totalPaidDurationSec + currDuration <= maxPaidDurationSec) {
                    willAdd = true;
                }
            } else {
                willAdd = true;
            }

            if (willAdd) {
                playList.add(broadcast);
                //System.out.println("broadcast added: " + broadcast);
                totalDurationSec += currDuration;
                if (broadcast.isPaid()) {
                    totalPaidDurationSec += currDuration;
                }
            }
        }
    }

    public int getCost() {
        int _cost = 0;
        for (Broadcast broadcast : playList) {
            _cost+= broadcast.getCost();
        }
        return _cost;
    }

    public List<Broadcast> getPlayList() {
        return playList;
    }

    @Override
    public String toString() {
        return "Playlist{" +
                //", broadcastCollection=" + broadcastCollection +
                ", maxDurationSec=" + maxDurationSec +
                ", totalDurationSec=" + totalDurationSec +
                ", maxPaidDurationSec=" + maxPaidDurationSec +
                ", totalPaidDurationSec=" + totalPaidDurationSec +
                ", cost=" + getCost() +
                ", playList=" + playList +
                '}';
    }
}