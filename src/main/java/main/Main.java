package main;

import radiostation.logic.*;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        new Main().runTranslation();
    }

    private void runTranslation() {
        List<Song> songs = new BroadcastList<>(new ArrayList<>());
        songs.add( new Song("Beatles", "Yesterday", 300));
        songs.add( new Song("Scorpions", "Wild Child", 420));
        songs.add( new Song("Deep Purple", "Smoke on the water", 380));


        List<Advertising> ads = new BroadcastList<>(new ArrayList<>());
        ads.add(new Advertising("Lipton Tea", 20));
        ads.add(new Advertising("MacCoffee", 35));
        ads.add(new Advertising("Dove Soap", 27));

        List<Interview> interviews = new BroadcastList<>(new ArrayList<>());
        interviews.add(new Interview("James Hetfield", 60*20));
        interviews.add(new Interview("Ozzy Osbourne", 60*35));
        interviews.add(new Interview("Bill Gates", 60*62));


        BroadcastCollection bCollect = new BroadcastCollection(songs, ads, interviews);
        PlaylistFactory factory = new PlaylistFactory(bCollect, 3*60*60 + 1); // 3 hours 1 sec
        factory.createPlaylist();
        System.out.println(factory.getPlaylist().toString());

    }
}


