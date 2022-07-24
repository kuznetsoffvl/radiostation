package radiostation.patterns;

import radiostation.logic.broadcasts.BroadcastList;

public interface Content {
    BroadcastList getContent();
    boolean addContent(Content content);
}
