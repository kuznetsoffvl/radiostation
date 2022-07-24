package radiostation.patterns;

import radiostation.logic.broadcasts.BroadcastSession;
import radiostation.logic.broadcasts.Repository;

// ABSTRACT FACTORY pattern applied
public class MixWithAdsFactory implements BroadcastFactory{

    @Override
    public PaidContent createPaidContent(int durationSec) {
        return MixMasterFactory.createPaidContent(durationSec, 0);
    }

    @Override
    public FreeContent createFreeContent(int durationSec) {
        return MixMasterFactory.createFreeContent(durationSec);
    }

    @Override
    public Content createContent(BroadcastSession broadcastSession) {
        return MixMasterFactory.createContent(broadcastSession);
    }

    @Override
    public Content createContentWithBuilder(BroadcastSession broadcastSession, int durationSongsBlock, int durationAdsBlock) {
        return MixMasterFactory.createContentWithBuilder(broadcastSession, durationSongsBlock, durationAdsBlock, 0);
    }
}
