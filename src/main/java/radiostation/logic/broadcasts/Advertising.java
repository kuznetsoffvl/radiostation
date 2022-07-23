package radiostation.logic.broadcasts;

import radiostation.patterns.PaidContent;

public class Advertising extends Broadcast {
    protected String productName;

    protected static final int PRICE_PER_SEC = 5;


    public Advertising(String productName, int durationSec ) {
        super(durationSec);
        this.productName = productName;
    }
    @Override
    public int getCost() {
        return durationSec * PRICE_PER_SEC;
    }

    @Override
    public String toString() {
        return "Advertising{" +
                "productName='" + productName + '\'' +
                ", durationSec=" + durationSec +
                '}';
    }

    @Override
    public boolean isPaid() {
        return true;
    }

}
