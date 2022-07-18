package radiostation.logic;

public abstract class Broadcast {

    protected int durationSec;

   // protected int cost = 0;

    public Broadcast(int durationSec) {
        this.durationSec = durationSec;
    }

    public abstract int getCost();

    @Override
    public abstract String toString();

    public boolean isPaid() {
        return getCost() != 0;
    }

    public int getDurationSec() {
        return durationSec;
    }
}
