package radiostation.logic.broadcasts;

// Only static fields and methods should have been there,
// but I wanted to apply the SINGLETON pattern... :)
public class Repository //implements FreeContent, PaidContent
{
    private static Repository instance;
    private final BroadcastList songs;
    private final BroadcastList ads;
    private final BroadcastList interviews;

    private Repository() {
        songs = new BroadcastList();
        songs.add( new Song("Beatles", "Yesterday", 300));
        songs.add( new Song("Scorpions", "Wild Child", 280));
        songs.add( new Song("Deep Purple", "Smoke on the water", 290));
        songs.add( new Song("ABBA", "Happy New Year", 310));
        songs.add( new Song("Bon Jovi", "It's my life", 295));
        songs.add( new Song("Led Zeppelin", "Stairway To Heaven", 294));
        songs.add( new Song("Nazareth", "The Hair OF The Dog", 284));
        songs.add( new Song("Rainbow", "Stargazer", 326));

        ads = new BroadcastList();
        ads.add(new Advertising("Lipton Tea", 120));
        ads.add(new Advertising("MacCoffee", 135));
        ads.add(new Advertising("Dove Soap", 127));
        ads.add(new Advertising("Samsung TV", 125));
        ads.add(new Advertising("Renault cars", 131));
        ads.add(new Advertising("Victoria Secret", 123));

        interviews = new BroadcastList();
        interviews.add(new Interview("James Hetfield", 60*20));
        interviews.add(new Interview("Ozzy Osbourne", 60*35));
        interviews.add(new Interview("Bill Gates", 60*23));
        interviews.add(new Interview("Eric Clapton", 60*28));
        interviews.add(new Interview("Brian May ", 60*31));
        interviews.add(new Interview("Tony Iommi", 60*38));
        interviews.add(new Interview("Richard Blackmore", 60*18));
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

    public BroadcastList getNextSongs(int n) {
        BroadcastList broadcastList = new BroadcastList();
        for (int i = 1; i <= n; i++) {
            broadcastList.add(nextSong());
        }
        return broadcastList;
    }

    public BroadcastList getNextAds(int n) {
        BroadcastList broadcastList = new BroadcastList();
        for (int i = 1; i <= n; i++) {
            broadcastList.add(nextAd());
        }
        return broadcastList;
    }

    public BroadcastList getNextInterviews(int n) {
        BroadcastList broadcastList = new BroadcastList();
        for (int i = 1; i <= n; i++) {
            broadcastList.add(nextInterview());
        }
        return broadcastList;
    }

    public BroadcastList getSongsBlock(int durationSec) {
        return getBroadcastsByDuration(songs, durationSec);
    }

    public BroadcastList getAdsBlock(int durationSec) {
        return getBroadcastsByDuration(ads, durationSec);
    }

    public BroadcastList getInterviewsBlock(int durationSec) {
        return getBroadcastsByDuration(interviews, durationSec);
    }

    public BroadcastList getBroadcastsByDuration(BroadcastList source, int durationSec){
        BroadcastList destination = new BroadcastList();

        while (destination.getTotalDurationSec() <= durationSec ){
            Broadcast currBroadcast = source.getNext();
            if (destination.getTotalDurationSec() + currBroadcast.getDurationSec() <= durationSec){
                destination.add(currBroadcast);

            } else break;
        }
        return  destination;
    }
}
