package radiostation.patterns;

import radiostation.logic.broadcasts.BroadcastSession;

// ABSTRACT FACTORY pattern applied
public class MixWithInterviewFactory implements BroadcastFactory{

    @Override
    public PaidContent createPaidContent(int durationSec) {
        return MixMasterFactory.createPaidContent(0, durationSec);
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
    public Content createContentWithBuilder(BroadcastSession broadcastSession, int durationSongsBlock, int durationInterviewsBlock) {
        return MixMasterFactory.createContentWithBuilder(broadcastSession, durationSongsBlock, 0, durationInterviewsBlock);
    }

}
