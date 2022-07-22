package radiostation.logic.broadcasts;

import radiostation.patterns.RoundMathAdapter;

public class Interview extends Broadcast {

    protected String respondent;

    protected static final int PRICE_PER_MIN = 30;

    public Interview(String respondent, int durationSec) {
        super(durationSec);
        this.respondent = respondent;
    }

    @Override
    public int getCost() {
        // ADAPTER pattern used
        return RoundMathAdapter.roundDivisionToInt(durationSec * PRICE_PER_MIN, 60);
    }

    @Override
    public String toString() {
        return "Interview{" +
                "respondent='" + respondent + '\'' +
                ", durationSec=" + durationSec +
                '}';
    }

    @Override
    public boolean isPaid() {
        return true;
    }
}
