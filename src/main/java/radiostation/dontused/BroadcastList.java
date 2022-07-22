package radiostation.dontused;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

public class BroadcastList<Broadcast> extends ArrayList<Broadcast> implements List<Broadcast>, RandomAccess, Cloneable, java.io.Serializable{
    private int index;


    public BroadcastList(Collection<? extends Broadcast> c) {
        super(c);
    }

    public Broadcast getNext(){
        if (index >= this.size()) {
            index = 0;
        }
        return this.get(index++);
    }

    @Override
    public BroadcastList<Broadcast> clone() {
        BroadcastList clone = (BroadcastList) super.clone();
        // TODO: copy mutable state here, so the clone can't change the internals of the original
        return clone;
    }
}
