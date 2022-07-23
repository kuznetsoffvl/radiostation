package radiostation.patterns;

import radiostation.logic.broadcasts.Repository;

// ABSTRACT FACTORY pattern used
public class MixWithInterviewFactory implements BroadcastFactory{

    @Override
    public PaidContent createPaidContent(int durationSec) {
        Repository repository = Repository.getInstance();
        return (PaidContent) repository.getInterviewsBlock(durationSec);
    }

    @Override
    public FreeContent createFreeContent(int durationSec) {
        Repository repository = Repository.getInstance();
        return (FreeContent) repository.getSongsBlock(durationSec);
    }

}
