package radiostation.logic.Presenters;

import radiostation.dontused.BroadcastList;

import java.util.List;

public abstract class Presenter {
    private final String name;

    private List<BroadcastList> broadcastLists;
    //will store all radio broadcasts for the entire time of this presenter

    public Presenter(String name) {
        this.name = name;
    }

    public void addBroadcastList(BroadcastList broadcastList) {
        broadcastLists.add( broadcastList );
    }
}
