package radiostation.patterns;

import radiostation.logic.broadcasts.Broadcast;

// NULL OBJECT pattern used
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

    @Override
    public boolean isPaid() {
        return false;
    }
}
