package radiostation.patterns;

import radiostation.logic.broadcasts.BroadcastSession;

// ABSTRACT FACTORY pattern used
public interface BroadcastFactory {
    PaidContent createPaidContent(int durationSec);
    FreeContent createFreeContent(int durationSec);

    Content createContent(BroadcastSession broadcastSession);

    Content createContentWithBuilder(BroadcastSession broadcastSession, int durationSongsBlock, int durationAdsBlock);
}
