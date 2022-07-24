package radiostation.logic.broadcasts;

import radiostation.patterns.*;

import java.util.*;
import java.util.function.Consumer;

public class BroadcastList implements FreeContent, PaidContent, Content{
    private List<Broadcast> broadcasts = new ArrayList<>();
    private int cursor = -1; // to start with 0 position on getNext()

    private int totalDurationSec = 0;
    private int paidDurationSec = 0;
    private int totalCost = 0;

    public BroadcastList() {
    }

    public BroadcastList(List<Broadcast> broadcasts){
        this.broadcasts = broadcasts;
        for (Broadcast broadcast : broadcasts) {
            accumulateDuration(broadcast);
        }
    }

    @Override
    public BroadcastList getContent() {
        return this;
    }

    @Override
    public boolean addContent(Content content) {
        return addAll(content.getContent().broadcasts);
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("BroadcastList{\n   broadcasts: \n");
        for (Broadcast broadcast : broadcasts) {
            stringBuilder.append("     -").append(broadcast.toString()).append("\n");
        }
        stringBuilder.append("   totalDurationSec: ").append(totalDurationSec).append("\n");
        stringBuilder.append("   paidDurationSec: ").append(paidDurationSec).append("\n");
        stringBuilder.append("   totalCost: ").append(totalCost).append("\n");
        stringBuilder.append("}");

        return stringBuilder.toString();
    }

    private void calibrateCursor(){
        cursor = (cursor <= broadcasts.size()-1) ? cursor : 0;
    }

    public Broadcast get(int index) {
        cursor = index;
        calibrateCursor();
        return broadcasts.get(cursor);
    }

    public Broadcast getNext() {
        return this.get(cursor + 1);
    }

    public int getTotalDurationSec() {
        return totalDurationSec;
    }

    public int getPaidDurationSec(){
        return paidDurationSec;
    }

    public boolean add(Broadcast broadcast) {
        if (broadcasts.add(broadcast)) {
            accumulateDuration(broadcast);
            return true;
        }
        return false;
    }

    public boolean addAll(Collection<? extends Broadcast> c) {
        if (broadcasts.addAll(c)) {
            for (Broadcast broadcast : c) {
                accumulateDuration(broadcast);
            }
            return true;
        }
        return false;
    }

    public void forEach(Consumer<? super Broadcast> action) {
        broadcasts.forEach(action);
    }

    public List<Broadcast> getBroadcasts() {
        return broadcasts;
    }

    public int getTotalCost(){
        return totalCost;
    }

    private void accumulateDuration(Broadcast broadcast) {
        totalDurationSec += broadcast.durationSec;
        // TODO: think about to release OBSERVER pattern here
        if (broadcast.isPaid()) {
            paidDurationSec += broadcast.durationSec;
            totalCost += broadcast.getCost();
        }
    }


}
