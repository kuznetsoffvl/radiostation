package radiostation.logic.broadcasts;

public abstract class Broadcast {

    protected int durationSec;

    public Broadcast(int durationSec) {
        this.durationSec = durationSec;
    }

    public abstract int getCost();

    @Override
    public abstract String toString();

    public int getDurationSec() {
        return durationSec;
    }

    public abstract boolean isPaid();
}
