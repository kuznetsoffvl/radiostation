package radiostation;

public class Interview extends Broadcast {

    protected String respondent;

    protected static final int PRICE_PER_MIN = 30;

    public Interview(String respondent, int durationSec) {
        super(durationSec);
        this.respondent = respondent;
    }

    @Override
    public int getCost() {
        return ((int) (double) Math.round( Double.valueOf(durationSec) / 60 ))  * PRICE_PER_MIN;
    }

    @Override
    public String toString() {
        return "Interview{" +
                "respondent='" + respondent + '\'' +
                ", durationSec=" + durationSec +
                '}';
    }
}
