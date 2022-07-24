package radiostation.patterns;

import radiostation.logic.broadcasts.BroadcastList;
import radiostation.logic.broadcasts.BroadcastSession;
import radiostation.logic.broadcasts.Repository;

// ABSTRACT FACTORY pattern applied
public abstract class MixMasterFactory{
    public static PaidContent createPaidContent(int durationAdsSec, int durationInterviewsSec) {
        PaidContent paidContent = Repository.getInstance().getInterviewsBlock(durationInterviewsSec);
        paidContent.addContent(Repository.getInstance().getAdsBlock(durationAdsSec));
        return paidContent;
    }

    public static FreeContent createFreeContent(int durationSongsSec) {
        FreeContent freeContent = Repository.getInstance().getSongsBlock(durationSongsSec);
//        while (freeContent.getContent().getTotalDurationSec() < durationSongsSec) {
//            freeContent.getContent().add(Repository.getInstance().nextSong());
//        }
        return freeContent;
    }

    public static Content createContent(BroadcastSession broadcastSession) {
        Content content = createPaidContent(0, broadcastSession.getPaidDurationSec());
        content.addContent(createPaidContent(broadcastSession.getPaidDurationSec() - content.getContent().getPaidDurationSec(), 0));
        content.addContent(createFreeContent(broadcastSession.getTotalDurationSec() - content.getContent().getTotalDurationSec()));
        return content;
    }

    //BUILDER pattern used here
    public static Content createContentWithBuilder(BroadcastSession broadcastSession, int durationSongsBlock, int durationAdsBlock, int durationInterviewsBlock) {

        ContentBuilder.Builder builder = new ContentBuilder.Builder(broadcastSession.getTotalDurationSec(), broadcastSession.getPaidDurationSec());

        Content content = new BroadcastList(); // initialize content

        int sizeBefore;
        int sizeAfter;
        //int currTotalDurationSec = 0;

        while (builder.getCurrentTotalDurationSec() <= broadcastSession.getTotalDurationSec()){

            // sizeBefore, sizeAfter - variables to solving looping issue
            sizeBefore = builder.countAllContent();

            builder
                    .songsWithDuration(Math.min(
                            broadcastSession.getFreeDurationSec() - builder.getCurrentFreeDurationSec(), durationSongsBlock))
                    .adsWithDuration(Math.min(
                            broadcastSession.getPaidDurationSec() - builder.getCurrentPaidDurationSec(), durationAdsBlock))
                    .interviewsWithDuration(Math.min(
                            broadcastSession.getPaidDurationSec() - builder.getCurrentPaidDurationSec(), durationInterviewsBlock));

            sizeAfter = builder.countAllContent();

            if (sizeBefore == sizeAfter) {
                //solving looping issue here
                break;
            }
        }

        // Fill broadcast for TotalDurationSec by free content
//        while (broadcastSession.getTotalDurationSec() - builder.getCurrentTotalDurationSec() > 0) {
//            builder.songs(1);
//        }
        content.addContent(builder.build());
        return content;
    }

    public static void fillContentWithBuilder(BroadcastSession broadcastSession, int durationSongsBlock, int durationAdsBlock, int durationInterviewsBlock){
        Content content = MixMasterFactory.createContentWithBuilder(broadcastSession, durationSongsBlock, durationAdsBlock, durationInterviewsBlock);
        broadcastSession.addAllFromBroadcastList(content.getContent());
    }

}
