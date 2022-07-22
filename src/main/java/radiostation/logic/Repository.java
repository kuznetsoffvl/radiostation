package radiostation.logic;

import java.util.ArrayList;
import java.util.List;

public class Repository {

    private static ListOfBroadcasts songs;
    private static ListOfBroadcasts ads;
    private static ListOfBroadcasts interviews;

    public Repository() {
        songs = new ListOfBroadcasts();
        songs.add( new Song("Beatles", "Yesterday", 300));
        songs.add( new Song("Scorpions", "Wild Child", 420));
        songs.add( new Song("Deep Purple", "Smoke on the water", 380));

        ads = new ListOfBroadcasts();
        ads.add(new Advertising("Lipton Tea", 20));
        ads.add(new Advertising("MacCoffee", 35));
        ads.add(new Advertising("Dove Soap", 27));

        interviews = new ListOfBroadcasts();
        interviews.add(new Interview("James Hetfield", 60*20));
        interviews.add(new Interview("Ozzy Osbourne", 60*35));
        interviews.add(new Interview("Bill Gates", 60*62));
    }

    public static ListOfBroadcasts getSongs() {
        return songs;
    }

    public static ListOfBroadcasts getAds() {
        return ads;
    }

    public static ListOfBroadcasts getInterviews() {
        return interviews;
    }
}
