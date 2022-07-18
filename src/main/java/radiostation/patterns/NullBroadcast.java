package radiostation.patterns;

import radiostation.logic.Broadcast;

public class NullBroadcast extends Broadcast {

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
}
