package radiostation.patterns;

import radiostation.logic.broadcasts.BroadcastList;

// ABSTRACT FACTORY pattern used
public interface PaidContent {
    BroadcastList getAdsBlock(int durationSec);
    BroadcastList getInterviewsBlock(int durationSec);
}
