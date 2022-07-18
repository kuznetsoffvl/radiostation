package radiostation.logic;

import radiostation.patterns.NullBroadcast;

import java.util.List;

public class BroadcastCollection
        //implements IContainer
        //implements PlaylistFactory
{
    private final List<Song> songs; // = new BroadcastList<>(new ArrayList<>());
    private final List<Advertising> ads; // = new BroadcastList<>(new ArrayList<>());
    private final List<Interview> interviews; // = new BroadcastList<>(new ArrayList<>());

    //private List<Broadcast> playlist;

    private int cursor = 3; //0-song, 1-ad, 2-interview


    public BroadcastCollection(List<Song> songs, List<Advertising> ads, List<Interview> interviews) {
        this.songs = songs;
        this.ads = ads;
        this.interviews = interviews;
    }

    public Broadcast nextSong() {
        return (Broadcast) ((BroadcastList<?>) songs).getNext();
    }

    public Broadcast nextAd() {
        return (Broadcast) ((BroadcastList<?>) ads).getNext();
    }

    public Broadcast nextInterview() {
        return (Broadcast) ((BroadcastList<?>) interviews).getNext();
    }

    public Broadcast nextBroadcast(){
        Broadcast result
            = cursor % 3 == 0 ? nextSong()
            : cursor % 3 == 1 ? nextAd()
            : cursor % 3 == 2 ? nextInterview()
            : new NullBroadcast();

        cursor++;
        return result;
    }

    @Override
    public String toString() {
        return "BroadcastCollection{" +
                "songs=" + songs +
                ", ads=" + ads +
                ", interviews=" + interviews +
                //", playlist=" + playlist +
                ", cursor=" + cursor +
                '}';
    }

    //    public Song getNextSong(){
//        if (songsIndex >= songs.size()){
//            songsIndex = -1;
//        }
//        return songs.get(songsIndex++);
//    }
//
//    public Advertising getNextAd(){
//        if (adsIndex >= ads.size()){
//            adsIndex = -1;
//        }
//        return ads.get(adsIndex++);
//    }
//
//    public Interview getNextInterview(){
//        if (interviewIndex >= interviews.size()){
//            interviewIndex = -1;
//        }
//        return interviews.get(interviewIndex++);
//    }

//    @Override
//    public IIterator createSongsIterator() {
//        SongsIterator iterator = new SongsIterator();
//        return iterator;
//    }
//
//    @Override
//    public IIterator createAdsIterator() {
//        return null;
//    }
//
//    @Override
//    public IIterator createInterviewsIterator() {
//        return null;
//    }
//
//    private class SongsIterator implements IIterator{
//        private int index;
//
//        @Override
//        public boolean hasNext() {
//            if (index < songs.size() ) {
//                return true;
//            }
//            return false;
//        }
//
//        @Override
//        public Object next() {
//            if (!this.hasNext()){
//                index = -1; // to the top of the list
//            }
//            return songs.get(index++);
//        }
//
//    }
//
}
