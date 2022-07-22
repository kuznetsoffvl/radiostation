package radiostation.logic.broadcasts;

public class Repository {

    // Only static fields and methods should have been there,
    // but i want to use the SINGLETON pattern... :)
    private static Repository instance;
    private BroadcastList songs;
    private BroadcastList ads;
    private BroadcastList interviews;

    private Repository() {
        songs = new BroadcastList();
        songs.add( new Song("Beatles", "Yesterday", 300));
        songs.add( new Song("Scorpions", "Wild Child", 420));
        songs.add( new Song("Deep Purple", "Smoke on the water", 380));

        ads = new BroadcastList();
        ads.add(new Advertising("Lipton Tea", 20));
        ads.add(new Advertising("MacCoffee", 35));
        ads.add(new Advertising("Dove Soap", 27));

        interviews = new BroadcastList();
        interviews.add(new Interview("James Hetfield", 60*20));
        interviews.add(new Interview("Ozzy Osbourne", 60*35));
        interviews.add(new Interview("Bill Gates", 60*62));
    }

    public static Repository getInstance() {
        if (instance == null) {
            instance = new Repository();
        }
        return instance;
    }

    public BroadcastList getSongs() {
        return songs;
    }

    public BroadcastList getAds() {
        return ads;
    }

    public BroadcastList getInterviews() {
        return interviews;
    }
    public Broadcast nextSong(){
        return songs.getNext();
    }

    public Broadcast nextAd(){
        return ads.getNext();
    }

    public Broadcast nextInterview(){
        return interviews.getNext();
    }
}
