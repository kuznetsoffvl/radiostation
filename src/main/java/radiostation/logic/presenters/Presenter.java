package radiostation.logic.presenters;


import radiostation.logic.broadcasts.BroadcastList;

import java.util.ArrayList;
import java.util.List;

public abstract class Presenter {
    protected final String name;

    protected List<BroadcastList> broadcastLists = new ArrayList<>();
    //will store all radio broadcasts for the entire time of this presenter

    public Presenter(String name) {
        this.name = name;
    }

    public void addBroadcastList(BroadcastList broadcastList) {
        broadcastLists.add( broadcastList );
    }

    @Override
    public String toString() {
        return "Presenter{" +
                "name='" + name + '\'' +
                ", broadcastLists=" + broadcastLists +
                '}';
    }
}
