package radiostation.patterns;

import radiostation.logic.broadcasts.BroadcastList;

// ABSTRACT FACTORY pattern applied
public interface PaidContent extends Content{
    BroadcastList getContent();
    boolean addContent(Content content);
}
