package radiostation.patterns;

import radiostation.logic.broadcasts.BroadcastList;

public interface FreeContent extends Content{
    BroadcastList getContent();
    boolean addContent(Content content);
}
