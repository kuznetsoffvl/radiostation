package radiostation;

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
