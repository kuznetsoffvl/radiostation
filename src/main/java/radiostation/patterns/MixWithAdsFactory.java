package radiostation.patterns;

import radiostation.logic.broadcasts.BroadcastList;
import radiostation.logic.broadcasts.Repository;

// ABSTRACT FACTORY pattern used
public class MixWithAdsFactory implements BroadcastFactory{

    @Override
    public PaidContent createPaidContent(int durationSec) {
        Repository repository = Repository.getInstance();
        return (PaidContent) repository.getAdsBlock(durationSec);
    }

    @Override
    public FreeContent createFreeContent(int durationSec) {
        Repository repository = Repository.getInstance();
        return (FreeContent) repository.getSongsBlock(durationSec);
    }
}
