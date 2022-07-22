package radiostation.patterns;

import radiostation.logic.broadcasts.Broadcast;

public class NullBroadcast extends Broadcast {

    // NULL OBJECT pattern used here
    public NullBroadcast() {
        super(0);
    }

    @Override
    public int getCost() {
        return 0;
    }

    @Override
    public String toString() {
        return "";
    }

    @Override
    public boolean isPaid() {
        return false;
    }
}
