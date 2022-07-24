package radiostation.logic.presenters;


import radiostation.logic.broadcasts.BroadcastList;

public class StuffPresenter extends Presenter {
    private final int experience;

    public StuffPresenter(String name, int experience, BroadcastList broadcastList) {
        super(name);
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "StuffPresenter{" +
                "name='" + name + '\'' +
                ", experience=" + experience +
                ", broadcastLists=" + broadcastLists +
                '}';
    }
}
