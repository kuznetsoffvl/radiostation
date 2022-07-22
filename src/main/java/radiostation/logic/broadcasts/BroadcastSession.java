package radiostation.logic.broadcasts;

import radiostation.logic.Presenters.Presenter;

import static radiostation.patterns.RoundMathAdapter.floorMultiplyIntByDouble;

public class BroadcastSession {

    private final Presenter presenter;

    private BroadcastList broadcastList;
    //list of all songs, ads and interviews played during the session
    private final int durationSec;
    private static final double PAID_PROPORTION = 0.5;

    public BroadcastSession(Presenter presenter, int durationSec) {
        this.presenter = presenter;
        this.durationSec = durationSec;
        broadcastList = new BroadcastList();
    }

    public Presenter getPresenter() {
        return presenter;
    }

    public BroadcastList getBroadcastList() {
        return broadcastList;
    }

    public int getDurationSec() {
        return durationSec;
    }

    public int getPaidDurationSec(){
        // ADAPTER pattern used
        return floorMultiplyIntByDouble(durationSec, PAID_PROPORTION);
    }

    public int getCurrentDurationSec(){
        // DELEGATION pattern
        return broadcastList.getTotalDurationSec();
    }



}
