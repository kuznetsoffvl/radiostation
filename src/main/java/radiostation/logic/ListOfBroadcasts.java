package radiostation.logic;

import java.util.*;
import java.util.function.Consumer;

public class ListOfBroadcasts {
    private List<Broadcast> broadcasts = new ArrayList<>();
    private int cursor = -1; // to start with 0 position on getNext()

    private void calibrateCursor(){
        cursor = (cursor < broadcasts.size()-1) ? cursor : 0;
    }

    public Broadcast get(int index) {
        cursor = index;
        calibrateCursor();
        return broadcasts.get(cursor);
    }

    public Broadcast getNext() {
        return this.get(cursor + 1);
    }

    public boolean add(Broadcast broadcast) {
        return broadcasts.add(broadcast);
    }

    public boolean addAll(Collection<? extends Broadcast> c) {
        return broadcasts.addAll(c);
    }

    public void forEach(Consumer<? super Broadcast> action) {
        broadcasts.forEach(action);
    }

    public List<Broadcast> getBroadcasts() {
        return broadcasts;
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ListOfBroadcasts{\n   broadcasts: \n");
        for (Broadcast broadcast : broadcasts) {
            stringBuilder.append("     -").append(broadcast.toString()).append("\n");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
