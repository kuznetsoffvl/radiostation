package radiostation.logic.broadcasts;

import radiostation.logic.presenters.Presenter;
import radiostation.logic.presenters.StuffPresenter;

import static radiostation.patterns.RoundMathAdapter.floorMultiplyIntByDouble;

public class BroadcastSession {

    private final Presenter presenter;

    private final BroadcastList broadcastList;
    //list of all songs, ads and interviews played during the session
    private final int totalDurationSec;
    private static final double PAID_PROPORTION = 0.5;

    public BroadcastSession(Presenter presenter, int totalDurationSec, BroadcastList broadcastList) {
        this.presenter = presenter;
        this.totalDurationSec = totalDurationSec;
        this.broadcastList = broadcastList;
        if (presenter.getClass() == StuffPresenter.class) {
            this.presenter.addBroadcastList(broadcastList);
        }
    }

    public Presenter getPresenter() {
        return presenter;
    }

    public BroadcastList getBroadcastList() {
        return broadcastList;
    }

    public int getTotalDurationSec() {
        return totalDurationSec;
    }

    public int getPaidDurationSec(){
        // ADAPTER pattern used
        return floorMultiplyIntByDouble(totalDurationSec, PAID_PROPORTION);
    }

    public int getFreeDurationSec() {
        return totalDurationSec - getPaidDurationSec();
    }

    public int getCurrentTotalDurationSec(){
        // DELEGATION pattern
        return broadcastList.getTotalDurationSec();
    }

    public int getCurrentPaidDurationSec(){
        // DELEGATION pattern
        return broadcastList.getPaidDurationSec();
    }

    public int getCurrentFreeDurationSec(){
        return getCurrentTotalDurationSec() - getCurrentPaidDurationSec();
    }


    public void addAllFromBroadcastList(BroadcastList source){
        broadcastList.addAll(source.getBroadcasts());
    }

    @Override
    public String toString() {
        return "BroadcastSession{" +
                "presenter=" + presenter +
                ", broadcastList=" + broadcastList +
                ", totalDurationSec=" + totalDurationSec +
                ", paidDurationSec=" + getPaidDurationSec() +
                ", CurrentDurationSec=" + getCurrentTotalDurationSec() +
                ", CurrentPaidDurationSec=" + getCurrentPaidDurationSec() +
                '}';
    }
}
